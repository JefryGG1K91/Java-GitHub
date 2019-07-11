/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Values;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jgutierrez
 */
@Named
@SessionScoped
public class SessionBean implements Serializable {

    @Inject
    private Values values;

    public void increment() {
        this.values.setCounter(getValues().getCounter() + 1);
    }

    /**
     * @return the values
     */
    public Values getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(Values values) {
        this.values = values;
    }
    
    public void destroySession(){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().invalidateSession();
    }

}
