package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Member;
import com.example.librarymanagementsystem.repository.MemberRepository;
import com.example.librarymanagementsystem.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {


   private final MemberService memberService;

    @GetMapping("/members")
    public String member(ModelMap modelMap){
        List<Member> members = memberService.findAll();
        modelMap.addAttribute("members",members);

        return "members";
    }
    @GetMapping("/members/add")
    public String addMember() {
        return "addMember"; // addMember.html թեմփլեյթը
    }

    @PostMapping("/members/add")
    public String addMember(@ModelAttribute Member member){

     memberService.save(member);

        return "redirect:/members";
    }

}