package com.cms.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class ControllerTe {

    @GetMapping("one")
    public  void testdd(){

        System.out.println("asdasd");
    }

}
