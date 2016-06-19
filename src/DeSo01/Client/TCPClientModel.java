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
import java.io.Serializable;

public class TCPClientModel implements Serializable {

    private String soA;
    private String soB;

    public TCPClientModel() {
    }

    public TCPClientModel(String soa, String sob) {
        this.soA = soa;
        this.soB = sob;
    }

    public String getSoA() {
        return soA;
    }

    public void setSoA(String soA) {
        this.soA = soA;
    }

    public String getSoB() {
        return soB;
    }

    public void setSoB(String soB) {
        this.soB = soB;
    }
}
