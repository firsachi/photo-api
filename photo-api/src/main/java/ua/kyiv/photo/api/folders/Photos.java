/**
 * 
 */
package ua.kyiv.photo.api.folders;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;

import ua.kyiv.photo.api.settings.PathFile;

/**
 * @author firsov
 *
 */
@Path("/photo")
public class Photos extends BaseFile{
	
	@PostConstruct
	public void init() {
		appSettings.setPatch(PathFile.PATCH_TWO_PARAMETRS);
		appSettings.setFolder("PHOTO");
	}

}
