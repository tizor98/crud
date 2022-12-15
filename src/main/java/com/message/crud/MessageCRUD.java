package com.message.crud;

import com.message.model.Message;
import database.ConnectionDB;

import java.sql.SQLException;

public class MessageCRUD {

   public static void createMessageDB(Message message) {

      ConnectionDB.writeUpdateDB("INSERT INTO `messages_app`.`messages` (`message`,`author_id`) VALUES (?,?)", message.getMessage(),String.valueOf(message.getAuthor_id()) );

      System.out.println("Message was created");

   }

   public static void readMessageDB() throws SQLException {

      System.out.println("This is the list of all messages:");
      ConnectionDB.writeQueryDB("messages", "SELECT m.id, m.message, a.name, m.createdAt FROM `messages_app`.`messages` m INNER JOIN `messages_app`.`authors` a ON m.author_id = a.id");

   }

   public static void deleteMessageDB(int message_id) {

      ConnectionDB.writeUpdateDB("DELETE FROM `messages_app`.`messages` WHERE id = ?", String.valueOf(message_id));

      System.out.println("Messages was deleted");

   }

}
