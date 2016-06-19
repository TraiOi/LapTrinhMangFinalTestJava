/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeSo01.Server;

/**
 *
 * @author traioi
 */
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import DeSo01.Client.TCPClientModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;

public class TCPServerControl {

    private final TCPServerView view;
    private ServerSocket myServer;
    private Socket clientSocket;
    private final int serverPort = 8888;
    private DataInputStream dis;

    public TCPServerControl(TCPServerView view) throws BadLocationException {
        this.view = view;
        this.view.addStartListener(new StartListener());
    }

    class StartListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            send();
        }
    }

    private void openServer(int serverPort) throws BadLocationException {
        try {
            myServer = new ServerSocket(serverPort);
        } catch (IOException e) {
            System.out.println(":)");
        }
    }

    public void open() throws BadLocationException {
        try {
            clientSocket = myServer.accept();
            dis = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
        } catch (IOException ex) {
            view.appendLog("[-] " + ex + "\n");
        }

    }

    public void close() {
        try {
            if (clientSocket != null) {
                try {
                    view.appendLog("[+] TCP Server is stop!\n");
                } catch (BadLocationException ex) {
                    Logger.getLogger(TCPServerControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                view.toggleButton(true);
            }
            if (dis != null) {
                dis.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(TCPServerControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void send() {
        try {
            view.appendLog("[+] TCP Server is running ...\n");
            view.toggleButton(false);
            openServer(serverPort);
            open();
            int soa = Integer.parseInt(dis.readUTF());
            int sob = Integer.parseInt(dis.readUTF());
            view.appendLog("[+] So a = " + soa + " va so b = " + sob + "\n");
            int bcnn = bcnn(soa, sob);
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            dos.writeUTF(Integer.toString(bcnn));
            close();

        } catch (BadLocationException ex) {
            Logger.getLogger(TCPServerControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TCPServerControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int bcnn(int soA, int soB) {
        int i = 1;
        while (((soA * i) % soB) != 0) {
            i++;
        }
        return soA * i;
    }
}
