/**
 * 
 */
package rga.google.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.sun.org.apache.xpath.internal.operations.Plus;

/**
 * @author marciog
 * 
 */
public class ShortMain {

	private static final String SCOPE = "https://www.googleapis.com/auth/urlshortener";
	private static final String CALLBACK_URL = "urn:ietf:wg:oauth:2.0:oob";
	private static final HttpTransport TRANSPORT = new NetHttpTransport();
	private static final JsonFactory JSON_FACTORY = new JacksonFactory();

	// FILL THESE IN WITH YOUR VALUES FROM THE API CONSOLE
	private static final String CLIENT_ID = "199976829739-koner4bgfei09u8rkvphtv837uvuqtg7.apps.googleusercontent.com";
	private static final String CLIENT_SECRET = "P7R3qz1vm6OsZgdlp2g2VCcf";

	/**
	 * @param args
	 */
	public static void main(String[] args) {


//		GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
//	    Plus plus = Plus.builder(new NetHttpTransport(), new JacksonFactory())
//	        .setApplicationName("Google-PlusSample/1.0")
//	        .setHttpRequestInitializer(credential)
//	        .build();
//	    
//	    
//		
//		   // Generate the URL to which we will direct users
//	    String authorizeUrl = new GoogleAuthorizationRequestUrl(CLIENT_ID, CALLBACK_URL, SCOPE).build();
//	    System.out.println("Paste this url in your browser: " + authorizeUrl);
//
//	    // Wait for the authorization code
//	    System.out.println("Type the code you received here: ");
//	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//	    String authorizationCode = in.readLine();
//
//	    // Exchange for an access and refresh token
//	    GoogleAuthorizationCodeGrant authRequest = new GoogleAuthorizationCodeGrant(TRANSPORT, JSON_FACTORY, CLIENT_ID, CLIENT_SECRET, authorizationCode, CALLBACK_URL);
//	    authRequest.useBasicAuthorization = false;
//	    AccessTokenResponse authResponse = authRequest.execute();
//	    String accessToken = authResponse.accessToken;
//	    GoogleAccessProtectedResource access = new GoogleAccessProtectedResource(accessToken, TRANSPORT, JSON_FACTORY, CLIENT_ID, CLIENT_SECRET, authResponse.refreshToken);
//	    HttpRequestFactory rf = TRANSPORT.createRequestFactory(access);
//	    System.out.println("Access token: " + authResponse.accessToken);
//
//	    // Make an authenticated request
//	    GenericUrl shortenEndpoint = new GenericUrl("https://www.googleapis.com/urlshortener/v1/url");
//	    String requestBody = "{\"longUrl\":\"http://farm6.static.flickr.com/5281/5686001474_e06f1587ff_o.jpg\"}";
//	    HttpRequest request = rf.buildPostRequest(shortenEndpoint, ByteArrayContent.fromString("application/json", requestBody));
//	    HttpResponse shortUrl = request.execute();
//	    BufferedReader output = new BufferedReader(new InputStreamReader(shortUrl.getContent()));
//	    
//	    System.out.println("Shorten Response: ");
//	    for (String line = output.readLine(); line != null; line = output.readLine()) {
//	      System.out.println(line);
//	    }
//
//	    // Refresh a token (SHOULD ONLY BE DONE WHEN ACCESS TOKEN EXPIRES)
//	    access.refreshToken();
//	    System.out.println("Original Token: " + accessToken + " New Token: " + access.getAccessToken());		
		

	}
}
