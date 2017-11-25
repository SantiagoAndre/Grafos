/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

/**
 *
 * @author santiago
 */
public  class Arista implements Comparable{
    private NodoGrafoPonderado nodoInicial;
    private NodoGrafoPonderado nodoFinal;
    private Integer ponderacion;
    
    public Arista(NodoGrafoPonderado nodoInicial,NodoGrafoPonderado nodoFinal,Integer ponderacion) { 
        setNodoInicial(nodoInicial);
        setNodoFinal(nodoFinal);
        setPonderacion(ponderacion);
    }
    public Arista(NodoGrafoPonderado nodoInicial,NodoGrafoPonderado nodoFinal) { 
        setNodoInicial(nodoInicial);
        setNodoFinal(nodoFinal);
        setPonderacion(-1);
    }
    
    public NodoGrafoPonderado getNodoInicial() {
        return nodoInicial;
    }
    public void setNodoInicial(NodoGrafoPonderado nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    public NodoGrafoPonderado getNodoFinal() {
        return nodoFinal;
    }

    public void setNodoFinal(NodoGrafoPonderado nodoFinal) {
        this.nodoFinal = nodoFinal;
    }

    public Integer getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(int ponderacion) {
        this.ponderacion = ponderacion;
    }
    
    @Override
    public String toString(){
        return "("+getNodoInicial().getDato()+","+getNodoFinal().getDato()+","+getPonderacion()+")";
    }

    public String toString2(){// NO MUESTRA EL NODO INICIAL
        return "("+getNodoInicial().getDato()+","+getNodoFinal().getDato()+","+getPonderacion()+")";
    }


    @Override
    public int compareTo(Object o) {
        Arista a = (Arista) o;                
        int comparacion = getNodoInicial().compareTo(a.getNodoInicial());
        if(comparacion !=0)
            return comparacion;
        
        comparacion = getNodoFinal().compareTo(a.getNodoFinal());
        if(comparacion==0)
            return getPonderacion().compareTo(a.getPonderacion());
        return comparacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Arista a = (Arista) obj;
        if( a.getPonderacion()!=-1 && getPonderacion() !=-1){
            if(!getPonderacion().equals(a.getPonderacion()))
                return false;
        }
        return getNodoInicial().equals(a.getNodoInicial()) && getNodoFinal().equals(a.getNodoFinal());
    }
    public Arista invertir(){
        return new Arista(getNodoFinal(),getNodoInicial(),getPonderacion());
    }

    
}
