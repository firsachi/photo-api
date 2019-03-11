/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.photo.api.folders;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author firsov
 */
@Path("/place")
public class Place extends BaseFile{
	
	@PostConstruct
	public void init() {
		appSettings.setPatch("/home/scanner//%s//%s.jpg");
		appSettings.setFolder("PLACE");
	}
	
	@GET
    @Path("/{id}")
    @Produces("image/png")
    public Response getImage(@PathParam("id") String id){ 
    	String path = appSettings.getPatch(id);
    	return readFile(path);
    }
	
}
