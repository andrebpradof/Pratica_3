/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cronometro;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Andre Prado
 */
public class InterfaceGrafica extends JFrame{
    private JTextField txtMinutos = new JTextField();
    private JTextField txtSegundos = new JTextField();
    private JTextField txtMilesegungos = new JTextField();
    private JPanel pnlVisor = new JPanel();
    private JPanel pnlBotoes = new JPanel();
    private JButton btnFechar = new JButton("Fechar");
    private JButton btnReset = new JButton("Reset");
    private JButton btnIniciar = new JButton("Iniciar");
    private Cronometro cronometro;

    public InterfaceGrafica(){
        super("Cronômetro");
        
        this.setLayout(new GridLayout(2, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setSize(500,150);
        
        pnlVisor.setLayout(new GridLayout(1,3,10,10));
        
        
        pnlBotoes.setLayout(new GridLayout(1,3,10,10));
        
        
        txtMinutos.setEditable(false);
        txtSegundos.setEditable(false);
        txtMilesegungos.setEditable(false);
        
        txtMilesegungos.setHorizontalAlignment(JTextField.RIGHT);
        txtMinutos.setHorizontalAlignment(JTextField.RIGHT);
        txtSegundos.setHorizontalAlignment(JTextField.RIGHT);
        
        txtMilesegungos.setFont(txtMilesegungos.getFont().deriveFont(40f));
        txtMilesegungos.setForeground(Color.red);
        txtMinutos.setFont(txtMinutos.getFont().deriveFont(40f));
        txtMinutos.setForeground(Color.blue);
        txtSegundos.setFont(txtSegundos.getFont().deriveFont(40f));
        txtSegundos.setForeground(Color.BLUE);
        
        pnlVisor.add(txtMinutos);
        pnlVisor.add(txtSegundos);
        pnlVisor.add(txtMilesegungos);
        
        pnlBotoes.add(btnFechar);
        pnlBotoes.add(btnReset);
        pnlBotoes.add(btnIniciar);
        
        this.add(pnlVisor);
        this.add(pnlBotoes);
        
        txtMilesegungos.setText("000");
        txtMinutos.setText("00");
        txtSegundos.setText("00");
        
        
        cronometro = new Cronometro(txtMilesegungos, txtSegundos, txtMinutos);
        
        
        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 System.exit(0);
            }
        });
        
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnIniciar.getText().equals("Iniciar")){
                    btnIniciar.setText("Pausar");
                    cronometro.iniciarContagem();
                }
                else{
                    btnIniciar.setText("Iniciar");
                    cronometro.pararContagem();
                }
            }
        });
        
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIniciar.setText("Iniciar");
                cronometro.reset();
            }
        });
    }
    
    public static void main(String[] args) {
        InterfaceGrafica interfaceGrafica = new InterfaceGrafica();
    }
    
}
