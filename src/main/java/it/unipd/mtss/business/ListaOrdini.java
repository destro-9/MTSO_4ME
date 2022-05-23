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
    public List<Ordine> OrdiniRegalati(List<Ordine> lista)
    {
        Collections.shuffle(lista);
        DateFormat df=new SimpleDateFormat("HH:mm");
        Date d1,d2;
        Timestamp t1,t2;
        List<Ordine> temp=new ArrayList<>();
        int dim=0;
        if(lista.size()<10)  dim=lista.size();
        else dim=10;
        try{
            d1=df.parse("18.00");
            d2=df.parse("19.00");
            t1=new Timestamp(d1.getTime());
            t2=new Timestamp(d2.getTime());

            for(int i=0; i<dim; i++)
            {
                if(lista.get(i).getUser().getEta()<18)
                {
                    if(lista.get(i).getTime().compareTo(t1)>=0 && lista.get(i).getTime().compareTo(t2)<=0)
                    {
                        temp.add(lista.get(i));
                    }
                }
            }
        }
        catch(ParseException z){return temp;}
        return temp;
    }
}