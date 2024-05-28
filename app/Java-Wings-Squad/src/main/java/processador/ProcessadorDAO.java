package processador;
import BancoDeDados.BancoLooca;
import org.example.Console;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProcessadorDAO {
    public void cadastrarDados(ProcessadorMetodo metodoProcessador, Console console) throws SQLException {

        String sql = "UPDATE ComputadorESpec set processadorModelo = ?, processadorNucleosFisicos = ?, processadorNucleosLógicos = ?, processadorFrequencia = ? WHERE idComputador = ?";
        String sql2 = "INSERT INTO Monitoramento (processadorUso, dataCaptura, fkComputador) VALUES (?, ?, ?)";
        String sql3 = "select idMonitoramento From Monitoramento order by idMonitoramento desc;";

        PreparedStatement ps = null;
        PreparedStatement ps3 = null;

        DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            ps = BancoLooca.getbancoLooca2().prepareStatement(sql);
            ps.setString(1, metodoProcessador.getModelo());
            ps.setString(2, metodoProcessador.getNucleosFisicos());
            ps.setString(3, metodoProcessador.getNucleosLogicos());
            ps.setString(4, metodoProcessador.getFrequencia());
            ps.setInt(5, console.getIdComputador());
            ps.execute();
            ps.close();

            ps3 = BancoLooca.getbancoLooca2().prepareStatement(sql3);

            try (ResultSet moni = ps3.executeQuery()) {
                if (moni.next()) {
                    Integer idMoni = moni.getInt("idMonitoramento");
                    console.setIdMonitoramento(idMoni);
                }
            }

            try (PreparedStatement ps2 = BancoLooca.getbancoLooca2().prepareStatement(sql2)) {

                ps2.setString(1, metodoProcessador.getUso());
                ps2.setObject(2, formatadorDeData.format(LocalDateTime.now()));
                ps2.setInt(3, console.getIdComputador());
                ps2.execute();
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao inserir dados na tabela Monitoramento", e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}