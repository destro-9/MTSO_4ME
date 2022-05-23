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
    public void EccezioneAspettataSeInferioreCinqueProcessori(){
        l.add(item);
        o = new Ordine(u,d,l);
        try{
            o.PrezzoScontatoDelProcessoreMenoCostosoSeOrdinatiPiuDiCinqueProcessori();
        } catch (OggettoNonTrovato e){fail(e.getMessage());}
    }
    @Test //Task2
    public void ScontoSeNumeroProcessoriMaggioreDiCinque(){
        for(int i=0;i<5;i++)
            l.add(item);
        l.add(new EItem(itemType.Processor, "Min", 200));
        o = new Ordine(u,d,l);
        double numero = 0.0;
        try{
            numero = o.PrezzoScontatoDelProcessoreMenoCostosoSeOrdinatiPiuDiCinqueProcessori();
        }catch(OggettoNonTrovato e){fail(e.getMessage());}
        assertEquals(100.0, numero,0.001); 
    }    
    @Test(expected=OggettoNonTrovato.class)
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
        new EItem(EItem.itemType.Mouse,"Q10",89.9));
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
            assertEquals(totale, o.milleuro(),0.001);
    }

}
