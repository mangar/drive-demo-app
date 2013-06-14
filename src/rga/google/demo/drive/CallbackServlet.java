package rga.google.demo.drive;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rga.google.helper.AuthenticationHelper;

import com.google.api.client.auth.oauth2.Credential;

@SuppressWarnings("serial")
public class CallbackServlet extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		resp.setContentType("text/html");
		
//		MyClass myClass = new MyClass();
//		String url = myClass.getAuthorizationUrl("marcio.mangar@gmail.com", "scope");
//		String url = AuthenticationHelper.getAuthorizationUrl("", "scope");
		
		String code = req.getParameter("code");
		String state = req.getParameter("state");
		
		resp.getWriter().println("Code: " + code + "<br>");
		resp.getWriter().println("State: " + state + "<br>");

				
		Credential credential = this.getCredential(code, state);
		
		
		
//		resp.getWriter().println("Hello, Callback <br>");
//		resp.getWriter().println("url: " + url + "<br>");
//		resp.getWriter().println("<hr>");
//		resp.getWriter().println("<a href=\"" + url + "\">Link</a><br>");
		
		
	}
	
	public Credential getCredential(final String code, final String state) {
		Credential credential = null;
		try {
			credential = AuthenticationHelper.getCredentials(code,  state);
			
			

			
		} catch (Exception e) {
			System.err.println("Erro ao obter as credenciais do usuario..." + e.toString());
		}
		return credential;
	}
	
	
	
	
}
