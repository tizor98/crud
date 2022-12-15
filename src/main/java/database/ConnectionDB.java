package database;

import com.message.model.Author;

import java.sql.*;

public class ConnectionDB {

   private final static String username = "root";
   private final static String password = "12345";

   private static Connection getConnection() {

      Connection connection = null;

      try {
         connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/messages_app", ConnectionDB.username, ConnectionDB.password);
      } catch (SQLException e) {
         System.out.println(e);
      }

      return connection;

   }

   public static void writeUpdateDB(String update, String... args) {

      try(Connection db = getConnection()) {

         PreparedStatement ps = db.prepareStatement(update);
         for(int i=0; i< args.length; i++) {
            ps.setString(i+1, args[i]);
         }
         ps.executeUpdate();

      } catch (SQLException e) {
         System.out.println(e);
      }

   }

   public static Author writeQueryDB(String type, String query, String... args) {

      Author login = new Author();

      try(Connection db = getConnection()) {

         PreparedStatement ps = db.prepareStatement(query);
         for(int i=0; i< args.length; i++) {
            ps.setString(i+1, args[i]);
         }
         ResultSet rs = ps.executeQuery();

         switch (type) {
            case "login":
               if (rs.next()) {
                  System.out.println("Login completed!");
                  login.setId(rs.getInt("id"));
                  login.setName(rs.getString("name"));
               } else {
                  System.out.println("Login failed");
               }
               break;
            case "authors":
               while (rs.next()) {
                  System.out.print("\n[ID: " + rs.getString("id") + " | ");
                  System.out.print("Name: " + rs.getString("name") + " ] \n");
               }
               break;
            case "messages":
               while (rs.next()) {
                  System.out.print("\n[ID - " + rs.getString("id") + " | ");
                  System.out.print("Message - " + rs.getString("message") + " | ");
                  System.out.print("Author - " + rs.getString("name") + " | ");
                  System.out.print("Creation date - " + rs.getString("createdAt") + " | ] ");
               }
               break;
         }

      } catch (SQLException e) {
         System.out.println(e);
      }

      return login;

   }

}
