package com.example.databaseproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Properties;

public class Queries {

    private static String dbURL;
    private static String dbUsername = "root";
    private static String dbPassword = "";
    private static String URL = "127.0.0.1";
    private static String port = "3306";
    private static String dbName = "test1";
    private static Connection con;


    public static void connectDB() throws ClassNotFoundException, SQLException {

        dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
        Properties p = new Properties();
        p.setProperty("user", dbUsername);
        p.setProperty("password", dbPassword);
        p.setProperty("useSSL", "false");
        p.setProperty("autoReconnect", "true");
        Class.forName("com.mysql.jdbc.Driver");

        con = DriverManager.getConnection(dbURL, p);

    }

    public static void ExecuteStatement(String SQL) throws SQLException {

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            stmt.close();

        } catch (SQLException s) {

        }

    }

    public static User userLogin( String firstname, String pass)
            throws ClassNotFoundException, SQLException {
        System.out.println(firstname+" "+pass);

        connectDB();



        System.out.println(firstname+" "+pass);
        String SQL = "select * from user s where s.password='" + pass + "' and s.firstName='" + firstname + "';";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        User s = null;

        while (rs.next()) {

            s = new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(1),rs.getString(7));

        }
        rs.close();
        stmt.close();

        con.close();
        return s;
    }


    public static void insertUser(User user) {
        try {
            connectDB();
            System.out.println(user.getUserName());
            ExecuteStatement("INSERT INTO `user`( `firstName`, `lastName`, `password`, `email`, `age`, `userType`) VALUES" +
                    " ('" +user.getUserName()+"','"+user.getLastName() +"','"+user.getPassowrd() +"','"+ user.getEmail()+"','"+user.getAge() +"','"+user.getUser_type() +"')");


            con.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

    }

    public static User getUserForCheck(String user_name) throws ClassNotFoundException, SQLException {
        connectDB();

        System.out.println(user_name);

        String SQL = "select * from  user s where s.firstName='" + user_name + "';";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        User s = null;

        while (rs.next()) {


            s = new User(user_name);

        }

        rs.close();
        stmt.close();

        con.close();
        return s;

    }

}

