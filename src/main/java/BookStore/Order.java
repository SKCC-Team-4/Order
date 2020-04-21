package BookStore;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;
@Entity
@Table(name="Order_table")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String bookName;
    private Integer bookQty;
    private String status;
    private Long orderId;
    private Date orderDate;
    private Date changeDate;
    private Date cancelDate;
    private Long price;

    @PostPersist
    public void onPostPersist(){
        Ordered ordered = new Ordered();
        BeanUtils.copyProperties(this, ordered);
        ordered.publish();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        BookStore.external.Payment payment = new BookStore.external.Payment();
        // mappings goes here
        payment.setOrderId(ordered.getId());
        Application.applicationContext.getBean(BookStore.external.PaymentService.class)
            .payRequest(payment);


    }

    @PostUpdate
    public void onPostUpdate(){
        OrderChanged orderChanged = new OrderChanged();
        BeanUtils.copyProperties(this, orderChanged);
        orderChanged.publish();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        BookStore.external.Payment payment = new BookStore.external.Payment();
        // mappings goes here
        Application.applicationContext.getBean(BookStore.external.PaymentService.class)
            .payRequest(payment);

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        // mappings goes here
        Application.applicationContext.getBean(BookStore.external.PaymentService.class)
            .payCancel(payment);


    }

    @PostRemove
    public void onPostRemove(){
        OrderCanceled orderCanceled = new OrderCanceled();
        BeanUtils.copyProperties(this, orderCanceled);
        orderCanceled.publish();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

//        BookStore.external.Order order = new BookStore.external.Order();
//        // mappings goes here
//        Application.applicationContext.getBean(BookStore.external.OrderService.class)
//            .payRequest(order);


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
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }




}
