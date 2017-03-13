package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.ImageDB;

@WebServlet("/deleteImage")
public class DeleteImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteImageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int imageId = Integer.parseInt(request.getParameter("imgId"));
		int adId = Integer.parseInt(request.getParameter("adId"));
		
		boolean imageDeletedSuccessful = ImageDB.deleteImage(imageId);
		
		String message;
		
		if (imageDeletedSuccessful == true) {
			message = "Succesfully deleted image";
		} else {
			message = "Error ocured";
		}
		
		request.setAttribute("message", message);
		request.setAttribute("images", ImageDB.findAdImages(adId));
		request.setAttribute("adId", adId);
		
		RequestDispatcher rd = request.getRequestDispatcher("image.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
