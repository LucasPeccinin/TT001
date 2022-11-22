package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Consulta;
import model.ConsultaDAO;
import model.Veterinario;
import model.VeterinarioDAO;

/**
 *
 * @author Lucas Peccinin
 */
//TROCAR FINALIZADO PARA BOOLEAN
public class ConsultaTableModel extends GenericTableModel {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ConsultaTableModel(List vDados) {
        super(vDados, new String[]{"ID", "Veterinario", "Cliente", "Animal", "Comentarios", "Hora", "Data", "Finalizado"});
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return Integer.class;
            case 6:
                return String.class;
            case 7:
                return Boolean.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex outr of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return consulta.getId();
            case 1:
                Veterinario veterinario = VeterinarioDAO.getInstance().retrieveById(consulta.getVeterinario());
                return veterinario.getNome();
            case 2:
                Animal animal = AnimalDAO.getInstance().retrieveById(consulta.getAnimal());
                return ClienteDAO.getInstance().retrieveById(animal.getCliente()).getNome();
            case 3:
                animal = AnimalDAO.getInstance().retrieveById(consulta.getAnimal());
                return animal.getNome();
            case 4:
                return consulta.getComentarios();
            case 5:
                return consulta.getHora();
            case 6:
                return dateFormat.format(consulta.getData().getTime());
            case 7:
                return consulta.isFinalizado();
            default:
                throw new IndexOutOfBoundsException("columnIndex outr of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                consulta.setComentarios((String)aValue);
                break;
            case 5:
                consulta.setHora((Integer)aValue);
                break;
            case 6:
                Calendar cal = Calendar.getInstance();
                try {
                    cal.setTime(dateFormat.parse((String)aValue));
                } catch (ParseException ex) {
                    Logger.getLogger(ConsultaTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                consulta.setData(cal);
                break;
            case 7:
                consulta.setFinalizado((Boolean)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex outr of bounds");
        }
        ConsultaDAO.getInstance().update(consulta);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if ((columnIndex > 2)) {
            return true;
        } else {
            return false;
        }
    }
}
