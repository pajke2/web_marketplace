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

@WebServlet("/logOut")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogOutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		
		List<Ad> allAds = AdDB.allAds();
		request.setAttribute("ads", allAds);
		
		RequestDispatcher rd = request.getRequestDispatcher("indexPage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
