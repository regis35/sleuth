package bzh.redge.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@Slf4j
public class MyController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @Autowired
    private MyFeign myFeign;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @GetMapping("/hello/a")
    public String hello() {
        log.info("serviceA / hello / rest template");
        String res = restTemplate.getForObject("http://localhost:8080/hello/b", String.class);
        log.info("Rest first call '{}'",res);

        log.info("serviceA / hello / web flux");
        ResponseEntity<String> resWf = webClient.get()
                .uri("/hello/b")
                .retrieve()
                .toEntity(String.class)
                .block();

        return resWf.getBody();
    }

    @GetMapping("/hello/feign")
    public String helloFeign() {
        log.info("serviceA / hello / feign");
        return myFeign.helloBFeign();
    }

    @GetMapping("/hello/rabbit")
    public void helloRabbit() {
        log.info("serviceA / hello / rabbit");
        this.template.convertAndSend(queue.getName(), "Regis");
    }

}
