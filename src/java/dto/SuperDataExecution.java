/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;

/**
 *
 * @author Justin
 */
public class SuperDataExecution<T> {
    private static final long serialVersionUID=1L;
    private boolean success;
    private T data;
    private T data2;
    private T data3;
    private T data4;
    private List list1;
    private List list2;
    private List list3;
    private List list4;
    private List list5;
    private List list6;
    private List list7;
    private String error;

    public SuperDataExecution(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public SuperDataExecution(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    
    
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData2() {
        return data2;
    }

    public void setData2(T data2) {
        this.data2 = data2;
    }

    public T getData3() {
        return data3;
    }

    public void setData3(T data3) {
        this.data3 = data3;
    }

    public T getData4() {
        return data4;
    }

    public void setData4(T data4) {
        this.data4 = data4;
    }

    public List getList1() {
        return list1;
    }

    public void setList1(List list1) {
        this.list1 = list1;
    }

    public List getList2() {
        return list2;
    }

    public void setList2(List list2) {
        this.list2 = list2;
    }

    public List getList3() {
        return list3;
    }

    public void setList3(List list3) {
        this.list3 = list3;
    }

    public List getList4() {
        return list4;
    }

    public void setList4(List list4) {
        this.list4 = list4;
    }

    public List getList5() {
        return list5;
    }

    public void setList5(List list5) {
        this.list5 = list5;
    }

    public List getList6() {
        return list6;
    }

    public void setList6(List list6) {
        this.list6 = list6;
    }

    public List getList7() {
        return list7;
    }

    public void setList7(List list7) {
        this.list7 = list7;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
}
