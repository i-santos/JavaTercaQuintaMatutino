/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula7;

/**
 *
 * @author Professor
 */
public class Aula7Boolean {

    public static void main(String[] args) {

        boolean b;
        int n1;
        int n2;
        n1 = 10;
        n2 = 5;

        b = true;
        b = false;
        b = 10 > 5; // b = true
        b = 10 < 5; // b = false
        b = 10 == 5;// b = false
        b = 10 == 10;// b = true

        b = n1 > n2; // b = true
        b = n1 < n2; // b = false
        b = n1 == n2; // b = false
        b = n1 == (n2 + 5);// b = true

        b = n1 > n2 && n1 == (n2 + 5); // n1 > n2       -> true
        // n1 == n2 + 5  -> true
        // true && true  -> true
        // b = true
        b = n1 < n2 && n1 == n2;// n1 < n2 -> false
        // b = false

        b = !true; // b = false
        b = !false;// b = true

        b = !((n1 > n2 && n1 == (n2 + 5))
                && (n1 < n2 || n1 == 15)
                || (n2 == n1)); // b = true
    }
}
