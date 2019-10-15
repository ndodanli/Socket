
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dream
 */
public class sunucu {
    public static void main(String[] args) throws IOException {
          String clientGelen;
          ServerSocket serverSocket = null;
          Socket istemciSocket = null;
 
          int sayi;
 
          try {
               serverSocket = new ServerSocket(2718); //istemcinin dinlendiği port
          } catch (Exception e) {
               System.out.println("Port Hatası!");
          }
          System.out.println("SERVER BAŞLANTI İÇİN HAZIR...");
          istemciSocket = serverSocket.accept();
          PrintWriter out = new PrintWriter(istemciSocket.getOutputStream(), true);
          BufferedReader in = new BufferedReader(new InputStreamReader(istemciSocket.getInputStream()));
 
          while((clientGelen = in.readLine()) != null) {
               System.out.println("Client'dan gelen veri = " + clientGelen);
               String tersString = "";
               for(int i = clientGelen.length() - 1; i >= 0; i--)
               {
                   tersString = tersString + clientGelen.charAt(i);
               }
               out.println(tersString);
          }
          out.close();
          in.close();
          istemciSocket.close();
          serverSocket.close();
     }
}

