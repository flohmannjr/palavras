package edu.flj.Palavras;

import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PalavrasPanelLetrasLetra
{
  private ImageIcon[] imagens;
  private JLabel      lblLetra;

  public PalavrasPanelLetrasLetra()
  {
    imagens = new ImageIcon[26];

    imagens[0]  = new ImageIcon("imagens/A.gif");
    imagens[1]  = new ImageIcon("imagens/B.gif");
    imagens[2]  = new ImageIcon("imagens/C.gif");
    imagens[3]  = new ImageIcon("imagens/D.gif");
    imagens[4]  = new ImageIcon("imagens/E.gif");
    imagens[5]  = new ImageIcon("imagens/F.gif");
    imagens[6]  = new ImageIcon("imagens/G.gif");
    imagens[7]  = new ImageIcon("imagens/H.gif");
    imagens[8]  = new ImageIcon("imagens/I.gif");
    imagens[9]  = new ImageIcon("imagens/J.gif");
    imagens[10] = new ImageIcon("imagens/K.gif");
    imagens[11] = new ImageIcon("imagens/L.gif");
    imagens[12] = new ImageIcon("imagens/M.gif");
    imagens[13] = new ImageIcon("imagens/N.gif");
    imagens[14] = new ImageIcon("imagens/O.gif");
    imagens[15] = new ImageIcon("imagens/P.gif");
    imagens[16] = new ImageIcon("imagens/Q.gif");
    imagens[17] = new ImageIcon("imagens/R.gif");
    imagens[18] = new ImageIcon("imagens/S.gif");
    imagens[19] = new ImageIcon("imagens/T.gif");
    imagens[20] = new ImageIcon("imagens/U.gif");
    imagens[21] = new ImageIcon("imagens/V.gif");
    imagens[22] = new ImageIcon("imagens/W.gif");
    imagens[23] = new ImageIcon("imagens/X.gif");
    imagens[24] = new ImageIcon("imagens/Y.gif");
    imagens[25] = new ImageIcon("imagens/Z.gif");
  }

  public JLabel getLabelLetra(PalavrasPanelLetrasMouseListener listener)
  {
    lblLetra = new JLabel();
    lblLetra.setIcon(getLetra());
    lblLetra.addMouseListener(listener);

    return lblLetra;
  }

  private Icon getLetra()
  {
    Icon i = imagens[(byte)(Math.random() * 26)];

    return i;
  }
}