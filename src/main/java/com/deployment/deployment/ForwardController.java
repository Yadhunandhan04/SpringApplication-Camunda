package com.deployment.deployment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForwardController {

    @GetMapping("/{path:[^\\.]*}")
    public String forward() {

        // Forward to index.html for Angular routing to work
        return "forward:/index.html";
    }
}
