package app.client.vistaPrincipal;

import javax.swing.JFrame;

import app.services.RecursosService;

public class VistaPrincipalTemplate extends JFrame {
  private static final long serialVersionUID = 1L;
  
  private RecursosService sRecursos;

  public VistaPrincipalTemplate() {
    super("Vista Principal");

    sRecursos = RecursosService.getService();

    getContentPane().setBackground(sRecursos.getColorAzul());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(1200, 700);
    setLocationRelativeTo(this);
    setLayout(null);
    setVisible(true);
  }
}