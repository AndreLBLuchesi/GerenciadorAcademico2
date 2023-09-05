package modelo;

/**
 *
 * @author Andre
 */
public class Disciplina implements Comparable<Disciplina>, IExibirInformacoes  {
    private String nome;
    private int cargaHoraria;
    private int semestre;
    private Curso curso;

    public Disciplina() {
        curso = new Curso();
    }

    public Disciplina(String nome, int cargaHoraria, int semestre, Curso curso) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.semestre = semestre;
        this.curso = curso;
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

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    @Override
    public String getInformacoes() {
        return "Disciplina: " + nome + " | Carga horária: " + cargaHoraria + " |  semestre: " + semestre;
    }
    
    @Override
    public void exibirInformacoes(){
        System.out.println(getInformacoes() );
    }

    @Override
    public int compareTo(Disciplina o) {
        return this.nome.compareToIgnoreCase(o.getNome());
    }
}
