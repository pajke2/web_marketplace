package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.CommentDB;
import dataBase.UserDB;
import model.AdComment;

@WebServlet("/comments")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int adId = Integer.parseInt(request.getParameter("adId"));
		List<AdComment> comments = CommentDB.adComments(adId);
		
		request.setAttribute("adId", adId);
		request.setAttribute("comments", comments);
		
		if (comments.size() == 0) {
			request.setAttribute("message", "Jos uvijek nema komentara za ovaj oglas");
		}
		RequestDispatcher rd = request.getRequestDispatcher("comments.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
