package bookstore;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookListRepository extends CrudRepository<BookList, Long> {

    List<BookList> findByBookName(String bookName);

}