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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.StudentService;

/**
 *
 * @author Justin
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService=new StudentService();
    
    @ResponseBody
    @RequestMapping(value="/id",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
    public SuperDataExecution studentDetails(@RequestParam("studentId")String studentId){
        return studentService.studentDetails(studentId);
    }
    
    @ResponseBody
    @RequestMapping(value="/all",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
    public SuperDataExecution allStudents(){
        return studentService.allStudents();
    }
    
    @ResponseBody
    @RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public MsgExecution saveOrUpdateStudent(@ModelAttribute Student student){
        return studentService.saveOrUpdate(student);
    }
}
