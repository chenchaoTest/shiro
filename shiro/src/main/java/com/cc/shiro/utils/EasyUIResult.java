package com.cc.shiro.utils;

import java.util.List;

/**
 * easyUIDataGrid���󷵻�ֵ
 * <p>Title: EasyUIResult</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	�³�
 * @date	2016��11��30�� 15:17:19
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
