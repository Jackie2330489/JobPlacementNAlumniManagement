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
import service.NotificationService;

/**
 *
 * @author Justin
 */
@Controller
@RequestMapping("/notis")
public class NotificationController {
    private NotificationService nService=new NotificationService();
    
    @ResponseBody
    @RequestMapping(value="/id",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public SuperDataExecution noti(@RequestParam("uid")String uid){
        return nService.noti(uid);
    }
}
