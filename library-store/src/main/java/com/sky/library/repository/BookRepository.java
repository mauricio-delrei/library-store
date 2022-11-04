package com.sky.library.repository;

import com.sky.library.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

    @Query("select b from Book b where b.reference = :reference")
    Book findByReference(@Param("reference")String reference);
}
