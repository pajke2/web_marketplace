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

@WebServlet("/expired")
public class ExpiredAdsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExpiredAdsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ad> expiredAds = AdDB.expiredAds();
		
		if (expiredAds.size() == 0) {
			request.setAttribute("message", "Nema oglasa koji su istekli!");
		}
		
		request.setAttribute("expiredAds", expiredAds);
		
		RequestDispatcher rd = request.getRequestDispatcher("expired.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
