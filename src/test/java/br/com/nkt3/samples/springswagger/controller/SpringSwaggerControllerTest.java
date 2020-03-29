package br.com.nkt3.samples.springswagger.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import br.com.nkt3.samples.springswagger.exception.ServiceException;
import br.com.nkt3.samples.springswagger.model.Book;
import br.com.nkt3.samples.springswagger.service.SpringSwaggerService;

public class SpringSwaggerControllerTest {

	@InjectMocks
	private SpringSwaggerController controller;
	
	@Mock
	private SpringSwaggerService service;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetBooks() throws ServiceException {
		Mockito.when(service.getBooks()).thenReturn(new ArrayList<Book>());
		List<Book> result = controller.getBooks();
		Assert.assertNotNull(result);
	}

	@Test(expected = ResponseStatusException.class)
	public void testGetBooksException() throws ServiceException {
		Mockito.when(service.getBooks()).thenThrow(ServiceException.class);
		controller.getBooks();
	}
	
	@Test
	public void testGetBook() throws ServiceException {
		Mockito.when(service.getBook(Mockito.any())).thenReturn(new Book());
		Book result = controller.getBook(0L);
		Assert.assertNotNull(result);
	}

	@Test(expected = ResponseStatusException.class)
	public void testGetBookNoElement() throws ServiceException {
		Mockito.when(service.getBook(Mockito.any())).thenThrow(NoSuchElementException.class);
		controller.getBook(0L);
	}
	
	@Test(expected = ResponseStatusException.class)
	public void testGetBookException() throws ServiceException {
		Mockito.when(service.getBook(Mockito.any())).thenThrow(ServiceException.class);
		controller.getBook(0L);
	}
	
	@Test
	public void testInsertBook() throws ServiceException {
		Mockito.when(service.insertBook(Mockito.any())).thenReturn(new Book());
		Book result = controller.insertBook(new Book());
		Assert.assertNotNull(result);
	}

	@Test(expected = ResponseStatusException.class)
	public void testInsertBookException() throws ServiceException {
		Mockito.when(service.insertBook(Mockito.any())).thenThrow(ServiceException.class);
		controller.insertBook(new Book());
	}
	
	@Test
	public void testUpdateBook() throws ServiceException {
		Mockito.when(service.updateBook(Mockito.any())).thenReturn(new Book());
		Book result = controller.updateBook(new Book());
		Assert.assertNotNull(result);
	}

	@Test(expected = ResponseStatusException.class)
	public void testUpdateBookNoElement() throws ServiceException {
		Mockito.when(service.updateBook(Mockito.any())).thenThrow(NoSuchElementException.class);
		controller.updateBook(new Book());
	}

	@Test(expected = ResponseStatusException.class)
	public void testUpdateBookException() throws ServiceException {
		Mockito.when(service.updateBook(Mockito.any())).thenThrow(ServiceException.class);
		controller.updateBook(new Book());
	}
	
	@Test
	public void testDeleteBook() throws ServiceException {
		Mockito.doNothing().when(service).deleteBook(Mockito.any());
		controller.deleteBook(0L);
	}

	@Test(expected = ResponseStatusException.class)
	public void testDeleteBookNoElement() throws ServiceException {
		Mockito.doThrow(NoSuchElementException.class).when(service).deleteBook(Mockito.any());
		controller.deleteBook(0L);
	}

	@Test(expected = ResponseStatusException.class)
	public void testDeleteBookException() throws ServiceException {
		Mockito.doThrow(ServiceException.class).when(service).deleteBook(Mockito.any());
		controller.deleteBook(0L);
	}
}
