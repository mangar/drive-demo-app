package rga.google.demo.drive;

import java.util.Arrays;
import java.util.List;

import com.google.appengine.api.utils.SystemProperty;

public class Constants {

	public static final String CLIENT_ID = "503002196978.apps.googleusercontent.com";
	public static final String CLIENT_SECRET = "TBUAP2sGWDD1nd0oNWsdwjpB";

	public static final List<String> SCOPES = Arrays.asList(
			// "https://www.googleapis.com/auth/drive.file",
			"https://www.googleapis.com/auth/drive", "https://www.googleapis.com/auth/userinfo.email",
			"https://www.googleapis.com/auth/userinfo.profile");

	public static final String CLIENT_ID_LOCAL = "";
	public static final String CLIENT_SECRET_LOCAL = "";
	public static final String CLIENT_REDIRECT_LOCAL = "urn:ietf:wg:oauth:2.0:oob";

	
	public static String CLIENT_REDIRECT() {
		String redirectPath = "http://localhost:8888/callback";
		if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
			redirectPath = "http://drive-demo-app.appspot.com/callback";
		} 
		return redirectPath;
	}
	
	
}
