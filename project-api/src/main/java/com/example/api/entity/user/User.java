package com.example.api.entity.user;

import com.example.api.entity.DataEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class User extends DataEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String account;
	
	private String password;
	
	private int role;
	
	
}
