package com.sptringtest.SpringBoot.controllers;

import com.sptringtest.SpringBoot.model.User;
import com.sptringtest.SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/people")
public class PeopleController {

    private final UserService userService;

    @Autowired
    public PeopleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/people";
    }

    @GetMapping("/find")
    public String showPersonById(@RequestParam(value = "id", required = true) Long id, Model model) {
        User user = userService.showUserById(id);
        model.addAttribute("user", user);
        return "people";
    }

    @GetMapping()
    public String showPeople(Model model) {
            model.addAttribute("people", userService.showPeople());
        return "people";
    }

    @GetMapping("/find/edit")
    public String edit(@RequestParam(value = "id", required = true) Long id, Model model) {
        User user = userService.showUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PatchMapping("/find/edit")
    public String update(@ModelAttribute("user") User user, @RequestParam(value = "id", required = true) Long id) {
        userService.updateUser(user.getId(), user);
        return "redirect:/people";
    }

    @DeleteMapping("/find/edit")
    public String delete(@ModelAttribute("user") User user, @RequestParam(value = "id", required = true) Long id) {
        userService.deleteUserById(user.getId());
        return "redirect:/people";
    }
}
