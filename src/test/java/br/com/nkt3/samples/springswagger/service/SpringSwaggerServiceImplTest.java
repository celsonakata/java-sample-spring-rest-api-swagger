package br.com.nkt3.samples.springswagger.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.nkt3.samples.springswagger.exception.ServiceException;
import br.com.nkt3.samples.springswagger.model.Book;
import br.com.nkt3.samples.springswagger.repository.BookRepository;

public class SpringSwaggerServiceImplTest {

	@InjectMocks
	private SpringSwaggerServiceImpl service;
	
	@Mock
	private BookRepository dao;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetBooks() throws ServiceException {
		Mockito.when(dao.findAll()).thenReturn(new ArrayList<Book>());
		List<Book> result = service.getBooks();
		Assert.assertNotNull(result);
	}

	@Test
	public void testGetBook() throws ServiceException {
		LocalDate now = LocalDate.now();
		Book book = new Book();
		book.setTitle("title");
		book.setDescription("description");
		book.setAuthor("author");
		book.setEdition("edition");
		book.setPages(0);
		book.setLaunchDate(now);
		book.setStatus("status");
		book.setPublisher("publisher");
		Mockito.when(dao.findById(Mockito.any())).thenReturn(Optional.of(book));
		Book result = service.getBook(0L);
		Assert.assertNotNull(result);
		Assert.assertEquals(result.getTitle(), book.getTitle());
		Assert.assertEquals(result.getDescription(), book.getDescription());
		Assert.assertEquals(result.getAuthor(), book.getAuthor());
		Assert.assertEquals(result.getEdition(), book.getEdition());
		Assert.assertEquals(result.getPages(), book.getPages());
		Assert.assertEquals(result.getLaunchDate(), book.getLaunchDate());
		Assert.assertEquals(result.getStatus(), book.getStatus());
		Assert.assertEquals(result.getPublisher(), book.getPublisher());
		Assert.assertNotNull(result.toString());
	}

	@Test
	public void testInsertBook() throws ServiceException {
		Mockito.when(dao.save(Mockito.any())).thenReturn(new Book());
		Book result = service.insertBook(new Book());
		Assert.assertNotNull(result);
	}

	@Test
	public void testUpdateBook() throws ServiceException {
		Mockito.when(dao.existsById(Mockito.any())).thenReturn(true);
		Mockito.when(dao.save(Mockito.any())).thenReturn(new Book());
		Book result = service.updateBook(new Book());
		Assert.assertNotNull(result);
	}

	@Test(expected = ServiceException.class)
	public void testUpdateBookNotFound() throws ServiceException {
		Mockito.when(dao.save(Mockito.any())).thenReturn(new Book());
		service.updateBook(new Book());
	}
	
	@Test
	public void testDeleteBook() throws ServiceException {
		Mockito.doNothing().when(dao).delete(Mockito.any());
		service.deleteBook(0L);
	}
}
