package com.pack.exception;

public class AdminNotFoundException extends Exception{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
	public String toString()
	{
		
		return "Admin Id not found";
	}

}
