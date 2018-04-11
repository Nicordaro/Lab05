/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	Model model = new Model();

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtInput"
	private TextField txtInput; // Value injected by FXMLLoader

	@FXML // fx:id="btnCalcola"
	private Button btnCalcola; // Value injected by FXMLLoader

	@FXML // fx:id="txtAnCorretti"
	private TextArea txtAnCorretti; // Value injected by FXMLLoader

	@FXML // fx:id="txtAnSbagliati"
	private TextArea txtAnSbagliati; // Value injected by FXMLLoader

	@FXML // fx:id="btnReset"
	private Button btnReset; // Value injected by FXMLLoader

	@FXML

	void doCalcola(ActionEvent event) {
		txtAnCorretti.clear();
		txtAnSbagliati.clear();
		String parola = txtInput.getText();
		model.findSoluzione(parola);

		for (String s : model.anagrammiCorretti()) {
			txtAnCorretti.appendText(s + "\n");
		}

		for (String s : model.anagrammiErrati()) {
			txtAnSbagliati.appendText(s + "\n");
		}
	}

	@FXML
	void doReset(ActionEvent event) {
		txtInput.clear();
		txtAnCorretti.clear();
		txtAnSbagliati.clear();
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert txtAnCorretti != null : "fx:id=\"txtAnCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert txtAnSbagliati != null : "fx:id=\"txtAnSbagliati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

	}
}
