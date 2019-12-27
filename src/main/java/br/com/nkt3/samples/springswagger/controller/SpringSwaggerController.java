package br.com.nkt3.samples.springswagger.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.nkt3.samples.springswagger.exception.ServiceException;
import br.com.nkt3.samples.springswagger.model.Book;
import br.com.nkt3.samples.springswagger.service.SpringSwaggerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/book")
@Api(value = "Books REST API")
public class SpringSwaggerController {

	@Autowired
	private SpringSwaggerService service;
	
	@ApiOperation(value = "Get a list of all the books", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns a list with all the books"),
			@ApiResponse(code = 400, message = "Database data access error")
	})
	@GetMapping("")
	public @ResponseBody List<Book> getBooks() {
		try {
			return service.getBooks();
			
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
	
	@ApiOperation(value = "Get the details from a selected book", response = Book.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Return the details from a selected book"),
			@ApiResponse(code = 400, message = "Database data access error"),
			@ApiResponse(code = 404, message = "Selected book not found")
	})
	@GetMapping("/{id}")
	public @ResponseBody Book getBook(
			@ApiParam(value = "Book ID", required = true) @PathVariable Long id) {
		try {
			return service.getBook(id);
			
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}

	@ApiOperation(value = "Insert a new book", response = Book.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successful of new book is added"),
			@ApiResponse(code = 400, message = "Database data access error")
	})
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Book insertBook(
			@ApiParam(value = "Book details", required = true) @Valid @RequestBody Book book) {
		try {
			return service.insertBook(book);
			
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}

	@ApiOperation(value = "Update of data from the selected book", response = Book.class)
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "Successful of selected book is updated"),
			@ApiResponse(code = 400, message = "Database data access error"),
			@ApiResponse(code = 404, message = "Selected book not found")
	})
	@PutMapping("")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody Book updateBook(
			@ApiParam(value = "Book details", required = true) @Valid @RequestBody Book book) {
		try {
			return service.updateBook(book);
			
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}

	@ApiOperation(value = "Delete the selected book")
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "Successful of delete the selected book"),
			@ApiResponse(code = 400, message = "Database data access error"),
			@ApiResponse(code = 404, message = "Selected book not found")
	})
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody void deleteBook(
			@ApiParam(value = "Book ID", required = true) @PathVariable Long id) {
		try {
			service.deleteBook(id);
			
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}
}
