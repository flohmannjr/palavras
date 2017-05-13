package edu.flj.Palavras;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.RepaintManager;

public class PalavrasImpressao implements Printable
{
  private Component componente;

  public static void printComponent(Component c)
  {
    new PalavrasImpressao(c).imprimir();
  }

  public PalavrasImpressao(Component componente)
  {
    this.componente = componente;
  }

  public void imprimir()
  {
    PrinterJob job = PrinterJob.getPrinterJob();
    job.setPrintable(this);

    if (job.printDialog())
    {
      try
      {
        job.print();
      }
      catch(PrinterException e)
      {
        System.out.println("Error printing: " + e.getMessage());
      }
    }
  }

  public int print(Graphics g, PageFormat formato, int indice)
  {
    if (indice > 0)
    {
      return NO_SUCH_PAGE;
    }
    else
    {
      Graphics2D g2d = (Graphics2D)g;

      g2d.translate(formato.getImageableX(), formato.getImageableY());
      g2d.scale(0.7, 0.7);

      doubleBuffering(componente, false);
      componente.paint(g2d);
      doubleBuffering(componente, true);

      return PAGE_EXISTS;
    }
  }

  public static void doubleBuffering(Component c, boolean abilitar)
  {
    RepaintManager gerenciador = RepaintManager.currentManager(c);
    gerenciador.setDoubleBufferingEnabled(abilitar);
  }
}