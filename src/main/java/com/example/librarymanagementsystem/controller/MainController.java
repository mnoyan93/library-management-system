package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Users;
import com.example.librarymanagementsystem.service.UsersService;
import com.example.librarymanagementsystem.service.sequrity.SpringUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final UsersService usersService;

    @GetMapping("/")
    public String mainPage(@AuthenticationPrincipal SpringUser userPrincipal, ModelMap modelMap) {
        if (userPrincipal != null) {
            modelMap.addAttribute("users", userPrincipal.getUsers());
        }

        return "index";
    }

    @GetMapping("/loginPage")
    public String loginPage(@RequestParam(required = false)String msg,ModelMap modelMap) {
        modelMap.addAttribute("msg",msg);
        return "loginPage";
    }

    @GetMapping("/registerPage")
    public String registerPage(@RequestParam (required = false)String msg,ModelMap modelMap) {
        modelMap.addAttribute("msg",msg);
        return "registerPage";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Users users) {
        if (usersService.findByUsername(users.getUsername()).isPresent()) {
            return "redirect:/registerPage?msg=Username already exists!!!";
        }
        usersService.save(users);
        return "redirect:/loginPage?msg=Registration successfull ,,please login";
    }
}
