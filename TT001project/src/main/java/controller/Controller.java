package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import view.GenericTableModel;
import model.*;
import view.AnimalTableModel;
import view.ClienteTableModel;
import view.ConsultaTableModel;
import view.EspecieTableModel;
import view.VeterinarioTableModel;

/**
 *
 * @author Lucas Peccinin
 */
public class Controller {

    private static Cliente clienteSelecionado = null;
    private static Animal animalSelecionado = null;
    private static Veterinario veterinarioSelecionado = null;
    private static JTextField clienteSelecionadoTextField = null;
    private static JTextField animalSelecionadoTextField = null;
    private static JTextField veterinarioSelecionadoTextField = null;
    private static int hora;
    
    Calendar data;

    public static void setTableModel(JTable table, GenericTableModel tableModel) {
        table.setModel(tableModel);
    }

    public static void setTextFields(JTextField cliente, JTextField animal, JTextField veterinario) {
        clienteSelecionadoTextField = cliente;
        animalSelecionadoTextField = animal;
        veterinarioSelecionadoTextField = veterinario;
    }

    public static Veterinario getVeterinarioSelecionado() {
        return veterinarioSelecionado;
    }

    public static Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public static Animal getAnimalSelecionado() {
        return animalSelecionado;
    }

    public static void setSelected(Object selected) {
        if (selected instanceof Cliente) {
            clienteSelecionado = (Cliente) selected;
            clienteSelecionadoTextField.setText(clienteSelecionado.getNome());
            animalSelecionadoTextField.setText("");
        } else if (selected instanceof Animal) {
            animalSelecionado = (Animal) selected;
            animalSelecionadoTextField.setText(animalSelecionado.getNome());
        } else if (selected instanceof Veterinario) {
            veterinarioSelecionado = (Veterinario) selected;
            veterinarioSelecionadoTextField.setText(veterinarioSelecionado.getNome());
        }
    }

    public static void jRadioButtonClienteSelecionado(JTable table) {
        setTableModel(table, new ClienteTableModel(ClienteDAO.getInstance().retrieveAll()));
    }

    public static boolean jRadioButtonAnimalSelecionado(JTable table) {
        if (Controller.getClienteSelecionado() != null) {
            setTableModel(table, new AnimalTableModel(AnimalDAO.getInstance().retrieveByIdCliente(Controller.getClienteSelecionado().getId())));
            return true;
        } else {
            setTableModel(table, new AnimalTableModel(new ArrayList()));
            return false;
        }
    }

    public static void jRadioButtonEspecieSelecionado(JTable table) {
        setTableModel(table, new EspecieTableModel(EspecieDAO.getInstance().retrieveAll()));
    }

    public static void jRadioButtonVeterinarioSelecionado(JTable table) {
        setTableModel(table, new VeterinarioTableModel(VeterinarioDAO.getInstance().retrieveAll()));
    }

    public static List<Object> getClientesNomeParecido(String nome) {
        return ClienteDAO.getInstance().retrieveBySimilarName(nome);
    }

    public static void atualizaNomeParecido(JTable table, String nomeParecido) {
        if (table.getModel() instanceof ClienteTableModel) {
            ((GenericTableModel) table.getModel()).addListOfItems(ClienteDAO.getInstance().retrieveBySimilarName(nomeParecido));
        } else if (table.getModel() instanceof VeterinarioTableModel) {
            ((GenericTableModel) table.getModel()).addListOfItems(VeterinarioDAO.getInstance().retrieveBySimilarName(nomeParecido));
        } else if (table.getModel() instanceof AnimalTableModel) {
            if (getClienteSelecionado() != null) {
                ((GenericTableModel) table.getModel()).addListOfItems(AnimalDAO.getInstance().retrieveBySimilarName(getClienteSelecionado().getId(), nomeParecido));
            }
        } else if (table.getModel() instanceof EspecieTableModel) {
            ((GenericTableModel) table.getModel()).addListOfItems(EspecieDAO.getInstance().retrieveBySimilarName(nomeParecido));
        }
    }

    public static Cliente novoCliente(String nome, String cpf, String cep, String email, String telefone) {
        return ClienteDAO.getInstance().create(nome, cpf, cep, email, telefone);
    }

    public static Animal novoAnimal(String nome, String sexo, String especie) {
        return AnimalDAO.getInstance().create(nome, 0, sexo, getClienteSelecionado().getId(), 0);
    }

    public static Consulta novaConsulta(String comentarios, int hora) {
        return ConsultaDAO.getInstance().create(getVeterinarioSelecionado().getId(), getAnimalSelecionado().getId(), 0, "", hora, Calendar.getInstance(), false);
    }

