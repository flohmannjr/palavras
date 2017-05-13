package edu.flj.Palavras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class PalavrasDialogSelecaoActionListener implements ActionListener
{
  private Vector opcoes;

  private PalavrasInterfaceGrafica      ig;
  private PalavrasDialogSelecao         selecao;
  private PalavrasDialogSelecaoPalavras dialogoPalavras;

  private boolean ok;

  public PalavrasDialogSelecaoActionListener(PalavrasInterfaceGrafica      ig,
                                             PalavrasDialogSelecao         selecao,
                                             PalavrasDialogSelecaoPalavras dialogoPalavras)
  {
    this.ig              = ig;
    this.selecao         = selecao;
    this.dialogoPalavras = dialogoPalavras;

    ok = true;

    Vector meses = new Vector();
    meses.add("Janeiro");
    meses.add("Fevereiro");
    meses.add("Marco");
    meses.add("Abril");
    meses.add("Maio");
    meses.add("Junho");
    meses.add("Julho");
    meses.add("Agosto");
    meses.add("Setembro");
    meses.add("Outubro");
    meses.add("Novembro");
    meses.add("Dezembro");

    Vector aneis = new Vector();
    aneis.add("Aragorn");
    aneis.add("Arwen");
    aneis.add("Frodo");
    aneis.add("Gandalf");
    aneis.add("Gimli");
    aneis.add("Legolas");
    aneis.add("Merry");
    aneis.add("Pippin");
    aneis.add("Sam");
    aneis.add("Saruman");
    aneis.add("Sauron");
    aneis.add("Smeagol");

    Vector capitais = new Vector();
    capitais.add("Aracaju");
    capitais.add("Belem");
    capitais.add("Cuiaba");
    capitais.add("Curitiba");
    capitais.add("Floripa");
    capitais.add("Goiania");
    capitais.add("Manaus");
    capitais.add("Natal");
    capitais.add("Palmas");
    capitais.add("Rio");
    capitais.add("Salvador");
    capitais.add("Vitoria");

    Vector paises = new Vector();
    paises.add("Alemanha");
    paises.add("Australia");
    paises.add("Brasil");
    paises.add("Canada");
    paises.add("Congo");
    paises.add("Egito");
    paises.add("Espanha");
    paises.add("Finlandia");
    paises.add("Inglaterra");
    paises.add("Japao");
    paises.add("Panama");
    paises.add("Russia");

    Vector nomes = new Vector();
    nomes.add("Ana");
    nomes.add("Carolina");
    nomes.add("Catherine");
    nomes.add("Elisa");
    nomes.add("Guiliana");
    nomes.add("Isabela");
    nomes.add("Karen");
    nomes.add("Monica");
    nomes.add("Osiris");
    nomes.add("Rafaela");
    nomes.add("Tania");
    nomes.add("Valquiria");

    Vector frutas = new Vector();
    frutas.add("Abacate");
    frutas.add("Banana");
    frutas.add("Goiaba");
    frutas.add("Laranja");
    frutas.add("Maca");
    frutas.add("Maracuja");
    frutas.add("Melancia");
    frutas.add("Morango");
    frutas.add("Pera");
    frutas.add("Pessego");
    frutas.add("Tangerina");
    frutas.add("Uva");

    Vector carros = new Vector();
    carros.add("Audi");
    carros.add("BMW");
    carros.add("Bugatti");
    carros.add("Ferrari");
    carros.add("Honda");
    carros.add("Jaguar");
    carros.add("Lotus");
    carros.add("Mercedes");
    carros.add("Opel");
    carros.add("Porsche");
    carros.add("Rolls");
    carros.add("Toyota");

    Vector personagens = new Vector();
    personagens.add("Amigos");
    personagens.add("Calvin");
    personagens.add("Cobras");
    personagens.add("Garfield");
    personagens.add("Geraldao");
    personagens.add("Hagar");
    personagens.add("Horacio");
    personagens.add("Niquel");
    personagens.add("Piratas");
    personagens.add("Rebordosa");
    personagens.add("Snoopy");
    personagens.add("Zero");

    Vector insetos = new Vector();
    insetos.add("Abelha");
    insetos.add("Barata");
    insetos.add("Besouro");
    insetos.add("Borboleta");
    insetos.add("Formiga");
    insetos.add("Gafanhoto");
    insetos.add("Joaninha");
    insetos.add("Mariposa");
    insetos.add("Mosca");
    insetos.add("Mosquito");
    insetos.add("Pulga");
    insetos.add("Vespa");

    Vector entrada = new Vector();

    opcoes = new Vector();

    opcoes.add(meses);
    opcoes.add(aneis);
    opcoes.add(capitais);
    opcoes.add(paises);
    opcoes.add(nomes);
    opcoes.add(frutas);
    opcoes.add(carros);
    opcoes.add(personagens);
    opcoes.add(insetos);
    opcoes.add(entrada);
  }

  public void actionPerformed(ActionEvent e)
  {
    char comando = e.getActionCommand().charAt(0);

    switch(comando)
    {
      case 'm':
        ig.montarPalavras((Vector)opcoes.get(0));
        ok = true;
        break;
      case 's':
        ig.montarPalavras((Vector)opcoes.get(1));
        ok = true;
        break;
      case 'c':
        ig.montarPalavras((Vector)opcoes.get(2));
        ok = true;
        break;
      case 'p':
        ig.montarPalavras((Vector)opcoes.get(3));
        ok = true;
        break;
      case 'n':
        ig.montarPalavras((Vector)opcoes.get(4));
        ok = true;
        break;
      case 'f':
        ig.montarPalavras((Vector)opcoes.get(5));
        ok = true;
        break;
      case 'a':
        ig.montarPalavras((Vector)opcoes.get(6));
        ok = true;
        break;
      case 'e':
        ig.montarPalavras((Vector)opcoes.get(7));
        ok = true;
        break;
      case 'i':
        ig.montarPalavras((Vector)opcoes.get(8));
        ok = true;
        break;
      case 't':
        dialogoPalavras.mostrarDialogo(true);
        ok = true;
        break;
      case 'o':
        if(dialogoPalavras.camposValidos())
        {
          ig.montarPalavras(dialogoPalavras.getPalavras());
          dialogoPalavras.mostrarDialogo(false);
          ok = true;
        }
        else
        {
          ok = false;
        }

        break;
    }

    if(ok)
    {
      selecao.mostrarDialogo(false);
    }
  }
}