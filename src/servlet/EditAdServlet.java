package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.AdDB;
import dataBase.CategoryDB;
import model.Ad;
import model.User;

@WebServlet("/editAd")
public class EditAdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditAdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int adId = Integer.parseInt(request.getParameter("adId"));
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		
		Ad ad = AdDB.findAdById(adId);
		
		if (ad.getUserId() != userId) {
			request.setAttribute("message", "Operation is not allowed");
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
		
		request.setAttribute("ad", ad);
		request.setAttribute("category", CategoryDB.allCategories());
		
		
		RequestDispatcher rd = request.getRequestDispatcher("editAd.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String detail = request.getParameter("detail");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		double price = Double.parseDouble(request.getParameter("price"));
		String saleSubjectType = request.getParameter("type");
		String saleSubjectCondition = request.getParameter("condition");
		String postingDate = request.getParameter("postingDate");
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		int userId2 = Integer.parseInt(request.getParameter("userId"));
		int adId = Integer.parseInt(request.getParameter("adId"));
		
		if (userId != userId2) {
			request.setAttribute("message", "Operation is not allowed");
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
		
		boolean successfulEditing = AdDB.editAd(adId, title, detail, categoryId, postingDate, userId2, price, saleSubjectType, saleSubjectCondition);
		
		if (successfulEditing == true) {
			request.setAttribute("message", "Uspjesno ste editovali oglas");
			request.setAttribute("ads", AdDB.userAds(userId2));
			
			RequestDispatcher rd = request.getRequestDispatcher("myAds.jsp");
			rd.forward(request, response);
		} else {
			
			request.setAttribute("category", CategoryDB.allCategories());
			request.setAttribute("message", "Niste unijeli odgovarajuce podatke, molimo vas da unesete ponovo");
			request.setAttribute("ad", AdDB.findAdById(adId));
			
			RequestDispatcher rd = request.getRequestDispatcher("editAd.jsp");
			rd.forward(request, response);
		}
	}

}
