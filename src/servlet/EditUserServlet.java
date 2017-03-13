package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.AdDB;
import dataBase.UserDB;
import model.User;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		
		request.setAttribute("user", UserDB.findUserById(userId));
		
		RequestDispatcher rd = request.getRequestDispatcher("editUser.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = ((User)request.getSession().getAttribute("user")).getId();
		int userId2 = Integer.parseInt(request.getParameter("userId"));
		
		if (userId != userId2) {
			request.setAttribute("message", "Invalid operation!");
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		String email = request.getParameter("email");
		String username = request.getParameter("username").trim();
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		String city = request.getParameter("city");
		
		boolean successfulUserEdit = UserDB.editUser(userId2, firstName, lastName, email, username, birthday, sex, city);
		
		if (successfulUserEdit == true) {
			request.setAttribute("message", "Uspjesna izmjena profila korisnika!");
			request.setAttribute("ads", AdDB.userAds(userId));
			
			RequestDispatcher rd = request.getRequestDispatcher("myAds.jsp");
			rd.forward(request, response);
		}
		
		else {
			request.setAttribute("user", UserDB.findUserById(userId));
			
			request.setAttribute("message", "Doslo je do problema prilikom izmjene korisnika, molimo da pokusate ponovo");
			RequestDispatcher rd = request.getRequestDispatcher("editUser.jsp");
			rd.forward(request, response);
		}
	
	}

}
