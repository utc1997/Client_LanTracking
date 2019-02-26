/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientTrackingExample;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;

/**
 *
 * @author Lenovo
 */
public class Server1 {

ServerSocket serverSocket = null;
Socket socket = null;
DataInputStream dataInputStream = null;

public Server1() {
    try {
        serverSocket = new ServerSocket(6002);
        System.out.println("Server is Waiting for request...");
        socket = serverSocket.accept();
        System.out.println("Connected with: " + socket.getInetAddress());
        dataInputStream = new DataInputStream(socket.getInputStream());
        System.out.println("Server Read from client: " + dataInputStream.readUTF());
        BufferedImage image = ImageIO.read(socket.getInputStream());
        System.out.println("Server: Image received from client.");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    new Server1();
}

    
}
