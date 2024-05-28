package processador;

import java.time.LocalDateTime;

public class ProcessadorMetodo {

    private String modelo;
    private Integer nucleosFisicos;
    private Integer nucleosLogicos;
    private long frequencia;
    private Double uso;

    private LocalDateTime tempo;

    private Integer fkUser;
    private Integer idComp;
    private Integer fkEmp;

    public Integer getFkEmp() {
        return fkEmp;
    }

    public void setFkEmp(Integer fkEmp) {
        this.fkEmp = fkEmp;
    }

    public Integer getFkUser() {
        return fkUser;
    }

    public void setFkUser(Integer fkUser) {
        this.fkUser = fkUser;
    }

    public Integer getIdComp() {
        return idComp;
    }

    public void setIdComp(Integer idComp) {
        this.idComp = idComp;
    }

    public ProcessadorMetodo() {
        this.tempo = LocalDateTime.now();
    }

    public LocalDateTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalDateTime tempo) {
        this.tempo = tempo;
    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNucleosFisicos() {
        return String.valueOf(nucleosFisicos);
    }

    public void setNucleosFisicos(Integer nucleosFisicos) {
        this.nucleosFisicos = nucleosFisicos;
    }

    public String getNucleosLogicos() {
        return String.valueOf(nucleosLogicos);
    }

    public void setNuclSeosLogicos(Integer nucleosLogicos) {
        this.nucleosLogicos = nucleosLogicos;
    }

    public String getFrequencia() {
        return String.valueOf(frequencia);
    }

    public void setFrequencia(long frequencia) {
        this.frequencia = frequencia;
    }

    public String getUso() {
        return String.valueOf(uso);
    }

    public void setUso(Double uso) {
        this.uso = uso;
    }

}
