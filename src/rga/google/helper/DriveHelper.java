/**
 * 
 */
package rga.google.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

/**
 * @author marciog
 * 
 */
public class DriveHelper {

	/**
	 * Build a Drive service object.
	 * 
	 * @param credentials
	 *            OAuth 2.0 credentials.
	 * @return Drive service object.
	 */
	// public static Drive buildService(GoogleCredential credentials) {
	// HttpTransport httpTransport = new NetHttpTransport();
	// JacksonFactory jsonFactory = new JacksonFactory();
	//
	// return new Drive.Builder(httpTransport, jsonFactory, credentials).build();
	// }

	public static Drive buildService(Credential credentials) {
		HttpTransport TRANSPORT = new NetHttpTransport();
		JacksonFactory JSON_FACTORY = new JacksonFactory();

		return new Drive.Builder(TRANSPORT, JSON_FACTORY, credentials).build();
	}

	/**
	 * 
	 * @param service
	 * @return
	 * @throws IOException
	 */
	public static List<File> retrieveAllFiles(Drive service) throws IOException {
		List<File> result = new ArrayList<File>();
		Files.List request = service.files().list();

		do {
			try {
				FileList files = request.execute();

				result.addAll(files.getItems());
				request.setPageToken(files.getNextPageToken());
			} catch (IOException e) {
				System.out.println("An error occurred: " + e);
				request.setPageToken(null);
			}
		} while (request.getPageToken() != null && request.getPageToken().length() > 0);

		return result;
	}

}
