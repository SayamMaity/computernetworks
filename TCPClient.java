import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the port number to connect with the server: ");
            int port = sc.nextInt();

            // Establish connection to the server
            Socket socket = new Socket("localhost", port);

            if (socket.isConnected()) {
                System.out.println("Client is ready to connect");

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                PrintWriter pr = new PrintWriter(outputStream, true);
                BufferedReader buf1 = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader buf2 = new BufferedReader(new InputStreamReader(inputStream));

                System.out.print("Enter Message: ");
                String str1 = buf1.readLine();
                pr.println(str1);

                System.out.println("Message sent successfully!");

                String str2 = buf2.readLine();
                System.out.println("Message from server: " + str2);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
