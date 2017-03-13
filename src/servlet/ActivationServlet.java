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
		
		UserDB.activateUser(username);
		
		request.setAttribute("message", "Uspjesno ste napravili nalog na sajtu web oglasnik");
		
		RequestDispatcher rd = request.getRequestDispatcher("logInPage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
