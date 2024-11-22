package com.jeevankumar.com.service.impl;

import com.jeevankumar.com.entity.Book;
import com.jeevankumar.com.repo.BookRepository;
import com.jeevankumar.com.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private  final BookRepository bookRepository;
    @Override
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    @CachePut(value = "books",key = "#book.id")
    public Book updateBook(Book book, Long bookId) {
        return null;
    }

    @Override
    @CacheEvict(value = "books",key = "#bookId")
    public Book delete(Long bookID) {
        long startTime = System.currentTimeMillis();
        Book book = bookRepository.findById(bookID).orElseThrow(() -> new RuntimeException("NO book with id: " + bookID));
      long endTime = System.currentTimeMillis();
        System.out.println("Total Time has been taken for deleting the book object with id: " + (endTime - startTime));

return book;
    }

    @Override
    @Cacheable(value = "books",key = "#bookId")
    public Book bookById(Long bookId) {
        long startTime = System.currentTimeMillis();
     Book getBook =    this.bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("No Book available for this book id: " + bookId));
     long endTime = System.currentTimeMillis();
        System.out.println("How of time has been taken is: " + (endTime - startTime));
        return getBook;
    }
}
