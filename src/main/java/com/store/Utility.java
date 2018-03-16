package com.store;

public class Utility {
	
	public static boolean numberOrNot(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException ex) {
			return false;
		}
		
		return true;
	}

}
