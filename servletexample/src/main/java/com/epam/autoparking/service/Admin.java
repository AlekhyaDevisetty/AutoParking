package com.epam.autoparking.service;

public class Admin {
	public boolean match(String u, String p) {
		if(u.equals("alekhya") && p.equals("3341")) {
			return true;
		}
		else {
			return false;
		}
	}
}
