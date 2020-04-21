package BookStore;

import BookStore.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BookListViewHandler {


    @Autowired
    private BookListRepository bookListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookRegisterd_then_CREATE_1 (@Payload BookRegisterd bookRegisterd) {
        try {
            if (bookRegisterd.isMe()) {
                // view 객체 생성
                BookList bookList = new BookList();
                // view 객체에 이벤트의 Value 를 set 함
                bookList.setBookName(bookRegisterd.getBookName());
                bookList.setBookQty(bookRegisterd.getBookQty());
                bookList.setPrice(bookRegisterd.getPrice());
                // view 레파지 토리에 save
                bookListRepository.save(bookList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookChanged_then_UPDATE_1(@Payload BookChanged bookChanged) {
        try {
            if (bookChanged.isMe()) {
                // view 객체 조회
                List<BookList> bookListList = bookListRepository.findByBookName(bookChanged.getBookName());
                for(BookList bookList : bookListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookList.setBookQty(bookChanged.getBookQty());
                    // view 레파지 토리에 save
                    bookListRepository.save(bookList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}