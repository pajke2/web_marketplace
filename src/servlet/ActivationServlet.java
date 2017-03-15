package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.UserDB;

@WebServlet("/activation")
public class ActivationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ActivationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		boolean successfulActivation = UserDB.activateUser(username);
		String message = null;
		if (successfulActivation == true) {
			message = "Uspjesno ste napravili nalog na sajtu web oglasnik";
		} else {
			message = "Postoji problem sa aktiviranjem naloga";
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("logInPage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
