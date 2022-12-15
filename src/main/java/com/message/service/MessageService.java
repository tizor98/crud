package com.message.service;

import com.message.crud.MessageCRUD;
import com.message.model.Author;
import com.message.model.Message;

import java.sql.SQLException;
import java.util.Scanner;

public class MessageService {

   private static final String messageString = "Write a message with a max lenght of 280 chars";
   private static final String messageID = "What is the message ID?";


   public static void createMessage(Author author, Scanner sc) {

      System.out.println(messageString);
      String messageText;
      do {
         messageText = sc.nextLine();
      } while (messageText.startsWith("/n") || messageText.startsWith(" "));

      Message message = new Message(messageText, author.getId());
      MessageCRUD.createMessageDB(message);

   }

   public static void listMessage() throws SQLException {

      MessageCRUD.readMessageDB();

   }

   public static void deleteMessage(Scanner sc) {

      System.out.println(messageID);

      while(sc.hasNextLine()) {
         String messageID = sc.nextLine();
         if (messageID.startsWith("//") || messageID.startsWith(" ")) {
            continue;
         }
         MessageCRUD.deleteMessageDB(Integer.parseInt(messageID));
         break;
      }
   }

}
