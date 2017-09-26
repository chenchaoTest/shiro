package com.cc.shiro.utils;

import java.util.List;

/**
 * easyUIDataGrid对象返回值
 * <p>Title: EasyUIResult</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	陈超
 * @date	2016年11月30日 15:17:19
 * @version 1.0
 */
public class EasyUIResult {

	private long total;
	private List<?> rows;
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
