package model;

/**
 *
 * @author Lucas Peccinin
 */
public class Main {

    public static void main(String[] args) {
        Cliente c1 = new Cliente(1, "Lucas", "34473628809","13484141", "l247536@dac.unicamp.br");
        Cliente c2 = new Cliente(2,"Bruno", "5481654651","653215122","bruno@gmail.com");
        System.out.println("Nome: "+c1.getNome());
        System.out.println("Nome: "+c2.getNome());
    }
}
