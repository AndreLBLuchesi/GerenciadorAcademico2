package modelo;

public class Curso {
    protected String nome;
    protected int cargaHoraria;
    protected int qtdSemestres;
    protected Coordenador coordenador;
    
    //variável auxiliar 
    private int qtdAlunosCurso;
    
    public Curso() {
    }

    public Curso(String nome, int cargaHoraria, int qtdSemestres, Coordenador coordenador) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.qtdSemestres = qtdSemestres;
        this.coordenador = coordenador;
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

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public int getQtdAlunosCurso() {
        return qtdAlunosCurso;
    }

    public void setQtdAlunosCurso(int qtdAlunosCurso) {
        this.qtdAlunosCurso = qtdAlunosCurso;
    }
    
    public void exibirInformacoes(){
        System.out.println("Curso: " + nome + " | Carga horária: " + cargaHoraria + " | Quantidade semestre: " + qtdSemestres + " | Coordenador: " + coordenador.getNome() + " | Quantidade alunos: " + qtdAlunosCurso);
    }
}
