/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import View.PrincipalKintrol;

/**
 *
 * @author karin
 */
public class Kintrol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Interfaz principal
        javax.swing.SwingUtilities.invokeLater(()->{
            PrincipalKintrol principal = new PrincipalKintrol();
            principal.setVisible(true);
            principal.setLocationRelativeTo(null);
        });
    }
    
}
