package it.unipd.mtss.classi;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void ValoriNomaliVannoAccettati(){new User(0,40,"Mario","Rossi");}
    @Test(expected=IllegalArgumentException.class)
    public void IDmaggioreDiZero(){new User(-1,33,"gesu","nazareno");}
    @Test(expected = IllegalArgumentException.class)
    public void EtaMinorediZero(){new User(2,-44, "angelo", "azzurro");}
    @Test
    public void NomeCorretto(){User u = new User(0,40,"Mario","Rossi"); assertEquals("Mario", u.getName());}
    @Test
    public void IdCorretto(){User u = new User(0,40,"Mario","Rossi"); assertEquals(0, u.getId());}
    @Test
    public void EtaCorretta(){User u = new User(0,40,"Mario","Rossi"); assertEquals(40, u.getEta());}
    @Test
    public void CognomeCorretto(){User u = new User(0,40,"Mario","Rossi"); assertEquals("Rossi", u.getSurname());}
}
