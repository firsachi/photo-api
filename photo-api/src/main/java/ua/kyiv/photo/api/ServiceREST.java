package ua.kyiv.photo.api;

import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

@Stateless
@Path("/place")
@ApplicationPath("/api")
public class ServiceREST extends Application{
	
	@GET
	@Path("/hello")
	public String getHello() {
		return "Hello world!";
	}

}
