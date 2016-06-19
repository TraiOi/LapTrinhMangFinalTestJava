/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeSo01.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author traioi
 */
public class TCPClientControl {

    private final TCPClientView view;
    private final String serverIP = "127.0.0.1";
    private final Integer serverPort = 8888;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    public TCPClientControl(TCPClientView view) {
        this.view = view;
        this.view.btnSubmitListener(new SubmitListener());
    }

    class SubmitListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            TCPClientModel so = view.getSo();
            String pattern = "([0-9]+)";
            String soa = so.getSoA();
            String sob = so.getSoB();
            Pattern r = Pattern.compile(pattern);
            Matcher ma = r.matcher(soa);
            Matcher mb = r.matcher(sob);
            if(ma.find( ) && mb.find( )) {
               send(soa, sob);
            } else {
               JOptionPane.showMessageDialog(view, "a or b must be an Integer");
            }        
        }
    }

    public void send(String soa, String sob) {
        try {
            socket = new Socket(serverIP, serverPort);
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(soa);
            dos.writeUTF(sob);
            dis = new DataInputStream(socket.getInputStream());
            view.getKetQua(dis.readUTF());
            socket.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view, "Can't connect to server");
            System.out.println(ex);
        }
    }

}
