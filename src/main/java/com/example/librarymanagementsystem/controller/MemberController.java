package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Member;
import com.example.librarymanagementsystem.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MemberController {
   @Autowired
   private MemberRepository memberRepository;

    @GetMapping("/members")
    public String member(ModelMap modelMap){
        List<Member> members = memberRepository.findAll();
        modelMap.addAttribute("members",members);

        return "members";
    }
    @GetMapping("/addMember")
    public String addMember() {
        return "addMember"; // addMember.html թեմփլեյթը
    }
    @PostMapping("/addMember")
    public String addMember(@RequestParam ("full_name") String fullName,
                            @RequestParam("email") String email,
                            @RequestParam("phone")String phone){
        Member member = new Member();
        member.setFullName(fullName);
        member.setEmail(email);
        member.setPhone(phone);
        member.setRegistrationDate(LocalDateTime.now());

        memberRepository.save(member);

        return "redirect:/members";
    }

}