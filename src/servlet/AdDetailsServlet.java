package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.AdDB;
import model.Ad;

@WebServlet("/details")
public class AdDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdDetailsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int adId = Integer.parseInt(request.getParameter("adId"));
		
		Ad ad = AdDB.adDetails(adId);
		request.setAttribute("ad", ad);
		
		RequestDispatcher rd = request.getRequestDispatcher("adDetails.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
