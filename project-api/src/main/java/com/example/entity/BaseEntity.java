package com.example.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础公共类
 * 
 * @author Administrator
 *
 */
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
