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
    ArrayList<Ordine> orderlist;//list

    @Before
    public void inizializzacose()
    {
      DateFormat df= new SimpleDateFormat("HH:mm");
      try{
          d1=df.parse("12.00");//date12
          d2=df.parse("18.30");//date18
          d3=df.parse("20.00");//date20
      }  
      catch(ParseException e){}
      ordine=new ArrayList<EItem>();
    }
    @Test
    public void regalaTuttoListamaggioredi10()
    {
        orderlist = new ArrayList<Ordine>();
        orderlist.add(new Ordine(new User(0, 14, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(1, 14, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(2, 14, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(3, 14, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Keyboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(4, 15, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Keyboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(5, 15, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Keyboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(6, 15, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Processor, "M1", 25.6))));
        orderlist.add(new Ordine(new User(7, 11, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Processor, "M1", 25.6))));
        orderlist.add(new Ordine(new User(8, 17, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Mouse, "M1", 25.6))));
        orderlist.add(new Ordine(new User(9, 16, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Mouse, "M1", 25.6))));
        orderlist.add(new Ordine(new User(10, 16, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Mouse, "M1", 25.6))));
        L = new ListaOrdini();
        int i = L.OrdiniRegalati(orderlist);
        assertEquals(10, i);
    }
    @Test
    public void regalaNienteListamaggioredi10()
    {
        orderlist = new ArrayList<Ordine>();
        orderlist.add(new Ordine(new User(0, 14, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(1, 14, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(2, 14, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(3, 14, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Keyboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(4, 15, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Keyboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(5, 15, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Keyboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(6, 15, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Processor, "M1", 25.6))));
        orderlist.add(new Ordine(new User(7, 11, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Processor, "M1", 25.6))));
        orderlist.add(new Ordine(new User(8, 17, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Mouse, "M1", 25.6))));
        orderlist.add(new Ordine(new User(9, 16, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Mouse, "M1", 25.6))));
        orderlist.add(new Ordine(new User(10, 16, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Mouse, "M1", 25.6))));
        L = new ListaOrdini();
        assertEquals(10, L.OrdiniRegalati(orderlist));
    }
    @Test
    public void regalaTuttoListaminoredi10()
    {
        orderlist = new ArrayList<Ordine>();
        orderlist.add(new Ordine(new User(0, 14, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(1, 14, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(2, 14, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        L = new ListaOrdini();
        assertEquals(3, L.OrdiniRegalati(orderlist));
    }
    @Test 
    public void regalaNienteListaminoredi10()
    {
        orderlist = new ArrayList<Ordine>();
        orderlist.add(new Ordine(new User(0, 14, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(1, 14, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(2, 14, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        L = new ListaOrdini();
        assertEquals(0, L.OrdiniRegalati(orderlist));
    }
    @Test
    public void regalaOrdiniCorretti(){
        orderlist = new ArrayList<Ordine>();
        orderlist.add(new Ordine(new User(0, 14, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(1, 14, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(2, 14, "nome", "cognome"),d3 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(3, 14, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Keyboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(4, 15, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Keyboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(5, 15, "nome", "cognome"),d3 , ordine=Arrays.asList(new EItem(itemType.Keyboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(6, 15, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Processor, "M1", 25.6))));
        orderlist.add(new Ordine(new User(7, 11, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Processor, "M1", 25.6))));
        orderlist.add(new Ordine(new User(8, 17, "nome", "cognome"),d3 , ordine=Arrays.asList(new EItem(itemType.Mouse, "M1", 25.6))));
        orderlist.add(new Ordine(new User(9, 16, "nome", "cognome"),d1 , ordine=Arrays.asList(new EItem(itemType.Mouse, "M1", 25.6))));
        orderlist.add(new Ordine(new User(10, 16, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Mouse, "M1", 25.6))));
        orderlist.add(new Ordine(new User(11, 19, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Motherboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(12, 20, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Keyboard, "M1", 25.6))));
        orderlist.add(new Ordine(new User(13, 90, "nome", "cognome"),d2 , ordine=Arrays.asList(new EItem(itemType.Processor, "M1", 25.6))));
        orderlist.add(new Ordine(new User(14, 91, "nome", "cognome"),d3 , ordine=Arrays.asList(new EItem(itemType.Mouse, "M1", 25.6))));
        L = new ListaOrdini();
        assertEquals(4, L.OrdiniRegalati(orderlist));
    }
}
