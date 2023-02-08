
import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wxw18
 */
public class MyAWTEventListener implements AWTEventListener {
    ArrayList<AWTEvent> alae;
    boolean recording = false;

    MyAWTEventListener(ArrayList<AWTEvent> alae) {
        this.alae = alae;
    }

    @Override
    public void eventDispatched(AWTEvent event) {
        if(event.getID() == MouseEvent.MOUSE_CLICKED){
            Object o = event.getSource();
            if(o instanceof JButton){
                JButton button = (JButton)o;
                if(button.getText().equals("First, click me, move mouse, and then click jTextField1")){
                    recording = true;
                }
            }
            else if(o instanceof JTextField){
                recording = false;
            }
        }
        if(recording){
            alae.add(event);
        }
    }
    
}
