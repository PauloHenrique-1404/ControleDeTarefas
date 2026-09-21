package controledetarefas;

import java.util.Scanner;
import java.util.ArrayList;

public class ControleDeTarefas {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ArrayList<String> tarefas = new ArrayList<>();
        ArrayList<Boolean> concluidas = new ArrayList<>();
        int opcao = 0;

        do {
            System.out.println("=============================");
            System.out.println("      Controle de Tarefas     ");
            System.out.println("=============================");
            System.out.println("[1] Cadastrar Tarefa");
            System.out.println("[2] Lista de tarefa");
            System.out.println("[3] Concluir tarefa");
            System.out.println("[4] Remover tarefa");
            System.out.println("[5] Sair");
            System.out.println(" ");
            System.out.println("=============================");

            // Validação do Menu Principal
            while (true) {
                System.out.print("Qual sua opção: ");
                String entradaMenu = entrada.nextLine();

                try {
                    opcao = Integer.parseInt(entradaMenu);
                    break; // Se for um número inteiro válido, sai do loop
                } catch (NumberFormatException e) {
                    System.out.println("Opção inválida! Digite apenas o número de uma opção.");
                    System.out.println(" ");
                }
            }

            switch (opcao) {
                case 1:
                    System.out.println("=============================");
                    System.out.println("      Cadastro de Tarefas     ");
                    System.out.println("=============================");
                    System.out.println(" ");
                    System.out.print("Nome da tarefa: ");

                    String tarefa = entrada.nextLine();
                    tarefas.add(tarefa);
                    concluidas.add(false);

                    System.out.println("Tarefa " + tarefa + " registrada com sucesso!");
                    break;

                case 2:
                    int quant = tarefas.size();

                    if (tarefas.size() == 0) {
                        System.out.println("Não temos nenhuma tarefa cadastrada.");
                    } else if (tarefas.size() == 1) {
                        System.out.println(quant + " tarefa Cadastrada:");
                        if (concluidas.get(0)) {
                            System.out.println("[X] " + tarefas.get(0));
                        } else {
                            System.out.println("[ ] " + tarefas.get(0));
                        }
                    } else {
                        System.out.println(quant + " tarefas Cadastradas");
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
                    } else {
                        System.out.println("=============================");
                        System.out.println("      Tarefas Cadastradas     ");
                        System.out.println("=============================");

                        for (int j = 0; j < tarefas.size(); j++) {
                            System.out.println((j + 1) + " - " + tarefas.get(j));
                        }

                        int tafNaoCon = 0;

                        while (true) {
                            System.out.print("Qual tarefa foi concluída: ");
                            String textoDigitado = entrada.nextLine();

                            try {
                                tafNaoCon = Integer.parseInt(textoDigitado);

                                if (tafNaoCon >= 1 && tafNaoCon <= tarefas.size()) {
                                    break;
                                } else {
                                    System.out.println("Número fora da lista! Digite uma opção entre 1 e " + tarefas.size() + ".");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Opção inválida! Digitar apenas o número da tarefa.");
                            }
                        }

                        concluidas.set(tafNaoCon - 1, true);
                        System.out.println("Tarefa " + tarefas.get(tafNaoCon - 1) + " foi concluída!");
                    }
                    break;

                case 4:
                    if (tarefas.size() == 0) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        System.out.println("=============================");
                        System.out.println("      Tarefas Cadastradas     ");
                        System.out.println("=============================");

                        for (int j = 0; j < tarefas.size(); j++) {
                            System.out.println((j + 1) + " - " + tarefas.get(j));
                        }

                        int excluirTaf = 0;

                        while (true) {
                            System.out.print("Qual tarefa gostaria de excluir: ");
                            String textoDigitado = entrada.nextLine();

                            try {
                                excluirTaf = Integer.parseInt(textoDigitado);

                                if (excluirTaf >= 1 && excluirTaf <= tarefas.size()) {
                                    break;
                                } else {
                                    System.out.println("Número fora da lista! Digite uma opção entre 1 e " + tarefas.size() + ".");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Opção inválida! Digitar apenas o número da tarefa.");
                            }
                        }

                        System.out.println("Tarefa " + tarefas.get(excluirTaf - 1) + " foi excluída!");
                        tarefas.remove(excluirTaf - 1);
                        concluidas.remove(excluirTaf - 1);
                    }
                    break;

                case 5:
                    System.out.println("Até a próxima!");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha um número entre 1 e 5.");
                    System.out.println(" ");
            }

        } while (opcao != 5);

        entrada.close();
    }
}