package rga.google.demo.drive;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rga.google.helper.AuthenticationHelper;
import rga.google.helper.DriveHelper;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;


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
		
		String accessToken = credential.getAccessToken();
		resp.getWriter().println("Access Token: " + accessToken + "<br>");
		
		
		
//		GoogleCredential gCredential = new GoogleCredential();
//		gCredential.setAccessToken(accessToken);
		
		
		Drive service = DriveHelper.buildService(credential);
		resp.getWriter().println("Drive OK <br>");

		
		System.out.println("Start@: " + new Date());
		
		List<File> files = DriveHelper.retrieveAllFiles(service);
		resp.getWriter().println("Arquivos no Drive: " + files.size());
		
		System.out.println("End@: " + new Date());
		
		
//		List list = service.files().list();
//		for (int i = 0; i < list.size(); i++) {
//			list.
//		}
		
//		FileList fl = service.files().list().execute();

		
		
		
		
//		System.out.println(fl);
		
		

//		String fileId = "1xrg9AFgvZj-pCjoToasMm4sS7B1jPTHH0FIJ7AC_jNg";
//		 try {
//		      File file = service.files().get(fileId).execute();
//
//		      System.out.println("Title: " + file.getTitle());
//		      System.out.println("Description: " + file.getDescription());
//		      System.out.println("MIME type: " + file.getMimeType());
//		      
//		    } catch (HttpResponseException e) {
//		      if (e.getStatusCode() == 401) {
//		        // Credentials have been revoked.
//		        // TODO: Redirect the user to the authorization URL.
//		        throw new UnsupportedOperationException();
//		      }
//		    } catch (IOException e) {
//		      System.out.println("An error occurred: " + e);
//		    }		
		
		
//		List fileList = 
//		FileList fileList = service.files().list().execute();

	
//		System.out.println("List: " + fileList);
		
//		
//		
//		try {
////		      File file = service.files().get(fileId).execute();
//
//		      System.out.println("Title: " + file.getTitle());
//		      System.out.println("Description: " + file.getDescription());
//		      System.out.println("MIME type: " + file.getMimeType());
//		    } catch (HttpResponseException e) {
//		      if (e.getStatusCode() == 401) {
//		        // Credentials have been revoked.
//		        // TODO: Redirect the user to the authorization URL.
//		        throw new UnsupportedOperationException();
//		      }
//		    } catch (IOException e) {
//		      System.out.println("An error occurred: " + e);
//		    }
		
		System.out.println("...");
		
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
