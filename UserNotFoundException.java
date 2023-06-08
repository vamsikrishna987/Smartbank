package com.pack.exception;

public class UserNotFoundException extends Exception{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
	public String toString()
	{
		
		return "No Users exist on given corporate";
	}
}
