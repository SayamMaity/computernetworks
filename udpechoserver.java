import java.net.*;

class udpechoServer {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(5555)) {
            System.out.println("Server is listening on port 5555");
            byte[] buf = new byte[2048];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buf,buf.length);
                socket.receive(packet);

                InetAddress ca = packet.getAddress();
                int cport = packet.getPort();
                int dlength = packet.getLength();
                String message = new String(packet.getData(), 0, dlength);

                System.out.println("Received: " + message);

                DatagramPacket echoPacket = new DatagramPacket(packet.getData(), dlength, ca, cport);
                socket.send(echoPacket);

                System.out.println("Echoed: " + message);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
