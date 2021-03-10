package bzh.redge.service;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MyProcess {

    private static Logger log = LoggerFactory.getLogger(MyProcess.class);

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
