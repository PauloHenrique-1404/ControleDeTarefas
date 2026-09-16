package controledetarefas;

import java.util.Scanner;
import java.util.ArrayList;

public class ControleDeTarefas {
    public static void main(String[] args) {

        Scanner entrada = new Scanner (System.in);
        ArrayList<String> tarefas = new ArrayList<>();
        ArrayList<Boolean> concluidas = new ArrayList<>();
        int opcao;

        do {
            System.out.println("=============================");
            System.out.println("     Controle de Tarefas     ");
            System.out.println("=============================");
            System.out.println("[1] Cadastrar Tarefa");
            System.out.println("[2] Lista de tarefa");
            System.out.println("[3] Concluir tarefa");
            System.out.println("[4] Remover tarefa");
            System.out.println("[5] Sair");
            System.out.println(" ");
            System.out.println("=============================");
            System.out.print("Qual sua opção: ");

            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("=============================");
                    System.out.println("     Cadastro de Tarefas     ");
                    System.out.println("=============================");
                    System.out.println(" ");
                    entrada.nextLine();
                    System.out.print("Nome da tarefa: ");

                    String tarefa = entrada.nextLine();
                    tarefas.add(tarefa);
                    concluidas.add(false);

                    System.out.println("Tarefa "+tarefa+" registrada com sucesso!");
                    break;

                case 2:
                    int quant = tarefas.size();
                    int i = 0;

                        if (tarefas.size() == 0) {
                            System.out.println("Não temos nenhuma tarefa cadastrada.");

                        }else if (tarefas.size() == 1){
                            System.out.println(quant+" tarefa Cadastrada:");

                            if (concluidas.get(i)) {
                                System.out.println("[X] " + tarefas.get(i));
                            } else {
                                System.out.println("[ ] " + tarefas.get(i));
                            }

                        }else{
                            System.out.println(quant+" tarefas Cadastradas");
                            for (int j = 0; j < tarefas.size(); j++) {
                                if (concluidas.get(j)) {
                                    System.out.println("[X] " + tarefas.get(j));
                                } else {
                                    System.out.println("[ ] " + tarefas.get(j));
                                }
                            }
                        }
                    break;

                case 3:

                    if (tarefas.size() == 0) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    }else {

                        System.out.println("=============================");
                        System.out.println("     Tarefas Cadastradas     ");
                        System.out.println("=============================");

                        for (int j = 0; j < tarefas.size(); j++) {
                            System.out.println((j + 1) + " - " + tarefas.get(j));
                        }

                        System.out.print("Qual tarefa foi concluida:");

                        int tafNaoCon = entrada.nextInt();

                        while (tafNaoCon > tarefas.size() || tafNaoCon <= 0) {
                            System.out.println("Opção invalida");

                            System.out.print("Qual tarefa foi concluida:");

                            tafNaoCon = entrada.nextInt();
                        }

                        concluidas.set(tafNaoCon - 1, true);

                        System.out.println("Tarefa " + tarefas.get(tafNaoCon - 1) + " foi concluido!");
                    }
                    break;

                case 4:
                    if (tarefas.size() == 0){
                        System.out.println("Nenhuma tarefa cadastrada.");
                    }else {

                        System.out.println("=============================");
                        System.out.println("     Tarefas Cadastradas     ");
                        System.out.println("=============================");

                        for (int j = 0; j < tarefas.size(); j++) {
                            System.out.println((j + 1) + " - " + tarefas.get(j));
                        }

                        System.out.print("Qual tarefa gostaria de excluir:");

                        int excluirTaf = entrada.nextInt();

                        while (excluirTaf > tarefas.size() || excluirTaf <= 0) {
                            System.out.println("Opção invalida");

                            System.out.print("Qual tarefa gostaria de excluir:");

                            excluirTaf = entrada.nextInt();
                        }

                        System.out.println("Tarefa "+tarefas.get(excluirTaf - 1)+" foi excluida!");

                        tarefas.remove(excluirTaf-1);
                        concluidas.remove(excluirTaf-1);
                    }
                    break;
                case 5:
                    System.out.println("Até a proxima!");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        }while (opcao != 5);
    }
}
