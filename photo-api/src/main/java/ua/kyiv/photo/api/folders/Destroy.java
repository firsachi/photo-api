/**
 * 
 */
package ua.kyiv.photo.api.folders;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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
	
	@GET
    @Path("/{id}")
    @Produces("image/png")
    public Response getImage(@PathParam("id") String id){ 
    	String path = appSettings.getPatch(id);
    	return readFile(path);
    }
	
}
