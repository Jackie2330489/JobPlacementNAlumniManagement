/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Justin
 */
public enum VacancyStatusEnum {
    OVER(0,"Over"),
    RECRUITING(1,"Recruiting");
    
    private int state;
    
    private String stateInfo;

    private VacancyStatusEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
    
    public static VacancyStatusEnum stateOf(int index){
        for(VacancyStatusEnum state : values()){
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }
}
