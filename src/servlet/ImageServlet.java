package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dataBase.ImageDB;
import model.Image;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int adId = Integer.parseInt(request.getParameter("adId"));
		
		request.setAttribute("adId", adId);
		request.setAttribute("images", ImageDB.findAdImages(adId));
		
		RequestDispatcher rd = request.getRequestDispatcher("image.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			
			
			int adId = -1;
			String imagePath = null;
			
			for(FileItem item: items) {
				if (item.isFormField()) {
					String fieldName = item.getFieldName(); //name atributa u jsp stranici
					String fieldValue = item.getString(); //vrijednost atributa
					adId = Integer.parseInt(fieldValue);
					
				} else {
					String path = request.getServletContext().getRealPath(""); //Putanja do tomcat direktorijuma gdje se cuva fajl
					String savePath = path + File.separator + "ad_images";

					String imageName = Integer.toString(new Random().nextInt(2000000000)) + ".jpg";
					item.write(new File(savePath+File.separator+imageName));
					imagePath = imageName;
				}
			}
			
			String message;
			
			if (ImageDB.insertImage(imagePath, adId)) {
				message = "upload succesfull";
			} else {
				message = "unsuccesfull upload";
			}
			
			request.setAttribute("message", message);
			request.setAttribute("images", ImageDB.findAdImages(adId));
			request.setAttribute("adId", adId);
			
			RequestDispatcher rd = request.getRequestDispatcher("image.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	}

}
