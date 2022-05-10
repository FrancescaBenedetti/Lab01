package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;

    @FXML
    private TextArea txtPerformance;
    
    @FXML
    void doCancella(ActionEvent event) {
    	
    	String p = txtResult.getSelectedText();
    	double start = System.nanoTime();
    	elenco.cancella(p);
    	double stop = System.nanoTime();
    	
    	txtResult.clear();
    	String result="";
    	for(String s: elenco.getElenco()) {
    		result+=s+"\n";
    	}
    	txtResult.setText(result);
    	txtPerformance.setText("Tempo impiegato: " + (stop-start)/1e9 + " secondi");
    	txtParola.clear();
    }

    @FXML
    void doInsert(ActionEvent event) {
    	
    	double start = System.nanoTime();
    	String parola = txtParola.getText();
    	if(parola != null) {
    		elenco.addParola(parola);
    	}
    	
    	txtResult.clear();
    	String s = "";
    	for(String p: elenco.getElenco()) {
    		s+=p+"\n";
    	}
    	double stop = System.nanoTime();
    	txtResult.setText(s);
    	txtPerformance.setText("Tempo impiegato: " + (stop-start)/1e9 + " secondi");
    	txtParola.clear();    	
  
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtResult.clear();
    	elenco.reset();
    	txtPerformance.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPerformance != null : "fx:id=\"txtPerformance\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
    }
}
