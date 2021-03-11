package bzh.redge.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class MyProcess {

    @Async
    public void helloAsync() {

        log.info("Debut async");

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("Fin async");

    }

}
