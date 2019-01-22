/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jefry Gutierrez
 */
public class Rectangulo {

    private int base;
    private int altura;
    private int area;

    public Rectangulo() {

    }

    public Rectangulo(int altura, int base) {
        this.altura = altura;
        this.base = base;
    }

    /**
     * @return the base
     */
    public int getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(int base) {
        this.base = base;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public int getArea(){
        return this.base*this.altura;
    }
}
