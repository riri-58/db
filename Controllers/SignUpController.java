package Controllers;

import application.DatabaseHandler;
import application.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class SignUpController {

    @FXML
    private TextField signUpName;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpLastname;

    @FXML
    private TextField login_field;

    @FXML
    private TextField SignUpCountry;

    @FXML
    private RadioButton signUpRadioMale;

    @FXML
    private ToggleGroup Gear;

    @FXML
    private RadioButton signUpRadioFeMale;
    
    @FXML
    void initialize() {
    	
    	
    	signUpButton.setOnAction(event -> {
    		
    		signUpNewUser();
    		
    		System.out.println("Успешная регистрация!");
    	});
    }

	private void signUpNewUser() {
		
		DatabaseHandler dbHanlder = new DatabaseHandler();
		String firstName = signUpName.getText();
		String lastName = signUpLastname.getText();
		String userName = login_field.getText();
		String password = password_field.getText();
		String location = SignUpCountry.getText();
		String gender = "";
		if(signUpRadioMale.isSelected()) {
			gender = "Мужской";
		}else if (signUpRadioFeMale.isSelected()) {
			gender = "Женский";
		}else 
			System.out.println("Гендер не был выбран");
		
		User user = new User(firstName,lastName,userName,password,location,gender);
		
		
		dbHanlder.signUpUser(user);		
	}
    

}
