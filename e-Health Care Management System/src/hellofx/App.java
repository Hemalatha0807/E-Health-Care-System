package hellofx;

//import the required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//create a class that extends Application
public class App extends Application {

    //declare the connection, statement, and result set variables
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    //declare the gui components
    private TextField tfUsername;
    private PasswordField pfPassword;
    private Button btLogin;
    private Label lbMessage;

    //override the start method
    @Override
    public void start(Stage primaryStage) {

        //initialize the gui components
        tfUsername = new TextField();
        pfPassword = new PasswordField();
        btLogin = new Button("Login");
        lbMessage = new Label();

        //create a grid pane to hold the components
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Username:"), 0, 0);
        gridPane.add(tfUsername, 1, 0);
        gridPane.add(new Label("Password:"), 0, 1);
        gridPane.add(pfPassword, 1, 1);
        gridPane.add(btLogin, 1, 2);
        gridPane.add(lbMessage, 1, 3);

        //set the alignment, padding, and spacing of the grid pane
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        //create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setTitle("E-Health Care Management System");
        primaryStage.setScene(scene);
        primaryStage.show();

        //register the button action
        btLogin.setOnAction(e -> login());

        //connect to the database
        connectDB();
    }

    //define the login method
    private void login() {
        //get the username and password from the text fields
        String username = tfUsername.getText();
        String password = pfPassword.getText();

        //check if the username and password are valid
        if (validateUser(username, password)) {
            //display a success message
            lbMessage.setText("Login successful");
        } else {
            //display an error message
            lbMessage.setText("Invalid username or password");
        }
    }

    //define the connectDB method
    private void connectDB() {
        try {
            //load the jdbc driver
            Class.forName("com.mysql.jdbc.Driver");

            //establish the connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "harine#2005");

            //create a statement
            stmt = conn.createStatement();
        } catch (Exception ex) {
            //handle the exception
            ex.printStackTrace();
        }
    }

    //define the validateUser method
    private boolean validateUser(String username, String password) {
        try {
            //execute a query to check the user credentials
            String query = "select * from users where username = '" + username + "' and password = '" + password + "'";
            rs = stmt.executeQuery(query);

            //return true if the result set is not empty, false otherwise
            return rs.next();
        } catch (Exception ex) {
            //handle the exception
            ex.printStackTrace();
            return false;
        }
    }

    //define the main method
    public static void main(String[] args) {
        //launch the application
        launch(args);
    }
}
