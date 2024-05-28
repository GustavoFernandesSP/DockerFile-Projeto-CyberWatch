package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Console {

// LOGIN
    private String user;
    private String password;
    private Boolean entrou = false;

// IDSa
    private String nome;
    private Integer idUser = 0;
    private Integer idEmpresa = 0;
    private Integer idComputador = 0;
    private Integer idMonitoramento = 0;

    private LocalDateTime tempo;

    public Console() {
        this.tempo = LocalDateTime.now();
    }

    public LocalDateTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalDateTime tempo) {
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEntrou() {
        return entrou;
    }

    public void setEntrou(Boolean entrou) {
        this.entrou = entrou;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(Integer idComputador) {
        this.idComputador = idComputador;
    }

    public Integer getIdMonitoramento() {
        return idMonitoramento;
    }

    public void setIdMonitoramento(Integer idMonitoramento) {
        this.idMonitoramento = idMonitoramento;
    }
}
