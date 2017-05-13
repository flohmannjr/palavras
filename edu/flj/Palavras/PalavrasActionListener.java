package edu.flj.Palavras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class PalavrasActionListener implements ActionListener
{
  private Palavras palavras;

  public PalavrasActionListener(Palavras palavras)
  {
    this.palavras = palavras;
  }

  public void actionPerformed(ActionEvent e)
  {
    char comando = e.getActionCommand().charAt(0);

    switch(comando)
    {
      case 'n':
        palavras.mostrarSelecao(true);
        break;
      case 's':
        if(JOptionPane.showConfirmDialog(palavras,
                                         "Deseja realmente sair do sistema?",
                                         "Sair",
                                         JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
          System.exit(0);
        }

        break;
      case 'm':
        palavras.mostrarManual(true);
        break;
      case 'b':
        palavras.mostrarSobre(true);
        break;
    }
  }
}