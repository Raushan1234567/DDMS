package com.c3ihub.exception;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<ErrorDetails> getErrors(MethodArgumentNotValidException me){
		ErrorDetails re=new ErrorDetails();
	    
		re.setMessage("validation exception");
		re.setTimeStamp(LocalDateTime.now());
		 List<ObjectError> o=me.getBindingResult().getAllErrors();
		 List<String> o1=MethodArgumentNotValidException.errorsToStringList(o);
		 
		 re.setDescription(String.join(", ", o1));
		 
		return new ResponseEntity<ErrorDetails>(re , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> GeneralExceptionHandler(Exception se){
		return new ResponseEntity<>(se.getMessage() , HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(DogNotFoundException.class)
	public ResponseEntity<String> customerExceptionHandler(DogNotFoundException se){
		return new ResponseEntity<>(se.getMessage() , HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<String> NoHandelerExceptionHandler(NoHandlerFoundException se){
		return new ResponseEntity<>("There is no handler for this endpoint" , HttpStatus.BAD_REQUEST) ;
	}

}

