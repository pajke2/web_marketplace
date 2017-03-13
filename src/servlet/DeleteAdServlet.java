package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.AdDB;


@WebServlet("/deleteAd")
public class DeleteAdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteAdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int adId = Integer.parseInt(request.getParameter("adId"));
		boolean successfulDeletingAd = AdDB.deleteAd(adId);
			
		if (successfulDeletingAd == true) {
			String message = "Oglas je uspjesno obrisan!";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("myAds.jsp");
			rd.forward(request, response);
		} else {
			String message = "Postoji problem sa brisanjem oglasa, molimo pokusajte ponovo!";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("editAd.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
