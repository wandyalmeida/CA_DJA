/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Equation;

import enums.MathTypes;
import java.util.Scanner;

/**
 *
 * @author Wandwilson Almeida Da Silva
 * Student name: Carolina Gomes Landim
 */
public class Math implements MathInterface {

    @Override
    public void math(int id_user) {
        Matrix matrix = new Matrix();
        System.out.println(
            "******** Choice in which matrix you want to do the linear equation ********");
        
        /*
        Show the enum menu
        */
        for (int type = 1; type <=MathTypes.values().length; type++) {
              System.out.println( type + ". " + MathTypes.values()[type-1]);
          }
        
        System.out.println("Enter the number of matrix would like to use: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        try {
            if (num == 1 ) {
                
                matrix.Matrix_2X2(2, id_user);//if option is 1 go to matrix_2x2 class
           
            }if (num == 2 ) {
               
                matrix.Matrix_3X3(3, id_user);//if option is 2 go to matrix_3x3 class
           
            }
            else {
                System.out.println("Sorry, that is an invalid number");
                math(id_user);
            }
          }
          catch (Exception e) {
              System.out.println("Sorry, that is an invalid input type");// show this message if this method get a error.
              math(id_user);// if the user put an wrong option return to math class.
          }

    }
    
}
