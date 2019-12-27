package br.com.nkt3.samples.springswagger.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nkt3.samples.springswagger.dao.BookDao;
import br.com.nkt3.samples.springswagger.exception.ServiceException;
import br.com.nkt3.samples.springswagger.model.Book;

@Service
public class SpringSwaggerServiceImpl implements SpringSwaggerService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> getBooks() throws ServiceException {
		return StreamSupport.stream(bookDao.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Book getBook(Long id) throws ServiceException {
		return bookDao.findById(id).get();  
	}

	@Override
	public Book insertBook(Book livro) throws ServiceException {
		return bookDao.save(livro);
	}

	@Override
	public Book updateBook(Book livro) throws ServiceException {
		if (!bookDao.existsById(livro.getId())) {
			throw new ServiceException("Book not found");
		}
		return bookDao.save(livro);
	}

	@Override
	public void deleteBook(Long id) throws ServiceException {
		Book livro = new Book(id, "", "", "", "", 0, null, "", "");
		bookDao.delete(livro);
	}
}
