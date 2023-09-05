package modelo;

import java.time.LocalDate;

/**
 *
 * @author Andre
 */
public class MatriculaCurso implements IExibirInformacoes{
    private int ano;
    private LocalDate dataMatricula;
    private String situacao;
    private Aluno aluno;
    private Curso curso;

    public MatriculaCurso() {
    }

    public MatriculaCurso(int ano, LocalDate dataMatricula, String situacao, Aluno aluno, Curso curso) {
        this.ano = ano;
        this.dataMatricula = dataMatricula;
        this.situacao = situacao;
        this.aluno = aluno;
        this.curso = curso;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String getInformacoes() {
        return "Curso: " + curso.getNome() + " | Ano matricula: " + ano + " | Situação: " + situacao;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println(getInformacoes());
    }
    
    
}
