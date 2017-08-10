/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.MsgExecution;
import dto.SuperDataExecution;
import entity.Vacancy;
import enums.VacancyStatusEnum;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.VacancyService;

/**
 *
 * @author Justin
 */
@Controller
@RequestMapping("/vacancy")
public class VacancyController {

    private VacancyService vacancyService = new VacancyService();

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public SuperDataExecution searchVacancy(@RequestParam("content") String content) {
        return vacancyService.getVacancyByContent(content);
    }

    @ResponseBody
    @RequestMapping(value = "/id", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public SuperDataExecution vacancyDetails(@RequestParam("vacancyId") long vacancyId) {
        return vacancyService.vacancyDetails(vacancyId);
    }

    @ResponseBody
    @RequestMapping(value = "/filter", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public SuperDataExecution filter(@RequestParam("arr") String[] arr) {
        return vacancyService.filter(arr);
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public SuperDataExecution allVacancies() {
        return vacancyService.allVacancies();
    }

    @ResponseBody
    @RequestMapping(value = "/sendnotis", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public MsgExecution sendnotis(@RequestParam("vacancyId")long vacancyId) {
//        System.out.println("vacancyId:"+vacancyId);
        return vacancyService.sendnotis(vacancyId);
//        return null;
    }
    
    @ResponseBody
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public MsgExecution saveOrUpdate(@RequestParam("vacancyId") long vacancyId,@RequestParam("type") String type, @RequestParam("companyId") long companyId, @RequestParam("jobId") long jobId,
             @RequestParam("skills") long[] skillIds, @RequestParam("status") String status, @RequestParam("cTime") String cTime, @RequestParam("lDate") String lDate) {
        Date createTime=null;
        Date lastDate=null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            createTime = sdf.parse(cTime);
            lastDate = sdf.parse(lDate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Vacancy vacancy=new Vacancy();
        vacancy.setVacancyId(vacancyId);
        vacancy.setType(type);
        vacancy.setCreateTime(createTime);
        vacancy.setLastDate(lastDate);
        if(status.equals("RECRUITING"))vacancy.setVacancyStatus(VacancyStatusEnum.RECRUITING);
        else vacancy.setVacancyStatus(VacancyStatusEnum.OVER);
        return vacancyService.saveOrUpdate(vacancy,companyId,jobId,skillIds);
    }
}
