/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.MsgExecution;
import dto.SuperDataExecution;
import entity.Member;
import entity.Student;
import enums.MemberStatusEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MemberService;

/**
 *
 * @author Justin
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    
    private MemberService memberService=new MemberService();
    
    @ResponseBody
    @RequestMapping(value="/login",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public MsgExecution login(@ModelAttribute Member member){
        return memberService.login(member);
    }
    
    @ResponseBody
    @RequestMapping(value="/rememberLogin",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public MsgExecution rememberLogin(String uid,String md5){
        return memberService.rememberLogin(uid, md5);
    }
    
    @ResponseBody
    @RequestMapping(value="/register",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public MsgExecution register(@ModelAttribute Member member,@ModelAttribute Student student){
        if(student.getGrade()==null)student.setGrade(0);
        return memberService.register(member,student);       
    }
    
    @ResponseBody
    @RequestMapping(value="/all",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
    public SuperDataExecution getAll(){
        return memberService.getAll();       
    }
    
    @ResponseBody
    @RequestMapping(value="/activate",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public MsgExecution activate(@RequestParam("memberId")String memberId){
        return memberService.activate(memberId);       
    }
    
    @ResponseBody
    @RequestMapping(value="/add",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public MsgExecution addMember(@ModelAttribute Member member){
        member.setMemberStatus(MemberStatusEnum.INACTIVATED);
        return memberService.addMember(member);       
    }
    
    @ResponseBody
    @RequestMapping(value="/details",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public SuperDataExecution details(String uid,String md5){
        return memberService.details(uid,md5);
    }
}
