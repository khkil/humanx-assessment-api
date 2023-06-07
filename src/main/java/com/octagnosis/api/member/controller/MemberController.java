package com.octagnosis.api.member.controller;

import com.octagnosis.api.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("")
    public ResponseEntity getMemberList(){
        return ResponseEntity.ok(memberService.findAll());
    }

    /*@PutMapping("")
    public ResponseEntity updateMember(@RequestBody Member member, @AuthenticationPrincipal Member authenticatedMember){
        int memberIdx = authenticatedMember.getIdx();
        memberService.updateMember(memberIdx, member);
        return ResponseEntity.ok(CommonResponse.successResult(memberService.memberInfo(member)));
    }*/

    @GetMapping("/{memberIdx}/group-info")
    public ResponseEntity getMembersGroup(@PathVariable int memberIdx){
        /*Group group = memberService.getMembersGroup(memberIdx);
        return ResponseEntity.ok(CommonResponse.successResult(group));*/
        return null;
    }


}
