/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGIN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author wandw
 */
public class login implements LoginInterface {
    Scanner input = new Scanner(System.in);
    RegularUserDAO list = new RegularUserDAO();
    Equation.Math math = new Equation.Math();
    
    
    @Override
    public void login() {
        try {
            String name_usuario, senha_usuario;
            int id;
//            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Digite seu usuario:");
            name_usuario = input.next();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Digite sua senha:");
            senha_usuario = input.next();
            
            UsuarioDTO objusuariodto = new UsuarioDTO();
            objusuariodto.setNome_usuario(name_usuario);
            objusuariodto.setSenha_usuario(senha_usuario);
            
            UsuarioDAO objusuariodao = new UsuarioDAO();
            ResultSet rsusuariodao = objusuariodao.autenticationUesr(objusuariodto);
            id = list.getId(name_usuario, senha_usuario);
            
            
            if (rsusuariodao.next()) {
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("Loggin sucefull");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                         
            } else {
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("Usuario ou senha invalida");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                login();
            }
            list.check_admin(id, name_usuario, senha_usuario);

        } catch (SQLException e) {
            System.out.println("Erro no login " + e);
        }

    }
    
    @Override
     public void menu(){
        boolean start = true; 
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         System.out.println("Welcome to equation Database: ");
         System.out.println("[1] to Login");
         System.out.println("[2] to registar new users");
         System.out.println("please choosen one of the option:");
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         String option = input.next();

         while (start){
         
             switch (option){

                case "1": 
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    login();
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                 
//                    break;
                    
                case "2":
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    RegistrarUsers registrar = new RegistrarUsers();
                    registrar.RegistrarUsers();
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
//                    break;
                    menu();
                default:
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Sorry, Wrong option try again...");
                    menu();
                

            }
         }   
    }
    
    @Override
    public void admin(int id){
        boolean start = true; 
        RegularUserDAO list = new RegularUserDAO();
        RegistrarUsers alt = new RegistrarUsers();
      
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         System.out.println("What would you like to do? ");
         System.out.println("[1] modify profile");
         System.out.println("[2] see the users list");
         System.out.println("[3] remove users");
         System.out.println("[4] see the operations ");
         System.out.println("[5] log out. ");
         System.out.println("please choosen one of the option:");
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         String option = input.next();
         while (start){
         
             switch (option){

                case "1": 
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println(id);
                    alt.alterar(id);
   
                    admin(id);
                    
//                    break;
                    
                case "2":
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

                    list.pesquisarUsuario(id);
                    admin(id);

                case "3":
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    list.pesquisarUsuario(id);  
//                    RegistrarUsers deletar = new RegistrarUsers();
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    deletar.excuirdados();
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Usuario deletado com sucesso");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    list.pesquisarUsuario(id);
                    admin(id);
//                  
                case "4":
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("It is not working yet.");
                    admin(id);

                case "5":
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Bye see you soon");
                    menu();
//
                default:
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Sorry, Wrong option try again...");
                    admin(id);
            }
         }
        
    }
    
    /**
     * menu user to check what the user would like to do.
     * @param id  get the id from the user is log in to check if he would like to update profile
     */
    @Override
    public void users(int id){
        boolean start = true; 
        RegistrarUsers alt = new RegistrarUsers();
      
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         System.out.println("What would you like to do? ");
         System.out.println("[1] Modify profile");
         System.out.println("[2] Solve systems of linear equations");
         System.out.println("[3] Log out");
//         System.out.println("[4] see the operations ");
//         System.out.println("[5] log out. ");
         System.out.println("please choosen one of the option:");
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         String option = input.next();
         while (start){
         
             switch (option){

                case "1": 
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    alt.alterar(id);
                    users(id);
                    
//                    break;
                    
                case "2":
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
//                    System.out.println("sorry is not work yet..");
                    math.math(id);
//                    users(id);
                case "3":
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Bye see you soon");
                    menu();
                default:
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Sorry, Wrong option try again...");
                    users(id);
            }
         }
        
    }
    
}
