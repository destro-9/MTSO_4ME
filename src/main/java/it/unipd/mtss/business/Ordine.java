////////////////////////////////////////////////////////////////////
// Alberto  Angeloni    1231122
// Stefano  Destro      1229139
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import it.unipd.mtss.exception.OggettoNonTrovato;
import it.unipd.mtss.exception.SgarroOrdine;
import it.unipd.mtss.classi.EItem;
import it.unipd.mtss.classi.EItem.itemType;
import it.unipd.mtss.classi.Interfaccia;
import it.unipd.mtss.classi.User;

public class Ordine {
    private User user;
    private Date time;
    private List<EItem> list;

public Ordine(User us, Date d, List<EItem> l)
{
    this.user=us;
    this.time=d;
    this.list=l;
}
public User getUser()
{
    return user;
}
public Date getTime()
{
    return time;
}
//ISSUE #1
public double Totale()
{
    double totale=0.0;

    for(EItem paolo: list )
        totale+=paolo.getPrezzo();

    return totale;
}
//ISSUE #2
public double PrezzoScontatoDelProcessoreMenoCostosoSeOrdinatiPiuDiCinqueProcessori() throws OggettoNonTrovato{
    int i = 0;
    double min=9999;
    for(EItem giorgio : list)
        if(giorgio.getTipo() == itemType.Processor){
            if(i == 0)
                min = giorgio.getPrezzo();
            i++;
            if(giorgio.getPrezzo() < min)
                min = giorgio.getPrezzo();
        }
        if(i>5)
            min = min-(min*50/100);
        else
            throw new OggettoNonTrovato("Sconto non applicabile, numero processori < 5");
        return min;
}
//ISSUE #3
public EItem dieciMouse() throws OggettoNonTrovato
{
    int i=0;
    double min=99999;
    int pos=0;
    for(EItem pippo: list)
    {
        if(pippo.getTipo()==itemType.Mouse)
        {
            i++;
            if(pippo.getPrezzo()<min)
            {
                min=pippo.getPrezzo();
                pos=i;

            }

        }
    }
    if(i>10)
    {
        for(EItem franco: list)
        {
            if(pos==0) return  new EItem(franco.getTipo(), franco.getNome(),franco.getPrezzo());
            if(franco.getTipo()==itemType.Mouse)
            {
                pos--;
            }
        }
    }
    throw new OggettoNonTrovato("Numero mouse inferiore a dieci");
}
//ISSUE #4
public EItem NumeroTastiereUgualeANumeroMouseAlloraRegaloArticoloMenoCaro() throws OggettoNonTrovato{
    int m=0, k=0, i=0, pos=0;
    double min=9999;
    for(EItem cristiano : list){
        if(i==0) min=cristiano.getPrezzo();
        if(cristiano.getTipo() == itemType.Mouse)
            m++;
        if(cristiano.getTipo() == itemType.Keyboard)
            k++;
        if(cristiano.getPrezzo() < min){
            min = cristiano.getPrezzo();
            pos=i;
        }
        i++;
    }
    i=0;
    if(m == k)
        for(EItem luca : list){
            if(i==pos) return new EItem(luca.getTipo(),luca.getNome(),0); //Ritorno articolo con costo zero
            i++;
        }
    throw new OggettoNonTrovato("Numero tastiere disuguale da numero mouse");
}
//ISSUE #5
public double milleuro()
{
    double totale=0.0;
    for(EItem mario:list)
    {
        totale+=mario.getPrezzo();
    }
    if(totale>1000)
        totale=totale-((totale*10)/100);
return totale;
}

public int trentaelementi() throws SgarroOrdine{
    int elementi=0;
    for(EItem gino:list)
    {
        elementi++;
    }
    if(elementi>30) throw new SgarroOrdine("ordine non valido, il limite massimo e' 30");
return elementi;
}
}