package com.message.service;

import com.message.model.Author;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

   public static void sessionMenu(Author author, Scanner sc) throws SQLException {

      byte option = -1;

      final String sessionMenuMessage = ("=================== \n"
         + "Hi " + author.getName() + ": \n"
         + "1. write message \n"
         + "2. read messages \n"
         + "3. delete message \n"
         + "4. show users \n"
         + "5. logout \n");

      do {
         System.out.println();
         System.out.print(sessionMenuMessage);

         try {
            option = Byte.parseByte(sc.nextLine());
         } catch (Exception e) {
            System.out.println(e);
            continue;
         }

         switch (option) {

            case 1:
               MessageService.createMessage(author, sc);
               break;
            case 2:
               MessageService.listMessage();
               break;
            case 3:
               MessageService.deleteMessage(sc);
               break;
            case 4:
               AuthorService.showAuthors();
               break;
            default:
               break;
         }

      } while (option != 5);

   }

   public static void mainMenu(Scanner sc) throws SQLException {

      final String mainMenuMessage = ("=================== \n"
         + "Hi Visitor, welcome to messages media: \n"
         + "1. Register \n"
         + "2. Login \n"
         + "3. Logout \n");

      byte option = -1;

      do{
         System.out.println();
         System.out.println(mainMenuMessage);

         try {
            option = Byte.parseByte(sc.nextLine());
         } catch (Exception e) {
            System.out.println(e);
            continue;
         }

         switch (option){
            case 1:
               AuthorService.createAuthor(sc);
               break;
            case 2:
               Author result = AuthorService.login(sc);
               if(result.getId() > 0){
                  sessionMenu(result, sc);
               }
               break;
            default:
               break;
         }
      } while(option != 3);

   }

}
