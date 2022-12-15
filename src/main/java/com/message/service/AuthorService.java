package com.message.service;

import com.message.crud.AuthorCRUD;
import com.message.model.Author;

import java.sql.SQLException;
import java.util.Scanner;



public class AuthorService {

   private static final String nameMessage = "What is your full name?";

   public static void createAuthor(Scanner sc) {

      System.out.println(nameMessage);
      String name = "";
      if(sc.hasNextLine()) {
         name = sc.nextLine();

      }

      AuthorCRUD.createAuthorDB(name);

   }

   public static Author login(Scanner sc) throws SQLException {

      System.out.println(nameMessage);

      if(sc.hasNextLine()) {
         String name = sc.nextLine();
         return AuthorCRUD.loginDB(name);
      }

      return null;

   }

   public static void showAuthors() throws SQLException {

      AuthorCRUD.showAuthorsDB();

   }

}
