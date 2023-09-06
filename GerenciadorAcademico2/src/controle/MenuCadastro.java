package controle;

import util.Input;

/**
 *
 * @author Andre
 */
public class MenuCadastro {

    public static void exibirMenuPrincipal() {
        System.out.println("\n######## Menu principal ########");
        System.out.println("| 1 - Cadastro Aluno                  |");
        System.out.println("| 2 - Cadastro Funcionário            |");
        System.out.println("| 3 - Cadastro Funcionário Tercerizado|");
        System.out.println("| 4 - Cadastro Professor              |");
        System.out.println("| 5 - Cadastro Curso                  |");
        System.out.println("| 6 - Cadastro Disciplina             |");
        System.out.println("| 7 - Matricula Curso                 |");
        System.out.println("| 8 - Matricula Disciplina            |");
        System.out.println("| 0 - SAIR                            |");
        System.out.println("##################################");
    }

    public static void exibirMenuCadastro(String cadastro) {
        System.out.println("\n######## Cadastro de " + cadastro + " ########");
        System.out.println("| 1 - Cadastrar     |");
        System.out.println("| 2 - Pesquisar     |");
        System.out.println("| 3 - Alterar       |");
        System.out.println("| 4 - Remover       |");
        System.out.println("| 5 - Listar        |");
        System.out.println("| 0 - VOLTAR        |");
        System.out.println("################################");
    }

    public static void exibirMenuMatricula(String cadastro) {
        System.out.println("\n######## Matrícula de " + cadastro + " ########");
        if (cadastro.equalsIgnoreCase("Curso")) {
            System.out.println("| 1 - Realizar Matricula      |");
            System.out.println("| 2 - Trancar Matricula       |");
            System.out.println("| 3 - Destrancar Matricula    |");
            System.out.println("| 4 - Cancelar Matricula      |");
            System.out.println("| 5 - Listar                  |");
            System.out.println("| 0 - VOLTAR                  |");
        }
        else{
            System.out.println("| 1 - Matricula Disciplina     |");
            System.out.println("| 2 - Lançar resultado final   |");
            System.out.println("| 3 - Pesquisar                |");
            System.out.println("| 4 - Listar                   |");
            System.out.println("| 0 - VOLTAR                   |");
        }

        System.out.println("################################");
    }

    public static int selecionarOpcaoMenuPrincipal() {
        exibirMenuPrincipal();
        System.out.println("digite uma das opções acima");
        System.out.print("opção: ");
        return Input.nextInt();
    }

    public static int selecionarOpcaoMenuCadastro(String cadastro) {
        exibirMenuCadastro(cadastro);
        System.out.println("digite uma das opções acima");
        System.out.print("opção: ");
        return Input.nextInt();
    }

    public static int selecionarOpcaoMenuMatricula(String cadastro) {
        exibirMenuMatricula(cadastro);
        System.out.println("digite uma das opções acima");
        System.out.print("opção: ");
        return Input.nextInt();
    }
}
