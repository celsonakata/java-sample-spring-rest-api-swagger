package br.com.nkt3.samples.springswagger.exception;

import org.junit.Test;
import org.mockito.Mockito;

public class ServiceExceptionTest {

	@Test
	public void testServiceExceptionStringThrowable() {
		new ServiceException("errorMessage", new Throwable());
	}

	@Test
	public void testServiceExceptionString() {
		new ServiceException("errorMessage");
	}

}
