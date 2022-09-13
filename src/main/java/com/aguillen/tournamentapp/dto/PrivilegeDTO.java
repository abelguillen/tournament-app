package com.aguillen.tournamentapp.dto;

public class PrivilegeDTO {

	private Long id;
	private String name;
	
	public PrivilegeDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public PrivilegeDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
