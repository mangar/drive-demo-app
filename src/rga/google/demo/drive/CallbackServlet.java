package rga.google.demo.drive;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

@SuppressWarnings("serial")
public class CallbackServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		resp.setContentType("text/html");
		
		String code = req.getParameter("code");
		req.setAttribute("code", code);
		
		String state = req.getParameter("state");
		req.setAttribute("state", state);
				
		// 1 - obtendo a permissão (creentials) do usuario...		
		Credential credential = this.getCredential(code, state);
		String accessToken = credential.getAccessToken();
		req.setAttribute("accessToken", accessToken);
		

		// 2 - criando o servico para manipular o Drive do usuário...		
		Drive service = DriveHelper.buildService(credential);

		System.out.println("Start@: " + new Date());

		// 3 - listando os arquivos do usuário ...		
		List<File> files = DriveHelper.retrieveFiles(service, "title contains '" + state + "'");
		
		req.setAttribute("arquivosNoDrive", files.size());

		req.setAttribute("files", files);
		
		System.out.println("End@: " + new Date());


		// 4 - enviando um arquivo para o Drive do usuário...
		java.io.File fileContent = new java.io.File("DocumentoModelo.docx");
		
		File fileMetadata = new File();
		fileMetadata.setTitle("Documento Modelo");
			
		FileContent mediaContent = new FileContent("application/vnd.openxmlformats-officedocument.wordprocessingml.document", fileContent);
				
		Drive.Files.Insert insert = service.files().insert(fileMetadata, mediaContent);
		insert.setConvert(true);
		
		MediaHttpUploader uploader = insert.getMediaHttpUploader();
		uploader.setDirectUploadEnabled(true);
		
		File file = insert.execute();		
		req.setAttribute("fileIdUploaded", file.getId());


		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/callback.jsp");
		dispatcher.forward(req, resp);
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
