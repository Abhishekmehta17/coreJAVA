package com.employee;

public enum Department {
	
	RND,HR,SALES,FINANCE,PRODUCTION;
	
	@Override
	public String toString() {
		return name();
	}

}
