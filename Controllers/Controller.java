package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button authSignINButton;

    @FXML
    private Button LoginSignUpButton;

    @FXML
    void initialize() {
    	
    	authSignINButton.setOnAction(event ->{
    		String loginText = login_field.getText().trim();
    		String loginPassword = password_field.getText().trim();
    		
    		if(!loginText.equals("")  && !loginText.equals("")) 
    			loginUser(loginText, loginPassword);
    		else
    			System.out.println("Пустые поля!!!");
    		
    	});
    	
    	LoginSignUpButton.setOnAction(event -> {
    		LoginSignUpButton.getScene().getWindow().hide();
    		
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource("/ress/SignUp.fxml"));
    		
    		try {
				loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		Parent root = loader.getRoot();
    		
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root));
    		stage.showAndWait();
    		
    	});
    }

	private void loginUser(String loginText, String loginPassword) {
		// TODO Auto-generated method stub
		
	}
}

