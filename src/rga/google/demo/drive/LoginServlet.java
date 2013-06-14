package rga.google.demo.drive;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rga.google.helper.AuthenticationHelper;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		String url = AuthenticationHelper.getAuthorizationUrl("", Constants.SCOPE);
		resp.getWriter().println("<a href=\"" + url + "\">Login</a><br>");		
	}
		
}
