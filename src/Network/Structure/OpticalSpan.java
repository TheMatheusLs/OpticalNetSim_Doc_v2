package Network.Structure;

import java.util.ArrayList;
import java.util.List;

public class OpticalSpan {
    
    private int spanID;
    private OpticalFiber opticalFiber;
    private OpticalAmplifier opticalAmplifier;
    private int numberOfSlots;
    private double totalPower;      //Potência total na entrada do amplificador.
    private double[] powers;   // Lista de potências de cada slot de frequencia.
    
    public OpticalSpan(final int spanID, final int numberOfSlots, final OpticalFiber opticalFiber, final OpticalAmplifier opticalAmplifier) {
        this.spanID = spanID;
        this.numberOfSlots = numberOfSlots;
        this.opticalFiber = opticalFiber;
        this.opticalAmplifier = opticalAmplifier;

        this.inicializePowersInSpan(numberOfSlots);
    }


    /**
     * Método para inicializar a lista de potência da fibra óptica do Span.
     * 
     * @param numberOfSlots
     */
    private void inicializePowersInSpan(final int numberOfSlots) {
        this.powers = new double[numberOfSlots];    	
    	for(int i = 0;i < numberOfSlots; i++){    		
    		this.powers[i] = 0.0;
    	}    	
    	this.totalPower = 0.0;
    }


    /**
     * Método para remover a potência de um determinado slot da fibra.
     * 
     * @param slot
     */
    public void deallocate(int slot) {
        this.deallocateTotalPower(slot);
		this.powers[slot] = 0.0;
    }


    /**
     * Método para remover a potência de um determinado slot na potência total da fibra do Span.
     * 
     * @param slot
     */
    public void deallocateTotalPower(final int slot){
		this.totalPower -= this.powers[slot];
	}


    public int getSpanID() {
        return this.spanID;
    }


    public void setSpanID(int spanID) {
        this.spanID = spanID;
    }


    public OpticalAmplifier getOpticalAmplifier() {
		return this.opticalAmplifier;
	}
}