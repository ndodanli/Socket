
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dream
 */
public class istemci {
    public static void main(String[] args) throws IOException {
          islem();
     }
 
     public static void islem() throws UnknownHostException, IOException {
          Socket socket = null;
          PrintWriter out = null;
          BufferedReader in = null;
          String deger;
          try {
               socket = new Socket("istemci ip adresi", 2718); //istemci ip adresi ve bağlanılmak istenen port
          } catch (Exception e) {
               System.out.println("Port Hatası!");
          }
          out = new PrintWriter(socket.getOutputStream(), true);
          in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
          System.out.println("Server'a gönderilecek veriyi giriniz:");
          BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
 
          while((deger = data.readLine()) != null) {
               out.println(deger);
               System.out.println("Server'dan gelen yanıt = " + in.readLine());
               System.out.println("Server'a gönderilecek veriyi giriniz");
          }
          out.close();
          in.close();
          data.close();
          socket.close();
     }
}
