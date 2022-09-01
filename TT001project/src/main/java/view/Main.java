package view;

import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author Lucas Peccinin
 */
public class Main {

    public static void main(String[] args) {
        /*Cliente c1 = new Cliente(1, "Lucas", "34473628809","13484141", "l247536@dac.unicamp.br");
        Cliente c2 = new Cliente(2, "Bruno", "46515314515","13482459", "bruno@gmail.com");
        
        System.out.println("Nome: "+c1.getNome());*/
        
        ClienteDAO.getInstance().create("Lucas", "34473628809", "13484141", "l247536@dac.unicamp.br", "19982127348");
        
        //Cliente c1 = ClienteDAO.getInstance().retrieveById(1);
    }
}
