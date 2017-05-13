package edu.flj.Palavras;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PalavrasInterfaceGrafica extends JPanel
{
  private PalavrasPanelLetras    lp;
  private PalavrasPanelPalavras  pp;
  private PalavrasPanelBotoes    bp;

  private JLabel[][] letras,
                     letras_solucao;

  public PalavrasInterfaceGrafica()
  {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }

  public void mostrarSolucao(boolean mostrar)
  {
    if(mostrar)
    {
      lp.redesenhar(letras_solucao);
      bp.setTextoSolucao("Voltar");
    }
    else
    {
      lp.redesenhar(letras);
      bp.setTextoSolucao("Solução");
    }
  }

  public void imprimir()
  {
    try
    {
      JPanel iletras   = (JPanel)lp.clone();
      JPanel ipalavras = (JPanel)pp.clone();
      JPanel imprimir  = new JPanel();

      imprimir.setLayout(new BoxLayout(imprimir, BoxLayout.Y_AXIS));
      imprimir.add(iletras);
      imprimir.add(ipalavras);

      JFrame janela = new JFrame("Impressão");

      Container cp = janela.getContentPane();
      cp.setLayout(new GridLayout(1, 1));
      cp.add(imprimir);

      janela.pack();
      janela.setVisible(true);

      PalavrasImpressao.printComponent(janela);

      janela.setVisible(false);
      janela = null;
    }
    catch(CloneNotSupportedException e)
    {
      System.out.println("Erro ao imprimir: " + e.getMessage());
    }
  }

  public void montarPalavras(Vector palavras)
  {
    lp = new PalavrasPanelLetras(palavras, this);

    letras         = lp.getLetras();
    letras_solucao = lp.getLetrasSolucao();

    pp = new PalavrasPanelPalavras(palavras, this);
    bp = new PalavrasPanelBotoes(this);

    removeAll();

    add(lp);
    add(pp);
    add(bp);

    updateUI();
  }
}