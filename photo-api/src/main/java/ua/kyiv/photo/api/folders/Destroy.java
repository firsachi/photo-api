/**
 * 
 */
package ua.kyiv.photo.api.folders;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ua.kyiv.photo.api.service.ServiceJPG;
import ua.kyiv.photo.api.settings.PathFile;

/**
 * @author firsachi
 *
 */
@Path("/destroy")
public class Destroy extends BaseFile{


	@Inject
	private ServiceJPG service;
	
	@GET
	@Path("/{nameFile}")
	@Produces("image/png")
	public Response getPhoto(@PathParam("nameFile") String fileName) {
		appSettings.setPath(PathFile.PATCH_PARAMETRS, "DESTROY");
    	return Response.ok().cacheControl(getCacheControl()).entity(service.read(appSettings.getPatch(), fileName)).build();
	}
	
}