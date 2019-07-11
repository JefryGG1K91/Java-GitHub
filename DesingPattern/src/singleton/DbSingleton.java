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
public class DbSingleton {

    private static volatile DbSingleton instance = null;

    private DbSingleton() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create class object");
        }
    }

    public static DbSingleton getInstance() {

        if (instance == null) {

            synchronized (DbSingleton.class) {

                if (instance == null) {

                   instance = instance = new DbSingleton();

                }

            }

        }

        return instance;
    }
}
