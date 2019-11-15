package com.universal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.universal.model.Book;
import com.universal.service.BookSearchService;

@Controller
public class BookSearchController {

	@Autowired(required = true)
	private BookSearchService service;

	@RequestMapping("/bookFrom.htm")
	public String bookSearchForm(Model model) {
		model.addAttribute("book", new Book());
		return "bookForm";
	}

	@RequestMapping(value="/bookSearch.htm",method = RequestMethod.POST)
	public String searchBookById(@ModelAttribute("book") Book book, Model model) {
		System.out.println(book.getBookName()+"  "+book.getAuthorName());
		if(book.getBookId()==null && book.getBookName().equals("") && book.getAuthorName().equals("")) {
			model.addAttribute("msg","Please Select atleast one field");
		}
		else {
		model.addAttribute("book", new Book());
		List<Book> bookList = null;
		bookList = service.searchBook(book);
		model.addAttribute("books", bookList);
		}
		return "bookForm";
	}
}
