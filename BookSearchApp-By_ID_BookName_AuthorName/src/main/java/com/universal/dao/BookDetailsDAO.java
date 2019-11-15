package com.universal.dao;

import java.util.List;

import com.universal.model.Book;

public interface BookDetailsDAO {

	public List<Book> searchBook(Book book);
}
