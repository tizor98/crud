package com.message;

import com.message.service.Menu;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) throws SQLException {

      Scanner sc = new Scanner(System.in);

      Menu.mainMenu(sc);

      sc.close();

   }

}