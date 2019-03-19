/**
 * 
 */
package ua.kyiv.photo.api.folders;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ua.kyiv.photo.api.service.ServiceJPG;

/**
 * @author firsov
 *
 */
@Path("/photo")
public class Photos extends BaseFile{
	
	@EJB
	private ServiceJPG service;
	
	@GET
	@Path("/{nameFolder}/{nameFile}")
	@Produces("image/png")
	public Response getPhoto(@PathParam("nameFolder") String nameFolder ,@PathParam("nameFile") String fileName) {
		String path = "/home/scanner/PHOTO/" + nameFolder;
    	return Response.ok().cacheControl(getCacheControl()).entity(service.read(path, fileName)).build();
	}

}