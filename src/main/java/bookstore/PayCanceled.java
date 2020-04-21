
package bookstore;
import java.util.Date;
public class PayCanceled extends AbstractEvent {

    private Long id;
    private Long order_id;
    private String status;
    private Date cancel_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return order_id;
    }

    public void setOrderId(Long order_id) {
        this.order_id = order_id;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Date getCancelDate() {
        return cancel_date;
    }

    public void setCancelDate(Date cancel_date) {
        this.cancel_date = cancel_date;
    }
}
