import java.io.*;
import java.net.*;
import  java.util.Scanner;
 class TCPEchoClient
{
     public static void main(String args[])
{
       try {
               Scanner sc = new Scanner(System.in);
                System.out.println("enter the port number to connect with server:  ");
                int port = sc.nextInt();
               Socket sok = new Socket("localhost",port);
               if(sok. isConnected() == true){
              System.out.println("client is ready to connect");
              InputStream inputstream = sok.getInputStream();
              OutputStream outputstream = sok.getOutputStream();
              PrintWriter pr = new PrintWriter (outputstream);
              BufferedReader buf1 = new BufferedReader (new InputStreamReader(System.in));
             BufferedReader buf2 = new BufferedReader (new InputStreamReader(inputstream));
             String str1,str2;
             System.out.println("enter message");
             str1 = buf1.readLine();
             pr.println(str1);
             pr.flush();
             System.out.println("message sent successfully");
             str2 = buf2.readLine();
             System.out.println("Message from server:" + str2);
             }
      } catch(Exception e) {
           System.out.println("an error occured:" + e.getMessage());
}
}
}