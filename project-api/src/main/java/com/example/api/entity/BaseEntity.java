package com.example.api.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 基础公共类
 * 
 * @author Administrator
 *
 */
@Data
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	
	private Date createTime;
	
	private Date creater;
	
	private Date updateTime;
	
	private Date regenerator;
}
