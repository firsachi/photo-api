/**
 * 
 */
package ua.kyiv.photo.api.servicefolder;

import javax.ws.rs.core.Response;

/**
 * @author firsachi
 *
 */
public interface BaseComplexFilePath {

	public Response getPhoto(String nameFolder ,String fileName);
}
