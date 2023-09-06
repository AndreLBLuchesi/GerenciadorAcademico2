package controle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.Aluno;
import modelo.Curso;
import modelo.MatriculaCurso;
import util.DialogBoxUtils;
import util.Input;

/**
 *
 * @author Andre
 */
public class CadastroMatriculaCurso {

    private CadastroCurso cadCurso;
    private CadastroAluno cadAluno;
    private List<MatriculaCurso> matriculas;

    public CadastroMatriculaCurso(CadastroCurso cadCurso, CadastroAluno cadAluno) {
        this.cadCurso = cadCurso;
        this.cadAluno = cadAluno;
        this.matriculas = new ArrayList<>();
    }

    public List<MatriculaCurso> getMatriculas() {
        return matriculas;
    }

    public void menuControleMatriculaCurso(){
        int op;
        do {
            op = MenuCadastro.selecionarOpcaoMenuMatricula("Curso");
            switch (op) {
                case 1 ->
                    realizarMatriculaCurso();
                case 2 ->
                    trancarMatriculaCurso();
                case 3 ->
                    destrancarMatriculaCurso();
                case 4 ->
                    cancelarMatriculaCurso();
                case 5 ->
                    listar();
                case 0 ->
                    System.out.println("\nRetornando ao menu principal...");
                default ->
                    DialogBoxUtils.exibirMensagemDeErro("Opção inválida!", "Erro! Opção inválida!");
            }
        } while (op != 0);
    }
    
    public void realizarMatriculaCurso() {
        Aluno al = (Aluno) cadAluno.pesquisa(cadAluno.listaDePessoaAlunos());
        if (al == null) {
            DialogBoxUtils.exibirMensagem("Aluno não encontrado", "Nenhum aluno foi encontrado!");
            return;
        }
        realizarMatriculaCurso(al);
    }
    
    public void realizarMatriculaCurso(Aluno al) {
        Curso cursoPesquisa;
        do {
            cursoPesquisa = cadCurso.pesquisa();

            if (cursoPesquisa == null) {
                if (DialogBoxUtils.exibirCaixaConfirmacao("Curso não encontrado!", "Curso não encontrado! \nDeseja pesquisar novamente?") == 1) {
                    return;
                }
            } else {
                MatriculaCurso matricula = new MatriculaCurso();
                al.setMatriculaCurso(matricula);
                cursoPesquisa.IncrementarQtdAlunosCurso();
                matricula.setAluno(al);
                matricula.setCurso(cursoPesquisa);
                matricula.setAno(LocalDate.now().getYear());
                matricula.setDataMatricula(LocalDate.now());
                matricula.setSituacao("Em Andamento");
                matriculas.add(matricula);
            }
        } while (cursoPesquisa == null);

    }

    public void trancarMatriculaCurso() {
        MatriculaCurso matricula = pesquisa();
        if(matricula == null){
            DialogBoxUtils.exibirMensagem("Matrícula não encontrada", "Nenhuma matrícula foi encontrada!");
            return;
        }
        matricula.setSituacao("Trancado");
        matricula.getCurso().decrementarQtdAlunosCurso();
    }
    
    public void destrancarMatriculaCurso() {
        MatriculaCurso matricula = pesquisa();
        if(matricula == null){
            DialogBoxUtils.exibirMensagem("Matrícula não encontrada", "Nenhuma matrícula foi encontrada!");
            return;
        }
        matricula.setSituacao("Em Andamento");
        matricula.getCurso().IncrementarQtdAlunosCurso();
    }
    
    public void cancelarMatriculaCurso() {
        MatriculaCurso matricula = pesquisa();
        if(matricula == null){
            DialogBoxUtils.exibirMensagem("Matrícula não encontrada", "Nenhuma matrícula foi encontrada!");
            return;
        }
        if(matricula.getSituacao().equalsIgnoreCase("Em Andamento")){
            matricula.getCurso().decrementarQtdAlunosCurso();
        }
        matricula.setSituacao("Cancelado");
    }

    public ArrayList<MatriculaCurso> buscarListaMatriculas(String dadoBusca) {
        dadoBusca = dadoBusca.toLowerCase();
        ArrayList<MatriculaCurso> resultadoBusca = new ArrayList<>();
        for (MatriculaCurso matri : matriculas) {
            if (matri.getAluno().getNome().toLowerCase().contains(dadoBusca)
                    || matri.getAluno().getCpf().contains(dadoBusca)) {
                resultadoBusca.add(matri);
            }
        }
        return resultadoBusca;
    }

    public void remover() {
        MatriculaCurso matri = pesquisa();

        if (matri == null) {
            DialogBoxUtils.exibirMensagem("Curso não encotrado", "Nenhum curso foi encontrado!");
        } else if (matriculas.remove(matri)) {
            DialogBoxUtils.exibirMensagem("Curso removido", "Curso removido com sucesso !");
        }
    }

    public MatriculaCurso pesquisa() {
        System.out.println("Informe o CPF do aluno: ");
        String cpfAluno = Input.nextLine();
        return pesquisa(cpfAluno);
    }

    public MatriculaCurso pesquisa(String cpfAluno) {
        for (MatriculaCurso matri : matriculas) {
            if (matri.getAluno().getNome().equalsIgnoreCase(cpfAluno)) {
                return matri;
            }
        }
        return null;
    }

    public void listar() {
        System.out.println("Matriculas: ");
        for (MatriculaCurso matri : matriculas) {
            matri.exibirInformacoes();
        }
    }
}
