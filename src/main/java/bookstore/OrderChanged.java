package bookstore;
import java.util.Date;
public class OrderChanged extends AbstractEvent {

    private Long id;
    private String bookName;
    private Integer bookQty;
    private String status;
    private Long orderId;
    private Date changeDate;
    private Long price;

    public OrderChanged(){
        super();
    }

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
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
