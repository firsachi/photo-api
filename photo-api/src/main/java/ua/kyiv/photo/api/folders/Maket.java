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
@Path("/maket")
public class Maket extends BaseFile{
	
	@PostConstruct
	public void init() {
		path = "/home/scanner/MAKET/";
	}
	
}
