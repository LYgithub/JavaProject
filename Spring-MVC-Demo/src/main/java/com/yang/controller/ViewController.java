package com.yang.controller;

import com.yang.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author LiYang
 *
 *  数据模型
 *
 *      1。 map
 *      2。 model
 *      3。 modelAndView
 *      4。 @SessionAttribute
 *      5。 @modelAttribute
 */
@Controller
public class ViewController {

    @Autowired
    Person person;

    /**
     * 1. map
     * @param map
     * @return
     */
    @RequestMapping("/map")
    public String map(Map<String,Person> map){
        map.put("person", person);
        int x = 1/0 ;
        System.out.println(x);
        return "demo";
    }

    /**
     *  model and view
     * @return
     */
    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public ModelAndView demo (){

        ModelAndView modelAndView = new ModelAndView("demo");
        modelAndView.addObject("person",person);
        return modelAndView;

    }

    @RequestMapping(value = "/demo" ,method = RequestMethod.POST)
    public String demo(Person person, Model model){
        System.out.println(person.toString());
        model.addAttribute("person", person);
        return "demo";
    }

    @RequestMapping("/view")
    public ModelAndView view(){
        View view = new InternalResourceView("/demo.jsp");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(view);
        modelAndView.addObject("person",person);
        return modelAndView;
    }


    /**
     * request
     * @param request
     * @return
     */
    @RequestMapping("/servlet-request")
    public String request(HttpServletRequest request){
        request.setAttribute("person",person);
        return "demo";
    }

    @RequestMapping("/servlet")
    public String request(ServletRequest request){
        request.setAttribute("person",new Person("servlet"));
        return "demo";
    }

/**
 *  =============  ModelAttribute  =============
 *  详解： https://www.cnblogs.com/jin-zhe/p/8241368.html
 */

    @ModelAttribute
    public Person getPerson(){
        return person;
    }

    @ModelAttribute
    public void getPerson(Map<String,Person> map){
        map.put("person",new Person("modelAttribute-map"));
    }

    @ModelAttribute
    public void getPerson(Model model){
        model.addAttribute("person",new Person("modelAttribute-model"));
    }

    @RequestMapping("/modelAttribute")
    public String attribute(){
        return "demo";
    }

    @RequestMapping("/modelAttribute-model")
    public String attribute(Model model){
        return "demo";
    }
}
