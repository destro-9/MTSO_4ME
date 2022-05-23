package it.unipd.mtss.business;

import org.junit.Before;
import it.unipd.mtss.business.Ordine;
import org.junit.Test;
import it.unipd.mtss.classi.User;
import it.unipd.mtss.exception.OggettoNonTrovato;
import it.unipd.mtss.exception.SgarroOrdine;
import it.unipd.mtss.classi.EItem;
import it.unipd.mtss.classi.EItem.itemType;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.text.DateFormat;
import java.text.DateFormat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class OrdineTest {
    User u;
    Date d;
    Ordine o;
    EItem item;
    List<EItem> l;
    @Before
    public void Hobisognodivalori(){
        u=new User(0, 22, "Nome", "Cognome");
        item=new EItem(itemType.Processor, "Processor", 666);
        DateFormat df=new SimpleDateFormat("HH:mm");
        try{
            d=df.parse("18");
        }
        catch(ParseException P){System.out.print("FORMATO NON VALIDO");};
        l=Collections.emptyList();
        o=new Ordine(u, d, l);
    }
    @Test
    public void OggettoValido(){
        
        l=Arrays.asList(new EItem(EItem.itemType.Keyboard,"A",76.0),
            new EItem(EItem.itemType.Processor,"m1",99.0), 
            new EItem(EItem.itemType.Motherboard,"a567",122.0));
    }
    @Test 
    public void totalecorretto()
    {
        l=Arrays.asList(new EItem(EItem.itemType.Keyboard,"A",76.0),
            new EItem(EItem.itemType.Processor,"m1",99.0), 
            new EItem(EItem.itemType.Motherboard,"a567",122.0));
            o=new Ordine(u,d,l);
        assertEquals(297.0, o.Totale(),0.001);
    }
    @Test
    public void TotaleConListaVuota()
    {
        assertEquals(0.0, o.Totale(),0.001);
    }
    @Test(expected = OggettoNonTrovato.class)//Task2
    public void EccezioneAspettataSeInferioreCinqueProcessori() throws OggettoNonTrovato{
        ArrayList<EItem> aux = new ArrayList<EItem>();
        aux.add(item);
        o = new Ordine(u,d,aux);
        o.PrezzoScontatoDelProcessoreMenoCostosoSeOrdinatiPiuDiCinqueProcessori();
    }
    @Test //Task2
    public void ScontoSeNumeroProcessoriMaggioreDiCinque(){
        ArrayList<EItem> aux = new ArrayList<EItem>();
        for(int i=0;i<5;i++)
            aux.add(item);
        aux.add(new EItem(itemType.Processor, "Min", 200));
        o = new Ordine(u,d,aux);
        double numero = 0.0;
        try{
            numero = o.PrezzoScontatoDelProcessoreMenoCostosoSeOrdinatiPiuDiCinqueProcessori();
        }catch(OggettoNonTrovato e){fail(e.getMessage());}
        assertEquals(100.0, numero,0.001); 
    }    
    @Test(expected=OggettoNonTrovato.class) //Task3
    public void MouseRegalato() throws OggettoNonTrovato
    {
        l=Arrays.asList(
            new EItem(EItem.itemType.Mouse,"Q1",55.0),
            new EItem(EItem.itemType.Mouse,"Q2",55.5),
            new EItem(EItem.itemType.Mouse,"Q3",60.0),
            new EItem(EItem.itemType.Mouse,"Q4",65.0),
            new EItem(EItem.itemType.Mouse,"Q5",65.5),
            new EItem(EItem.itemType.Mouse,"Q6",70.0),
            new EItem(EItem.itemType.Mouse,"Q7",75.0),
            new EItem(EItem.itemType.Mouse,"Q8",75.5),
            new EItem(EItem.itemType.Mouse,"Q9",82.0),
            new EItem(EItem.itemType.Mouse,"Q10",89.9),
            new EItem(EItem.itemType.Mouse,"Q11",99.9));
        EItem it=new EItem(EItem.itemType.Mouse, "Q1", 55.0);
        assertEquals(it, o.dieciMouse());
    }
    //task3
    @Test (expected = OggettoNonTrovato.class)
    public void FailTest() throws OggettoNonTrovato
    {
        l=Arrays.asList(
            new EItem(EItem.itemType.Mouse,"Q1",55.0),
            new EItem(EItem.itemType.Mouse,"Q2",55.5),
            new EItem(EItem.itemType.Mouse,"Q3",60.0),
            new EItem(EItem.itemType.Mouse,"Q4",65.0),
            new EItem(EItem.itemType.Mouse,"Q5",65.5));
        o=new Ordine(u, d, l);
        o.dieciMouse();   
    }
    //task5
    @Test
    public void ScontoCorretto()
    {
        l=Arrays.asList(
            new EItem(EItem.itemType.Mouse,"Q1",155.0),
            new EItem(EItem.itemType.Mouse,"Q2",355.5),
            new EItem(EItem.itemType.Mouse,"Q3",360.0),
            new EItem(EItem.itemType.Mouse,"Q4",465.0),
            new EItem(EItem.itemType.Mouse,"Q5",565.5));
        o=new Ordine(u, d, l);
        double totale=1901-190.1;
        try{
            assertEquals(totale, o.milleuro(),0.001);
        }catch(SgarroOrdine e){fail(e.getMessage());}
    }
    @Test(expected = SgarroOrdine.class)
    public void ScontoConListaVuota() throws SgarroOrdine
    {
        o.milleuro();
    }
    @Test(expected = OggettoNonTrovato.class) //task4
    public void EccezioneAspettataNumeroTastiereDisugualeMouse() throws OggettoNonTrovato{
        ArrayList<EItem> aux = new ArrayList<EItem>();
        aux.add(new EItem(itemType.Mouse, "Mouse1", 10));
        aux.add(new EItem(itemType.Mouse, "Mouse2", 20));
        aux.add(new EItem(itemType.Keyboard, "Key1", 30));
        aux.add(new EItem(itemType.Keyboard, "Key2", 40));
        aux.add(new EItem(itemType.Mouse, "Mouse3", 50));
        o = new Ordine(u, d, aux);
        o.NumeroTastiereUgualeANumeroMouseAlloraRegaloArticoloMenoCaro();
    }
    @Test //task4
    public void NumeroTastiereUgualeANumeroMouse(){
        ArrayList<EItem> aux = new ArrayList<EItem>();
        aux.add(new EItem(itemType.Mouse, "Mouse1", 10));
        aux.add(new EItem(itemType.Mouse, "Mouse2", 20));
        aux.add(new EItem(itemType.Keyboard, "Key1", 30));
        aux.add(new EItem(itemType.Keyboard, "Key2", 40));
        o = new Ordine(u, d, aux);
        try{
            item = o.NumeroTastiereUgualeANumeroMouseAlloraRegaloArticoloMenoCaro();
        } catch(OggettoNonTrovato e){fail(e.getMessage());}
        assertEquals(0, item.getPrezzo(),0.001);
    }
    @Test(expected = SgarroOrdine.class) //task6
    public void EccezioneAspettata30Elementi() throws SgarroOrdine{
        item = new EItem(itemType.Processor,"item",666);
        ArrayList<EItem> aux = new ArrayList<EItem>();
        for(int i=0; i<40; i++)
            aux.add(item);
        o = new Ordine(u, d, aux);
        o.trentaelementi();
    }
    @Test //task6
    public void Test30Elementi(){
        item = new EItem(itemType.Processor, "item", 666);
        ArrayList<EItem> aux = new ArrayList<EItem>();
        aux.add(item);
        o = new Ordine(u, d, aux);
        int n=-1;
        try{
            n = o.trentaelementi();
        } catch(SgarroOrdine e){e.getMessage();}
        assertEquals(1, n);
    }
    @Test //task7
    public void Inferiore10Euro(){
        item = new EItem(itemType.Processor, "item", 5.0);
        ArrayList<EItem> aux = new ArrayList<EItem>();
        aux.add(item);
        o = new Ordine(u, d, aux);
        try{
            assertEquals(7.0, o.diecieuro(), 0.001);
        } catch(OggettoNonTrovato e){e.getMessage();}
    }
    @Test //task7
    public void Superiore10Euro(){
        item = new EItem(itemType.Processor, "item", 51);
        ArrayList<EItem> aux = new ArrayList<EItem>();
        aux.add(item);
        o = new Ordine(u, d, aux);
        double j = -1;
        try{
            j = o.diecieuro();
        } catch(OggettoNonTrovato e){e.getMessage();}
        assertEquals(51, j, 0.001);
    }
    @Test(expected = OggettoNonTrovato.class) //task7
    public void ListaVuota() throws OggettoNonTrovato{
        o = new Ordine(u,d,l);
        o.diecieuro();
    }
}
