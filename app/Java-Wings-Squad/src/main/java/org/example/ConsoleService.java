//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import com.github.britooo.looca.api.core.Looca;
import processos.ProcessosLocal;
import rede.RedeService;
import volume.VolumeService;
import processador.ProcessadorService;
import ram.RamService;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ConsoleService {
    public ConsoleService() {
    }

    public static void main(String[] args) {

        Console console = new Console();
        String usuario = null;
        String senha = null;
        Scanner in = new Scanner(System.in);

        new Timer();
        if (console.getUser() == null && console.getPassword() == null) {

            System.out.println("""
                     /* ╔═════════════════════════════════════════╗ */
                     /* ║                                         ║ */
                     /* ║   ░█▀▀▄░█▀▀░█▄█░░░█░█░▀█▀░█▀█░█▀▄░█▀█   ║ */
                     /* ║   ░█▀▀▄░█▀▀░█░█░░░█ █░░█░░█░█░█░█░█░█   ║ */
                     /* ║   ░▀▀▀░░▀▀▀░▀░▀░░░░▀░░▀▀▀░▀░▀░▀▀░░▀▀▀   ║ */
                     /* ║                                         ║ */
                     /* ║    ░░░░█░█░█▀▀░█░█░█▀█░█▀▄░▀█▀░█▀█      ║ */
                     /* ║    ░░░░█░█░▀▀█░█░█░█▀█░█▀▄░░█░░█░█      ║ */
                     /* ║    ░░░░▀▀▀░▀▀▀░▀▀▀░▀░▀░▀░▀░▀▀▀░▀▀▀      ║ */
                     /* ║                                         ║ */
                     /* ╚═════════════════════════════════════════╝ */
                    """);

            System.out.println("""
                    ═══════════════════════════════════════════════════
                    """);

            System.out.println("""
                    /* ╔══════════════════════════╗ */
                    /* ║   ░█░░░█▀█░█▀▀░▀█▀░█▀█   ║ */
                    /* ║   ░█░░░█░█░█░█░░█░░█░█   ║ */
                    /* ║   ░▀▀▀░▀▀▀░▀▀▀░▀▀▀░▀░▀   ║ */
                    /* ╚══════════════════════════╝
                    /* ╔══════════════════════════╗ */ 
                    /* ║ E-mail:                  ║ */""");

            usuario = in.nextLine();
            System.out.println("""
                    /* ╔══════════════════════════╗ */ 
                    /* ║  Senha:                  ║ */""");
            senha = in.nextLine();
            System.out.println("""
                    /* ╚══════════════════════════╝ */""");

        }
        console.setUser(usuario);
        console.setPassword(senha);
        new ConsoleDAO().login(console);

        if (!console.getEntrou()) {
            System.out.println("""
                    /* ╔═════════════════════════════════════════╗ */
                    /* ║                                         ║ */
                    /* ║                  ERRO                   ║ */
                    /* ║     LOGIN INVALIDO, TENTE NOVAMENTE     ║ */
                    /* ║                                         ║ */
                    /* ╚═════════════════════════════════════════╝ */
                      """);

        } else {
            System.out.println("""
                    /* ╔═════════════════════════════════════════╗ */
                    /* ║                                         ║ */
                    /* ║                 LOGADO                  ║ */
                    /* ║        LOGIN REALIZADO COM SUCESSO      ║ */
                    /* ║                                         ║ */
                    /* ╚═════════════════════════════════════════╝ */
                      """);
            Boolean executar = true;
            while (executar) {
                System.out.println("""
                                            
                         /* ╔═════════════════════════════════════╗ */
                         /* ║    Oque deseja realizar, %s    ║ */
                         /* ║═════════════════════════════════════║ */
                         /* ║   1 - Coletar Dados                 ║ */
                         /* ║   2 - Encerrar Processos            ║ */
                         /* ║   3 - Sair                          ║ */
                         /* ║═════════════════════════════════════║ */
                         /* ║  Digite uma opção:                  ║ */
                         /* ╚═════════════════════════════════════╝ */
                        """.formatted(console.getNome()));

                switch (in.nextInt()) {
                    case 1:
                        System.out.println("""
                                 /* ╔═════════════════════════════════════╗ */
                                 /* ║    Oque deseja realizar, %s    ║ */
                                 /* ║═════════════════════════════════════║ */
                                 /* ║   1 - Iniciar Coleta de Dados       ║ */
                                 /* ║   2 - Parar                         ║ */
                                 /* ║═════════════════════════════════════║ */
                                 /* ║  Digite uma opção:                  ║ */
                                 /* ╚═════════════════════════════════════╝ */
                                """.formatted(console.getNome()));

                        Scanner escolhaScanner = new Scanner(System.in);
                        Timer timer = new Timer();
                        boolean executar02 = true;


                        while (executar02) {
                            int escolha = escolhaScanner.nextInt();

                            if (escolha == 1) {
                                System.out.println("""
                                         /* ╔═════════════════════════════════════╗ */
                                         /* ║   2 - Parar                         ║ */
                                         /* ║═════════════════════════════════════║ */
                                         /* ║  Digite a opção:                    ║ */
                                         /* ╚═════════════════════════════════════╝ */
                                        """);
                                Console finalConsole = console;

                                TimerTask tarefa = new TimerTask() {
                                    Integer contagem = 0;

                                    public void run() {
                                        contagem++;
                                        System.out.println("Executando tarefa... Contagem: " + contagem);

                                        VolumeService.coletarDadosDisco(finalConsole);
                                        try {
                                            ProcessadorService.coletaDeProcessador(finalConsole);
                                        } catch (SQLException ex) {
                                            throw new RuntimeException(ex);
                                        }
                                        RamService.coletaDeRam(finalConsole);
                                        RedeService.coletaRede(finalConsole);


                                    }
                                };
                                timer.scheduleAtFixedRate(tarefa, 0, 1000L);
                            }
                            if (escolha == 2) {
                                timer.cancel();
                                executar02 = false;
                                System.out.println("""
                                         /* ╔═════════════════════════════════════════╗ */
                                         /* ║                                         ║ */
                                         /* ║        COLETA DE DADOS CANCELADA        ║ */
                                         /* ║                                         ║ */
                                         /* ╚═════════════════════════════════════════╝ */
                                        """);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("""
                                         /* ╔═════════════════════════════════════════╗ */
                                         /* ║                                         ║ */
                                         /* ║          ENCERRANDO PROCESSOS...        ║ */
                                         /* ║                                         ║ */
                                         /* ╚═════════════════════════════════════════╝ */
                                        """);
                        ProcessosLocal.EncerrarProcessos();
                        executar = true;
                        break;
                    case 3:
                        executar = false;
                        System.out.println("""
                                 /* ╔═════════════════════════════════════════╗ */
                                 /* ║                                         ║ */
                                 /* ║                  ADEUS                  ║ */
                                 /* ║                                         ║ */
                                 /* ╚═════════════════════════════════════════╝ */
                                """.formatted(console.getUser()));
                    break;
                }
            }
        }
    }
}