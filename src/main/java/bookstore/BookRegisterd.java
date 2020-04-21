package bookstore;

public class BookRegisterd extends AbstractEvent {

    private Long id;
    private String book_name;
    private Integer book_qty;
    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getBookName() {
        return book_name;
    }

    public void setBookName(String book_name) {
        this.book_name = book_name;
    }
    public Integer getBookQty() {
        return book_qty;
    }

    public void setBookQty(Integer book_qty) {
        this.book_qty = book_qty;
    }
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}