////////////////////////////////////////////////////////////////////
// Alberto  Angeloni    1231122
// Stefano  Destro      1229139
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.classi;

import it.unipd.mtss.exception.OggettoNonTrovato;
import it.unipd.mtss.exception.SgarroOrdine;
import java.util.List;

public interface Interfaccia {

    double getPrezzoOrdine(List<EItem> robaOrdinata, User user) 
        throws OggettoNonTrovato, SgarroOrdine;
}
