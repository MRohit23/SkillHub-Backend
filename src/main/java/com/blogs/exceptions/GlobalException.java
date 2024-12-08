package com.blogs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.project.dto.ErrorDto;

@RestControllerAdvice
public class GlobalException 
{
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDto> methodArgumentNotValidException(MethodArgumentNotValidException exception, WebRequest webRequest)
	{
		ErrorDto errorDto = new ErrorDto();
		errorDto.setApiPath(webRequest.getDescription(false));
		errorDto.setErrorCode(HttpStatus.BAD_REQUEST);
		errorDto.setErrorMessage(exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(errorDto);
	}
}
