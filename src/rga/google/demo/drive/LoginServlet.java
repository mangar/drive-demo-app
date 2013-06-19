package rga.google.demo.drive;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rga.google.helper.AuthenticationHelper;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException  {
		
		String url = AuthenticationHelper.getAuthorizationUrl("", null);
		req.setAttribute("url", url);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/login.jsp");
		dispatcher.forward(req, resp);		
	}
		
}
