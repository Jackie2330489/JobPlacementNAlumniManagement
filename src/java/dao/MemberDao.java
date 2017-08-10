/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Member;
import entity.Student;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Justin
 */
public interface MemberDao {
    public void saveMember(Member member);
    public void addStudentMember(String memberId,String password,Student student);
    public void addManagerMember(String memberId,String password);
    public void deleteMemberById(String memberId);
    public void updateMember(Member member);
    public List<Member> getAllMembers();
    public Member getMemberById(String memberId);
}
