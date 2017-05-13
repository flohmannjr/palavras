package edu.flj.Palavras;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PalavrasDialogSelecaoPalavras
{
  private PalavrasDialogSelecao selecao;

  private JDialog dialogo;

  private JTextField txt01,
                     txt02,
                     txt03,
                     txt04,
                     txt05,
                     txt06,
                     txt07,
                     txt08,
                     txt09,
                     txt10,
                     txt11,
                     txt12;

  private PalavrasDialogSelecaoActionListener alistener;

  public PalavrasDialogSelecaoPalavras(PalavrasDialogSelecao selecao)
  {
    this.selecao = selecao;
  }

  public void montarDialogo()
  {
    alistener = selecao.getListener();

    dialogo = new JDialog(selecao.getDialogo(), "Entrada de Palavras", true);
    dialogo.setLocation(125, 75);

    JPanel pnlTexto    = new JPanel(new GridLayout(2, 1));
    JPanel pnlPalavras = new JPanel(new GridLayout(6, 2));
    JPanel pnlBotoes   = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    JLabel lblLinha1 = new JLabel("Entre com 12 palavras de até 10 caracteres");
    JLabel lblLinha2 = new JLabel("(de A a Z, não-acentuados) cada.");

    txt01 = new JTextField();
    txt01.setColumns(2);

    txt02 = new JTextField();
    txt02.setColumns(2);

    txt03 = new JTextField();
    txt03.setColumns(2);

    txt04 = new JTextField();
    txt04.setColumns(2);

    txt05 = new JTextField();
    txt05.setColumns(2);

    txt06 = new JTextField();
    txt06.setColumns(2);

    txt07 = new JTextField();
    txt07.setColumns(2);

    txt08 = new JTextField();
    txt08.setColumns(2);

    txt09 = new JTextField();
    txt09.setColumns(2);

    txt10 = new JTextField();
    txt10.setColumns(2);

    txt11 = new JTextField();
    txt11.setColumns(2);

    txt12 = new JTextField();
    txt12.setColumns(2);

    JButton btnOK = new JButton("OK");
    btnOK.setActionCommand("o");
    btnOK.addActionListener(alistener);

    pnlTexto.add(lblLinha1);
    pnlTexto.add(lblLinha2);

    pnlPalavras.add(txt01);
    pnlPalavras.add(txt02);
    pnlPalavras.add(txt03);
    pnlPalavras.add(txt04);
    pnlPalavras.add(txt05);
    pnlPalavras.add(txt06);
    pnlPalavras.add(txt07);
    pnlPalavras.add(txt08);
    pnlPalavras.add(txt09);
    pnlPalavras.add(txt10);
    pnlPalavras.add(txt11);
    pnlPalavras.add(txt12);

    pnlBotoes.add(btnOK);

    JPanel pnlGeral = new JPanel();
    pnlGeral.setLayout(new BoxLayout(pnlGeral, BoxLayout.Y_AXIS));

    pnlGeral.add(pnlTexto);
    pnlGeral.add(pnlPalavras);
    pnlGeral.add(pnlBotoes);

    Container cp = dialogo.getContentPane();
    cp.setLayout(new GridLayout(1, 1));

    cp.add(pnlGeral);

    dialogo.pack();
    dialogo.setVisible(false);
    dialogo.setResizable(false);
  }

  public void mostrarDialogo(boolean mostrar)
  {
    if(mostrar)
    {
      txt01.setText("");
      txt02.setText("");
      txt03.setText("");
      txt04.setText("");
      txt05.setText("");
      txt06.setText("");
      txt07.setText("");
      txt08.setText("");
      txt09.setText("");
      txt10.setText("");
      txt11.setText("");
      txt12.setText("");
    }

    dialogo.setVisible(mostrar);
  }

  public Vector getPalavras()
  {
    Vector palavras = new Vector();

    palavras.add(txt01.getText());
    palavras.add(txt02.getText());
    palavras.add(txt03.getText());
    palavras.add(txt04.getText());
    palavras.add(txt05.getText());
    palavras.add(txt06.getText());
    palavras.add(txt07.getText());
    palavras.add(txt08.getText());
    palavras.add(txt09.getText());
    palavras.add(txt10.getText());
    palavras.add(txt11.getText());
    palavras.add(txt12.getText());

    return palavras;
  }

  public void setTexto(String texto)
  {
    txt12.setText(texto);
  }

  public boolean camposValidos()
  {
    if(!campoValido(txt01))
    {
      return false;
    }

    if(!campoValido(txt02))
    {
      return false;
    }

    if(!campoValido(txt03))
    {
      return false;
    }

    if(!campoValido(txt04))
    {
      return false;
    }

    if(!campoValido(txt05))
    {
      return false;
    }

    if(!campoValido(txt06))
    {
      return false;
    }

    if(!campoValido(txt07))
    {
      return false;
    }

    if(!campoValido(txt08))
    {
      return false;
    }

    if(!campoValido(txt09))
    {
      return false;
    }

    if(!campoValido(txt10))
    {
      return false;
    }

    if(!campoValido(txt11))
    {
      return false;
    }

    if(!campoValido(txt12))
    {
      return false;
    }

    return true;
  }

  private boolean campoValido(JTextField campo)
  {
    char[] cs = campo.getText().toCharArray();

    if(cs.length > 0)
    {
      if(cs.length > 10)
      {
        JOptionPane.showMessageDialog(dialogo,
                                      "As palavras devem conter até 10 caracteres!",
                                      "Mensagem",
                                      JOptionPane.WARNING_MESSAGE);

        campo.requestFocus();
        campo.selectAll();

        return false;
      }
      else
      {
        for(int c = 0; c < cs.length; c++)
        {
          int ca = (int)cs[c];

          if(ca < 65 || ca > 90)
          {
            JOptionPane.showMessageDialog(dialogo,
                                          "As palavras devem conter somente caracteres de A a Z (maiúsculos e não-acentuados)!",
                                          "Mensagem",
                                          JOptionPane.WARNING_MESSAGE);

            campo.requestFocus();
            campo.selectAll();

            return false;
          }
        }
      }
    }
    else
    {
      JOptionPane.showMessageDialog(dialogo,
                                    "Todas as palavras devem ser preenchidas!",
                                    "Mensagem",
                                    JOptionPane.WARNING_MESSAGE);

      campo.requestFocus();
      return false;
    }

    return true;
  }
}