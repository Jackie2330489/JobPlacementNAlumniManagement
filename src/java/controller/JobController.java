/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.SuperDataExecution;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.JobService;

/**
 *
 * @author Justin
 */
@Controller
@RequestMapping("/job")
public class JobController {
    private JobService jobService=new JobService();
    
    @ResponseBody
    @RequestMapping(value="/search",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
    public SuperDataExecution searchJob(@RequestParam("content")String content){
        return jobService.searchJob(content);
    }
    
    @ResponseBody
    @RequestMapping(value="/id",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
    public SuperDataExecution jobDetails(@RequestParam("jobId")long jobId){
        return jobService.jobDetails(jobId);
    }
    
    @ResponseBody
    @RequestMapping(value="/first10",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
    public SuperDataExecution fisrt10(){
        return jobService.first10();
    }
    
    @ResponseBody
    @RequestMapping(value="/all",method=RequestMethod.GET,produces={"application/json;charset=UTF-8"})
    public SuperDataExecution allJobs(){
        return jobService.allJobs();
    }
}
