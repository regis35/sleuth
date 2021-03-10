package bzh.redge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@RestController
public class MyController {

    private static Logger log = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @GetMapping("/hello/a")
    public String hello() {
        log.info("serviceA / hello");

        String res = restTemplate.getForObject("http://localhost:8080/hello/b", String.class);
        return  res;
    }

    @GetMapping("/hello/awf")
    public String helloWebFlux() {
        log.info("serviceA / hello");

        ResponseEntity<String> res = webClient.get()
                .uri("/hello/b")
                .retrieve()
                .toEntity(String.class)
                .block();

        return  res.getBody();
    }

}
