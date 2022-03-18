package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hp
 */
public class Dokter extends User{
    private String NID;
    private String Poliklinik;
    private double Gaji;
    private ArrayList<AbsensiDokter> Absen = new ArrayList<AbsensiDokter>();
    
    
    public Dokter(){   
        
    }

    public Dokter(String NID, String Poliklinik, double Gaji) {
        this.NID = NID;
        this.Poliklinik = Poliklinik;
        this.Gaji = Gaji;
    }

    public Dokter(String NID, String Poliklinik, String Nama, String NIK, Date tglLahir, String golDar, String gender, String Alamat, String Telepon) {
        super(Nama, NIK, tglLahir, golDar, gender, Alamat, Telepon);
        this.NID = NID;
        this.Poliklinik = Poliklinik;
        this.Gaji = Gaji;
    }
    
    public double hitungGaji(){
        int hadir = 0;
        for(int i = 0 ; i < this.Absen.size(); i ++){
            AbsensiDokter absens = Absen.get(i);
            if(absens.getStatus() == StatusAbsensi.MASUK){
                hadir++;
            }
        }
        double gaji = 250000 * hadir;
        this.setGaji(gaji);
        return gaji;
    }
    
    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }

    public Double getGaji() {
        return Gaji;
    }

    public void setGaji(Double Gaji) {
        this.Gaji = Gaji;
    }

    public ArrayList<AbsensiDokter> getAbsen() {
        return Absen;
    }

    public void setAbsen(ArrayList<AbsensiDokter> Absen) {
        this.Absen = Absen;
    }
  
    
    public String getPoliklinik() {
        return Poliklinik;
    }

    public void setPoliklinik(String Poliklinik) {
        this.Poliklinik = Poliklinik;
    }

    @Override
    public String toString() {
        return "Dokter{" + "NID=" + NID + ", Poliklinik=" + Poliklinik + ", Gaji=" + Gaji + '}';
    }
    
    
}
