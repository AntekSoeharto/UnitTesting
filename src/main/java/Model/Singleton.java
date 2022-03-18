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
public class Singleton {
    private static Singleton instance;
    private Staff staff;
    private Cabang cabang;

    public static Singleton getInstance() {
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    
    public Cabang getCabang(){
        return cabang;
    }
    
    public void setCabang(Cabang cabang){
        this.cabang = cabang;
    }
    
    
    
}
