////////////////////////////////////////////////////////////////////
// Alberto  Angeloni    1231122
// Stefano  Destro      1229139
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.classi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {
    @Test(expected = IllegalArgumentException.class)
    public void PrezzoMinoreDiZero(){new EItem(EItem.itemType.Processor, "I7"  , -3.0);}
    @Test
    public void OggettoValido(){new EItem(EItem.itemType.Processor, "I7"  , 45.50);}
    @Test
    public void RitornaNomeCorretto(){EItem e=new EItem(EItem.itemType.Processor, "I7"  , 45.50); assertEquals("I7", e.getNome());}
    @Test
    public void RitornaTipoCorretto(){EItem e=new EItem(EItem.itemType.Processor, "I7"  , 45.50); assertEquals(EItem.itemType.Processor, e.getTipo());}
    @Test
    public void RitornaPrezzoCorretto(){EItem e=new EItem(EItem.itemType.Processor, "I7"  , 45.50); assertEquals(45.50, e.getPrezzo(),0.001);}
}
