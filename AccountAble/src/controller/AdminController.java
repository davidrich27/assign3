package controller;
import model.basic.*;
import model.manager.*;
import model.master.*;

import java.io.IOException;
import java.util.*;

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

public class AdminController {

  @FXML
  private Button logoutBtn;

  @FXML
  private Label availBalanceLbl;

  @FXML
  private Button delAcctBtn;

  @FXML
  private Button newFeeBtn;

  @FXML
  private Label lastNameLbl;

  @FXML
  private Button delFeeBtn;

  @FXML
  private ListView<String> acctsList;

  @FXML
  private TableView<?> userTbl;

  @FXML
  private ListView<?> feeList;

  @FXML
  private Button editAcctBtn;

  @FXML
  private Button newAcctBtn;

  @FXML
  private AnchorPane allowedList;

  @FXML
  private ChoiceBox<?> dropdownAcct;

  @FXML
  private Button addTransactionBtn;

  @FXML
  private TextField userSearchTxt;

  @FXML
  private Button editUserBtn;

  @FXML
  private TableView<?> acctAllTbl;

  @FXML
  private ListView<?> userList;

  @FXML
  private Label feeBalanceLbl;

  @FXML
  private TextField acctSearchTxt;

  @FXML
  private ListView<String> acctsAllList;

  @FXML
  private Label phoneLbl;

  @FXML
  private Button examUserBtn;

  @FXML
  private Button toBlockedBtn;

  @FXML
  private Label masterBalanceLbl;

  @FXML
  private Button toAllowedBtn;

  @FXML
  private Button delUserBtn;

  @FXML
  private Label emailLbl;

  @FXML
  private Button changeInfoBtn;

  @FXML
  private ScrollPane blockedList;

  @FXML
  private Button examAcctBtn;

  @FXML
  private TextField feeSearchTxt;

  @FXML
  private Label usernameLbl;

  @FXML
  private Button selectAcct;

  @FXML
  private Button examFeeBtn;

  @FXML
  private Label firstNameLbl;

  @FXML
  private Label greetingLbl;

  @FXML
  private Button editFeeBtn;

  @FXML
  private Button newUserBtn;

  @FXML
  private TableView<?> acctTbl;

  @FXML
  private TextField acctAllSearchTxt;

  @FXML
  private Button acctHistoryBtn;

  // ************************** Model Variables *******************************

  ModelTXT model;
  Account master;

  User currentUser;
  ArrayList<Account> currentAccts;

  Stage thisStage;
  Stage loginStage;
  LoginController loginCtrl;

  // ************************** Initialization and Wireup *********************

  public void setDataModel(ModelTXT model){
    this.model = model;
  }
  public ModelTXT getDataModel(){
    return model;
  }
  public void setOtherStages(Stage loginStage, LoginController loginCtrl){
    this.loginStage = loginStage;
    this.loginCtrl = loginCtrl;
  }
  public void setStage(Stage thisStage){
    this.thisStage = thisStage;
  }

  // ************************** Other Events ************************************

  public void login(User loginUser){
    currentUser = loginUser;
    currentAccts = model.uaManager.getAllAccts();

    // OVERVIEW TAB
    // Populate Text on Overview Tab
    greetingLbl.setText("Welcome Back, " + currentUser.getName()[0] + "!");
    usernameLbl.setText(currentUser.getUsername());
    firstNameLbl.setText(currentUser.getName()[0]);
    lastNameLbl.setText(currentUser.getName()[1]);
    emailLbl.setText(currentUser.getEmail());
    phoneLbl.setText(currentUser.getPhone());
    // Master Account Balances
    master = model.uaManager.getMasterAccount();
    masterBalanceLbl.setText(master.getBalance().toString());
    feeBalanceLbl.setText(master.getFeesBalance().toString());
    availBalanceLbl.setText(master.getAvailBalance().toString());

    // ACCOUNTS TAB
    // Populate Avail Accounts List
    ObservableList<String> acctNames = FXCollections.observableArrayList();
    for (Account acct : currentAccts){
      String acctName = acct.getName();
      acctNames.add(acctName);
    }
    acctsList.setItems(acctNames);
    acctsAllList.setItems(acctNames);
  }

  // ************************** FX Events ***************************************

  @FXML
  void logoutClick(ActionEvent event) {
    currentUser = null;
    loginCtrl.clear();
    loginStage.show();
    thisStage.hide();
  }

  @FXML
  void changeInfoClick(ActionEvent event) throws IOException {
    // Open new instance of viewEditUser
    Stage newStage = new Stage();
    FXMLLoader newLoader = new FXMLLoader(getClass().getResource("../view/ViewEditUser.fxml"));
    Parent newRoot = newLoader.load();
    Scene newScene = new Scene(newRoot);
    newStage.setScene(newScene);
    UserEditController newCtrl = newLoader.<UserEditController>getController();
    //changeInfoCtrl.setHomeStages(thisStage);
    newStage.show();
  }

  @FXML
  void newUserClicked(ActionEvent event) throws Exception {
    Stage newStage = new Stage();
    FXMLLoader newLoader = new FXMLLoader(getClass().getResource("../view/ViewCreateUser.fxml"));
    Parent newRoot = newLoader.load();
    Scene newScene = new Scene(newRoot);
    newStage.setScene(newScene);
    UserCreateController newCtrl = newLoader.<UserCreateController>getController();
    //changeInfoCtrl.setHomeStages(thisStage);
    newStage.show();
  }

  @FXML
  void addTransactionClicked(ActionEvent event) throws Exception {
    System.out.println("Clicked!");
    Stage newStage = new Stage();
    FXMLLoader newLoader = new FXMLLoader(getClass().getResource("../view/ViewCreateTrans.fxml"));
    Parent newRoot = newLoader.load();
    Scene newScene = new Scene(newRoot);
    newStage.setScene(newScene);
    TransCreateController newCtrl = newLoader.<TransCreateController>getController();
    //changeInfoCtrl.setHomeStages(thisStage);
    newStage.show();
  }

  @FXML
  void newAcctClick(ActionEvent event) throws Exception {
    Stage newStage = new Stage();
    FXMLLoader newLoader = new FXMLLoader(getClass().getResource("../view/ViewCreateAcct.fxml"));
    Parent newRoot = newLoader.load();
    Scene newScene = new Scene(newRoot);
    newStage.setScene(newScene);
    AcctCreateController newCtrl = newLoader.<AcctCreateController>getController();
    //changeInfoCtrl.setHomeStages(thisStage);
    newStage.show();
  }

}
