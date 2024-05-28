package rede;

public class Rede {
    private long bytesEnviados;
    private long bytesRecebidos;

    public String getBytesEnviados() {
        return String.valueOf(bytesEnviados);
    }

    public void setBytesEnviados(long bytesEnviados) {
        this.bytesEnviados = bytesEnviados;
    }

    public String getBytesRecebidos() {
        return String.valueOf(bytesRecebidos);
    }

    public void setBytesRecebidos(long bytesRecebidos) {
        this.bytesRecebidos = bytesRecebidos;
    }
}
