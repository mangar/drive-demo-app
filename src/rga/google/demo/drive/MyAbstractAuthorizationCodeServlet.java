package rga.google.demo.drive;

import java.io.IOException;
import java.util.Collections;

import javax.jdo.JDOHelper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.extensions.jdo.auth.oauth2.JdoCredentialStore;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeServlet;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;

@SuppressWarnings("serial")
public class MyAbstractAuthorizationCodeServlet extends AbstractAuthorizationCodeServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// do stuff
	}

	@Override
	protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
		GenericUrl url = new GenericUrl(req.getRequestURL().toString());
		url.setRawPath("/oauth2callback");
		return url.build();
	}

	@Override
	protected AuthorizationCodeFlow initializeFlow() throws IOException {
		return new GoogleAuthorizationCodeFlow.Builder(new NetHttpTransport(), new JacksonFactory(),
				Constants.CLIENT_ID, Constants.CLIENT_SECRET,
				Collections.singleton("https://www.googleapis.com/auth/calendar")).setCredentialStore(
				new JdoCredentialStore(JDOHelper.getPersistenceManagerFactory("transactions-optional"))).build();
	}

	@Override
	protected String getUserId(HttpServletRequest req) throws ServletException, IOException {
		// return user ID
		return "user id!!!";
	}

}
