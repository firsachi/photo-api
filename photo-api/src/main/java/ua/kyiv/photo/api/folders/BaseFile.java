/**
 * 
 */
package ua.kyiv.photo.api.folders;

import javax.inject.Inject;
import javax.ws.rs.core.CacheControl;

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
	
}