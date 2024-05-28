package volume;

public class Volume {

    private long totalDisco;
    private long espacoDisponivel;
    private long espacoTotal;
    private Double discoEmUso;

    public String getTotalDisco() {
        return String.valueOf(totalDisco);
    }

    public void setTotalDisco(double totalDisco) {
        this.totalDisco = (long) totalDisco;
    }

    public String getEspacoDisponivel() {
        return String.valueOf(espacoDisponivel);
    }

    public void setEspacoDisponivel(double espacoDisponivel) {
        this.espacoDisponivel = (long) espacoDisponivel;
    }

    public String getEspacoTotal() {
        return String.valueOf(espacoTotal);
    }

    public void setEspacoTotal(double espacoTotal) {
        this.espacoTotal = (long) espacoTotal;
    }

    public String getDiscoEmUso() {
        return String.valueOf(discoEmUso);
    }

    public void setDiscoEmUso(Double discoEmUso) {
        this.discoEmUso = discoEmUso;
    }
}
