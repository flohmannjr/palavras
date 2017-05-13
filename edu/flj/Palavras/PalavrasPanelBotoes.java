package edu.flj.Palavras;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PalavrasPanelBotoes extends JPanel
{
  private JButton btnImprimir,
                  btnSolucao;

  private PalavrasPanelBotoesActionListener listener;

  public PalavrasPanelBotoes(PalavrasInterfaceGrafica ig)
  {
    setLayout(new FlowLayout(FlowLayout.RIGHT));

    listener = new PalavrasPanelBotoesActionListener(ig);

    btnImprimir = new JButton("Imprimir");
    btnImprimir.setActionCommand("i");
    btnImprimir.addActionListener(listener);

    btnSolucao = new JButton("Solução");
    btnSolucao.setActionCommand("s");
    btnSolucao.addActionListener(listener);

    add(btnImprimir);
    add(btnSolucao);
  }

  public void setTextoSolucao(String texto)
  {
    btnSolucao.setText(texto);
  }
}