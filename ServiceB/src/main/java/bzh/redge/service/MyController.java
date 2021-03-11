package bzh.redge.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class MyController {

    @Autowired
    private MyProcess process;

    @GetMapping("/hello/b")
    public String hello() {
        log.info("serviceB / hello");
        process.helloAsync();

        String res =  UUID.randomUUID().toString();
        log.info("end {}" , res);
        return res;
    }

}
