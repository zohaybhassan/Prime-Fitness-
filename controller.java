package application;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import db.dbhandler;

public class Controller implements Initializable {
    private Stage stage;
    private Parent root;
    private Scene scene;
    
    // ----- Scene switching methods for login pages -----
    public void switchToAdmin(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminlogin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToReception(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("receptionistlogin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToTrainer(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("trainerlogin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToShopkeeper(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("shopkeeperlogin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    // ----- Admin Login -----
    @FXML
    private Label loginmessagelable;
    @FXML
    private TextField adminname;
    @FXML
    private PasswordField adminpass;
    
    public void loginadmin(ActionEvent e) throws IOException {
        if (!adminname.getText().isBlank() && !adminpass.getText().isBlank()) {
            verifyadminlogin(e);
        } else {
            loginmessagelable.setText("Please Enter username and password!");
        }
    }
    
    public void verifyadminlogin(ActionEvent event) throws IOException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");
            String verifylogin = "select count(1) from admin where fname ='" + adminname.getText() + "' and password ='" + adminpass.getText() + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(verifylogin);
            ResultSet queryResult = preparedStatement.executeQuery();
            while(queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    loginmessagelable.setText("Welcome");
                    Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    loginmessagelable.setText("Login info not found!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database");
        }
    }
    
    // ----- Receptionist Login -----
    @FXML
    private Label loginmessagelableRec;
    @FXML
    private TextField receptionname;
    @FXML
    private PasswordField receptionpass;
    
    public void loginreception(ActionEvent e) throws IOException {
        if (!receptionname.getText().isBlank() && !receptionpass.getText().isBlank()) {
            verifyReclogin(e);
        } else {
            loginmessagelableRec.setText("Please Enter username and password!");
        }
    }
    
    public void verifyReclogin(ActionEvent event) throws IOException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");
            String verifylogin = "select count(1) from receptionist where fname ='" + receptionname.getText() + "' and password ='" + receptionpass.getText() + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(verifylogin);
            ResultSet queryResult = preparedStatement.executeQuery();
            while(queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    loginmessagelableRec.setText("Welcome");
                    Parent root = FXMLLoader.load(getClass().getResource("Receptionist.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    loginmessagelableRec.setText("Login info not found!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database");
        }
    }
    
    // ----- Shopkeeper Login -----
    @FXML
    private Label loginmessagelableshopkeeper;
    @FXML
    private TextField shopkeepername;
    @FXML
    private PasswordField shopkeeperpass;
    
    public void loginshopkeeper(ActionEvent e) throws IOException {
        if (!shopkeepername.getText().isBlank() && !shopkeeperpass.getText().isBlank()) {
            verifyshopkeeperlogin(e);
        } else {
            loginmessagelableshopkeeper.setText("Please Enter username and password!");
        }
    }
    
    public void verifyshopkeeperlogin(ActionEvent event) throws IOException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");
            String verifylogin = "select count(1) from shopkeeper where fname ='" + shopkeepername.getText() + "' and password ='" + shopkeeperpass.getText() + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(verifylogin);
            ResultSet queryResult = preparedStatement.executeQuery();
            while(queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    loginmessagelableshopkeeper.setText("Welcome");
                    Parent root = FXMLLoader.load(getClass().getResource("Shopkeeper.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    loginmessagelableshopkeeper.setText("Login info not found!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database");
        }
    }
    
    // ----- Trainer Login -----
    @FXML
    private Label loginmessagelabletrainer;
    @FXML
    private TextField trainername;
    @FXML
    private PasswordField trainerpass;
    private static Trainer trainer1 = new Trainer();
    
    public void logintrainer(ActionEvent e) throws IOException {
        if (!trainername.getText().isBlank() && !trainerpass.getText().isBlank()) {
            verifytrainerlogin(e);
        } else {
            loginmessagelabletrainer.setText("Please Enter username and password!");
        }
    }
    
    public void verifytrainerlogin(ActionEvent event) throws IOException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");
            String verifylogin = "select count(1) from trainer where fname ='" + trainername.getText() + "' and password ='" + trainerpass.getText() + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(verifylogin);
            ResultSet queryResult = preparedStatement.executeQuery();
            while(queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    trainer1.setFname(trainername.getText());
                    trainer1.setPassword(trainerpass.getText());
                    loginmessagelabletrainer.setText("Welcome");
                    Parent root = FXMLLoader.load(getClass().getResource("Trainer.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    loginmessagelabletrainer.setText("Login info not found!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database");
        }
    }
    
    // ----- Member (Customer) Management (Registration/Profile Management) -----
    @FXML private TextField traineridtext, lockeridtext, phonetext, cnictext, lnametext, fnametext;
    @FXML private DatePicker dobtext;
    @FXML private RadioButton feestatusno;
    @FXML private RadioButton feestatusyes;
    @FXML private Label addMemberlable;
    private boolean fee;
    
    public void addMemebr() throws SQLException {
        boolean radioselected = false;
        if (feestatusno.isSelected()) {
            fee = false;
            radioselected = true;
        } else if (feestatusyes.isSelected()) {
            fee = true;
            radioselected = true;
        }
        if (radioselected && !dobtext.getValue().toString().isBlank() && !phonetext.getText().isBlank() &&
            !cnictext.getText().isBlank() && !lnametext.getText().isBlank() && !fnametext.getText().isBlank()) {
            
            customer cus = new customer(cnictext.getText(), fnametext.getText(), lnametext.getText(),
                                        dobtext.getValue().toString(), fee, phonetext.getText(),
                                        traineridtext.getText(), lockeridtext.getText());
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");
                String query = "insert into customer (id, fname, lname, dob, feepaid, phone, tid, lid) values(?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, cus.getId());
                preparedStatement.setString(2, cus.getFname());
                preparedStatement.setString(3, cus.getLname());
                preparedStatement.setString(4, cus.getDob());
                preparedStatement.setBoolean(5, cus.isFeepaid());
                preparedStatement.setString(6, cus.getPhone());
                preparedStatement.setString(7, cus.getTid().isBlank() ? null : cus.getTid());
                preparedStatement.setString(8, cus.getLid().isBlank() ? null : cus.getLid());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error while connecting to the database " + e.toString());
            }
        } else {
            addMemberlable.setText("Please fill required fields!");
        }
    }
    
    @FXML private TextField removeMembercnic;
    @FXML private Label removeMemberlable;
    
    public void removeMember() {
        if (!removeMembercnic.getText().isBlank()) {
            if (verifyRemoveMemberCnic()) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");
                    String query = "DELETE FROM customer WHERE id ='" + removeMembercnic.getText() + "'";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error while connecting to the database " + e.toString());
                }
            }
        } else {
            removeMemberlable.setText("Please Enter Cnic!");
        }
    }
    
    public boolean verifyRemoveMemberCnic() {
        boolean found = false;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");
            String query = "select count(1) from customer where id ='" + removeMembercnic.getText() + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet queryResult = preparedStatement.executeQuery();
            while(queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    found = true;
                } else {
                    removeMemberlable.setText("Cnic not found!");
                    found = false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database " + e.toString());
        }
        return found;
    }
    
    @FXML private TextField viewMembercnic;
    @FXML private Label viewMemberlable, viewMemberfnamelable, viewMemberlnamelable,
                    viewMemberDOBlable, viewMemberPhonelable, viewMemberFeestatuslable,
                    viewMemberTrainerlable, viewMemberlockerlable;
    
    public void viewMember() {
        if (!viewMembercnic.getText().isBlank()) {
            if (verifyViewMemberCnic()) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");
                    String query = "Select * FROM customer WHERE id ='" + viewMembercnic.getText() + "'";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet queryResult = preparedStatement.executeQuery();
                    if (queryResult.next()){
                        viewMemberfnamelable.setText(queryResult.getString(2));
                        viewMemberlnamelable.setText(queryResult.getString(3));
                        viewMemberPhonelable.setText(queryResult.getString(6));
                        viewMemberFeestatuslable.setText(queryResult.getString(5));
                        viewMemberTrainerlable.setText(queryResult.getString(7));
                        viewMemberlockerlable.setText(queryResult.getString(8));
                        viewMemberDOBlable.setText(queryResult.getString(4));
                    }
                } catch (SQLException e) {
                    System.out.println("Error while connecting to the database " + e.toString());
                }
            }
        } else {
            viewMemberlable.setText("Please Enter Cnic!");
        }
    }
    
    public boolean verifyViewMemberCnic() {
        boolean found = false;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");
            String query = "select count(1) from customer where id ='" + viewMembercnic.getText() + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet queryResult = preparedStatement.executeQuery();
            while(queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    found = true;
                } else {
                    viewMemberlable.setText("Cnic not found!");
                    found = false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database " + e.toString());
        }
        return found;
    }
    
    @FXML private TextField updatetraineridtext, updatelockeridtext, updatephonetext, updatecnictext, updatelnametext, updatefnametext;
    @FXML private DatePicker updatedobtext;
    @FXML private RadioButton updatefeestatusno;
    @FXML private RadioButton updatefeestatusyes;
    @FXML private Label updateMemberlable;
    private boolean updatefee;
    
    public void updateMemebr() throws SQLException {
        boolean radioselected = false;
        if (updatefeestatusno.isSelected()) {
            updatefee = false;
            radioselected = true;
        } else if (updatefeestatusyes.isSelected()) {
            updatefee = true;
            radioselected = true;
        }
        if (radioselected && !updatedobtext.getValue().toString().isBlank() &&
            !updatephonetext.getText().isBlank() && !updatecnictext.getText().isBlank() &&
            !updatelnametext.getText().isBlank() && !updatefnametext.getText().isBlank()) {
            
            customer cus = new customer(updatecnictext.getText(), updatefnametext.getText(), updatelnametext.getText(),
                                        updatedobtext.getValue().toString(), updatefee, updatephonetext.getText(),
                                        updatetraineridtext.getText(), updatelockeridtext.getText());
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");
                String query;
                if (!updatetraineridtext.getText().isBlank() && !updatelockeridtext.getText().isBlank()){
                    query = "UPDATE customer SET fname = '" + updatefnametext.getText() + "', lname = '" + updatelnametext.getText() +
                            "', dob = '" + updatedobtext.getValue().toString() + "', feepaid = " + updatefee +
                            ", phone = '" + updatephonetext.getText() + "', tid = '" + updatetraineridtext.getText() +
                            "', lid = '" + updatelockeridtext.getText() + "' WHERE id = '" + updatecnictext.getText() + "'";
                } else if (updatetraineridtext.getText().isBlank() && !updatelockeridtext.getText().isBlank()) {
                    query = "UPDATE customer SET fname = '" + updatefnametext.getText() + "', lname = '" + updatelnametext.getText() +
                            "', dob = '" + updatedobtext.getValue().toString() + "', feepaid = " + updatefee +
                            ", phone = '" + updatephonetext.getText() + "', tid = NULL, lid = '" + updatelockeridtext.getText() +
                            "' WHERE id = '" + updatecnictext.getText() + "'";
                } else if (!updatetraineridtext.getText().isBlank() && updatelockeridtext.getText().isBlank()) {
                    query = "UPDATE customer SET fname = '" + updatefnametext.getText() + "', lname = '" + updatelnametext.getText() +
                            "', dob = '" + updatedobtext.getValue().toString() + "', feepaid = " + updatefee +
                            ", phone = '" + updatephonetext.getText() + "', tid = '" + updatetraineridtext.getText() +
                            "', lid = NULL WHERE id = '" + updatecnictext.getText() + "'";
                } else {
                    query = "UPDATE customer SET fname = '" + updatefnametext.getText() + "', lname = '" + updatelnametext.getText() +
                            "', dob = '" + updatedobtext.getValue().toString() + "', feepaid = " + updatefee +
                            ", phone = '" + updatephonetext.getText() + "' WHERE id = '" + updatecnictext.getText() + "'";
                }
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error while connecting to the database " + e.toString());
            }
        } else {
            updateMemberlable.setText("Please fill required fields!");
        }
    }
    
    // ----- Trainer Issuing Plans (Diet & Workout) -----
    @FXML private Label dietPlanlable;
    @FXML private TextField dietPlanCnicText;
    @FXML private TextArea dietPlanText;
    
    public void issueDietPlan(ActionEvent event) throws IOException {
        if (!dietPlanCnicText.getText().isBlank() && !dietPlanText.getText().isBlank()) {
            dietPlan plan = new dietPlan(trainer1.getFname(), dietPlanCnicText.getText(), dietPlanText.getText());
            if (dietPlanCnic()) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");
                    String query = "Insert into dietplan (tid, cid, plan) values(?,?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, plan.getTrainerid());
                    preparedStatement.setString(2, plan.getCustomerid());
                    preparedStatement.setString(3, plan.getPlan());
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error while connecting to the database " + e.toString());
                }
            }
        } else {
            dietPlanlable.setText("Please Enter Cnic and Plan!");
        }
    }
    
    public boolean dietPlanCnic() {
        boolean found = false;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");
            String query = "select count(1) from customer where id ='" + dietPlanCnicText.getText() + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet queryResult = preparedStatement.executeQuery();
            while(queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    found = true;
                } else {
                    dietPlanlable.setText("Cnic not found!");
                    found = false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database " + e.toString());
        }
        return found;
    }
    
    @FXML private Label workOutlable;
    @FXML private TextField workOutCnicText;
    @FXML private TextArea workOutText;
    
    public void issueworkOut(ActionEvent event) throws IOException {
        if (!workOutCnicText.getText().isBlank() && !workOutText.getText().isBlank()) {
            workOutplan plan = new workOutplan(trainer1.getFname(), workOutCnicText.getText(), workOutText.getText());
            if (workOutCnic()) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");
                    String query = "Insert into workoutplan (tid, cid, plan) values(?,?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, plan.getTrainerid());
                    preparedStatement.setString(2, plan.getCustomerid());
                    preparedStatement.setString(3, plan.getPlan());
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Error while connecting to the database " + e.toString());
                }
            }
        } else {
            workOutlable.setText("Please Enter Cnic and Plan!");
        }
    }
    
    public boolean workOutCnic() {
        boolean found = false;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");
            String query = "select count(1) from customer where id ='" + workOutCnicText.getText() + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet queryResult = preparedStatement.executeQuery();
            while(queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    found = true;
                } else {
                    workOutlable.setText("Cnic not found!");
                    found = false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database " + e.toString());
        }
        return found;
    }
    
    // ----- End of Sprint 1 functionalities in Controller -----
    
    @Override
    public void initialize(URL url, ResourceBundle resource) {
        // Initialization code for sprint 1 components can be placed here.
    }
}