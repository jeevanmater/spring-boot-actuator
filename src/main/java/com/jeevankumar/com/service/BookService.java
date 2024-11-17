package com.jeevankumar.com.service;

import com.jeevankumar.com.entity.Book;

import java.util.List;

public interface BookService {
   List<Book> allBooks();
   Book saveBook(Book book);
   Book updateBook(Book book ,Long bookId);
   Book delete(Long bookID);
   Book bookById(Long bookId);
}
