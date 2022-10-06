package view;

import java.util.List;
import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Consulta;
import model.ConsultaDAO;
import model.Especie;
import model.EspecieDAO;
import model.Exame;
import model.ExameDAO;
import model.Tratamento;
import model.TratamentoDAO;
import model.Veterinario;
import model.VeterinarioDAO;

/**
 *
 * @author Lucas Peccinin
 */
public class Main {

    public static void main(String[] args) {
        
        /* CADASTRO DE CLIENTES 
        ClienteDAO.getInstance().create("Lucas Peccinin", "34473628809", "13484141", "l247536@dac.unicamp.br", "19982127348");
        ClienteDAO.getInstance().create("Bruna Costa", "4254528569", "13485483", "brubs.brunacosta@gmail.com", "198545856985");
        List lista = ClienteDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* CADASTRO DE ESPÉCIES 
        EspecieDAO.getInstance().create("Cachorro");
        EspecieDAO.getInstance().create("Gato");
        EspecieDAO.getInstance().create("Macaco");
        List lista = EspecieDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* CADASTRO ANIMAIS 
        AnimalDAO.getInstance().create("Dindi", 2, "F", 2, 2);
        AnimalDAO.getInstance().create("Cícero", 2, "M", 1, 3);
        AnimalDAO.getInstance().create("Maila", 13, "F", 1, 1);
        List lista = AnimalDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* RETORNAR ANIMAIS PELO ID DO CLIENTE
        System.out.println(AnimalDAO.getInstance().retrieveByIdCliente(1));
        */
        
        /* CADASTRO DE VETERINÁRIO
        VeterinarioDAO.getInstance().create("Vet01", "vet01@gmail.com", "19985856545", "13485658");
        List lista = VeterinarioDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* CADASTRO DE TRATAMENTO 
        TratamentoDAO.getInstance().create(1, "Consulta", "05/08/2022", "05/08/2022", 1);
        List lista = TratamentoDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* CADASTRO DE CONSULTA 
        ConsultaDAO.getInstance().create(1, 1, 1, "Apresenta pata machucada. Foi feito um curativo e será feito um exame", 15, "05/08/2022", 1);
        List lista = ConsultaDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* CADASTRO DE EXAME
        ExameDAO.getInstance().create("Raio-X", 1);
        List lista = ExameDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* EXEMPLO DE DELETE
        Exame e2 = ExameDAO.getInstance().retrieveById(2);
        ExameDAO.getInstance().delete(e2);
        */
        
        /* EXEMPLO DE UPDATE
        Animal a3 = AnimalDAO.getInstance().retrieveById(3);
        a3.setIdade(12);
        AnimalDAO.getInstance().update(a3);
        */
    }

}
