/**
 * 
 */
package ua.kyiv.photo.api.servicefolder;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * @author firsachi
 *
 */
@Path("/small")
public class ServiceSmall extends ServiceBaseFile implements BaseComplexFilePath{
	
	@PostConstruct
	public void init() {
		this.path = "/home/scanner/SMALL/";
		this.fileExtension = ".jpg";
	}

	@GET
	@Path("/{nameFolder}/{nameFile}")
	@Produces("image/png")
	@Override
	public Response getPhoto(@PathParam("nameFolder") String nameFolder, @PathParam("nameFile") String fileName) {
		this.path = this.path + nameFolder;
    	return Response.ok().cacheControl(getCacheControl()).entity(service.read(this.path, fileName, fileExtension)).build();
	}

}
