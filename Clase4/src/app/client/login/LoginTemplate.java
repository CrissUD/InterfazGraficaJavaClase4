package app.client.login;

import app.services.ObjGraficosService;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class LoginTemplate extends JFrame {
    // Declaración Objetos Gráficos
    private JPanel pDerecha, pIzquierda;
    private JLabel lTituloApp, lEslogan, lTituloLogin, lNotificaciones;
    private JLabel lFondo, lSvg, lLogo, lUsuario, lClave, lFacebook, lTwitter, lYoutube;
    private JTextField tNombreUsuario;
    private JPasswordField tClaveUsuario;
    private JComboBox cbTipoUsuario;
    private JButton bEntrar, bCerrar, bRegistrarse, bOpcion1, bOpcion2, bOpcion3;
    private JCheckBox checkSi, checkNo;
    private ButtonGroup grupo;

    // Declaración objetos Decoradores
    private Color colorAzul, colorGrisOscuro;
    private Font fontTPrincipal, fontTitulo, fontSubtitulo;
    private Cursor cMano;
    private Border border;
    private ImageIcon iFondo, iSvg, iLogo, iUsuario, iClave, iPunto, iFacebook, iTwitter, iYoutube, iCerrar, iDimAux;

    // Declaración objetos
    private ObjGraficosService sObjGraficos;

    public LoginTemplate() {
        
        sObjGraficos = ObjGraficosService.getService();

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJTextFields();
        this.crearJPasswordFields();
        this.crearJComboBoxes();
        this.crearJButtons();
        this.crearJCheckBoxes();
        this.crearJLabels();
        
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(this);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
    }

    public void crearObjetosDecoradores(){

        colorAzul = new Color(60, 78, 120);
        colorGrisOscuro = new Color(80, 80, 80);
        fontTPrincipal = new Font("Rockwell Extra Bold", Font.PLAIN, 20);
        fontTitulo = new Font("Montserrat", Font.PLAIN, 18);
        fontSubtitulo = new Font("Forte", Font.PLAIN, 13);
        cMano = new Cursor(Cursor.HAND_CURSOR);
        border = BorderFactory.createMatteBorder(0, 0, 2, 0, colorAzul);
        iFondo = new ImageIcon("Clase4/resources/img/fondo.png");
        iLogo = new ImageIcon("Clase4/resources/img/logo.png");
        iUsuario = new ImageIcon("Clase4/resources/img/usuario.png");
        iClave = new ImageIcon("Clase4/resources/img/clave.png");
        iPunto = new ImageIcon("Clase4/resources/img/punto.png");
        iFacebook = new ImageIcon("Clase4/resources/img/facebook.png");
        iTwitter = new ImageIcon("Clase4/resources/img/twitter.png");
        iYoutube = new ImageIcon("Clase4/resources/img/youtube.png");
        iSvg = new ImageIcon("Clase4/resources/img/imagen.png");
        iCerrar = new ImageIcon("Clase4/resources/img/cerrar.png");
    }

    public void crearJPanels(){

        pIzquierda = sObjGraficos.construirJPanel(
            0, 0, 600, 500, Color.WHITE, null
        );
        this.add(pIzquierda);

        pDerecha = sObjGraficos.construirJPanel(
            600, 0, 400, 500, Color.WHITE, null
        );
        this.add(pDerecha);
    }

    public void crearJTextFields(){

        tNombreUsuario = sObjGraficos.construirJTextField(
            "Nombre Usuario", (pDerecha.getWidth() - 260) / 2, 130, 260, 40, 
            Color.WHITE, colorAzul, colorGrisOscuro, null, border, "c"
        );
        pDerecha.add(tNombreUsuario);
    }

    public void crearJButtons(){

        bEntrar = sObjGraficos.construirJButton(
            "Entrar", (pDerecha.getWidth() - 230) / 2, 330, 
            250, 45, cMano, null, null, colorAzul, 
            Color.WHITE, null, "c", true
        );
        pDerecha.add(bEntrar);

        iDimAux = new ImageIcon(
            iCerrar.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );

        bCerrar = sObjGraficos.construirJButton(
            null, 350, 10, 45, 30, cMano, iDimAux, null, 
            null, null, null, "c", false
        );
        pDerecha.add(bCerrar);

        bRegistrarse = sObjGraficos.construirJButton(
            "Registrarse", 240, 460, 145, 35, cMano, null, 
            null, colorAzul, Color.WHITE, null, "c", true
        );
        pDerecha.add(bRegistrarse);

        iDimAux = new ImageIcon(
            iPunto.getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)
        );

        bOpcion1 = sObjGraficos.construirJButton(
            null, 10, 220, 30, 20, cMano, iDimAux, null,
            null, null, null, "c", false
        );
        pIzquierda.add(bOpcion1);

        bOpcion2 = sObjGraficos.construirJButton(
            null, 10, 250, 30, 20, cMano, iDimAux, null,
            null, null, null, "c", false
        );
        pIzquierda.add(bOpcion2);

        bOpcion3 = sObjGraficos.construirJButton(
            null, 10, 280, 30, 20, cMano, iDimAux, null,
            null, null, null, "c", false
        );
        pIzquierda.add(bOpcion3);
    }

    public void crearJLabels(){

        iDimAux = new ImageIcon(
            iLogo.getImage().getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING)
        );

        lLogo= sObjGraficos.construirJLabel(null, 50, 20, 40, 40, iDimAux, null, null, null);
        pIzquierda.add(lLogo);

        lTituloApp = sObjGraficos.construirJLabel(
            "Login de Usuario", 100, 20, 220, 30, null, Color.WHITE, null, fontTPrincipal
        );
        pIzquierda.add(lTituloApp);

        iDimAux = new ImageIcon(
            iSvg.getImage().getScaledInstance(500, 345, Image.SCALE_AREA_AVERAGING)
        );

        lSvg= sObjGraficos.construirJLabel(null, 100, 100, 500, 345, iDimAux, null, null, null);
        pIzquierda.add(lSvg);

        lEslogan = sObjGraficos.construirJLabel(
            "Te ayudamos en todo", (pDerecha.getWidth() - 130) / 2, 60, 130, 20, 
            null, colorGrisOscuro, null, fontSubtitulo
        );
        pDerecha.add(lEslogan);

        lTituloLogin = sObjGraficos.construirJLabel(
            "Registra tus Datos", (pDerecha.getWidth() - 150) / 2, 80, 150, 30, 
            null, colorGrisOscuro, null, fontTitulo
        );
        pDerecha.add(lTituloLogin);

        lNotificaciones = sObjGraficos.construirJLabel(
            "¿Recibir Notificaciones?", (pDerecha.getWidth() - 140) / 2, 400, 140, 20, 
            null, colorGrisOscuro, null, fontSubtitulo
        );
        pDerecha.add(lNotificaciones);

        iDimAux = new ImageIcon(
            iUsuario.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );

        lUsuario= sObjGraficos.construirJLabel(null, 40, 140, 30, 30, iDimAux, null, null, null);
        pDerecha.add(lUsuario);

        iDimAux = new ImageIcon(
            iClave.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );

        lClave= sObjGraficos.construirJLabel(null, 40, 270, 30, 30, iDimAux, null, null, null);
        pDerecha.add(lClave);

        iDimAux = new ImageIcon(
            iFacebook.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );

        lFacebook= sObjGraficos.construirJLabel(null, 20, 460, 30, 30, iDimAux, null, null, null);
        pIzquierda.add(lFacebook);

        iDimAux = new ImageIcon(
            iTwitter.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );

        lTwitter= sObjGraficos.construirJLabel(null, 60, 460, 30, 30, iDimAux, null, null, null);
        pIzquierda.add(lTwitter);

        iDimAux = new ImageIcon(
            iYoutube.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
        );

        lYoutube= sObjGraficos.construirJLabel(null, 100, 460, 30, 30, iDimAux, null, null, null);
        pIzquierda.add(lYoutube);

        iDimAux = new ImageIcon(
            iFondo.getImage().getScaledInstance(600, 600, Image.SCALE_AREA_AVERAGING)
        );

        lFondo= sObjGraficos.construirJLabel(null, 0, 0, 600, 600, iDimAux, null, null, null);
        pIzquierda.add(lFondo);
    }

    public void crearJPasswordFields(){

        tClaveUsuario = sObjGraficos.construirJPasswordField(
            "clave Usuario", (pDerecha.getWidth() - 260) / 2, 260, 260, 40, 
            null, colorAzul, colorGrisOscuro, null, border, "c"
        );
        pDerecha.add(tClaveUsuario);
    }

    public void crearJComboBoxes(){

        cbTipoUsuario = sObjGraficos.construirJComboBox(
            "Cliente_Cajero_Administrador", (pDerecha.getWidth() - 220) / 2, 210, 220, 30, 
            Color.WHITE, colorAzul, "c"
        );
        pDerecha.add(cbTipoUsuario);
    }

    public void crearJCheckBoxes(){

        checkSi = sObjGraficos.construirJCheckBox(
            "Si", (pDerecha.getWidth() - 45) / 2 - 15, 375, 45, 25, cMano, null, null
        );
        pDerecha.add(checkSi);

        checkNo = sObjGraficos.construirJCheckBox(
            "No", (pDerecha.getWidth() + 45) / 2 - 15, 375, 45, 25, cMano, null, null
        );
        pDerecha.add(checkNo);

        grupo = new ButtonGroup();
        grupo.add(checkSi);
        grupo.add(checkNo);
    }
}