package org.launchcode.controllers;

import org.launchcode.models.Cheese;
import org.launchcode.models.CheeseData;
import org.launchcode.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
        //CheeseData.getAll() returns an ArrayList of Cheeses
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute("nameText", "Name of Cheese");
        model.addAttribute(new Cheese()); // Passes in skeleton of a Cheese object; by default th names it cheese
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                        Errors errors, Model model) {

        /*
        * Code that is implicitly run by Spring Boot
        * Cheese newCheese = new Cheese(); // Need default constructor so Spring can use it
        * newCheese.setName(Request.getParameter("name"));
        * newCheese.setDescription(Request.getParameter("description"));
        *
         */

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("nameText", "Name of Cheese");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/add";
        }

        CheeseData.add(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {
        Cheese foundCheese = CheeseData.getById(cheeseId);
        String foundCheeseName = foundCheese.getName();
        String foundCheeseDescription = foundCheese.getDescription();
        Integer CheeseId = cheeseId;
        model.addAttribute("CheeseNumber"+cheeseId, foundCheese);
        model.addAttribute("nameText", foundCheeseName);
        model.addAttribute("descriptionText", foundCheeseDescription);
        model.addAttribute("cheeseIdInt", CheeseId.toString());
        model.addAttribute("CheeseNumber"+cheeseId, foundCheese);
        model.addAttribute("foundCheese", foundCheese);
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        model.addAttribute("typeSelection", foundCheese.getType());
        model.addAttribute("cheeseRatingInteger", foundCheese.getRating());
        //display the form
        return "cheese/edit";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.POST)
    public String processEditForm(Model model, @RequestParam String cheeseIdField, @RequestParam String name,
                                  @RequestParam String description, @Valid Cheese newCheese, Errors errors,
                                  @RequestParam CheeseType type, @RequestParam Integer rating) {
        int realCheeseId = Integer.parseInt(cheeseIdField);

        if (errors.hasErrors()) {
            Cheese foundCheese = CheeseData.getById(realCheeseId);
            String foundCheeseName = foundCheese.getName();
            String foundCheeseDescription = foundCheese.getDescription();
            Integer CheeseId = realCheeseId;
            model.addAttribute("CheeseNumber"+realCheeseId, foundCheese);
            model.addAttribute("nameText", foundCheeseName);
            model.addAttribute("descriptionText", foundCheeseDescription);
            model.addAttribute("cheeseIdInt", CheeseId.toString());
            model.addAttribute("foundCheese", foundCheese);
            model.addAttribute("cheeseTypes", CheeseType.values());
            model.addAttribute("typeSelection", foundCheese.getType());
            model.addAttribute("cheeseRatingInteger", foundCheese.getRating());
            //display the form
            return "cheese/edit";
        }

        CheeseData.editCheese(realCheeseId, name, description, type, rating);
        //process the form
        return "redirect:/cheese";
    }

}
