package BookStore;

import BookStore.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired
    OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCanceled_OrderCancel(@Payload PayCanceled payCanceled){

        if(payCanceled.isMe()){
            System.out.println("##### listener OrderCancel : " + payCanceled.toJson());

            orderRepository.deleteById(payCanceled.getOrderId());
        }
    }

}
