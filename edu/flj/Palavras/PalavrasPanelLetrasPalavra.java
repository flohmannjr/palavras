package edu.flj.Palavras;

public class PalavrasPanelLetrasPalavra
{
  private String palavra;
  private byte altura,
               largura,
               posicao,
               x, y, xi, xf, yi, yf;

  public PalavrasPanelLetrasPalavra(byte altura, byte largura)
  {
    this.altura  = altura;
    this.largura = largura;
  }

  public void setPalavra(String palavra)
  {
    this.palavra = palavra;
    byte lp = (byte)palavra.length();

    posicao = (byte)(Math.random() * 8);

    switch(posicao)
    {
      case 0:
        xi = lp;
        xf = (byte)(altura - 1);
        yi = 0;
        yf = (byte)(largura - 1);
        break;
      case 1:
        xi = lp;
        xf = (byte)(altura - 1);
        yi = 0;
        yf = (byte)(largura - lp - 1);
        break;
      case 2:
        xi = 0;
        xf = (byte)(altura - 1);
        yi = 0;
        yf = (byte)(largura - lp - 1);
        break;
      case 3:
        xi = 0;
        xf = (byte)(altura - lp - 1);
        yi = 0;
        yf = (byte)(largura - lp - 1);
        break;
      case 4:
        xi = 0;
        xf = (byte)(altura - lp - 1);
        yi = 0;
        yf = (byte)(largura - 1);
        break;
      case 5:
        xi = 0;
        xf = (byte)(altura - lp - 1);
        yi = lp;
        yf = (byte)(largura - 1);
        break;
      case 6:
        xi = 0;
        xf = (byte)(altura - 1);
        yi = lp;
        yf = (byte)(largura - 1);
        break;
      case 7:
        xi = lp;
        xf = (byte)(altura - 1);
        yi = lp;
        yf = (byte)(largura - 1);
        break;
    }

    x = (byte)((Math.random() * (xf - xi)) + xi);
    y = (byte)((Math.random() * (yf - yi)) + yi);
  }

  public byte getPosicao()
  {
    return posicao;
  }

  public byte getX()
  {
    return x;
  }

  public byte getY()
  {
    return y;
  }
}