package com.qubits.bookstore;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers {

    private static List<Map<String, String>> books = Arrays.asList(
      ImmutableMap.of("id", "book-1", "name", "The Philo", "pageCount", "223", "authorId", "author-1"),
      ImmutableMap.of("id", "book-2", "name", "Plateau", "pageCount", "223", "authorId", "author-2")
    );

    private static List<Map<String, String>> authors = Arrays.asList(
            ImmutableMap.of("id", "author-1", "firstName", "Joa", "lastName", "Row"),
            ImmutableMap.of("id", "author-2", "firstName", "Sam", "lastName", "Bob")
    );

    public DataFetcher getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return books.stream().filter(book -> book.get("id").equals(bookId)).findFirst().orElse(null);
        };
    }

    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> book = dataFetchingEnvironment.getSource();
            String authorId = book.get("authorId");
            return authors.stream().filter(author -> author.get("id").equals(authorId)).findFirst().orElse(null);
        };
    }
}
