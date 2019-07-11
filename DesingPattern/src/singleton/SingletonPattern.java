/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author jgutierrez
 */
public class SingletonPattern {

    public static void main(String[] args) {
      
        DbSingleton instance= DbSingleton.getInstance();
        
        System.out.println("singleton.SingletonPattern.main()"+ instance);
        
        DbSingleton anotherInstance= DbSingleton.getInstance();
        
        System.out.println("singleton.SingletonPattern.main() anotherInstance"+ anotherInstance);
    }
    
}
