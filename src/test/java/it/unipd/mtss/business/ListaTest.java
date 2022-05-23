package it.unipd.mtss.business;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import it.unipd.mtss.classi.EItem;
import it.unipd.mtss.classi.User;
import it.unipd.mtss.classi.EItem.itemType;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.Before;

public class ListaTest{
    ListaOrdini L;
    Date d1, d2, d3;
    List<EItem> ordine; //itemList
    List<Ordine> orderlist;//list

    @Before
    public void inizializzacose()
    {
      L=new ListaOrdini();
      DateFormat df= new SimpleDateFormat("HH:mm");
      try{
          d1=df.parse("12.00");//date12
          d2=df.parse("18.00");//date18
          d3=df.parse("20.00");//date20
      }  
      catch(ParseException e){}
      ordine=new ArrayList<EItem>();
      orderlist=new ArrayList<Ordine>();
    }
    @Test
    public void regalaTuttoListamaggioredi10()
    {
        orderlist=Arrays.asList(new Ordine(new User(0, 14, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))),
        (new Ordine(new User(1, 14, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6)))),
        (new Ordine(new User(2, 14, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6)))),
        (new Ordine(new User(3, 14, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Keyboard, "M1", 25.6)))),
        (new Ordine(new User(4, 15, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Keyboard, "M1", 25.6)))),
        (new Ordine(new User(5, 15, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Keyboard, "M1", 25.6)))),
        (new Ordine(new User(6, 15, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Processor, "M1", 25.6)))),
        (new Ordine(new User(7, 11, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Processor, "M1", 25.6)))),
        (new Ordine(new User(8, 17, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Mouse, "M1", 25.6)))),
        (new Ordine(new User(9, 16, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Mouse, "M1", 25.6)))),
        (new Ordine(new User(10, 16, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Mouse, "M1", 25.6)))));
        assertEquals(10, L.OrdiniRegalati(orderlist));
    }
    @Test
    public void regalaNienteListamaggioredi10()
    {
        orderlist=Arrays.asList(new Ordine(new User(0, 14, "nome", "cognome"),d3 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))),
        (new Ordine(new User(0, 14, "nome", "cognome"),d3 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6)))),
        (new Ordine(new User(0, 14, "nome", "cognome"),d3 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6)))));
        assertEquals(0, L.OrdiniRegalati(orderlist));
    }
    @Test
    public void regalaTuttoListaminoredi10()
    {

    }
    @Test 
    public void regalaNienteListaminoredi10()
    {

    }
}
