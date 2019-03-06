/**
 * 
 */
package ua.kyiv.photo.api.folders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;

import ua.kyiv.photo.api.settings.AppSettings;

/**
 * @author firsov
 *
 */
public abstract class BaseFile {
	
	private CacheControl cacheControl;
	
	@Inject
	protected AppSettings appSettings;
	
	public void setAppSettings(AppSettings appSettings) {
		this.appSettings = appSettings;
	}

	public BaseFile() {
		super();
		this.cacheControl = new CacheControl();
		cacheControl.setNoCache(true);
    	cacheControl.setNoStore(true);
    	cacheControl.setPrivate(false);
    	cacheControl.setMaxAge(-1);
	}

	public CacheControl getCacheControl() {
		return cacheControl;
	}
	
	public Response fileNotFound() {
		return Response.ok().cacheControl(getCacheControl()).entity("!!! FILE NOT FOUND !!!!").build();
	}
	
	@GET
    @Path("/{id}")
    @Produces("image/png")
    public Response getImage(@PathParam("id") String id){ 
    	String path = appSettings.getPatch(id);
    	return readFile(path);
    }
	
	@GET
	@Path("/{nameFolder}/{id}")
	@Produces("image/png")
	public Response getPhoto(@PathParam("nameFolder") String nameFolder ,@PathParam("id") String id) {
		String path = appSettings.setPatch(nameFolder, id);
    	return readFile(path);
	}
	
	private Response readFile(String path) {
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
