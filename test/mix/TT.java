/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mix;

import dao.CompanyDao;
import dao.JobDao;
import dao.impl.CompanyDaoImpl;
import dao.impl.JobDaoImpl;
import dao.impl.MemberDaoImpl;
import dao.impl.StudentDaoImpl;
import entity.Member;
import entity.Student;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Justin
 */
public class TT {
    private CompanyDao companyDao=new CompanyDaoImpl();
    private JobDao jobDao=new JobDaoImpl();
    
    @Test
    public void testttt(){
        
    }
    @Test
    public void testManyToMany(){
        Student student=new Student();
        student.setStudentId("201440703989");
        Member member=new Member();
        student.setGrade(0);
        member.setMemberId("d704855911");
//        member.setStudent(student);
        try{
        new StudentDaoImpl().saveStudent(student);
        new MemberDaoImpl().saveMember(member);
        }catch(Exception e){
            e.printStackTrace();
        }
        member.setStudent(student);
        new MemberDaoImpl().updateMember(member);
    }
    
    @Test
    public void sss(){
//        DataExecution de=new DataExecution(true,new VacancyDaoImpl().getVacancyById((long)4));
          List<String> list1 = new ArrayList<String>();
          List<String> list2 = new ArrayList<String>();
          //给list1赋值
          list1.add("测");
          list1.add("试");
          list1.add("一");
          list1.add("下");
          //给list2赋值
          list2.add("合");
          list2.add("一");
          list2.add("列");
          list2.add("表");
          //将list1.list2合并
          list1.removeAll(list2);
          list1.addAll(list2);
          //循环输出list1 看看结果
          for (String s : list1) {
              System.out.print(s);
          }
    }
}
