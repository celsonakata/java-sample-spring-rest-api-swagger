package br.com.nkt3.samples.springswagger.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.nkt3.samples.springswagger.model.Book;

public interface BookDao extends CrudRepository<Book, Long> {
}
