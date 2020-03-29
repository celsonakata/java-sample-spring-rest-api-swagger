package br.com.nkt3.samples.springswagger.handler;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ValidationExceptionHandlerTest {

	@InjectMocks
	private ValidationExceptionHandler handler;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testHandleMethodArgumentNotValid() {
		BindingResult bindingResult = new MapBindingResult(Collections.singletonMap("a", "b"), "object");
		bindingResult.addError(new ObjectError("c", "d"));
		MethodArgumentNotValidException methodArgumentNotValidException = 
				new MethodArgumentNotValidException(null, bindingResult);
		
		ResponseEntity<Object> result = handler.handleMethodArgumentNotValid(
				methodArgumentNotValidException, Mockito.any(), HttpStatus.OK, Mockito.any());
		Assert.assertNotNull(result);
	}
}
