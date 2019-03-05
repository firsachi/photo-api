/**
 * 
 */
package ua.kyiv.photo.api.folders;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;

import ua.kyiv.photo.api.settings.PathFile;


/**
 * @author firsachi
 *
 */
@Path("/destroy")
public class Destroy extends BaseFile{

	@PostConstruct
	public void init() {
		appSettings.setPatch(PathFile.PATCH_PARAMETRS);
		appSettings.setFolder("DESTROY");
	}
	
}
