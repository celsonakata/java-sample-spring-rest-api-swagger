package br.com.nkt3.samples.springswagger.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.nkt3.samples.springswagger.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
