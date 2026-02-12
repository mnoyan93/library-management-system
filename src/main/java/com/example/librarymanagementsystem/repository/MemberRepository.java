package com.example.librarymanagementsystem.repository;


import com.example.librarymanagementsystem.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
}
