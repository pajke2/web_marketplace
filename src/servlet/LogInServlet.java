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
import dataBase.UserDB;
import model.Ad;
import model.User;

@WebServlet("/logIn")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogInServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("logInPage.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = UserDB.logInUser(username, password);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			
			int userId = ((User) request.getSession().getAttribute("user")).getId();
			List<Ad> userAds = AdDB.userAds(userId);
			request.setAttribute("ads", userAds);
			
			RequestDispatcher rd = request.getRequestDispatcher("myAds.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("message", "Nepostojece korisnicko ime ili sifra, pokusajte ponovo");
			
			RequestDispatcher rd = request.getRequestDispatcher("logInPage.jsp");
			rd.forward(request, response);
		}
	}

}
