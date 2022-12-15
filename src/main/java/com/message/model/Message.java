package com.message.model;

public class Message {

   private int id;
   private String message;
   private int author_id;

   public Message() {
   }

   public Message(String message, int author_id) {
      this.message = message;
      this.author_id = author_id;
   }

   public int getId() {
      return id;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public int getAuthor_id() {
      return author_id;
   }

   public void setAuthor_id(int author_id) {
      this.author_id = author_id;
   }
}
