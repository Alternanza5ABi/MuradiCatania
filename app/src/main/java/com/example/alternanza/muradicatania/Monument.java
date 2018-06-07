package com.example.alternanza.muradicatania;

public class Monument
{
    private String nome;
    private String descrizione;
    private String latitudine;
    private String longitudine;
    private int immagine;

    public Monument(String nome, String descrizione, String latitudine, String longitudine, int immagine)
    {
        this.nome = nome;
        this.descrizione = descrizione;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.immagine = immagine;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getLatitudine() {
        return latitudine;
    }

    public String getLongitudine() {
        return longitudine;
    }

    public int getImmagine() {
        return immagine;
    }
}
