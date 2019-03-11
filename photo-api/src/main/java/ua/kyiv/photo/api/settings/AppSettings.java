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
    
	private String path;
    
	public String getPatch() {
		return path;
	}

	public void setPath(String path, String folderName) {
		this.path = String.format(path, folderName);
	}
	
	public void setPath(String path, String firstFolderName, String secondFolderName) {
		this.path = String.format(path, firstFolderName, secondFolderName);
	}
    
}