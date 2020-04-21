
package BookStore.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by uengine on 2018. 11. 21..
 */

@FeignClient(name="Payment", url="${api.url.payment}")
public interface PaymentService {

    @RequestMapping(method= RequestMethod.POST, path="/payments")
    public void payRequest(@RequestBody Payment payment);

    @RequestMapping(method= RequestMethod.PUT, value="/payments/{id}")
    public void payCancel(@RequestBody Payment payment, @PathVariable("id") Long id);
}