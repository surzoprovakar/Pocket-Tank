/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocket;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Raju
 */
public class OptionController implements Initializable {

    
    Pocket p;
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        p.moun1();
    }
    @FXML
    private void about(ActionEvent event) throws IOException {
        p.About();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setMain(Pocket aThis) {
        p=aThis;
    }

    

    

    
    

    
    
    
}
