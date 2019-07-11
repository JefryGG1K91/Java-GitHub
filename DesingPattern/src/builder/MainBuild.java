/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

/**
 *
 * @author jgutierrez
 */
public class MainBuild {

    public static void main(String[] args) {

        LunchOrder.Builder builder = new LunchOrder.Builder();

        builder.bread("wheat").condiments("tomatoes").dressing("mayo").meat("turkey");

        LunchOrder lunchOrder = builder.build();

        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressing());
        System.out.println(lunchOrder.getMeat());

    }

}
