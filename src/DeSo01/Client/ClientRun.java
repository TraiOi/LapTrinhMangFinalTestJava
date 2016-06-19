/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeSo01.Client;

/**
 *
 * @author traioi
 */
public class ClientRun {
    public static void main(String args[]) {
        TCPClientView view = new TCPClientView();
        TCPClientControl control = new TCPClientControl(view);
        view.setVisible(true);
    }
}
