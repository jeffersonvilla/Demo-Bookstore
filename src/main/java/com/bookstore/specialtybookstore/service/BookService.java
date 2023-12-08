package com.bookstore.specialtybookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.bookstore.specialtybookstore.DTO.SearchCriteriaDTO;
import com.bookstore.specialtybookstore.interfaces.IBookService;
import com.bookstore.specialtybookstore.model.Author;
import com.bookstore.specialtybookstore.model.Book;
import com.bookstore.specialtybookstore.model.Edition;
import com.bookstore.specialtybookstore.model.Genre;
import com.bookstore.specialtybookstore.model.Publisher;
import com.bookstore.specialtybookstore.repository.BookRepository;

import jakarta.el.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SetAttribute;

@Service
public class BookService implements IBookService{
    
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book createBook(Book book) {
        return this.repository.save(book);
    }

    @Override
    public Book getBookById(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<Book> getAllBooks() {
        return this.repository.findAll();
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
