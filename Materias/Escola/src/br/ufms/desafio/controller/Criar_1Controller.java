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
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Higor
 */
public class Criar_1Controller implements Initializable {

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
    @FXML
    private Hyperlink hlProximo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("criar 1 controler inicialize");
        btnHome.setOpacity(0.3);
        btnRegistrar.setOpacity(1);
        btnProcurar.setOpacity(0.3);
        btnConfig.setOpacity(0.3);      
    }

    @FXML
    private void home(ActionEvent event) {
        btnConfig.setOpacity(0);

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

    @FXML
    private void registrar(ActionEvent event) {
    }
    
    @FXML
    private void proximaPagina(ActionEvent event){
     try {
            FXMLLoader loader = new FXMLLoader();
            // Carrega arquivo fxml do pacote view.fxml
            Parent root = (Parent) loader.load(getClass().getClassLoader().getResourceAsStream(
                    "br/ufms/desafio/view/fxml/Criar_2_aluno.fxml"));
            Scene scene = new Scene(root);
            Stage janelaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            janelaAtual.setScene(scene);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
