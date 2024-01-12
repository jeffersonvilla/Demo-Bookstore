package com.bookstore.specialtybookstore.service;

import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.BOOK_CREATION_ERROR;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_EMPTY_TITLE;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_GETTING_ALL_BOOKS;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_GETTING_BOOK_BY_ID;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_INVALID_BOOK_ID;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_KEYWORDS_LENGTH_EXCEEDS;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_NULL_BOOK;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_TITLE_LENGTH_EXCEEDS;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.ERROR_TITLE_REQUIRED;
import static com.bookstore.specialtybookstore.exceptions.error_messages.ExceptionMessages.PAGEABLE_NULL_ERROR;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.bookstore.specialtybookstore.DTO.SearchCriteriaDTO;
import com.bookstore.specialtybookstore.exceptions.BookCreationException;
import com.bookstore.specialtybookstore.exceptions.GetAllBooksException;
import com.bookstore.specialtybookstore.exceptions.GetBookByIdException;
import com.bookstore.specialtybookstore.interfaces.IBookService;
import com.bookstore.specialtybookstore.model.Author;
import com.bookstore.specialtybookstore.model.Book;
import com.bookstore.specialtybookstore.model.Edition;
import com.bookstore.specialtybookstore.model.Publisher;
import com.bookstore.specialtybookstore.repository.BookRepository;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;

@Service
public class BookService implements IBookService{
    
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book createBook(Book book) {

        validateBook(book);

        try {
            return this.repository.save(book);
        } catch (Exception e) {
            throw new BookCreationException(BOOK_CREATION_ERROR, e);
        }
    }

    private void validateBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException(ERROR_NULL_BOOK);
        }
        
        if (book.getTitle() == null) {
            throw new IllegalArgumentException(ERROR_TITLE_REQUIRED);
        }

        if (book.getTitle().isBlank()) {
            throw new IllegalArgumentException(ERROR_EMPTY_TITLE);
        }
    
        if (book.getTitle().length() > 255) {
            throw new IllegalArgumentException(ERROR_TITLE_LENGTH_EXCEEDS);
        }
    
        if (book.getKeywords() != null && book.getKeywords().length() > 255) {
            throw new IllegalArgumentException(ERROR_KEYWORDS_LENGTH_EXCEEDS);
        }
    }

    @Override
    public Book getBookById(int id) {

        if(id < 1) throw new IllegalArgumentException(ERROR_INVALID_BOOK_ID);

        try{
            return this.repository.findById(id).get();
        }catch(Exception e){
            throw new GetBookByIdException(ERROR_GETTING_BOOK_BY_ID, e);
        }
    }

    @Override
    public Page<Book> getAllBooks(Pageable pageable) {

        if(pageable == null) throw new RuntimeException(PAGEABLE_NULL_ERROR);

        try {
            return this.repository.findAll(pageable);
        } catch (Exception e) {
            throw new GetAllBooksException(ERROR_GETTING_ALL_BOOKS, e);
        }
    }

    @Override
    public Book updateBook(Book book) {
        return this.repository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Book> searchBookByTitle(String name) {
        return this.repository.searchBookByTitleLike(name);
    }

    @Override
    public List<Book> searchBooksByCriteria(SearchCriteriaDTO criteria) {

        return repository.findAll(
            BookCriteria.bookHasTitle(criteria.getTitle())
            .and(BookCriteria.bookContainsTextInDescription(criteria.getDescriptionText()))
            .and(BookCriteria.bookIsOfGenres(criteria.getGenreNames()))
            .and(BookCriteria.bookHasAuthors(criteria.getAuthorNames()))
            .and(BookCriteria.bookHasPublishers(criteria.getPublisherNames()))
        );

    }
    
    private static class BookCriteria{

        public static Specification<Book> bookHasTitle(String title){
            return (root, query, cb) -> {

                if(title == null) return cb.isTrue(cb.literal(true));

                return cb.like(cb.lower(root.get("title")), 
                "%" + title.toLowerCase() + "%");
            };
        }

        public static Specification<Book> bookContainsTextInDescription(String text){
            return(root, query, cb) -> {

                if(text == null) return cb.isTrue(cb.literal(true));

                return cb.like(cb.lower(root.get("description")), 
                "%" + text.toLowerCase() + "%");
            };
        }

        public static Specification<Book> bookHasAuthors(List<String> authorNames){
            return (root, query, cb) -> {

            // If authorNames is null or empty, return a always true predicate
            if (authorNames == null || authorNames.isEmpty()) {
                return cb.isTrue(cb.literal(true));
            }

            // Join the Book entity with the Authors entity
            Join<Book, Edition> editionJoin = root.join("editions");
            Join<Edition, Author> authorJoin = editionJoin.join("authors");

            // Create predicates for each author name
            List<Predicate> authorPredicates = authorNames.stream()
                .map(authorName -> cb.like(cb.lower(authorJoin.get("name"))
                    , "%" + authorName.toLowerCase() + "%"))
                .collect(Collectors.toList());

            // Combine the predicates with an OR condition
            Predicate finalPredicate = cb.or(authorPredicates.toArray(new Predicate[0]));

            return finalPredicate;
    };
        }

        public static Specification<Book> bookIsOfGenres(List<String> genreNames){
            return (root, query, cb) -> {

                if(genreNames == null || genreNames.isEmpty()) {
                    return cb.isTrue(cb.literal(true));
                }
    
                // Join the Book entity with the Genre entity
                root.join("genres");
    
                // Create a predicate to check if the genre names match the specified genreNames
                Predicate genrePredicate = cb.lower(
                    root.join("genres")
                    .get("name"))
                    .in(genreNames.stream().map(String::toLowerCase).toArray());
    
                return genrePredicate;
            };   
        }

        public static Specification<Book> bookHasPublishers(List<String> publisherNames){
            return (root, query, cb) -> {
                if(publisherNames == null || publisherNames.isEmpty()) return null;

                // Join the Book entity with the Publisher entity
                Join<Book, Edition> editionJoin = root.join("editions");
                Join<Edition, Publisher> publisherJoin = editionJoin.join("publishers");

                // Create predicates for each publisser name
                List<Predicate> publisherPredicates = publisherNames.stream()
                    .map(publisherName -> cb.like(cb.lower(publisherJoin.get("name"))
                        , "%" + publisherName.toLowerCase() + "%"))
                    .collect(Collectors.toList());

                // Combine the predicates with an OR condition
                Predicate finalPredicate = cb.or(publisherPredicates.toArray(new Predicate[0]));

                return finalPredicate;
            };
        }
    }
}
