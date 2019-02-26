
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class ClientPojo {
    
    public ClientPojo(InputStream is, OutputStream os, InetAddress ia) {
        this.is = is;
        this.os = os;
        this.ia = ia;
        IS.add(is);
        OS.add(os);
        IA.add(ia);
        
    }

    ArrayList<InputStream> IS = new ArrayList<InputStream>();
    ArrayList<OutputStream> OS = new ArrayList<OutputStream>();
    ArrayList<InetAddress> IA = new ArrayList<InetAddress>();
    InputStream  is;
    OutputStream os;
    InetAddress ia;
    
    
    
    
    
    
}
