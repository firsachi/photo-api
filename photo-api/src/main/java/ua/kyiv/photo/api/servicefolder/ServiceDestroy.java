/**
 * 
 */
package ua.kyiv.photo.api.folders;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;

/**
 * @author firsachi
 *
 */
@Path("/destroy")
public class Destroy extends BaseFile{

	@PostConstruct
	public void init() {
		path = "/home/scanner/DESTROY/";
	}
	
}