package modelo;
import java.time.LocalDate;
/**
 *
 * @author Andre
 */
public class Aluno extends Pessoa{
    protected String ra;
    protected MatriculaCurso matriculaCurso;
    
    
    public Aluno() {
        this.matriculaCurso = new MatriculaCurso();
    }

    public Aluno(String ra, String nome, String cpf, LocalDate dataNascimento, String email, Endereco endereco) {
        super(nome, cpf, dataNascimento, email, endereco);
        this.ra = ra;
         this.matriculaCurso = new MatriculaCurso();
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public MatriculaCurso getMatriculaCurso() {
        return matriculaCurso;
    }

    public void setMatriculaCurso(MatriculaCurso matriculaCurso) {
        this.matriculaCurso = matriculaCurso;
    }
    
    @Override
    public String getInformacoes() {
        String info = nome +  " | CPF: " + cpf + " | RA: " + ra + " | Idade: " + calcularIdade() + " anos | ";
        if(this.matriculaCurso != null){
            info+= "Curso: " + matriculaCurso.getCurso().getNome();
        }
        return info;
    }
    @Override
    public void exibirInformacoes(){
        System.out.println(getInformacoes());
    }
}

