package com.message.crud;

import com.message.model.Author;
import database.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorCRUD {

   public static void createAuthorDB(String name) {

      ConnectionDB.writeUpdateDB("INSERT INTO `messages_app`.`authors` (`name`) VALUES (?)", name);

      System.out.println("Author was created");

   }

   public static Author loginDB(String name) throws SQLException {

      return ConnectionDB.writeQueryDB("login", "SELECT * FROM `messages_app`.`authors` WHERE name = ?", name);

   }

   public static void showAuthorsDB() throws SQLException {

      System.out.println("This is the list of all authors:");
      ConnectionDB.writeQueryDB("authors", "SELECT * FROM `messages_app`.`authors`");

   }

}
