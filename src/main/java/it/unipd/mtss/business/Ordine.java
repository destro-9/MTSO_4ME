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


}