package com.universal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.universal.model.Book;
import com.universal.util.JdbcUtil;

@Repository
public class BookDetailsDAOImpl implements BookDetailsDAO {

	@Override
	public List<Book> searchBook(Book book) {
		StringBuilder SEARCH_SQL_QUERY = new StringBuilder("SELECT * FROM BOOK_DTLS WHERE 1=1");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> bookList = new ArrayList<>();
		// get connection
		con = JdbcUtil.getConnection();
		try {
			if (book.getBookId() != null) {
				SEARCH_SQL_QUERY.append(" AND BOOK_ID=" + book.getBookId());
			}
			if (book.getBookName() != null && !book.getBookName().equals("")) {
				SEARCH_SQL_QUERY.append(" AND BOOKNAME='" + book.getBookName() + "'");
			}
			if (book.getAuthorName() != null && !book.getAuthorName().equals("")) {
				SEARCH_SQL_QUERY.append(" AND AUTHORNAME='" + book.getAuthorName() + "'");
			}
			// create PreparedStatement object
			ps = con.prepareStatement(SEARCH_SQL_QUERY.toString());

			// create Result set object
			rs = ps.executeQuery();

			while (rs.next()) {
				Book b = new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthorName(rs.getString(3));
				b.setBookPrice(rs.getDouble(4));

				bookList.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close objects
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return bookList;
	}

}
