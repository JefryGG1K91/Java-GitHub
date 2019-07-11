/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Controller.BookServices;
import Entity.Book;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jgutierrez
 */
@Named
@SessionScoped
public class BookFormBean implements Serializable {

    @Inject
    private BookServices bookServices;
    private List<Book> booksLst;
    private String frValue = "";
    private List<Book> cartList;
    private int qty;
     
    @PostConstruct
    public void init() {
        this.booksLst = bookServices.getAllBooks();
        this.frValue = "One";
        cartList = new ArrayList<>();
    }
    
    public void changeFragment(ActionEvent evt) {

        String buttonId = evt.getComponent().getId();

        switch (buttonId) {
            case "one":
                this.frValue = "One";
                break;
            case "two":
                this.frValue = "Two";
                break;
            default:
                break;
        }

    }
   
    public void addItemToCart(Book book) {
        if (book != null) {
            getCartList().add(book);
        }
    }

    public void deleteItem(Book book) {
        if (book != null) {
            getCartList().remove(book);
        }
    }

    public String getFrValue() {
        return frValue;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setFrValue(String frValue) {
        this.frValue = frValue;
    }

    public List<Book> getBooksLst() {
        return booksLst;
    }

    public void setBooksLst(List<Book> booksLst) {
        this.booksLst = booksLst;
    }

    public List<Book> getCartList() {
        return cartList;
    }

    public void setCartList(List<Book> cartList) {
        this.cartList = cartList;
    }

}
