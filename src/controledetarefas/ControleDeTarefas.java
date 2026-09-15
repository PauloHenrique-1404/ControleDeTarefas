package controledetarefas;

import java.util.Scanner;
import java.util.ArrayList;

public class ControleDeTarefas {
    public static void main(String[] args) {

        Scanner entrada = new Scanner (System.in);
        ArrayList<String> tarefas = new ArrayList<>();
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

                    System.out.println("Tarefa "+tarefa+" registrada com sucesso!");
                    break;

                case 2:

                    int quant = tarefas.size();

                        if (tarefas.size() == 0) {
                            System.out.println("Não temos nenhuma tarefa cadastrada.");
                        }else if (tarefas.size() == 1){
                            System.out.println(quant+" tarefa Cadastrada:");
                            System.out.println(tarefas);
                        }else{
                            System.out.println(quant+" tarefas Cadastradas");
                            System.out.println(tarefas);
                        }
            }
        }while (opcao != 5);
    }
}
