package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.AdDB;
import dataBase.CategoryDB;
import model.Category;
import model.User;

@WebServlet("/newAd")
public class NewAdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewAdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> allCat = CategoryDB.allCategories();
		request.setAttribute("cat", allCat);
		
		RequestDispatcher rd = request.getRequestDispatcher("newAd.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		String title = request.getParameter("title");
		String detail = request.getParameter("detail");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		double price = Double.parseDouble(request.getParameter("price"));
		String saleSubjectType = request.getParameter("type");
		String saleSubjectCondition = request.getParameter("condition");
		
		boolean addAd = AdDB.createNewAd(title, detail, categoryId, userId, price, saleSubjectType, saleSubjectCondition);
		
		if (addAd == true) {
			
			request.setAttribute("ads", AdDB.userAds(userId));
			request.setAttribute("message", "Uspjesno ste dodali novi oglas");
			
			RequestDispatcher rd = request.getRequestDispatcher("myAds.jsp");
			rd.forward(request, response);
			
		} else {
			request.setAttribute("message", "Greska u unosenju informacija prilikom dodavanja oglasa!");
			RequestDispatcher rd = request.getRequestDispatcher("newAd.jsp");
			rd.forward(request, response);
		}
	}

}
