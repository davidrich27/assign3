package controller;

import model.basic.*;
import model.manager.*;
import model.master.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

public class UserCreateController {

    @FXML
    private TextField phoneTxt;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField usernameTxt;

    @FXML
    private TextField firstnameTxt;

    @FXML
    private TextField lastnameTxt;

    @FXML
    private TextField newPwdTxt1;

    @FXML
    private TextField newPwdTxt2;

    @FXML
    private Button confirmBtn;

    @FXML
    private TextField emailTxt;

    @FXML
    private CheckBox adminChkbx;

    // ************************** Model Variables *******************************

    ModelTXT model;
    Stage thisStage;
    Stage homeStage;

    // ************************** Initialization and Wireup *********************

    public void setModel(ModelTXT model){
      this.model = model;
    }
    public void setStage(Stage thisStage){
      this.thisStage = thisStage;
      System.out.println("Starting User creator...");
    }
    public void setHomeStage(Stage homeStage){
      this.homeStage = homeStage;
    }

    // ************************** Other Events ************************************

    @FXML
    void confirmClick(ActionEvent event) {
      // create new user
      String username = usernameTxt.getText();
      String pwd = newPwdTxt1.getText();
      String firstname = firstnameTxt.getText();
      String lastname = lastnameTxt.getText();
      String email = emailTxt.getText();
      String phone = phoneTxt.getText();
      Boolean admin = adminChkbx.isSelected();
      model.addNewUser(username, pwd, firstname, lastname, email, phone, admin);
      System.out.println("New User created!");
      // close window
      thisStage.hide();
    }

    @FXML
    void cancelClick(ActionEvent event) {
      thisStage.hide();
    }

}
