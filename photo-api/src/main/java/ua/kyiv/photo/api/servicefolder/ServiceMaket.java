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
 * @author firsov
 *
 */
@Path("/maket")
public class ServiceMaket extends ServiceBaseFile implements BaseSimpleFilePath{
	
	@PostConstruct
	public void init() {
		this.path = "/home/scanner/MAKET/";
		this.fileExtension = ".jpg";
	}

		@GET
		@Override
		@Path("/{nameFile}")
		@Produces("image/png")
		public Response getFile(@PathParam("nameFile")String fileName) {
			return Response.ok().cacheControl(getCacheControl()).entity(service.read(this.path, fileName, fileExtension)).build();
	}
	
}
