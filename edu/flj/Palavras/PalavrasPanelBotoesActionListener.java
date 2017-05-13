package edu.flj.Palavras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PalavrasPanelBotoesActionListener implements ActionListener
{
  private PalavrasInterfaceGrafica ig;

  private boolean mostrar_solucao;

  public PalavrasPanelBotoesActionListener(PalavrasInterfaceGrafica ig)
  {
    this.ig = ig;

    mostrar_solucao = true;
  }

  public void actionPerformed(ActionEvent e)
  {
    char comando = e.getActionCommand().charAt(0);

    switch(comando)
    {
      case 'i':
        ig.imprimir();
        break;
      case 's':
        mostrarSolucao(mostrar_solucao);
        break;
    }
  }

  private void mostrarSolucao(boolean mostrar)
  {
    ig.mostrarSolucao(mostrar);

    if(mostrar)
    {
      mostrar_solucao = false;
    }
    else
    {
      mostrar_solucao = true;
    }
  }
}