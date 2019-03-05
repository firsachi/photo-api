/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.photo.api.folders;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;

import ua.kyiv.photo.api.settings.PathFile;

/**
 *
 * @author firsov
 */
@Path("/place")
public class Place extends BaseFile{
	
	@PostConstruct
	public void init() {
		appSettings.setPatch(PathFile.PATCH_PARAMETRS);
		appSettings.setFolder("PLACE");
	}
	
}