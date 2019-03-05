/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kyiv.photo.api.settings;

import javax.ejb.Stateless;

/**
 *
 * @author firsov
 */
@Stateless
public class AppSettings {
    
	private String patch;
	
	private String folder;
    
	public String getPatch() {
		return patch;
	}

	public void setPatch(String patch) {
		this.patch = patch;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getPatch(String id) {
		return String.format(patch, folder, id);
	}

	public String setPatch(String nameFolder, String id) {
		return String.format(patch, folder, nameFolder, id);
	}
    
}
