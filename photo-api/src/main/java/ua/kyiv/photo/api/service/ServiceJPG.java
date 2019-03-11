/**
 * 
 */
package ua.kyiv.photo.api.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.ejb.Stateless;

/**
 * @author firsachi
 *
 */
@Stateless
public class ServiceJPG {
	
	public byte[] read(String path, String fileNmae) {
		File repositoryFile = new File(path, fileNmae + ".jpg");
		if (!repositoryFile.exists()) {
			repositoryFile = new File(path, fileNmae + ".JPG");
		}
		try(FileInputStream inStream = new FileInputStream(repositoryFile))	{
			byte[] result = new byte[(int) repositoryFile.length()];
			inStream.read(result);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}