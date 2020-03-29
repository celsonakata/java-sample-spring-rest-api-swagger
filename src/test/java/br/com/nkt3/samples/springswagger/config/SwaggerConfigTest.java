package br.com.nkt3.samples.springswagger.config;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class SwaggerConfigTest {

	@InjectMocks
	private SwaggerConfig swaggerConfig;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testApi() {
		swaggerConfig.api();
	}
}
