package br.com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import java.util.List;
import br.com.book.entity.Author;
import br.com.book.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;

	public List<Author> getAuthorList() {
		Iterable<Author> authorIterable = this.authorRepository.findAll();
		List<Author> list = Streamable.of(authorIterable).toList();
		
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
		
		return list;
	}
}
