package br.ufms.desafio.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Higor
 */
public class Criar_2_alunoController implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private VBox vbox_1;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnProcurar;
    @FXML
    private Button btnConfig;
    

    //  private final Image img_home = new Image(
    //         "br/ufms/desafio/view/icons/logo_home.png");
    // private final Image img_registrar = new Image(
    //         "br/ufms/desafio/view/icons/logo_register.png");
    //  private final Image img_procurar = new Image(
    //          "br/ufms/desafio/view/icons/logo_search.png");
    // private final Image img_config = new Image(
    //         "br/ufms/desafio/view/icons/logo_config.png");
    /**
     * Initializes the controller class.
     *
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //   ImageView imgview = new ImageView(img_home);
        // btnHome.setGraphic(imgview);
        System.out.println("criar 2 aluno controller inicializr");
        btnHome.setOpacity(0.3);
        btnRegistrar.setOpacity(1);
        btnProcurar.setOpacity(0.3);
        btnConfig.setOpacity(0.3);
        
        

        //  imgview = new ImageView(img_procurar);
        //  btnProcurar.setGraphic(imgview);
        // imgview = new ImageView(img_config);
        //  btnConfig.setGraphic(imgview);
    }

    @FXML
    private void registrar(ActionEvent event) {
    }

    @FXML
    private void home(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader();
            // Carrega arquivo fxml do pacote view.fxml
            Parent root = (Parent) loader.load(getClass().getClassLoader().getResourceAsStream(
                    "br/ufms/desafio/view/fxml/TesteLogin.fxml"));
            Scene scene = new Scene(root);
            Stage janelaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            janelaAtual.setScene(scene);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
