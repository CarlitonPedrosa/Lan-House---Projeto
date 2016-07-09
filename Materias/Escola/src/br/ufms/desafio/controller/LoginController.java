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
import javafx.scene.control.Control;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Higor
 */
public class LoginController implements Initializable {

    @FXML
    private TextField fxUsuario;
    @FXML
    private PasswordField fxSenha;
    @FXML
    private CheckBox fxMantenhaConectado;
    @FXML
    private Label fxMensagem;
    private ProgressIndicator fxProgresso;
    @FXML
    private Hyperlink fxEsqueciSenha;
    @FXML
    private VBox vbox;
    @FXML
    private Button btnEntrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void fxEntrarOnAction(ActionEvent event) throws IOException, InterruptedException {

        if (fxUsuario.getText().isEmpty() || fxSenha.getText().isEmpty()) {
            mostrarMensagem("Algum campo está vazio, tente novamente");
        } else if (fxUsuario.getText().equalsIgnoreCase("admin") && fxSenha.getText().equalsIgnoreCase("admin")) {

            try {
                FXMLLoader loader = new FXMLLoader();

                // Carrega arquivo fxml do pacote view.fxml
                Parent root = (Parent) loader.load(getClass().getClassLoader().getResourceAsStream(
                        "br/ufms/desafio/view/fxml/Criar_1.fxml"));

                Scene scene = new Scene(root);

                Stage janelaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
                janelaAtual.setScene(scene);
                janelaAtual.centerOnScreen();

            } catch (IOException ex) {

                System.err.println(ex.getMessage());

            }

//            Stage stage = new Stage();
//            Scene scene = new Scene(root);
        } else {
            mostrarMensagem("Usuário ou senha errados");
        }
    }

    private void mostrarMensagem(String msg) {
        fxProgresso.setVisible(false);
        fxMensagem.setVisible(true);
        fxEsqueciSenha.setVisible(false);
        fxMensagem.setText(msg);
    }

}
