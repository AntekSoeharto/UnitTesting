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
public abstract class User {
    private String Nama;
    private String NIK;
    private Date tglLahir;
    private String golDar;
    private String gender;
    private String Alamat;
    private String Telepon;
     public User(){
         
     }
    public User(String Nama, String NIK, Date tglLahir, String golDar, String gender, String Alamat, String Telepon) {
        this.Nama = Nama;
        this.NIK = NIK;
        this.tglLahir = tglLahir;
        this.golDar = golDar;
        this.gender = gender;
        this.Alamat = Alamat;
        this.Telepon = Telepon;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getGolDar() {
        return golDar;
    }

    public void setGolDar(String golDar) {
        this.golDar = golDar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getTelepon() {
        return Telepon;
    }

    public void setTelepon(String Telepon) {
        this.Telepon = Telepon;
    }

    @Override
    public String toString() {
        return super.toString() + "User{" + "Nama=" + Nama + ", NIK=" + NIK + ", tglLahir=" + tglLahir + ", golDar=" + golDar + ", gender=" + gender + ", Alamat=" + Alamat + ", Telepon=" + Telepon + '}';
    }
    
    
    
    
}
