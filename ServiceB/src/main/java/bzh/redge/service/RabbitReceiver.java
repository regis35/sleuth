package bzh.redge.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitReceiver {

    @RabbitListener(queues = "myQueue")
    public void receive(String in) {
        log.info(" [x] Received '" + in + "'");
    }

}
