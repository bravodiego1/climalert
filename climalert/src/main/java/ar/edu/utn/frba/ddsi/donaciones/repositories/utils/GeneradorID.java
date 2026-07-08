package ar.edu.utn.frba.ddsi.donaciones.repositories.utils;

public class GeneradorID {
    private long siguienteId;

    public GeneradorID(){
        this(1L);
    }
    public GeneradorID(Long valorInicial){
        this.siguienteId = valorInicial;
    }

    public long siguiente(){
        return siguienteId++;
    }
}
