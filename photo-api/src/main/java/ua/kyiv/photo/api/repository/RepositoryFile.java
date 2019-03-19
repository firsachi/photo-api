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
		byte[] result = null;
		if (!repositoryFile.exists()) {
			repositoryFile = new File(path, fileNmae + ".JPG");
		}if(!repositoryFile.exists()){
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("error.jpg").getFile());
			file.renameTo(repositoryFile);
			result = new byte[(int) file.length()];
			try (FileInputStream inStream = new FileInputStream(file)) {
				inStream.read(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		try(FileInputStream inStream = new FileInputStream(repositoryFile))	{
			result = new byte[(int) repositoryFile.length()];
			inStream.read(result);
		}
		catch (IOException e) {
			e.printStackTrace();
			
		}
		return result;
	}

}