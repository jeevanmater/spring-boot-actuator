package com.jeevankumar.com.controller;

import com.jeevankumar.com.entity.Book;
import com.jeevankumar.com.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/book")
@RequiredArgsConstructor
public class BookManagementController {
    private final BookService bookService;
    @GetMapping("/allBooks")
    public ResponseEntity<List<Book>> findAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.allBooks());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.bookById(id));
    }

    @GetMapping(value = "/allBooks",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getAllBooks(){
        System.out.println("Jeevan Kumar");
       List<Book> bookList = bookService.allBooks();
       if (!bookList.isEmpty() && bookList.size() > 1) {
           return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(bookList);
       }else {
           return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
       }
    }
    @PostMapping(value = "/saveBook")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
     Book saveBook =   bookService.saveBook(book);
     if (saveBook != null){
         return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(saveBook);
     }else {
         return ResponseEntity.status(HttpStatusCode.valueOf(500)).build();
     }
    }
    @PutMapping(value = "/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id") Long bookId){
        Book saveBook =   bookService.saveBook(book);
        if (saveBook != null){
            return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(saveBook);
        }else {
            return ResponseEntity.status(HttpStatusCode.valueOf(500)).build();
        }
    }
    @DeleteMapping(value = "/deleteBook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Long bookId){

        return ResponseEntity.status(HttpStatusCode.valueOf(204)).body(this.bookService.delete(bookId));
    }

}
