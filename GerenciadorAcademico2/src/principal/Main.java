package principal;

import controle.CadastroAluno;
import controle.CadastroCurso;
import controle.CadastroDisciplina;
import controle.CadastroFuncionario;
import controle.CadastroFuncionarioTerceirizado;
import controle.CadastroMatriculaCurso;
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
        CadastroProfessor cadProfessor =  new CadastroProfessor();
        CadastroCurso cadCurso = new CadastroCurso(cadProfessor);
        CadastroDisciplina cadDisciplina = new CadastroDisciplina(cadCurso);
        CadastroAluno cadAluno =  new CadastroAluno();
        CadastroMatriculaCurso cadMatriculaCurso = new CadastroMatriculaCurso(cadCurso, cadAluno);
        cadAluno.setCadMatCurso(cadMatriculaCurso);
        CadastroFuncionario cadFuncionario =  new CadastroFuncionario();
        CadastroFuncionarioTerceirizado cadFuncionarioTercerizado =  new CadastroFuncionarioTerceirizado();
        JOptionPane.getRootFrame();
        
        int op;
        do {
            op = MenuCadastro.selecionarOpcaoMenuPrincipal();
            switch (op) {
                case 1 -> cadAluno.menuAluno();
                case 2 -> cadFuncionario.menuFuncionario();
                case 3 -> cadFuncionarioTercerizado.menuFuncionarioTerceirizado(); 
                case 4 -> cadProfessor.menuProfessor();
                case 5 -> cadCurso.menuControleCurso();
                case 6 -> cadDisciplina.menuControleDisciplina();
                case 7 -> cadMatriculaCurso.menuControleMatriculaCurso();
                case 0 -> {
                    System.out.println("Saindo do sistema...");
                }
                default -> DialogBoxUtils.exibirMensagemDeErro("Opção inválida!", "Erro! Opção inválida!");
            }
        } while (op != 0);
    }
    
}
