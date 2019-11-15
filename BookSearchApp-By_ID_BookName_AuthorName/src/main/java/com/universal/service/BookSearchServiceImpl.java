package com.universal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universal.dao.BookDetailsDAO;
import com.universal.model.Book;

@Service
public class BookSearchServiceImpl implements BookSearchService {

	@Autowired
	private BookDetailsDAO bookDetailsDao;
	
	@Override
	public List<Book> searchBook(Book book) {
		return bookDetailsDao.searchBook(book);
	}

}
