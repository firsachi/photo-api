/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.photo.api.servicefolder;

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
public class ServicePlace extends ServiceBaseFile implements BaseSimpleFilePath{
	
	@PostConstruct
	public void init() {
		this.path = "/mnt/scanner/PLACE/";
		this.fileExtension = ".jpg";
	}

		@GET
		@Override
		@Path("/{nameFile}")
		@Produces("image/png")
		public Response getFile(@PathParam("nameFile")String fileName) {
			return Response.ok().cacheControl(getCacheControl()).entity(service.read(this.path, fileName, fileExtension)).build();
	}
	
}