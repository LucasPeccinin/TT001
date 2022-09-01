package controller;

import model.*;
/**
 *
 * @author Lucas Peccinin
 */
public class Controller {
    
    public static Cliente addCliente(String nome, String cpf, String cep, String email, String telefone){
        return ClienteDAO.getInstance().create(nome,cpf,cep,email,telefone);
    }
    
    /*public static boolean isLastClientEmpty(){
        return ClienteDAO.getInstance().isLastEmpty();
    }*/
}
