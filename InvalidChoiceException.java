package com.lms.library;

@SuppressWarnings("serial")
public class InvalidChoiceException extends RuntimeException 
{

	@Override
	public String toString() 
	{
		return "Given String is Invalid Please Enter 1 to 6";
	}
	
}
