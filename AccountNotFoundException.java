package com.pack.exception;

public class AccountNotFoundException extends Exception{
 @Override
	public String toString()
	{
		
		return "No Accounts exist on given corporate";
	}
}
