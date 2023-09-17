package com.app.custom_Exceptions;
//package com.app.custom_Exceptions;
//
//import java.time.LocalDateTime;
//
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import com.app.dto.ErrorResponse;
//
//@ControllerAdvice 
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//
//
//	@ExceptionHandler(EmptyResultDataAccessException.class)
//	public ResponseEntity<?> handleEmptyDataExcetpion(EmptyResultDataAccessException e)
//	{
//		System.out.println("in handle empty result exc "+e);
//		ErrorResponse resp=new ErrorResponse(e.getMessage(), LocalDateTime.now());
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
//	}
//	@ExceptionHandler(RuntimeException.class)
//	public ResponseEntity<?> handleRuntimeException(RuntimeException e)
//	{
//		System.out.println("in handle run time exc "+e);
//		ErrorResponse resp=new ErrorResponse(e.getMessage(), LocalDateTime.now());
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
//	}
//}
