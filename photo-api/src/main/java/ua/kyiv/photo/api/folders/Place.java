/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.photo.api.folders;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ua.kyiv.photo.api.service.ServiceJPG;
import ua.kyiv.photo.api.settings.PathFile;
/**
 *
 * @author firsov
 */
@Path("/place")
public class Place extends BaseFile{
	
	@Inject
	private ServiceJPG service;
	
	@GET
	@Path("/{nameFile}")
	@Produces("image/png")
	public Response getPhoto(@PathParam("nameFile") String fileName) {
		appSettings.setPath(PathFile.PATCH_PARAMETRS, "PLACE");
    	return Response.ok().cacheControl(getCacheControl()).entity(service.read("/home/scanner/PLACE/", fileName)).build();
	}
	
}