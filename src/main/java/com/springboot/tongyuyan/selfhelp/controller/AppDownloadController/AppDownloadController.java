package com.springboot.tongyuyan.selfhelp.controller.AppDownloadController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppDownloadController {



    @RequestMapping(value = "/index")
   public ModelAndView app(ModelAndView modelAndView){
     modelAndView.setViewName("/index");
        return modelAndView;
    }
    @RequestMapping(value = "/home")
    public ModelAndView homeapp(ModelAndView modelAndView){
        modelAndView.setViewName("/home");
        return modelAndView;
    }
    @RequestMapping(value = "/home2")
    public ModelAndView homeapp2(ModelAndView modelAndView){
        modelAndView.setViewName("/home2");
        return modelAndView;
    }
}
