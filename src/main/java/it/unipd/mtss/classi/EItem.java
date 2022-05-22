////////////////////////////////////////////////////////////////////
// Alberto  Angeloni    1231122
// Stefano  Destro      1229139
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.classi;

public class EItem {
    public enum  itemType {Processor,Motherboard, Mouse, Keyboard, vuoto}
    private final itemType tipo;
    private final String name;
    private final double price;
    public EItem(itemType t, String n, double p)
    {
        if(p < 0)
            throw new IllegalArgumentException("Il prezzo non puo esser negativo");
        this.tipo=t;
        this.name=n;
        this.price=p;
    }
    public String getNome(){return name;}
    public itemType getTipo(){return tipo;}
    public double getPrezzo(){return price;}
}