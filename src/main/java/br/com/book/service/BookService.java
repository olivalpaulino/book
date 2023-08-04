package br.com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import br.com.book.entity.Book;
import br.com.book.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public void save(Book book) {
		this.bookRepository.save(book);
	}
	
	public List<Book> getBooksList() {
		Iterable<Book> iterable = bookRepository.findAll();
		List<Book> list = Streamable.of(iterable).toList();
		return list;
	}
}
