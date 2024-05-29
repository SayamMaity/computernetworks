import java.io.*;
import java.net.*;
class TCPEchoServer
{
public static void main(String args[])
{
try(ServerSocket ss = new ServerSocket(5555))
{
System.out.print("Server is listening:");
Socket cs = ss.accept();
System.out.print("Client is connected:");
InputStreamReader in = new InputStreamReader(cs.getInputStream());
BufferedReader br = new BufferedReader(in);
PrintWriter pw = new PrintWriter(cs.getOutputStream(), true);
String cm;
while((cm = br.readLine())!=null)
{
System.out.print("Received from Client: " + cm);
pw.println("Server echoes: " + cm);
}
System.out.println("Client disconnected : ");
}
catch(IOException e)
{
System.out.print("Error:"+ e);
}
}
}