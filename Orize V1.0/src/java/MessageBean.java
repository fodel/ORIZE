/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author linos
 */
@ManagedBean(name="messageBean")
@RequestScoped
public class MessageBean {
    private String hidden="hidden";
  
    public MessageBean() {
    }

    public String isHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }
    
    public String show() 
    {
        return "visible";
    }
}
