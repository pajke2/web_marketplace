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
import model.User;

@WebServlet("/userAds")
public class UserAdsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserAdsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		
		List<Ad> ads = AdDB.userAds(userId);
		request.setAttribute("ads", ads);
		
		RequestDispatcher rd = request.getRequestDispatcher("myAds.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
