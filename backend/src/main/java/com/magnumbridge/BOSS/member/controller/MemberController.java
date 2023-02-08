package com.magnumbridge.BOSS.member.controller;

import com.magnumbridge.BOSS.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
  private final MemberService memberService;
}
