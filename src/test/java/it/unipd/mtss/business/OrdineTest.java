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

public class OrdineTest {
    User u;
    Date d;
    List<EItem> l;
    @Before
    void Hobisognodivalori(){
        u=new User(0, 22, "Nome", "Cognome");
        DateFormat df=new SimpleDateFormat("HH:mm");
        try{
            d=df.parse("18");
        }
        catch(ParseException P){System.out.print("FORMATO NON VALIDO");};
        l=Collections.emptyList();
        Ordine o=new Ordine(u, d, l);
    }
    @Test
    public void OggettoValido(){
        
        l=Arrays.asList(new EItem(EItem.itemType.Keyboard,"A",76.0),
            new EItem(EItem.itemType.Processor,"m1",99.0), 
            new EItem(EItem.itemType.Motherboard,"a567",122.0));
    }
    
}
