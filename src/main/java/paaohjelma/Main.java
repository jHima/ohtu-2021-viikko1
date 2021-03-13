package paaohjelma;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static void main(String[] args) {
    	
    	Varasto isoVarasto = new Varasto(20, -5);
    	System.out.println(isoVarasto.getTilavuus());
    	System.out.println(isoVarasto.getSaldo());
    	System.out.println(isoVarasto.toString());
    	
    	Varasto varasto = new Varasto(10);
    	varasto.lisaaVarastoon(6);
        String vastaus = varasto.toString();
        System.out.println(vastaus);


    }
}
