/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeSo01.Server;

import javax.swing.text.BadLocationException;

/**
 *
 * @author traioi
 */
public class ServerRun {
    public static void main(String[] args) throws BadLocationException  {
      TCPServerView view = new TCPServerView();
      TCPServerControl control = new TCPServerControl(view);
      view.setVisible(true);
    }
}
