/**
 * 
 */
package ua.kyiv.photo.api.folders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
@Path("/destroy")
public class Destroy extends BaseFile{

	@PostConstruct
	public void init() {
		appSettings.setPatch("/home/scanner//%s//%s.jpg");
		appSettings.setFolder("DESTROY");
	}
	
	@GET
    @Path("/{id}")
    @Produces("image/png")
    public Response getImage(@PathParam("id") String id){ 
    	String path = appSettings.getPatch(id);
    	File repositoryFile = new File(path);
		try(FileInputStream photo = new FileInputStream(repositoryFile);){
			return Response.ok().cacheControl(getCacheControl()).entity(photo).build();
		} catch (FileNotFoundException e) {
			return Response.ok().cacheControl(getCacheControl()).entity("No photo!").build();
		} catch (IOException e1) {
			return Response.ok().cacheControl(getCacheControl()).entity("No photo!").build();
		}
    }
	
}
