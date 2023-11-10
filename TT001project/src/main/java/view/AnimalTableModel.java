package view;

import java.util.List;
import model.Animal;
import model.AnimalDAO;
import model.Especie;
import model.EspecieDAO;

/**
 *
 * @author CASA
 */
public class AnimalTableModel extends GenericTableModel{
    
    public AnimalTableModel(List vDados){
        super(vDados, new String[]{"Nome","Nascimento","Sexo","Espécie"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return Integer.class;
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
        Animal animal = (Animal) vDados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return animal.getNome();
            case 1:
                return animal.getIdade();
            case 2:
                return animal.getSexo();
            case 3:
                Especie especies = EspecieDAO.getInstance().retrieveById(animal.getEspecie());
                if(especies != null){
                    return especies.getNome();
                }
                return "";
            default:
                throw new IndexOutOfBoundsException("columnIndex outr of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Animal animal = (Animal) vDados.get(rowIndex);
        
        switch (columnIndex){
            case 0:
                animal.setNome((String)aValue);
                break;
            case 1: 
                animal.setIdade((Integer)aValue);
                break;
            case 2:
                animal.setSexo((String)aValue);
                break;
            case 3:
                Especie especies = EspecieDAO.getInstance().retrieveByName((String)aValue);
                if(especies == null){
                    especies = EspecieDAO.getInstance().create((String)aValue);
                }
                animal.setEspecie(especies.getId());
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex outr of bounds");
        }
        AnimalDAO.getInstance().update(animal);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
}
