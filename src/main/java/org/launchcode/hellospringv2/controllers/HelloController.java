package org.launchcode.hellospringv2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//there are methods in this class that will handle HTTP requests
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //Handles request of the form /hello?name=launchcode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/Launchcode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }
    //lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name = 'name'>" +
                "<input type ='submit' value = 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}

