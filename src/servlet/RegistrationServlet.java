package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.UserDB;
import util.SendMail;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("registrationPage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		String email = request.getParameter("email");
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		String city = request.getParameter("city");
		
		boolean successfulRegistration = UserDB.userRegistration(firstName, lastName, email, username, password, birthday, sex, city);
		String message;
		if (successfulRegistration == true) {
			boolean successful = SendMail.sendMail(email, "Aktivacija naloga na sajtu web oglasnik", "za aktivaciju vaseg naloga, kliknite na sledeci link http://localhost:8081/web_marketplace/activation?username="+username);
			if (successful == true) {
				message = "Uspjesno ste se registrovali, provjerite mail i kliknite na aktivacioni link da bi ste zavrsili registraciju!";
			} else {
				message = "Problem sa slanjem maila";
			}
		} else {
			message = "Doslo je do problema prilikom registracije, potrebno je da unesete jedinstveno korisnicko ime i email adresu";
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("registrationPage.jsp");
		rd.forward(request, response);
	}

}
