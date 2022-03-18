/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hp
 */
public interface InterfaceAbsensiDokter {
    StatusAbsensi ALPHA = StatusAbsensi.ALPHA;
    StatusAbsensi IZIN = StatusAbsensi.IZIN;
    StatusAbsensi MASUK = StatusAbsensi.MASUK;
    
    public void absenDokter(AbsensiDokter absenDokter);
}
