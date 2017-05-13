package edu.flj.Palavras;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class PalavrasPanelPalavrasMouseListener implements MouseListener
{
  private PalavrasInterfaceGrafica ig;

  public PalavrasPanelPalavrasMouseListener(PalavrasInterfaceGrafica ig)
  {
    this.ig = ig;
  }

  public void mouseClicked(MouseEvent e)
  {
    JLabel jLabel = (JLabel)e.getSource();

    switch(e.getButton())
    {
      case MouseEvent.BUTTON1:
        jLabel.setForeground(Color.WHITE);
        break;
      case MouseEvent.BUTTON2:
      case MouseEvent.BUTTON3:
      default:
        jLabel.setForeground(Color.BLACK);
        break;
    }

    ig.updateUI();
  }

  public void mouseEntered(MouseEvent e)
  {
  }

  public void mouseExited(MouseEvent e)
  {
  }

  public void mousePressed(MouseEvent e)
  {
  }

  public void mouseReleased(MouseEvent e)
  {
  }
}