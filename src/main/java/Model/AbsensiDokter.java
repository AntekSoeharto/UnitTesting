/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import Controller.ControllerDokter;

/**
 *
 * @author hp
 */
public class AbsensiDokter implements InterfaceAbsensiDokter{
    private Date tanggal;
    private StatusAbsensi Status;

    
    
    public AbsensiDokter(){
        
    }

    public AbsensiDokter(Date tanggal, StatusAbsensi Status) {
        this.tanggal = tanggal;
        this.Status = Status;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public StatusAbsensi getStatus() {
        return Status;
    }

    public void setStatus(StatusAbsensi Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "AbsensiDokter{" + "tanggal=" + tanggal + ", Status=" + Status + '}';
    }
    
    //@Override
//    public void absenDokter(AbsensiDokter absenDokter){
//        ControllerDokter cd = new ControllerDokter();
//        ArrayList<Dokter> listDokter = cd.getDokters();
//        int i = 0;
//        boolean found = false;
//        String namaDokter = JOptionPane.showInputDialog("masukkan nama dokter : ");
//  
//        absenDokter.tanggal = new Date();
//        
//        int statusIzin = Integer.parseInt(JOptionPane.showInputDialog("apa yang mau anda lakukan?"
//                + "\n1. izin"
//                + "\n2. absen"));
//        
//        
//        while(i < listDokter.size() && !found){
//            if(namaDokter.equals(listDokter.get(i).getNama())){
//                found = true;
//            }else{
//                i++;
//            }
//        }
//        
//        if(found == true){
//            if(statusIzin == 2){
//                absenDokter.Status = MASUK;
//            }else if(statusIzin == 1){
//                absenDokter.Status = IZIN;
//            }else{
//                absenDokter.Status = ALPHA;
//            }
//        }else{
//            JOptionPane.showMessageDialog(null,"Nama tidak ditemukan!");
//        }
//        
//
//    }

    @Override
    public void absenDokter(AbsensiDokter absenDokter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