    public static Veterinario novoVeterinario(String nome, String email, String telefone, String cep) {
        return VeterinarioDAO.getInstance().create(nome, email, telefone, cep);
    }

    public static Especie novaEspecie(String nome) {
        return EspecieDAO.getInstance().create(nome);
    }

    public static boolean novosRegistros(JTable table) {
        if (table.getModel() instanceof ClienteTableModel) {
            ((GenericTableModel) table.getModel()).addItem(Controller.novoCliente("", "", "", "", ""));
        } else if (table.getModel() instanceof VeterinarioTableModel) {
            ((GenericTableModel) table.getModel()).addItem(Controller.novoVeterinario("", "", "", ""));
        } else if (table.getModel() instanceof EspecieTableModel) {
            ((GenericTableModel) table.getModel()).addItem(Controller.novaEspecie(""));
        } else if (table.getModel() instanceof AnimalTableModel) {
            ((GenericTableModel) table.getModel()).addItem(Controller.novoAnimal("", "", ""));
        } else if (table.getModel() instanceof ConsultaTableModel) {
            if ((clienteSelecionado != null) && (animalSelecionado != null) && (veterinarioSelecionado != null)) {
                ((GenericTableModel) table.getModel()).addItem(Controller.novaConsulta("", hora));
            } else {
                return false;
            }
        }
        return true;
    }

    public static void atualizaBotaoTodos(JTable table, JTextField textField) {
        if (table.getModel() instanceof ClienteTableModel) {
            ((GenericTableModel) table.getModel()).addListOfItems(ClienteDAO.getInstance().retrieveAll());
        } else if (table.getModel() instanceof AnimalTableModel) {
            if (getClienteSelecionado() != null) {
                ((GenericTableModel) table.getModel()).addListOfItems(AnimalDAO.getInstance().retrieveByIdCliente(getClienteSelecionado().getId()));
            }
        } else if (table.getModel() instanceof EspecieTableModel) {
            ((GenericTableModel) table.getModel()).addListOfItems(EspecieDAO.getInstance().retrieveAll());
        } else if (table.getModel() instanceof VeterinarioTableModel) {
            ((GenericTableModel) table.getModel()).addListOfItems(VeterinarioDAO.getInstance().retrieveAll());
        }
        textField.setText("");
    }

    public static void apagaCliente(Cliente cliente) {
        List<Animal> animais = AnimalDAO.getInstance().retrieveByIdCliente(cliente.getId());
        for (Animal animal : animais) {
            AnimalDAO.getInstance().delete(animal);
        }
        ClienteDAO.getInstance().delete(cliente);
    }

    public static void apagaAnimal(Animal animal) {
        AnimalDAO.getInstance().delete(animal);
    }

    public static List getTodasConsultas() {
        return ConsultaDAO.getInstance().retrieveAll();
    }

    public static boolean apagaConsulta(JTable table) {
        if (table.getSelectedRow() >= 0) {
            Object item = ((GenericTableModel) table.getModel()).getItem(table.getSelectedRow());
            ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
            ConsultaDAO.getInstance().delete((Consulta) item);
            return true;
        }
        return false;
    }

    public static void filtraConsultas(JTable table, JToggleButton jtTodas, JToggleButton jtVet) {
        if (table.getModel() instanceof ConsultaTableModel) {
            String query = "";
            String where = "";
            if(table.getModel() instanceof ConsultaTableModel){
                where = "WHERE data >= DATE('NOW')";
            }
            if (jtTodas.isSelected()/* && (!jtTodas.isSelected() || !jtHoje.isSelected())*/) {
                /*query = "SELECT * FROM CONSULTA " + where + " ORDER BY DATA, HORA";
                ((GenericTableModel) table.getModel()).addListOfItems(ConsultaDAO.getInstance().retrieve(query));*/
                getTodasConsultas();
            }
            if (jtVet.isSelected()/* && (!jtTodas.isSelected() || !jtHoje.isSelected())*/){
                if(getVeterinarioSelecionado() != null){
                query = "SELECT * FROM CONSULTA WHERE VETERINARIO = " + getVeterinarioSelecionado().getId();
                ((GenericTableModel) table.getModel()).addListOfItems(ConsultaDAO.getInstance().retrieve(query));
                }
            }
//            if (jtHoje.isSelected() && !jtTodas.isSelected() || !jtVet.isSelected()){
//                if(getVeterinarioSelecionado() != null){
//                query = "SELECT * FROM CONSULTA WHERE DATA = " + data.getTimeInMillis();
//                ((GenericTableModel) table.getModel()).addListOfItems(ConsultaDAO.getInstance().retrieve(query));
//                }
//            }
        }
    }

}
