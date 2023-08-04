package br.com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.book.entity.Author;
import br.com.book.entity.Book;
import br.com.book.service.AuthorService;
import br.com.book.service.BookService;
import jakarta.validation.Valid;

@Controller
public class BookController {
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private BookService bookService;

	@GetMapping("/book/form/add")
	public ModelAndView getForm() {
		
		ModelAndView mv = new ModelAndView("bookform");
		List<Author> authorList = authorService.getAuthorList();
		mv.addObject("authorlist", authorList);
		
		return mv;
	}
	
	@PostMapping("/book/form/save")
	public String saveBook(@Valid Book book, BindingResult result, RedirectAttributes redirect) {
		
		if (result.hasErrors()) {
			redirect.addFlashAttribute("mensagem", "Verifique os campos obrigatórios");
			return "redirect:/book/form/add";
		}
		
		this.bookService.save(book);
		
		return "redirect:/";
	}
}
