package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.Member;


import java.util.List;


public interface MemberService {
      List<Member> findAll();
      Member save(Member member);

}
