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
        ClienteDAO.getInstance().create("Bruna Costa", "4254528569", "13485483", "brubs.brunacosta@gmail.com", "198545856985");
        List lista = ClienteDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* DELETE CLIENTES 
        Cliente ex = ClienteDAO.getInstance().retrieveById(3);
        ClienteDAO.getInstance().delete(ex);
        List lista = ClienteDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* UPDATE CLIENTE 
        Cliente c1 = ClienteDAO.getInstance().retrieveById(1);
        c1.setTelefone("01900000000");
        ClienteDAO.getInstance().update(c1);
        List lista = ClienteDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* CADASTRO DE ESPÉCIES 
        EspecieDAO.getInstance().create("Cachorro");
        EspecieDAO.getInstance().create("Gato");
        EspecieDAO.getInstance().create("Macaco");
        EspecieDAO.getInstance().create("Macaco");
        List lista = EspecieDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* DELETE ESPECIE 
        Especie ex = EspecieDAO.getInstance().retrieveById(4);
        EspecieDAO.getInstance().delete(ex);
        List lista = EspecieDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* UPDATE ESPECIE 
        Especie e1 = EspecieDAO.getInstance().retrieveById(3);
        e1.setNome("Monkey");
        EspecieDAO.getInstance().update(e1);
        List lista = EspecieDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* CADASTRO ANIMAIS 
        AnimalDAO.getInstance().create("Dindi", 2, "F", 2, 2);
        AnimalDAO.getInstance().create("Cícero", 2, "M", 1, 3);
        AnimalDAO.getInstance().create("Maila", 13, "F", 1, 1);
        AnimalDAO.getInstance().create("Maila", 13, "F", 1, 1);
        List lista = AnimalDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* DELETE ANIMAL 
        Animal ex = AnimalDAO.getInstance().retrieveById(4);
        AnimalDAO.getInstance().delete(ex);
        List lista = AnimalDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* UPDATE ANIMAL 
        Animal a3 = AnimalDAO.getInstance().retrieveById(3);
        a3.setIdade(12);
        AnimalDAO.getInstance().update(a3);
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
        VeterinarioDAO.getInstance().create("Vet01", "vet01@gmail.com", "19985856545", "13485658");
        List lista = VeterinarioDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* DELETE VETERINARIO 
        Veterinario ex = VeterinarioDAO.getInstance().retrieveById(2);
        VeterinarioDAO.getInstance().delete(ex);
        List lista = VeterinarioDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* UPDATE VETERINARIO 
        Veterinario v1 = VeterinarioDAO.getInstance().retrieveById(1);
        v1.setEmail("vet001@gmail.com");
        VeterinarioDAO.getInstance().update(v1);
        List lista = VeterinarioDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* CADASTRO DE TRATAMENTO 
        TratamentoDAO.getInstance().create(1, "Consulta", "05/08/2022", "05/08/2022", 1);
        TratamentoDAO.getInstance().create(1, "Consulta", "05/08/2022", "05/08/2022", 1);
        List lista = TratamentoDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* DELETE TRATAMENTO 
        Tratamento ex = TratamentoDAO.getInstance().retrieveById(2);
        TratamentoDAO.getInstance().delete(ex);
        List lista = TratamentoDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* UPDATE TRATAMENTO 
        Tratamento t1 = TratamentoDAO.getInstance().retrieveById(1);
        t1.setInicio("06/08/2022");
        TratamentoDAO.getInstance().update(t1);
        List lista = TratamentoDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* CADASTRO DE CONSULTA 
        ConsultaDAO.getInstance().create(1, 1, 1, "Apresenta pata machucada. Foi feito um curativo e será feito um exame", 15, "05/08/2022", 1);
        ConsultaDAO.getInstance().create(1, 1, 1, "Apresenta pata machucada. Foi feito um curativo e será feito um exame", 15, "05/08/2022", 1);
        List lista = ConsultaDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* DELETE CONSULTA 
        Consulta ex = ConsultaDAO.getInstance().retrieveById(2);
        ConsultaDAO.getInstance().delete(ex);
        List lista = ConsultaDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* UPDATE CONSULTA 
        Consulta c1 = ConsultaDAO.getInstance().retrieveById(1);
        c1.setData("06/08/2022");
        ConsultaDAO.getInstance().update(c1);
        List lista = ConsultaDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* CADASTRO DE EXAME 
        ExameDAO.getInstance().create("Raio-X", 1);
        ExameDAO.getInstance().create("Raio-X", 1);
        List lista = ExameDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* DELETE EXAME 
        Exame e2 = ExameDAO.getInstance().retrieveById(2);
        ExameDAO.getInstance().delete(e2);
        List lista = ExameDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */
        
        /* UPDATE EXAME 
        Exame e1 = ExameDAO.getInstance().retrieveById(1);
        e1.setNome("Raio X");
        ExameDAO.getInstance().update(e1);
        List lista = ExameDAO.getInstance().retrieveAll();
        for(int i = 0; i <= lista.size() - 1 ; i++){
            System.out.println(lista.get(i));
        }
        */ 
    }
}
