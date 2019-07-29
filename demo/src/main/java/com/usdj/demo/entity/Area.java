package com.usdj.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author gerrydeng
 * @date 2019-07-29 12:44
 * @Description:
 */
@Data
public class Area {

	private Integer areaId;

	private String areaName;

	private Integer priority;

	private Date createTime;

	private Date lastEditTime;
}
