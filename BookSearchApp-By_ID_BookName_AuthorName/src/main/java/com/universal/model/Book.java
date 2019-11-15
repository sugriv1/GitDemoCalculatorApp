package com.universal.model;

import lombok.Data;

@Data
public class Book {

	private Integer bookId;
	private String bookName;
	private String authorName;
	private Double bookPrice;
}
