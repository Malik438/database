package com.example.databaseproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.SQLException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


//        ImageView image = new ImageView("file:logo.png");
//        image.setFitHeight(330);
//        image.setFitWidth(600);
//        image.setLayoutX(177);
//        image.setLayoutY(0);

        AnchorPane root = new AnchorPane();


        root.setStyle("-fx-background: grey;");


        Button backTomain = new Button("Back");
        backTomain.setPrefSize(150, 50);

        Label nameLabel = new Label("User Name :");
        nameLabel.setPrefHeight(44);
        nameLabel.setPrefWidth(113);
        nameLabel.setLayoutX(319);
        nameLabel.setLayoutY(330);
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));


        Label PasswordLabel = new Label("Password :");
        PasswordLabel.setPrefHeight(44);
        PasswordLabel.setPrefWidth(113);
        PasswordLabel.setLayoutX(319);
        PasswordLabel.setLayoutY(374);
        PasswordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));


        TextField NameTF = new TextField();
        NameTF.setLayoutX(432);
        NameTF.setLayoutY(340);


        PasswordField PasswordTF = new PasswordField();
        PasswordTF.setLayoutX(432);
        PasswordTF.setLayoutY(384);

        Button signIn = new Button("Log In");
        signIn.setPrefHeight(35);
        signIn.setPrefWidth(100);
        signIn.setLayoutX(637);
        signIn.setLayoutY(357);


        Button newAccount = new Button("Create new Account");
        newAccount.setPrefHeight(35);
        newAccount.setPrefWidth(150);
        newAccount.setLayoutX(425);
        newAccount.setLayoutY(438);

        root.getChildren().addAll(nameLabel, PasswordLabel, NameTF, PasswordTF, signIn, newAccount);


        signIn.setOnAction(event -> {
            if (NameTF.getText().isEmpty() || PasswordTF.getText().isEmpty()) {
                System.out.printf("Invalid logIn");
            } else {

                try {
                    User u = Queries.userLogin(NameTF.getText(), PasswordTF.getText());
                    if (u == null) {
                        System.out.printf("WARNING!\",\n +\"Wrong user name or password!");
                    } else {
                        System.out.printf("Valid Login");


                    }

                } catch (ClassNotFoundException | SQLException e) {
                    System.out.printf(e.getMessage());
                    System.out.printf("erorr in database");

                }

            }
        });


        newAccount.setOnAction(event -> {
            NameTF.clear();
            PasswordTF.clear();


            Label main = new Label("Make new Account");
            main.setFont(Font.font("Arial", FontWeight.BOLD, 30));
            main.setLayoutX(364);
            main.setLayoutY(44);


            Label LUN = new Label("User Name:");
            LUN.setFont(Font.font("Arial", FontWeight.BOLD, 15));
            LUN.setLayoutX(364);
            LUN.setLayoutY(115);


            Label LN = new Label("Last Name:");
            LN.setFont(Font.font("Arial", FontWeight.BOLD, 15));
            LN.setLayoutX(640);
            LN.setLayoutY(118);


            Label LPss = new Label("Password:");
            LPss.setFont(Font.font("Arial", FontWeight.BOLD, 15));
            LPss.setLayoutX(364);
            LPss.setLayoutY(198);


            Label LEmail = new Label("Email:");
            LEmail.setFont(Font.font("Arial", FontWeight.BOLD, 15));
            LEmail.setLayoutX(364);
            LEmail.setLayoutY(283);


            Label LPhone = new Label("Age:");
            LPhone.setFont(Font.font("Arial", FontWeight.BOLD, 15));
            LPhone.setLayoutX(364);
            LPhone.setLayoutY(369);

            Label user_type = new Label("User-type:");
            user_type.setFont(Font.font("Arial", FontWeight.BOLD, 15));
            user_type.setLayoutX(364);
            user_type.setLayoutY(460);


            TextField TUN = new TextField();
            TUN.setLayoutX(480);
            TUN.setLayoutY(115);

            PasswordField TPass = new PasswordField();
            TPass.setLayoutX(480);
            TPass.setLayoutY(198);

            TextField Temail = new TextField();
            Temail.setLayoutX(480);
            Temail.setLayoutY(283);


            TextField TPhone = new TextField();
            TPhone.setLayoutX(480);
            TPhone.setLayoutY(369);

            TextField user_type1 = new TextField();
            user_type1.setLayoutX(480);
            user_type1.setLayoutY(460);


            TextField lastName1 = new TextField();
            lastName1.setLayoutX(750);
            lastName1.setLayoutY(118);


            Button back = new Button("Back");
            back.setPrefSize(137, 37);
            back.setLayoutX(364);
            back.setLayoutY(500);

            Button done = new Button("Done");
            done.setPrefSize(137, 37);
            done.setLayoutX(530);
            done.setLayoutY(500);


            root.getChildren().removeAll(backTomain, user_type, user_type, nameLabel, PasswordLabel, NameTF, PasswordTF, signIn, newAccount);

            root.getChildren().addAll(main, LUN, LN, lastName1, LEmail, LPhone, LPss, user_type, user_type1, TUN, Temail, TPass, TPhone, back, done);


//            back.setOnAction(e->{
//
//                TUN.clear();
//                Temail.clear();
//                TPhone.clear();
//                TPass.clear();
//                root.getChildren().removeAll(main,LUN,LEmail,LPhone,LPss,TUN,Temail,TPass,TPhone,back,done);
//
//                root.getChildren().addAll(backTomain,image,nameLabel,PasswordLabel,NameTF,PasswordTF,signIn,newAccount);
//            });

            done.setOnAction(e -> {

                if (TPass.getText().isEmpty() || TUN.getText().isEmpty()
                        || Temail.getText().isEmpty() || TPhone.getText().isEmpty()) {
                    System.out.println("WARNING!Please Fill All text Text Field!");
                } else {
                    try {
                        User u = Queries.getUserForCheck(TUN.getText());
                        System.out.println(u==null);
                        if (u == null) {
                            String password = TPass.getText();
                            String user_name = TUN.getText();
                            String email = Temail.getText();
                            String age = TPhone.getText();
                            String lastname = lastName1.getText();
                            String type = user_type1.getText();


                            User user = new User(user_name, lastname, password, email, Integer.parseInt(age), type);
                            Queries.insertUser(user);


                        } else {
                            System.out.println("WARNING! User name Exist please Change user name!");
                        }

                    } catch (ClassNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }


                }
            });


        });








        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 1000, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}




