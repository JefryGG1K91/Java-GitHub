/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Values;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jgutierrez
 */
@Named
@ApplicationScoped
public class ApplicationBean {

    @ManagedProperty(value = "#{ConversationalBean}")
    @Inject
    private ConversationalBean cb;

    @ManagedProperty(value = "#{RequestBean}")
    @Inject
    private RequestBean rb;

    @ManagedProperty(value = "#{SessionBean}")
    @Inject
    private SessionBean sb;

    @Inject
    private Values values;

    public void increment() {
        this.getValues().setCounter(getValues().getCounter() + 1);
        getCb().increment();
        getRb().increment();
        getSb().increment();
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

    /**
     * @return the cb
     */
    public ConversationalBean getCb() {
        return cb;
    }

    /**
     * @param cb the cb to set
     */
    public void setCb(ConversationalBean cb) {
        this.cb = cb;
    }

    /**
     * @return the rb
     */
    public RequestBean getRb() {
        return rb;
    }

    /**
     * @param rb the rb to set
     */
    public void setRb(RequestBean rb) {
        this.rb = rb;
    }

    /**
     * @return the sb
     */
    public SessionBean getSb() {
        return sb;
    }

    /**
     * @param sb the sb to set
     */
    public void setSb(SessionBean sb) {
        this.sb = sb;
    }

}
