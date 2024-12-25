/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package widget;

import java.awt.Color;
import javax.swing.JCheckBox;

/**
 *
 * @author dosen3
 */
public class CheckBox extends JCheckBox{

    private static final long serialVersionUID = 1L;

    public CheckBox(){
        super();
        setFont(new java.awt.Font("Tahoma", 0, 11));
        //setBackground(new Color(209,209,209));
        //setForeground(new Color(90,90,90));
        setBackground(new Color(102,255,255));
        setForeground(new Color(50,50,50));
        setFocusPainted(false);
        
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255,0,0)));
        setOpaque(true);
        setSize(WIDTH,23);
    }
}