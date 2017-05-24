package org.itglance.docsea.web.rest;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sanj__000 on 5/24/2017.
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String Hello(@RequestHeader String token ){
        System.out.println(token);
        return "hello";
    }
}
