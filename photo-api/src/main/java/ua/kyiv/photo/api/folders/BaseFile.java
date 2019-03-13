/**
 * 
 */
package ua.kyiv.photo.api.folders;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;

import ua.kyiv.photo.api.service.ServiceJPG;


/**
 * @author firsov
 *
 */
public abstract class BaseFile {
	
	@EJB
	private ServiceJPG service;
	
	private CacheControl cacheControl;
	
	protected String path;

	public BaseFile() {
		super();
		this.cacheControl = new CacheControl();
		cacheControl.setNoCache(true);
    	cacheControl.setNoStore(true);
    	cacheControl.setPrivate(false);
    	cacheControl.setMaxAge(-1);
	}
	
	@GET
	@Path("/{nameFile}")
	@Produces("image/png")
	public Response getPhoto(@PathParam("nameFile") String fileName) {
		return Response.ok().cacheControl(getCacheControl()).entity(service.read(path, fileName)).build();
	}
	
	public CacheControl getCacheControl() {
		return cacheControl;
	}
	
}