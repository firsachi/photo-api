/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.photo.api.folders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
