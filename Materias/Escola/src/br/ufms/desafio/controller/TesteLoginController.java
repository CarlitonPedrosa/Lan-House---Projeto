    /*
 * Copyright (C) 2016 Higor
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Higor
 */
public class TesteLoginController implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private TextField fxUsuario;
    @FXML
    private PasswordField fxSenha;
    @FXML
    private CheckBox fxMantenhaConectado;
    @FXML
    private Button btnEntrar;
    @FXML
    private Label fxMensagem;
    @FXML
    private VBox vbox_1;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnProcurar;
    @FXML
    private Button btnConfig;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        System.out.println("teste login controller inicialize");
        // TODO
        btnHome.setOpacity(1);
        btnRegistrar.setOpacity(0.3);
        btnProcurar.setOpacity(0.3);
        btnConfig.setOpacity(0.3);
    }

    @FXML
    private void registrar(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader();

            // Carrega arquivo fxml do pacote view.fxml
            Parent root = (Parent) loader.load(getClass().getClassLoader().getResourceAsStream(
                    "br/ufms/desafio/view/fxml/Criar_1.fxml"));

            Scene scene = new Scene(root);

            Stage janelaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            janelaAtual.setScene(scene);
           // janelaAtual.centerOnScreen();

        } catch (IOException ex) {

            System.err.println(ex.getMessage());
        }
    }

    @FXML
    private void home(ActionEvent event) {
    }

    @FXML
    private void procurar(ActionEvent event) {
    }

    @FXML
    private void configuracoes(ActionEvent event) {
    }
    
}
