////////////////////////////////////////////////////////////////////
// Alberto  Angeloni    1231122
// Stefano  Destro      1229139
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.classi;

public class User {
    private final int id;
    private final int eta;
    private final String nome;
    private final String cognome;

    public User(int id, int eta, String nome, String cognome) {
        if(id < 0) throw new IllegalArgumentException(
                "Cannot use negative value for 'id'");
        if(eta < 0) throw new IllegalArgumentException(
                "Cannot use negative value for 'eta'");
        this.id = id;
        this.eta = eta;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getId() {
        return id;
    }

    public int getEta() {
        return eta;
    }

    public String getSurname() {
        return cognome;
    }

    public String getName() {
        return nome;
    }
}
