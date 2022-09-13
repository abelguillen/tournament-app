package com.aguillen.tournamentapp.dto;

import java.util.List;

public class RoleDTO {
	
	private Long id;
    private String name;
    private List<PrivilegeDTO> privilegeList;
    
	public RoleDTO(Long id, String name, List<PrivilegeDTO> privilegeList) {
		super();
		this.id = id;
		this.name = name;
		this.privilegeList = privilegeList;
	}
    
	public RoleDTO() {}

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

	public List<PrivilegeDTO> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<PrivilegeDTO> privilegeList) {
		this.privilegeList = privilegeList;
	}

}
