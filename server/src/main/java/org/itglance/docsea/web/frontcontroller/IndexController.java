package org.itglance.docsea.web.frontcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by sanjib on 7/14/17.
 */
@Controller
@RequestMapping("/abc")
public class IndexController {
    String message = "Hello !!";
    @GetMapping
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "index";
    }

}
