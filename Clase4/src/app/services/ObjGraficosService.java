package app.services;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class ObjGraficosService {
    private JPanel panel;
    private JButton button;
    static private ObjGraficosService servicio;


    private ObjGraficosService(){}

    public JPanel construirJPanel(int x, int y, int ancho, int alto, Color colorFondo, Border borde){
        panel = new JPanel(); 
        panel.setSize(ancho, alto);
        panel.setLocation(x, y);
        panel.setLayout(null);
        panel.setBackground(colorFondo);
        panel.setBorder(borde);
        return panel;
    }

    public JButton construirJButton(
        String texto, int x, int y, int ancho, int alto, Cursor cursor, 
        ImageIcon imagen, Font fuente, Color colorFondo, Color colorFuente, 
        Border borde, String direccion, boolean esSolido){
            
        button= new JButton(texto);
        button.setSize(ancho, alto);
        button.setLocation(x, y);
        button.setFocusable(false);
        button.setCursor(cursor);
        button.setFont(fuente);
        button.setBackground(colorFondo);
        button.setForeground(colorFuente);
        button.setIcon(imagen);
        button.setBorder(borde);
        button.setContentAreaFilled(esSolido);
        switch(direccion){
            case "l":
                button.setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case "r":
                button.setHorizontalAlignment(SwingConstants.RIGHT);
                break;    
            default:
                break;
        }
        return button;
    }

    public static ObjGraficosService getService(){
        if(servicio == null){
            servicio = new ObjGraficosService();
        }
        return servicio;
    }
}