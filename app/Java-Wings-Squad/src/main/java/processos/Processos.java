package processos;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;


import java.io.IOException;
import java.util.List;

public class Processos {
    public static void main(String[] args) {
        Looca looca = new Looca();
        ProcessoGrupo processos = looca.getGrupoDeProcessos();
        List<Processo> processo = processos.getProcessos();

        for(int i = 0; i < processo.size(); i++) {

            String nome = processo.get(i).getNome();
            Integer pid = processo.get(i).getPid();

        if(nome.equalsIgnoreCase("opera")) {

        System.out.println("Nome ===> " + nome);
        System.out.println("PID ===> " + pid);
        System.out.println("=========================");

    try {
        // Crie um ProcessBuilder com o comando para chamar o script shell
        ProcessBuilder processBuilder = new ProcessBuilder("kill.sh", pid.toString());

        // Inicie o processo
        Process process = processBuilder.start();

        // Espere pelo término do processo
        int exitCode = process.waitFor();

        // Verifique o código de saída
        if (exitCode == 0) {
            System.out.println("Script shell executado com sucesso.");
        } else {
            System.out.println("Ocorreu um erro ao executar o script shell.");
        }
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
}
}

    }


}
