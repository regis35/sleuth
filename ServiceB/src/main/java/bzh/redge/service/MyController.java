package bzh.redge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MyController {

    private static Logger log = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private MyProcess process;

    @GetMapping("/hello/b")
    public String hello() {
        log.info("serviceB / hello");
        process.helloAsync();
        return  UUID.randomUUID().toString();
    }

}
