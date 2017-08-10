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
public enum NotiStatusEnum {
    UNREADED(0,"UnReaded"),
    READED(1,"Readed");
    
    private int state;
    
    private String stateInfo;

    private NotiStatusEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
    
    public static NotiStatusEnum stateOf(int index){
        for(NotiStatusEnum state : values()){
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }
}
