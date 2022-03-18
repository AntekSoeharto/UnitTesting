/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.GridBagConstraints;

/**
 *
 * @author V for Vladimir
 */
public class ControllerViewPasien {
    private GridBagConstraints gbc = new GridBagConstraints();

    public ControllerViewPasien() {
        
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }
    
    public void setGBC(GridBagConstraints gbc,double weightx,double weighty,int x,int y,int anchor,int fill){
        gbc.anchor = anchor;
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.gridx = x;
        gbc.gridy = y;
        
    }
    public void setGBC(GridBagConstraints gbc,double weightx,double weighty,int x,int y,int fill){
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.gridx = x;
        gbc.gridy = y;
        
    }
    public void setGBC(GridBagConstraints gbc,double weightx,double weighty,int x,int y){

        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.gridx = x;
        gbc.gridy = y;
        
    }
}
