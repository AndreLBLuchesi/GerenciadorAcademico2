
package modelo;

/**
 *
 * @author Andre
 */
public class MatriculaDisciplina implements IExibirInformacoes{
    private Aluno aluno;
    private Disciplina disciplina;
    private int ano;
    private int semestre;
    private double percentualFrequencia;
    private double mediaFinal;
    private String situacao;

    public MatriculaDisciplina() {
    }

    public MatriculaDisciplina(Aluno aluno, Disciplina disciplina, int ano) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.ano = ano;
        this.semestre = disciplina.getSemestre();
        this.situacao = "Em Andamento";
    }
    
    public MatriculaDisciplina(Aluno aluno, Disciplina disciplina, int ano, int semestre, double percentualFrequencia, double mediaFinal, String situacao) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.ano = ano;
        this.semestre = semestre;
        this.percentualFrequencia = percentualFrequencia;
        this.mediaFinal = mediaFinal;
        this.situacao = situacao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public double getPercentualFrequencia() {
        return percentualFrequencia;
    }

    public void setPercentualFrequencia(double percentualFrequencia) {
        this.percentualFrequencia = percentualFrequencia;
    }

    public double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public void gerarSituacaoFinal(){
        if(mediaFinal == 0 && percentualFrequencia == 0){
            situacao = "Em Andamento";
        }
        else if(percentualFrequencia >= 0.75 && mediaFinal >= 6){
            situacao = "Aprovado";
        }
        else{
             situacao = "Reprovado";
        }
    }
    @Override
    public String getInformacoes() {
        return "RA: "+ aluno.getRa() + " - Nome: " + aluno.getNome()  +"Disciplina: " + disciplina.getNome() + " | Ano matricula: " + ano + " | Situação: " + situacao;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println(getInformacoes());
    }
}
