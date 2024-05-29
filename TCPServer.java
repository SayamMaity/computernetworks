import java.net.*;
import java.io.*;
import java.util.Scanner;

class TCPServer {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the port number to connect: ");
            int port = sc.nextInt();

            System.out.println("Server is waiting to connect...");
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                Socket socket = serverSocket.accept();

                if (socket.isConnected()) {
                    System.out.println("Server is ready to connect");

                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();

                    PrintWriter pr = new PrintWriter(outputStream, true);
                    BufferedReader buf = new BufferedReader(new InputStreamReader(inputStream));

                    String str = buf.readLine();
                    System.out.println("Message Received from client: " + str);

                    System.out.println("The Message is forwarded to client");
                    pr.println(str);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
