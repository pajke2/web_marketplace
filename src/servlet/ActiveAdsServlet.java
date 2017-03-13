package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.AdDB;
import model.Ad;

@WebServlet("/active")
public class ActiveAdsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ActiveAdsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Ad> activeAds = AdDB.activeAds();
		
		request.setAttribute("activeAds", activeAds);
		
		RequestDispatcher rd = request.getRequestDispatcher("active.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
