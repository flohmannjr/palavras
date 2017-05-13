package edu.flj.Palavras;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Palavras extends JFrame
{
  private PalavrasActionListener   alistener;
  private PalavrasDialogSelecao    selecao;
  private PalavrasDialogManual     manual;
  private PalavrasDialogSobre      sobre;
  private PalavrasInterfaceGrafica ig;
  private PalavrasWindowListener   wlistener;

  public static void main(String[] args)
  {
    Palavras palavras = new Palavras();
  }

  public Palavras()
  {
    setTitle("Projeto Palavras");
    setLocation(20, 20);
    setIconImage((new ImageIcon("imagens/icone_16.gif")).getImage());

    wlistener = new PalavrasWindowListener();
    ig        = new PalavrasInterfaceGrafica();
    selecao   = new PalavrasDialogSelecao(this, ig);
    manual    = new PalavrasDialogManual(this);
    sobre     = new PalavrasDialogSobre(this);
    alistener = new PalavrasActionListener(this);

    Container contentPane = getContentPane();
    contentPane.setLayout(new GridLayout(1, 1));

    contentPane.add(ig);

    addWindowListener(wlistener);

    selecao.mostrarDialogo(true);

    criarMenu();

    pack();

    if(getSize().getHeight() < 100.0)
    {
      System.exit(0);
    }

    setResizable(false);
    setVisible(true);
  }

  private void criarMenu()
  {
    JMenuBar  mnbBarra;
    JMenu     mnuPalavras,
              mnuAjuda;
    JMenuItem mniNovo,
              mniSair,
              mniManual,
              mniSobre;

    mnbBarra = new JMenuBar();

    mnuPalavras = new JMenu("Palavras");
    mnuAjuda    = new JMenu("Ajuda");

    mniNovo = new JMenuItem("Novo");
    mniNovo.setActionCommand("n");
    mniNovo.addActionListener(alistener);

    mniSair = new JMenuItem("Sair");
    mniSair.setActionCommand("s");
    mniSair.addActionListener(alistener);

    mniManual = new JMenuItem("Manual");
    mniManual.setActionCommand("m");
    mniManual.addActionListener(alistener);

    mniSobre = new JMenuItem("Sobre...");
    mniSobre.setActionCommand("b");
    mniSobre.addActionListener(alistener);

    mnuPalavras.add(mniNovo);
    mnuPalavras.addSeparator();
    mnuPalavras.add(mniSair);

    mnuAjuda.add(mniManual);
    mnuAjuda.addSeparator();
    mnuAjuda.add(mniSobre);

    mnbBarra.add(mnuPalavras);
    mnbBarra.add(mnuAjuda);

    setJMenuBar(mnbBarra);
  }

  public void mostrarSelecao(boolean mostrar)
  {
    selecao.mostrarDialogo(mostrar);
  }

  public void mostrarSobre(boolean mostrar)
  {
    sobre.mostrarDialogo(mostrar);
  }

  public void mostrarManual(boolean mostrar)
  {
    manual.mostrarDialogo(mostrar);
  }
}