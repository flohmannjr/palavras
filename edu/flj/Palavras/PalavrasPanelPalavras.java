package edu.flj.Palavras;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.Locale;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class PalavrasPanelPalavras extends JPanel implements Cloneable
{
  private Vector palavras;
  private JLabel palavra;

  private PalavrasPanelPalavrasMouseListener listener;

  public PalavrasPanelPalavras(Vector palavras, PalavrasInterfaceGrafica ig)
  {
    JPanel pnlEsquerda = new JPanel();
    pnlEsquerda.setLayout(new GridLayout(0, 1));

    JPanel pnlDireita = new JPanel();
    pnlDireita.setLayout(new GridLayout(0, 1));

    this.palavras = palavras;

    listener = new PalavrasPanelPalavrasMouseListener(ig);

    setLayout(new GridLayout(0, 4));
    setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

    for(int p = 0; p < palavras.size(); p++)
    {
      palavra = new JLabel(palavras.get(p).toString());
      palavra.setFont(new Font("Courier New", Font.BOLD, 16));
      palavra.addMouseListener(listener);

      add(palavra);
    }
  }

  public Object clone() throws CloneNotSupportedException
  {
    return super.clone();
  }
}