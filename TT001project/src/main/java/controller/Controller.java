package controller;

import javax.swing.JTable;
import javax.swing.JTextField;
import view.GenericTableModel;
import model.*;
/**
 *
 * @author Lucas Peccinin
 */
public class Controller {
    
    private static Cliente clienteSelecionado = null;
    private static Animal animalSelecionado = null;
    private static JTextField clienteSelecionadoTextField = null;
    private static JTextField animalSelecionadoTextField = null;
    
    public static void setTextFields(JTextField cliente, JTextField animal){
        clienteSelecionadoTextField = cliente;
        animalSelecionadoTextField = animal;
    }
    
    public static void setTableModel(JTable table, GenericTableModel tableModel){
        table.setModel(tableModel);
    }
    
    public static Cliente gatClienteSelecionado(){
        return clienteSelecionado;
    }
    
    public static void setSelected(Object selected){
        if(selected instanceof Cliente){
            clienteSelecionado = (Cliente)selected;
            clienteSelecionadoTextField.setText(clienteSelecionado.getNome());
            animalSelecionadoTextField.setText("");
        } else if (selected instanceof Animal){
            animalSelecionado = (Animal)selected;
            animalSelecionadoTextField.setText(animalSelecionado.getNome());
            
        }
    }
}
