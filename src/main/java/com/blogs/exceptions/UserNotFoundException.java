package com.blogs.exceptions;

public class UserNotFoundException extends RuntimeException 
{
	private static final long serialVersionUID = -9090354276272513606L;

	public UserNotFoundException(String message)
	{
		super(message);
	}

}
