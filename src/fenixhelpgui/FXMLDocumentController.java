/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenixhelpgui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 *
 * @author pedro
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button BtnGo;
    @FXML
    private Button BtnCancel;
    @FXML
    private ListView<String> listViewTTs;
    
    private List<String> listaTTs = new ArrayList();
    private ObservableList<String> observableListStrings;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregarListViewStrings();

    }      
  public void carregarListViewStrings(){
        listaTTs.add("Adicionar calendário ao Google");
        listaTTs.add("Verificar assiduidade");
        listaTTs.add("Inscrever para uma avaliação");
        //listaTTs.add("Teste 2");
        
        observableListStrings = FXCollections.observableArrayList(listaTTs);
        listViewTTs.setItems(observableListStrings);
    }
    @FXML
    public void quitApp(){
        System.exit(0);
    }
    
    @FXML
    public void launchScript() throws IOException{
        final int option = listViewTTs.getSelectionModel().getSelectedIndex();
        System.out.println(""+option);
        
        switch(option){
                case 0:
                    Runtime.getRuntime().exec("C:\\Users\\pedro\\Desktop\\TSIO\\Sikuli\\runsikulix.cmd -r C:\\Users\\pedro\\Desktop\\TSIO\\AddCalendario.sikuli");                    
                    break;
                case 1:
                    Runtime.getRuntime().exec("C:\\Users\\pedro\\Desktop\\TSIO\\Sikuli\\runsikulix.cmd -r C:\\Users\\pedro\\Desktop\\TSIO\\Assiduidade.sikuli"); 
                    break;
                case 2:
                    Runtime.getRuntime().exec("C:\\Users\\pedro\\Desktop\\TSIO\\Sikuli\\runsikulix.cmd -r C:\\Users\\pedro\\Desktop\\TSIO\\insc.sikuli"); 
                    break;
                default:
                    System.out.println("Opção não reconhecida.");
                    break;
        }
    }
}
