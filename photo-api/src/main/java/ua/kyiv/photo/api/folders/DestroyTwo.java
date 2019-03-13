/**
 * 
 */
package ua.kyiv.photo.api.folders;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;

/**
 * @author firsov
 *
 */
@Path("/destroy-two")
public class DestroyTwo extends BaseFile{
	
	@PostConstruct
	public void init() {
		path = "/home/scanner/DESTROY2/";
	}
}
