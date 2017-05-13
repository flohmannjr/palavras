package edu.flj.Palavras;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

public class PalavrasDialogSelecao
{
  private Palavras palavras;
  private JDialog  dialogo;

  private PalavrasDialogSelecaoPalavras       dialogoPalavras;
  private PalavrasDialogSelecaoActionListener listener;

  public PalavrasDialogSelecao(Palavras palavras, PalavrasInterfaceGrafica ig)
  {
    this.palavras = palavras;

    dialogoPalavras = new PalavrasDialogSelecaoPalavras(this);

    listener = new PalavrasDialogSelecaoActionListener(ig, this, dialogoPalavras);

    montarDialogo();

    dialogoPalavras.montarDialogo();
  }

  private void montarDialogo()
  {
    dialogo = new JDialog(palavras, "Seleção de Palavras", true);
    dialogo.setLocation(100, 50);

    JButton btnMeses = new JButton("Meses do Ano");
    btnMeses.setActionCommand("m");
    btnMeses.addActionListener(listener);

    JButton btnAneis = new JButton("Senhor dos Anéis");
    btnAneis.setActionCommand("s");
    btnAneis.addActionListener(listener);

    JButton btnCapitais = new JButton("Capitais");
    btnCapitais.setActionCommand("c");
    btnCapitais.addActionListener(listener);

    JButton btnPaises = new JButton("Países");
    btnPaises.setActionCommand("p");
    btnPaises.addActionListener(listener);

    JButton btnNomes = new JButton("Nomes");
    btnNomes.setActionCommand("n");
    btnNomes.addActionListener(listener);

    JButton btnFrutas = new JButton("Frutas");
    btnFrutas.setActionCommand("f");
    btnFrutas.addActionListener(listener);

    JButton btnCarros = new JButton("Marcas de Carros");
    btnCarros.setActionCommand("a");
    btnCarros.addActionListener(listener);

    JButton btnPersonagens = new JButton("Personagens");
    btnPersonagens.setActionCommand("e");
    btnPersonagens.addActionListener(listener);

    JButton btnInsetos = new JButton("Insetos");
    btnInsetos.setActionCommand("i");
    btnInsetos.addActionListener(listener);

    JButton btnEntrada = new JButton("Entrar com Palavras");
    btnEntrada.setActionCommand("t");
    btnEntrada.addActionListener(listener);

    Container cp = dialogo.getContentPane();
    cp.setLayout(new GridLayout(5, 2));

    cp.add(btnMeses);
    cp.add(btnAneis);
    cp.add(btnCapitais);
    cp.add(btnPaises);
    cp.add(btnNomes);
    cp.add(btnFrutas);
    cp.add(btnCarros);
    cp.add(btnPersonagens);
    cp.add(btnInsetos);
    cp.add(btnEntrada);

    dialogo.pack();
    dialogo.setVisible(false);
    dialogo.setResizable(false);
  }

  public void mostrarDialogo(boolean mostrar)
  {
    dialogo.setVisible(mostrar);
  }

  public PalavrasDialogSelecaoActionListener getListener()
  {
    return listener;
  }

  public JDialog getDialogo()
  {
    return dialogo;
  }
}