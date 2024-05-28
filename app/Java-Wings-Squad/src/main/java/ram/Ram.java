package ram;

public class Ram {

    private double disponivel;
    private double memoriaTotal;
    private double memoriaUtilizada;
    private double ramEmUso;

    public String getDisponivel() {
        return String.valueOf(disponivel);
    }

    public void setDisponivel(double disponivel) {
        this.disponivel = disponivel;
    }

    public String getMemoriaTotal() {
        return String.valueOf(memoriaTotal);
    }

    public void setMemoriaTotal(double memoriaTotal) {
        this.memoriaTotal = memoriaTotal;
    }

    public String getMemoriaUtilizada() {
        return String.valueOf(memoriaUtilizada);
    }

    public void setMemoriaUtilizada(double memoriaUtilizada) {
        this.memoriaUtilizada = memoriaUtilizada;
    }

    public String getRamEmUso() {
        return String.valueOf(ramEmUso);
    }

    public void setRamEmUso(double ramEmUso) {
        this.ramEmUso = ramEmUso;
    }
}
