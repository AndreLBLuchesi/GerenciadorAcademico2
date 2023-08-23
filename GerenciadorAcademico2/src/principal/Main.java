package principal;

import controle.CadastroAluno;
import controle.CadastroCoordenador;
import controle.CadastroCurso;
import controle.CadastroFuncionario;
import controle.CadastroFuncionarioTerceirizado;
import controle.CadastroPessoa;
import controle.CadastroProfessor;
import controle.MenuCadastro;
import javax.swing.JOptionPane;
import util.DialogBoxUtils;

/**
 *
 * @author Andre
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CadastroCurso cadCurso = new CadastroCurso();
        CadastroAluno cadAluno =  new CadastroAluno(cadCurso);
        CadastroProfessor cadProfessor =  new CadastroProfessor();
        CadastroCoordenador cadCoordenador =  new CadastroCoordenador(cadCurso);
        CadastroFuncionario cadFuncionario =  new CadastroFuncionario();
        CadastroFuncionarioTerceirizado cadFuncionarioTercerizado =  new CadastroFuncionarioTerceirizado();
        JOptionPane.getRootFrame();
        //gerarCadastrosDeTeste();
        int op;
        do {
            op = MenuCadastro.selecionarOpcaoMenuPrincipal();
            switch (op) {
                case 1 -> cadAluno.menuAluno();
                case 2 -> cadFuncionario.menuFuncionario();
                case 3 -> cadProfessor.menuProfessor();
                case 4 -> cadCoordenador.menuCoordenador();
                case 5 -> cadCurso.menuControleCurso();
                case 6 -> cadFuncionarioTercerizado.menuFuncionarioTerceirizado();
                case 0 -> {
                    System.out.println("Saindo do sistema...");
                }
                default -> DialogBoxUtils.exibirMensagemDeErro("Opção inválida!", "Erro! Opção inválida!");
            }
        } while (op != 0);
    }
    
}
