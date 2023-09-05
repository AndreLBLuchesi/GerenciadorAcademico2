package modelo;

import java.util.ArrayList;
import java.util.List;

public class Curso implements Comparable<Curso>, IExibirInformacoes {

    private String nome;
    private int cargaHoraria;
    private int qtdSemestres;
    private Professor coordenador;
    private List<Disciplina> disciplinas;

    //variável auxiliar 
    private int qtdAlunosCurso;

    public Curso() {
        this.disciplinas = new ArrayList<>();
    }

    public Curso(String nome, int cargaHoraria, int qtdSemestres, Professor coordenador) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.qtdSemestres = qtdSemestres;
        this.coordenador = coordenador;
        this.disciplinas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getQtdSemestres() {
        return qtdSemestres;
    }

    public void setQtdSemestres(int qtdSemestres) {
        this.qtdSemestres = qtdSemestres;
    }

    public Professor getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Professor coordenador) {
        this.coordenador = coordenador;
    }

    public int getQtdAlunosCurso() {
        return qtdAlunosCurso;
    }

    public void setQtdAlunosCurso(int qtdAlunosCurso) {
        this.qtdAlunosCurso = qtdAlunosCurso;
    }
    
    public void IncrementarQtdAlunosCurso(){
        this.qtdAlunosCurso++;
    }
    
    public void decrementarQtdAlunosCurso(){
        this.qtdAlunosCurso--;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void adicionarDisciplina(Disciplina disc) {
        disc.setCurso(this);
        this.disciplinas.add(disc);
    }

    public boolean removerDisciplina(Disciplina disc) {
        disc.setCurso(null);
        return this.disciplinas.remove(disc);
    }

    @Override
    public String getInformacoes() {
        return "Curso: " + nome + " | Carga horária: " + cargaHoraria + " | Quantidade semestre: " + qtdSemestres + " | Coordenador: " + coordenador.getNome() + " | Quantidade alunos: " + qtdAlunosCurso;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println(getInformacoes());
    }

    @Override
    public int compareTo(Curso o) {
        return this.nome.compareToIgnoreCase(o.getNome());
    }
}
