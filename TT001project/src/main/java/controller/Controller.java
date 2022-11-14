package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import view.GenericTableModel;
import model.*;
import view.AnimalTableModel;
import view.ClienteTableModel;
import view.EspecieTableModel;
import view.VeterinarioTableModel;

/**
 *
 * @author Lucas Peccinin
 */
public class Controller {

    private static Cliente clienteSelecionado = null;
    private static Animal animalSelecionado = null;
    private static JTextField clienteSelecionadoTextField = null;
    private static JTextField animalSelecionadoTextField = null;

    public static void setTableModel(JTable table, GenericTableModel tableModel) {
        table.setModel(tableModel);
    }

    public static void setTextFields(JTextField cliente, JTextField animal) {
        clienteSelecionadoTextField = cliente;
        animalSelecionadoTextField = animal;
    }

    public static Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public static void setSelected(Object selected) {
        if (selected instanceof Cliente) {
            clienteSelecionado = (Cliente) selected;
            clienteSelecionadoTextField.setText(clienteSelecionado.getNome());
            animalSelecionadoTextField.setText("");
        } else if (selected instanceof Animal) {
            animalSelecionado = (Animal) selected;
            animalSelecionadoTextField.setText(animalSelecionado.getNome());

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
}
