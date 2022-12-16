/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Equation;

import Create_and_insertDB.DDL_DML_DQL;
import LOGIN.login;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Wandwilson Almeida Da Silva 2021230
 * @author Carolina Gomes Landim 2021226
 */
public class Matrix implements MatrixInterface {
    
    /*
    call other packege to use other class
    */
    login lg = new login();
    DDL_DML_DQL user = new DDL_DML_DQL();
    Scanner input = new Scanner(System.in);
    
    /*
        If the option is 1 use matrix_2x2 class
    */
    @Override
    public void Matrix_2X2(int num, int id_user) {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("it is not necesary to put any sinals or letters, only if the number is negative.\nPress the enter button when do you finish each equation."
                + "\nif the equation is x + y = 2 put number 1 instead letters.");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(
            "Enter the equation");
        System.out.println(
            "Enter in the format shown below");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("1 -2 29 \nor\n 1\n-2\n 29");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        
       
        // Input of equation from user
        String numbers = null, numbers2 = null, numbers3 = null, equation, solution;
        int[][] matrix = new int[num][num];
        int[] constt = new int[num];
        int[][] matrix1 = new int[num][num];
        int[][] matrix2 = new int[num][num];
        
        for (int i = 0; i < num; i++) {
            
            for (int j = 0; j < num; j++) {

                matrix[i][j] = input.nextInt(); // get the user input.
                
            }

            constt[i] = input.nextInt(); // get the last input of each equation
            
            //start check if the numbers is positive or negative and if the both equation do not have any negative number.
            if (matrix[i][1] >= 0){
                 numbers3 = matrix[i][0] +"x + "+matrix[i][1]+ "y = "+ constt[i];//if the number is positive they will save the number in this form.
                 if(numbers == null){
                     numbers = numbers3;

                 }else{
                     numbers2 = numbers3;
                 }
            }
             else{//if the equation have numbers negative.
                 numbers3 = matrix[i][0] +"x "+matrix[i][1]+ "y = "+ constt[i]; //if both equation have negative numbers they will save the number in this form.
                 if(numbers == null){
                     numbers = numbers3;

                 }else{
                     numbers2 = numbers3;
                 }
             }

        }
        
         
        // Representation of linear equations in form of
        // matrix
        
        //start the calculator to get the determinante of each matrix 
        System.out.println(
            "Matrix representation of above linear equations is: ");
        
        
        for (int i = 0; i < num; i++) { //start the first matrix
            for (int j = 0; j < num; j++) {
                matrix1[i][j] = matrix[i][j];
                matrix1[i][0] = constt[i];
                matrix2[i][j] = matrix[i][j];
                matrix2[i][1] = constt[i];
                System.out.print(" " + matrix[i][j]);//show the first matrix
                

            }
            System.out.print("  =  " + constt[i]);
            System.out.println();
        }
        
        int determitationM =Determinant.determinantMatrix(matrix, num);// go to determinat class to get the determinant
        System.out.println("The determinant: " + determitationM); //show the determinant for the first matrix
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        
        for (int i = 0; i < num; i++) {//Start the second matrix
        
            for (int j = 0; j < num; j++) {

                System.out.print(" " + matrix1[i][j]);//show the second matrix
                
            }
            
            System.out.println();
        }
        int determitationX = Determinant.determinantMatrix(matrix1, num);// go to determinat class to get the determinant
        System.out.println("The determinant: " + determitationX);//show the determinant for the second matrix
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="); 
        
        for (int i = 0; i < num; i++) { //Start the third matrix
        
            for (int j = 0; j < num; j++) {
                System.out.print(" " + matrix2[i][j]);//show the third matrix
               
                

            }
            
            System.out.println();
        }
        int determitationY =Determinant.determinantMatrix(matrix2, num);// go to determinat class to get the determinant
        System.out.println("The determinant: " + determitationY);//show the determinant for the third matrix
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="); 
        if (determitationM == 0 && determitationX == 0 && determitationY == 0){
            solution = "No Solutions or Infinitie Solutions";
        }else{
            solution = "X: "+new DecimalFormat().format((double)determitationX / (double)determitationM) + ", Y: "+ new DecimalFormat("#.####").format((double)determitationY / (double)determitationM);//get the solution of the equation.
        }
        System.out.println(numbers); //show the first equation form
        System.out.println(numbers2);//show the first equation form
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="); 
        System.out.println(solution);//show the answer to user.
        
        
        boolean op = true;

        do{
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Would you like to save this equation ?"
                    + "\n[1] Yes"
                    + "\n[2] No  ");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    op = false;
                    break;
                case 2:
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("This solution was not save.");
                    lg.users(id_user);
                default:
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("wrong option try again");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    break;
            }

        }while (op);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("This solution was save.");
            equation = numbers + " " + numbers3;
            user.addEquation(equation, solution, id_user);
            lg.users(id_user);
    }

    /*
        If the option is 2 use matrix_3x3 class
    */
    @Override
    public void Matrix_3X3(int num, int id_user) {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("it is not necesary to put any sinals or letters, only if the number is negative.\nPress the enter button when do you finish each equation."
                + "\nif the equation is x + y - z = 2 put number 1 instead letters.");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(
            "Enter the equation");
        System.out.println(
            "Enter in the format shown below");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("1 -2 3 29 \nor\n 1\n-2\n 3\n 29");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        
        
        // Input of coefficients from user
        String numbers = null, numbers2 = null, numbers3 = null, numbers4 = null, equation, solution;
        int[][] matrix = new int[num][num];
        int[] constt = new int[num];
        int[][] matrix1 = new int[num][num];
        int[][] matrix2 = new int[num][num];
        int[][] matrix3 = new int[num][num];
  
        
        
        for (int i = 0; i < num; i++) {
            
            for (int j = 0; j < num; j++) {

                matrix[i][j] = input.nextInt();// get the user input.
                
                
            }
            constt[i] = input.nextInt(); // get the last input of each equation
            
            if (matrix[i][1] >= 0 && matrix[i][2] >= 0){ //start check if the numbers is positive or negative and if the both equation do not have any negative number.
                 numbers4 = matrix[i][0] +"x + " +matrix[i][1]+ "y + "+matrix[i][2]+ "z = " +constt[i];//if the number is positive they will save the number in this form.
                 if(numbers == null){
                     numbers = numbers4;
                 }else if(numbers2 == null){
                     numbers2 = numbers4;
                 }else{
                     numbers3 = numbers4;
                 }
                
            }else if(matrix[i][1] >= 0 && matrix[i][2] <=0  ){
                 numbers4 = matrix[i][0] +"x + " +matrix[i][1]+ "y "+matrix[i][2]+ "z = " +constt[i];//if the second number is positive and the third is negative they will save the number in this form.
                if (numbers == null){
                     numbers = numbers4;
                }else if(numbers2 == null){
                    numbers2 = numbers4;
                }else{
                    numbers3 = numbers4;
                }
            }else if(matrix[i][1] <= 0 && matrix[i][2] >=0  ){ //if the second number is negative and the third is positive they will save the number in this form.
                 numbers4 = matrix[i][0] +"x  " +matrix[i][1]+ "y + "+matrix[i][2]+ "z = " +constt[i];
                 if (numbers == null){
                     numbers = numbers4;
                }else if(numbers2 == null){
                    numbers2 = numbers4;
                }else{
                    numbers3 = numbers4;
                }
            }
             
             else{
                 numbers4 = matrix[i][0] +"x "+matrix[i][1]+ "y "+matrix[i][2]+ "z = "+ constt[i];//if the number is negative they will save the number in this form.
                 if (numbers == null){
                     numbers = numbers4;
                }else if(numbers2 == null){
                    numbers2 = numbers4;
                }else{
                    numbers3 = numbers4;
                }
             }
        }      
        
        // Representation of linear equations in form of
        // matrix
        System.out.println(
            "Matrix representation of above linear equations is: ");
        for (int i = 0; i < num; i++) { //start the first matrix
            for (int j = 0; j < num; j++) {
                matrix1[i][j] = matrix[i][j];
                matrix1[i][0] = constt[i];
                matrix2[i][j] = matrix[i][j];
                matrix2[i][1] = constt[i];
                matrix3[i][j] = matrix[i][j];
                matrix3[i][2] = constt[i];
                System.out.print(" " + matrix[i][j]);//show the first matrix
                

            }
            System.out.print("  =  " + constt[i]);
            
            System.out.println();
        }
        int determitationM = Determinant.determinantMatrix(matrix, num);// go to determinat class to get the determinant
        System.out.println("The determinant: " + determitationM);//show the determinant for the first matrix
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        
    for (int i = 0; i < num; i++) {//start the second matrix
        
            for (int j = 0; j < num; j++) {

                System.out.print(" " + matrix1[i][j]);//show the second matrix
                
                

            }
            
            System.out.println();
        }
        int determitationX = Determinant.determinantMatrix(matrix1, num);// go to determinat class to get the determinant
        System.out.println("The determinant: " + determitationX);//show the determinant for the second matrix
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        
    for (int i = 0; i < num; i++) {//start the third matrix

        for (int j = 0; j < num; j++) {

            System.out.print(" " + matrix2[i][j]);//show the third matrix



        }

        System.out.println();
    }
    int determitationY = Determinant.determinantMatrix(matrix2, num);// go to determinat class to get the determinant
    System.out.println("The determinant: " + determitationY);//show the determinant for the third matrix
    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    for (int i = 0; i < num; i++) {//start the fourth matrix

         for (int j = 0; j < num; j++) {
        System.out.print(" " + matrix3[i][j]);//show the fourth matrix




    }
    System.out.println();
    }
    DecimalFormat dc = new DecimalFormat();
    int determitationZ = Determinant.determinantMatrix(matrix3, num);// go to determinat class to get the determinant
    System.out.println("The determinant: " + determitationZ);//show the determinant for the fourth matrix
    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    if (determitationM == 0 && determitationX == 0 && determitationY == 0 && determitationZ == 0){
        solution = "No Solutions or Infinitie Solutions";
    }else{
        solution ="X: "+dc.format((double)determitationX / (double)determitationM) + ", Y: "+ dc.format((double)determitationY  / (double)determitationM) + ", Z: "+ dc.format((double)determitationZ / (double)determitationM);//get the solution of the equation.
    }
    System.out.println(numbers);//show the first equation
    System.out.println(numbers2);//show the second equation
    System.out.println(numbers3);//show the third equation
    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println(solution);//show answer
    
    
    boolean op = true;
    
    do{
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Would you like to save this equation ?"
                + "\n[1] Yes"
                + "\n[2] No  ");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        int option = input.nextInt();
        switch (option) {
            case 1:
                op = false;
                break;
            case 2:
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("This solution was not save.");
                lg.users(id_user);
            default:
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("wrong option try again");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                break;
        }
    
    }while (op);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("This solution was save.");
        equation = numbers + " "+ numbers2 + " " +numbers3;
        user.addEquation(equation, solution, id_user);
        lg.users(id_user);
    }
    
}