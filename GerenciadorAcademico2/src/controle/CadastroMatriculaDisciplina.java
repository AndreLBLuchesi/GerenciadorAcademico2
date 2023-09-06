package controle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import modelo.Aluno;
import modelo.Disciplina;
import modelo.MatriculaCurso;
import modelo.MatriculaDisciplina;
import util.DialogBoxUtils;
import util.Input;

/**
 *
 * @author Andre
 */
public class CadastroMatriculaDisciplina {
    private CadastroAluno cadAluno;
    private List<MatriculaDisciplina> matriculas;

    public CadastroMatriculaDisciplina(CadastroAluno cadAluno) {
        this.cadAluno = cadAluno;
        this.matriculas = new ArrayList<>();
    }

    public List<MatriculaDisciplina> getMatriculas() {
        return matriculas;
    }
    
    public void menuControleMatriculaDisciplina(){
        int op;
        do {
            op = MenuCadastro.selecionarOpcaoMenuMatricula("Disciplina");
            switch (op) {
                case 1 ->
                    realizarMatriculaDisciplina();
                case 2 ->
                    lancarResultadoFinal();
                case 3 ->
                    pesquisar();
                case 4 ->
                    listar();
                case 0 ->
                    System.out.println("\nRetornando ao menu principal...");
                default ->
                    DialogBoxUtils.exibirMensagemDeErro("Opção inválida!", "Erro! Opção inválida!");
            }
        } while (op != 0);
    }
    
    public void realizarMatriculaDisciplina() {
        Aluno al = (Aluno) cadAluno.pesquisa(cadAluno.listaDePessoaAlunos());
        if (al == null) {
            DialogBoxUtils.exibirMensagem("Aluno não encontrado", "Nenhum aluno foi encontrado!");
            return;
        }
        if(al.getMatriculaCurso() != null || al.getMatriculaCurso().getCurso() == null || al.getMatriculaCurso().getCurso().getNome().isBlank() ){
            DialogBoxUtils.exibirMensagem("Aluno sem Curso", "O Aluno não está matriculado em um curso!");
            return;
        }
        if(!al.getMatriculaCurso().getSituacao().equalsIgnoreCase("Em Andamento")){
            DialogBoxUtils.exibirMensagem("Aluno Matricula suspensa", "A matrícula do aluno está inativa!");
            return;
        }
        Disciplina disc = selecionarDisciplina(al.getMatriculaCurso());
        if(disc == null){
            return;
        }
        
        MatriculaDisciplina matricula = new MatriculaDisciplina(al, disc, LocalDate.now().getYear());
        matriculas.add(matricula);
    }
    
    private void exibirDisciplinasCurso(MatriculaCurso matCurso){
        int i = 1;
        System.out.println("\nLista de Disciplinas do Curso");
        for (Disciplina disciplina : matCurso.getCurso().getDisciplinas()) {
            System.out.println(i+" - "+disciplina.getNome());
        }
    }
    
    private Disciplina selecionarDisciplina(MatriculaCurso matCurso){
        exibirDisciplinasCurso(matCurso);
        System.out.println("\ninforme o número da disciplina que deseja matricular:");
        int pos = Input.nextInt();
        if( pos < 1 || pos > matCurso.getCurso().getDisciplinas().size()){
            DialogBoxUtils.exibirMensagem("Número inválido", "O número da disciplina informada é inválido!");
            return null;
        }
        return matCurso.getCurso().getDisciplinas().get((pos-1));
    }
    
    public void lancarResultadoFinal(){
        Aluno al = (Aluno) cadAluno.pesquisa(cadAluno.listaDePessoaAlunos());
        if (al == null) {
            DialogBoxUtils.exibirMensagem("Aluno não encontrado", "Nenhum aluno foi encontrado!");
            return;
        }
        if(al.getMatriculaCurso() != null || al.getMatriculaCurso().getCurso() == null || al.getMatriculaCurso().getCurso().getNome().isBlank() ){
            DialogBoxUtils.exibirMensagem("Aluno sem Curso", "O Aluno não está matriculado em um curso!");
            return;
        }
        
        Disciplina disc = selecionarDisciplina(al.getMatriculaCurso());
        if(disc == null){
            return;
        }
        
        MatriculaDisciplina matricula = pesquisarMatriculaDisciplina(al, disc);
        if (matricula == null) {
            DialogBoxUtils.exibirMensagem("Matrícula Disciplina não encontrada", "Nenhuma Matrícula de Disciplina foi encontrada!");
            return;
        }
        
        System.out.println("\nInforme o percentual de frequência [0 a 1]:");
        matricula.setPercentualFrequencia(Input.nextDouble());
        System.out.println("Informe a média Final:");
        matricula.setPercentualFrequencia(Input.nextDouble());
        matricula.gerarSituacaoFinal();
    }
    
    public MatriculaDisciplina pesquisarMatriculaDisciplina(Aluno al, Disciplina disc){
         Optional<MatriculaDisciplina> result = matriculas.stream().filter(x -> x.getAluno().getCpf().equals(al.getCpf()) && 
                                x.getDisciplina().getNome().equalsIgnoreCase(disc.getNome())).findFirst();
         
         return result.isPresent()? result.get() : null;
    }
    
    public List<MatriculaDisciplina> pesquisarMatriculasDisciplinaPorAluno(Aluno al){
         return matriculas.stream().filter(x -> x.getAluno().getCpf().equals(al.getCpf())).collect(Collectors.toList());
    }
    
    public void pesquisar(){
        Aluno al = (Aluno) cadAluno.pesquisa(cadAluno.listaDePessoaAlunos());
        if (al == null) {
            DialogBoxUtils.exibirMensagem("Aluno não encontrado", "Nenhum aluno foi encontrado!");
            return;
        }
        listar(pesquisarMatriculasDisciplinaPorAluno(al));
    }
    
    public void listar() {
        listar(matriculas);
    }
    
    public void listar(List<MatriculaDisciplina> matriculas) {
        System.out.println("Matriculas Disciplinas: ");
        for (MatriculaDisciplina matri : matriculas) {
            matri.exibirInformacoes();
        }
    }
}
