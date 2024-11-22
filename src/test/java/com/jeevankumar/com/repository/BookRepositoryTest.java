package com.jeevankumar.com.repository;

import com.jeevankumar.com.entity.Book;
import com.jeevankumar.com.repo.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void saveBookTest(){
        Book book = new Book(1L,"Java","java",9000.00);
      Book savedBook =  bookRepository.save(book);
     Optional<Book> optionalBook = bookRepository.findById(savedBook.getId());
     assertThat(optionalBook).isPresent();
    assertThat(optionalBook.get().getTitle()).isEqualTo("Java");
    }
    @Test
    public void  findAllBookTest(){
        List<Book> bookList = List.of(
                new Book(1L,"Java","java",900.00),
                new Book(2L,"Spring","spring",500.00),
                new Book(3L,"Could","aws",200.00)

        );
     List<Book> savedBooks =   bookRepository.saveAll(bookList);
   List<Book> allBooks =  bookRepository.findAll();
   assertThat(allBooks.size()).isEqualTo(3L);
   assertThat(allBooks.get(0).getTitle()).isEqualTo("Java");
    }
}
