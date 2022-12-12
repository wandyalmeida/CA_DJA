/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SIGNUP;

import java.util.Scanner;

/**
 *
 * @author wandw
 */
public class SignUp {
    
        Scanner input = new Scanner(System.in);
    
    public void SingUpUsers(){
        String name_usuario, senha_usuario;
       
        System.out.println("Digite nome d0 usuario");
        name_usuario = input.nextLine();
        System.out.println("Digite uma senha para o usuario");
        senha_usuario = input.nextLine();
        RegularUserDTO objregistaruserdto = new RegularUserDTO();
        objregistaruserdto.setUser_name(name_usuario);
        objregistaruserdto.setUser_password(senha_usuario);
        
        
        RegularUserDAO objregularuserdao = new RegularUserDAO();
        objregularuserdao.registrarUser(objregistaruserdto);
        
    }
    
    public void update(int id){
           RegularUserDAO list = new RegularUserDAO();
//           int id;
           String nome_usuario, senha_usuario;

//            if ("admin".equals(admin) && "123".equals(senha)){
//                    list.pesquisarUsuario();
//                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
//                    System.out.println("Digite o id do usuario que deseja modificar");
//                    id = input.nextInt();
//                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
//                    System.out.println("Digite um novo usuario: ");
//                    nome_usuario = input.next();
//                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
//                    System.out.println("Digite a nova senha: ");
//                    senha_usuario = input.next();
//                    RegularUserDTO obDTO = new RegularUserDTO();
//                    obDTO.setId_user(id);
//                    obDTO.setUser_name(nome_usuario);
//                    obDTO.setUser_password(senha_usuario);
//
//                    RegularUserDAO obDAO = new RegularUserDAO();
//                    obDAO.alterarUsuario(obDTO);
//             }else{
//                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
////                    System.out.println("Digite o  seu id");
////                    id = input.nextInt();
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Digite um novo usuario: ");
                    nome_usuario = input.next();
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Digite a nova senha: ");
                    senha_usuario = input.next();
                    RegularUserDTO obDTO = new RegularUserDTO();
                    obDTO.setId_user(id);
                    obDTO.setUser_name(nome_usuario);
                    obDTO.setUser_password(senha_usuario);

                    RegularUserDAO obDAO = new RegularUserDAO();
                    obDAO.alterarUsuario(obDTO);
//            }
           
    }
    public void delete(){
         int id_usuario;
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         System.out.println("Digite o id que voce deseja excuir: ");
         id_usuario = input.nextInt();
         
         RegularUserDTO obDTO = new RegularUserDTO();
         
         obDTO.setId_user(id_usuario);
         
         RegularUserDAO obDAO = new RegularUserDAO();
         
         obDAO.excuirdados(obDTO);
    }
    
}
