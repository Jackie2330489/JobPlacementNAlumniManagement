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
public enum MemberStatusEnum {
    INACTIVATED(0,"Inactivated"),
    ACTIVATED(1,"Activated"),
    MANAGER(2,"Manager");
    
    private int state;
    
    private String stateInfo;

    private MemberStatusEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
    
    public static MemberStatusEnum stateOf(int index){
        for(MemberStatusEnum state : values()){
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }
}
