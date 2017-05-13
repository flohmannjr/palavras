package edu.flj.Palavras;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class PalavrasPanelLetras extends JPanel implements Cloneable
{
  private byte altura,
               largura,
               posicao,
               x, y;

  private JLabel[][] letras,
                     letras_solucao;

  private JLabel lblLetra;

  private Vector palavras;

  private char[] cs;

  private PalavrasPanelLetrasLetra         letra;
  private PalavrasPanelLetrasMouseListener listener;
  private PalavrasPanelLetrasPalavra       palavra;

  public PalavrasPanelLetras(Vector palavras, PalavrasInterfaceGrafica ig)
  {
    altura  = 20;
    largura = 30;

    letras         = new JLabel[altura][largura];
    letras_solucao = new JLabel[altura][largura];

    this.palavras = palavras;

    letra    = new PalavrasPanelLetrasLetra();
    listener = new PalavrasPanelLetrasMouseListener(ig);
    palavra  = new PalavrasPanelLetrasPalavra(altura, largura);

    setLayout(new GridLayout(altura, largura));
    setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    setBackground(Color.WHITE);

    for(int a = 0; a < altura; a++)
    {
      for(int l = 0; l < largura; l++)
      {
        letras[a][l] = letra.getLabelLetra(listener);
      }
    }

    for(int p = 0; p < palavras.size(); p++)
    {
      palavra.setPalavra(palavras.get(p).toString());
      posicao = palavra.getPosicao();
      x = palavra.getX();
      y = palavra.getY();
      cs = palavras.get(p).toString().toCharArray();

      if(cruzamentoProibido(cs, posicao, x, y))
      {
        p--;
        continue;
      }

      for(int c = 0; c < cs.length; c++)
      {
        lblLetra = new JLabel(new ImageIcon("imagens\\" + Character.toUpperCase(cs[c]) + ".gif"));
        lblLetra.addMouseListener(listener);

        switch(posicao)
        {
          case 0:
            letras[x - c][y]         = lblLetra;
            letras_solucao[x - c][y] = lblLetra;
            break;
          case 1:
            letras[x - c][y + c]         = lblLetra;
            letras_solucao[x - c][y + c] = lblLetra;
            break;
          case 2:
            letras[x][y + c]         = lblLetra;
            letras_solucao[x][y + c] = lblLetra;
            break;
          case 3:
            letras[x + c][y + c]         = lblLetra;
            letras_solucao[x + c][y + c] = lblLetra;
            break;
          case 4:
            letras[x + c][y]         = lblLetra;
            letras_solucao[x + c][y] = lblLetra;
            break;
          case 5:
            letras[x + c][y - c]         = lblLetra;
            letras_solucao[x + c][y - c] = lblLetra;
            break;
          case 6:
            letras[x][y - c]         = lblLetra;
            letras_solucao[x][y - c] = lblLetra;
            break;
          case 7:
            letras[x - c][y - c]         = lblLetra;
            letras_solucao[x - c][y - c] = lblLetra;
            break;
        }
      }
    }

    for(int a = 0; a < altura; a++)
    {
      for(int l = 0; l < largura; l++)
      {
        add(letras[a][l]);
      }
    }
  }

  public JLabel[][] getLetras()
  {
    return letras;
  }

  public JLabel[][] getLetrasSolucao()
  {
    return letras_solucao;
  }

  public void redesenhar(JLabel[][] ls)
  {
    removeAll();

    for(int a = 0; a < altura; a++)
    {
      for(int l = 0; l < largura; l++)
      {
        if(ls[a][l] instanceof JLabel)
        {
          add(ls[a][l]);
        }
        else
        {
          add(new JLabel());
        }
      }
    }

    updateUI();
  }

  private boolean cruzamentoProibido(char[] cs, byte p, byte x, byte y)
  {
    int a = 0;
    int b = 0;

    for(int c = 0; c < cs.length; c++)
    {
      switch(p)
      {
        case 0:
          a = x - c;
          b = y;
          break;
        case 1:
          a = x - c;
          b = y + c;
          break;
        case 2:
          a = x;
          b = y + c;
          break;
        case 3:
          a = x + c;
          b = y + c;
          break;
        case 4:
          a = x + c;
          b = y;
          break;
        case 5:
          a = x + c;
          b = y - c;
          break;
        case 6:
          a = x;
          b = y - c;
          break;
        case 7:
          a = x - c;
          b = y - c;
          break;
      }

      if(letras_solucao[a][b] instanceof JLabel)
      {
        String sLetra = letras_solucao[a][b].toString();
        int    indice = sLetra.indexOf(".gif");

        if((indice < 1) || (sLetra.charAt(indice - 1) != Character.toUpperCase(cs[c])))
        {
          return true;
        }
      }
    }

    return false;
  }

  public Object clone() throws CloneNotSupportedException
  {
    return super.clone();
  }
}