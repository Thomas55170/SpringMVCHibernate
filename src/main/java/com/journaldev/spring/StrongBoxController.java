package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.journaldev.spring.model.StrongBox;
import com.journaldev.spring.service.StrongBoxService;

/**
 * Created by pcthomas on 10/01/2017.
 */
@Controller
public class StrongBoxController {

    private StrongBoxService strongBoxService;

    @Autowired(required=true)
    @Qualifier(value="strongBoxService")
    public void setstrongBoxService(StrongBoxService sbs){
        this.strongBoxService = sbs;
    }

    @RequestMapping(value = "/strongbox", method = RequestMethod.GET)
    public String listStrongBox(Model model) {
        model.addAttribute("strongBox", new StrongBox());
        model.addAttribute("listStrongBox", this.strongBoxService.listStrongBox());
        return "strongbox";
    }

    //For add and update strongbox both
    @RequestMapping(value= "/strongbox/add", method = RequestMethod.POST)
    public String addStrongBox(@ModelAttribute("StrongBox") StrongBox sb){

        if(sb.getId() == 0){
            //new person, add it
            this.strongBoxService.addStrongBox(sb);
        }else{
            //existing person, call update
            this.strongBoxService.updateStrongBox(sb);
        }

        return "redirect:/strongbox";

    }

    @RequestMapping("/strongboxremove/{id}")
    public String removeStrongBox(@PathVariable("id") int id){

        this.strongBoxService.removeStrongBox(id);
        return "redirect:/strongbox";
    }

    @RequestMapping("/strongboxedit/{id}")
    public String editStrongBox(@PathVariable("id") int id, Model model){
        model.addAttribute("strongbox", this.strongBoxService.getStrongBoxById(id));
        model.addAttribute("listPersons", this.strongBoxService.listStrongBox());
        return "strongbox";
    }

}
