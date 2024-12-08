package com.project.dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorDto 
{
	private String ApiPath;
	private HttpStatus errorCode;
	private String errorMessage;
}
