/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hp
 */
public class Staff{
    private String username;
    private String password;
    private String idCabang;

    public Staff(String username, String password, String idCabang) {
        this.username = username;
        this.password = password;
        this.idCabang = idCabang;
    }
    
    public Staff(){
        
    }
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdCabang() {
        return idCabang;
    }

    public void setIdCabang(String idCabang) {
        this.idCabang = idCabang;
    }

    @Override
    public String toString() {
        return "Staff{" + "username=" + username + ", password=" + password + ", idCabang=" + idCabang + '}';
    }
    
    
    
    
}

