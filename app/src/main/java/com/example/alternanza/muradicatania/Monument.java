package com.example.alternanza.muradicatania;

public class Monument
{
    String nome;
    String descrizione;
    String latitudine;
    String longitudine;
    int immagine;

    public Monument(String nome, String descrizione, String latitudine, String longitudine, int immagine)
    {
        this.nome = nome;
        this.descrizione = descrizione;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.immagine = immagine;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDescrizione()
    {
        return descrizione;
    }

    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }

    public String getLatitudine()
    {
        return latitudine;
    }

    public void setLatitudine(String latitudine)
    {
        this.latitudine = latitudine;
    }

    public String getLongitudine()
    {
        return longitudine;
    }

    public void setLongitudine(String longitudine)
    {
        this.longitudine = longitudine;
    }

    public int getImmagine()
    {
        return immagine;
    }

    public void setImmagine(int immagine) {
        this.immagine = immagine;
    }
}
