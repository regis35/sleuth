package bzh.redge.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-a", url = "http://localhost:8080")
public interface MyFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/hello/b")
    String helloBFeign();
}
