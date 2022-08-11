package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class MainUIController {

    @FXML
    private Button btnCopy;

    @FXML
    private Button btnGenerate;

    @FXML
    private CheckBox chbLowercase;

    @FXML
    private CheckBox chbNumbers;

    @FXML
    private CheckBox chbSpecial;

    @FXML
    private CheckBox chbUppercase;

    @FXML
    private TextField txtfPassword;
	
    @FXML 
    private Spinner<Integer> spinLength ;
    
    @FXML
    void initialize() {
    	
    	SpinnerValueFactory<Integer> valuefactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
    	valuefactory.setValue(10);
    	spinLength.setValueFactory(valuefactory);
    	
    }
    
    @FXML
    void generatePassword(ActionEvent event) {
    	String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    	String numbers = "0123456789";
    	String special = "!#$%&()*+/-=?<>@_[]{}";
    	
    	String result ="";
	    Random random = new Random();
		String allchar = "";
	    
		if (chbLowercase.isSelected()  || chbUppercase.isSelected() || chbSpecial.isSelected() || chbNumbers.isSelected()) {
			
			if (chbUppercase.isSelected())  { allchar += upperAlphabet ;}
			if (chbLowercase.isSelected())  { allchar += lowerAlphabet ;}
			if (chbNumbers.isSelected()) { allchar += numbers ;}
			if (chbSpecial.isSelected()) { allchar += special ;}
			
		}else {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error ");
			alert.setHeaderText("Unchecked Parameters");
			alert.setContentText("At least check one parameter to generate the password ");
			alert.showAndWait();
			
		}
		
		for (int i = 0 ; i< spinLength.getValue() ; i++) {    
			
	        int x = random.nextInt(allchar.length());
	        char randomChar = allchar.charAt(x);
	        result+=randomChar;
	    	
	    }

		txtfPassword.setText(result);
		
    }
    
    @FXML
    void copyPassword(ActionEvent event) {
    	
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(txtfPassword.getText());
        clipboard.setContent(content);
        
    }

}
