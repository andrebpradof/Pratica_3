/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cronometro;

import java.util.TimerTask;
import javax.swing.JTextField;
import java.util.Timer;

/**
 *
 * @author Andre Prado
 */
public class Cronometro extends TimerTask{
    private int mile;
    private int seg;
    private int min;
    private Timer tempo;
    private JTextField txtMilesegundos;
    private JTextField txtSegundos;
    private JTextField txtMinutos;
    private boolean correndo;
    
    public Cronometro(JTextField txtMilesegundos, JTextField txtSegundos, JTextField txtMinutos){
        this.txtMilesegundos = txtMilesegundos;
        this.txtMinutos = txtMinutos;
        this.txtSegundos = txtSegundos;
        
        mile = 0;
        seg = 0;
        min = 0;
        
        tempo = new Timer();
        correndo = false;
        
        tempo.scheduleAtFixedRate(this, 0,1);
    }
    
    private void atualizarInterface(){
        txtMilesegundos.setText(String.format("%03d", mile));
        txtSegundos.setText(String.format("%02d", seg));
        txtMinutos.setText(String.format("%02d", min));
    }
    
    @Override
    public void run(){
        if(!correndo)
            return;
        
        mile++;
        
        if(mile == 1000){
            mile = 0;
            seg++;
            
            if(seg == 60){
                seg = 0;
                min++;
                
                if(min == 60)
                    min = 0;
            }
        }
        atualizarInterface();
    }
    
    public void iniciarContagem(){
        correndo = true;
    }
    
    
    public void pararContagem(){
        correndo = false;
    }
    
    public void reset(){
        pararContagem();
        mile= 0;
        seg = 0;
        min = 0;
        atualizarInterface();
    }
    
}
