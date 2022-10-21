package view;

import java.util.List;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author Lucas Peccinin
 */
public class ClienteTableModel extends GenericTableModel {
   
    public ClienteTableModel(List vDados){
        super(vDados, new String[]{"Nome", "CEP", "E-mail", "Telefone"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex outr of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Cliente client = (Cliente) vDados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return client.getNome();
            case 1:
                return client.getCep();
            case 2:
                return client.getEmail();
            case 3:
                return client.getTelefone();
            default:
                throw new IndexOutOfBoundsException("columnIndex outr of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Cliente client = (Cliente) vDados.get(rowIndex);
        
        switch (columnIndex){
            case 0:
                client.setNome((String)aValue);
                break;
            case 1: 
                client.setCep((String)aValue);
                break;
            case 2:
                client.setEmail((String)aValue);
                break;
            case 3:
                client.setTelefone((String)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex outr of bounds");
        }
        ClienteDAO.getInstance().update(client);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
}
