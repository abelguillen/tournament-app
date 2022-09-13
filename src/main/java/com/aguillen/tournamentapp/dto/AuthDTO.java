/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aguillen.tournamentapp.dto;

/**
 *
 * @author Abel Guillen
 */
public class AuthDTO {
    
	private long id;
    private String username;
    private String password;
    private String avatar;

    public AuthDTO(long id, String username, String password, String avatar) {
    	this.id = id;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
    }
    
    public AuthDTO() {}

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
    
}
