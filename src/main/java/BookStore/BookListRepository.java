package BookStore;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookListRepository extends CrudRepository<BookList, Long> {

    List<BookList> findByBookName(String bookName);

}