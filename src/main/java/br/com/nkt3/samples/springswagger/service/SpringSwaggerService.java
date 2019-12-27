package br.com.nkt3.samples.springswagger.service;

import java.util.List;

import br.com.nkt3.samples.springswagger.exception.ServiceException;
import br.com.nkt3.samples.springswagger.model.Book;

public interface SpringSwaggerService {

	public List<Book> getBooks() throws ServiceException;
	
	public Book getBook(Long id) throws ServiceException;
	
	public Book insertBook(Book book) throws ServiceException;
	
	public Book updateBook(Book book) throws ServiceException;
	
	public void deleteBook(Long id) throws ServiceException;
}
