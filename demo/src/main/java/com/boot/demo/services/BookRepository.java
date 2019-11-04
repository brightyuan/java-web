/**
 * Elasticsearch
 */

package com.boot.demo.services;

import com.boot.demo.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
    List<Book> findByAuthorLike(String bookName);
    List<Book> findByBookNameLike(String bookName);
}
