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
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.appengine.api.images.ImagesServicePb.OutputSettings.MIME_TYPE;

@SuppressWarnings("serial")
public class CallbackServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		resp.setContentType("text/html");

		// MyClass myClass = new MyClass();
		// String url = myClass.getAuthorizationUrl("marcio.mangar@gmail.com", "scope");
		// String url = AuthenticationHelper.getAuthorizationUrl("", "scope");

		String code = req.getParameter("code");
		String state = req.getParameter("state");

		resp.getWriter().println("Code: " + code + "<br>");
		resp.getWriter().println("State: " + state + "<br>");

		Credential credential = this.getCredential(code, state);

		String accessToken = credential.getAccessToken();
		resp.getWriter().println("Access Token: " + accessToken + "<br>");

		// GoogleCredential gCredential = new GoogleCredential();
		// gCredential.setAccessToken(accessToken);

		Drive service = DriveHelper.buildService(credential);
		resp.getWriter().println("Drive OK <br>");

		resp.getWriter().println("<hr>");

		System.out.println("Start@: " + new Date());

		List<File> files = DriveHelper.retrieveFiles(service, "title contains 'h2oh'");
		resp.getWriter().println("Arquivos no Drive: " + files.size());

		System.out.println("End@: " + new Date());

		for (File file : files) {
			resp.getWriter().println(" - " + file.getTitle() + "<br>");
		}

		resp.getWriter().println("<hr>");

		// //Insert a file
		// File body = new File();
		// body.setTitle("Plano de Midia - Modelo - Title");
		// body.setDescription("Descrioption: Modelo de Plano de Midia");
		// body.setMimeType("application/vnd.google-apps.document");
		//
		// java.io.File fileContent = new java.io.File("PlanoDeMidia-Modelo.docx");
		//
		// System.out.println(fileContent.getCanonicalFile());
		// System.out.println(fileContent.getPath());
		// System.out.println(fileContent.getAbsolutePath());
		//
		// FileContent mediaContent = new FileContent("application/vnd.google-apps.document", fileContent);
		//
		// File file = service.files().insert(body, mediaContent).execute();
		// System.out.println("File ID: " + file.getId());
		//
		//

//		java.io.File fileContent = new java.io.File("mario.jpeg");
//
//		File fileMetadata = new File();
//		fileMetadata.setTitle("nome_do_arquivo");
//		
//		FileContent mediaContent = new FileContent("image/jpeg", fileContent);

		
		java.io.File fileContent = new java.io.File("Plano_de_Midia__Modelo.docx");
//		java.io.File fileContent = new java.io.File("Plano_de_Midia_-_Modelo.gdoc");
		
		File fileMetadata = new File();
//		fileMetadata.setTitle("Plano de Midia - Modelo.gdoc");
		fileMetadata.setTitle("Plano de Midia - Modelo.docx");
		
//		FileContent mediaContent = new FileContent("application/vnd.google-apps.document", fileContent);	
		FileContent mediaContent = new FileContent("application/vnd.openxmlformats-officedocument.wordprocessingml.document", fileContent);
//		FileContent mediaContent = new FileContent(null, fileContent);
				
		Drive.Files.Insert insert = service.files().insert(fileMetadata, mediaContent);
		insert.setConvert(true);
		
		MediaHttpUploader uploader = insert.getMediaHttpUploader();
		uploader.setDirectUploadEnabled(true);
		
		File file = insert.execute();

		
		
		
		
		
		String fileId = file.getId();
		System.out.println(fileId);
		
		// return insert.execute();

		System.out.println("...");

	}

	public Credential getCredential(final String code, final String state) {
		Credential credential = null;
		try {
			credential = AuthenticationHelper.getCredentials(code, state);

		} catch (Exception e) {
			System.err.println("Erro ao obter as credenciais do usuario..." + e.toString());
		}
		return credential;
	}

}
