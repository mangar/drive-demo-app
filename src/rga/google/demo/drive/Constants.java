package rga.google.demo.drive;

import java.util.Arrays;
import java.util.List;

public class Constants {

	public static final String CLIENT_ID = "199976829739.apps.googleusercontent.com";
	public static final String CLIENT_SECRET = "Q-sBw0a8q6KB4_o1AWgJGw4O";
	public static final String API_KEY = "AIzaSyBqyF_iKSdIAtkLOog3k6dUJCGOk-4DlFs";
	public static final String CLIENT_REDIRECT = "http://localhost:8888/callback";

	public static final List<String> SCOPES = Arrays.asList(
			// "https://www.googleapis.com/auth/drive.file",
			"https://www.googleapis.com/auth/drive", "https://www.googleapis.com/auth/userinfo.email",
			"https://www.googleapis.com/auth/userinfo.profile");

	public static final String SCOPE = "openid email";

	public static final String CLIENT_ID_LOCAL = "199976829739-koner4bgfei09u8rkvphtv837uvuqtg7.apps.googleusercontent.com";
	public static final String CLIENT_SECRET_LOCAL = "P7R3qz1vm6OsZgdlp2g2VCcf";
	public static final String CLIENT_REDIRECT_LOCAL = "urn:ietf:wg:oauth:2.0:oob";

}
