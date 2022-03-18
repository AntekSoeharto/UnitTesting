/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author hp
 */
public class Riwayat {
    private Date Tanggal;
    private String Keluhan;
    private String Solusi;
    
    public Riwayat(){
        
    }

    public Riwayat(Date Tanggal, String Keluhan, String Solusi) {
        this.Tanggal = Tanggal;
        this.Keluhan = Keluhan;
        this.Solusi = Solusi;
    }

    public Date getTanggal() {
        return Tanggal;
    }

    public void setTanggal(Date Tanggal) {
        this.Tanggal = Tanggal;
    }

    @Override
    public String toString() {
        return "Riwayat{" + "tanggal=" + Tanggal + '}';
    }  
}
