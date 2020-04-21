package bookstore;

import javax.persistence.*;

@Entity
@Table(name="BookList_table")
public class BookList {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String bookName;
        private Integer bookQty;
        private Long price;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }
        public Integer getBookQty() {
            return bookQty;
        }

        public void setBookQty(Integer bookQty) {
            this.bookQty = bookQty;
        }
        public Long getPrice() {
            return price;
        }

        public void setPrice(Long price) {
            this.price = price;
        }

}
