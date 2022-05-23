////////////////////////////////////////////////////////////////////
// Alberto  Angeloni    1231122
// Stefano  Destro      1229139
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.business;

import java.util.Date;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.sql.Timestamp;
import java.util.List;

public class ListaOrdini{
    public int OrdiniRegalati(ArrayList<Ordine> lista)
    {
        //Collections.shuffle(lista);
        DateFormat df=new SimpleDateFormat("HH:mm");
        Date d1,d2;
        Timestamp t1,t2;
        int dim=lista.size(),k=0;
        if(lista.size()>10)
            dim=10;
        try{
            System.out.println("asdas");
            d1=df.parse("18.00");
            d2=df.parse("19.00");
            t1=new Timestamp(d1.getTime());
            t2=new Timestamp(d2.getTime());
            for(Ordine paolo : lista){
                if(dim == 0)
                    return k;
                if(paolo.getUser().getEta()<18){
                    Date m = paolo.getTime();
                    Timestamp aux = new Timestamp(m.getTime());
                    if(aux.after(t1) && aux.before(t2)){
                        dim--;
                        k++;
                        System.out.println(k);
                    }
                }
            }
        }catch(ParseException z){return k;}
        return k;
/*
            while(i != tot && dim != 0)
            {
                if(lista.get(i).getUser().getEta()<18)
                {
                    if(lista.get(i).getTime().compareTo(t1)>=0 && lista.get(i).getTime().compareTo(t2)<=0)
                    {
                        temp.add(lista.get(i));
                        dim--;
                        k++;
                    }
                }
                i++;
            }
        }
        catch(ParseException z){return k;}
    return k;
    */
    }
    
}