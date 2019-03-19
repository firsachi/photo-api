/**
 * 
 */
package ua.kyiv.photo.api.servicefolder;
import javax.ejb.EJB;
import javax.ws.rs.core.CacheControl;

import ua.kyiv.photo.api.repository.RepositoryFile;


/**
 * @author firsov
 *
 */
public abstract class ServiceBaseFile {
	
	@EJB
	protected RepositoryFile service;
	
	protected String fileExtension;
	
	private CacheControl cacheControl;
	
	protected String path;

	public ServiceBaseFile() {
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
	
}