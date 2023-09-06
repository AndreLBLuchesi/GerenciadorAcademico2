package principal;

import controle.CadastroAluno;
import controle.CadastroCurso;
import controle.CadastroDisciplina;
import controle.CadastroFuncionario;
import controle.CadastroFuncionarioTerceirizado;
import controle.CadastroMatriculaCurso;
import controle.CadastroMatriculaDisciplina;
import controle.CadastroPessoa;
import controle.CadastroProfessor;
import controle.MenuCadastro;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Curso;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Professor;
import util.DialogBoxUtils;

/**
 *
 * @author Andre
 */
public class Main {
    static CadastroProfessor cadProfessor;
    static CadastroCurso cadCurso;
    static CadastroDisciplina cadDisciplina;
    static CadastroAluno cadAluno;
    static CadastroMatriculaCurso cadMatriculaCurso;
    static CadastroMatriculaDisciplina cadMatriculaDisciplina;
    static CadastroFuncionario cadFuncionario;
    static CadastroFuncionarioTerceirizado cadFuncionarioTercerizado;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cadProfessor =  new CadastroProfessor();
        cadCurso = new CadastroCurso(cadProfessor);
        cadDisciplina = new CadastroDisciplina(cadCurso);
        cadAluno =  new CadastroAluno();
        cadMatriculaCurso = new CadastroMatriculaCurso(cadCurso, cadAluno);
        cadAluno.setCadMatCurso(cadMatriculaCurso);
        cadFuncionario =  new CadastroFuncionario();
        cadFuncionarioTercerizado =  new CadastroFuncionarioTerceirizado();
        cadMatriculaDisciplina = new CadastroMatriculaDisciplina(cadAluno);
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
                case 8 -> cadMatriculaDisciplina.menuControleMatriculaDisciplina();
                case 0 -> {
                    System.out.println("Saindo do sistema...");
                }
                default -> DialogBoxUtils.exibirMensagemDeErro("Opção inválida!", "Erro! Opção inválida!");
            }
        } while (op != 0);
    }
    
    
    private static void gerarCadastrosDeTeste(){
        Professor coord1 = new Professor("Bacharel em Ciência da Computação", "123", 2500, "Coordenador de Curso", "Rudimar", "1111111",  LocalDate.of(1980, 1, 1), "rudimar@univel.br", new Endereco("Cascavel", "Av. Tito Muffato", "10"));
        Curso curso1 = new Curso("TADS", 2500, 6, coord1);
        cadProfessor.getListaPessoas().add(coord1);
        cadCurso.getListaCursos().add(curso1);
        
        Professor coord2 = new Professor("Bacharel em Ciências Contábeis", "12334", 2500,"Coordenador de Curso", "Edson", "22222222", LocalDate.of(1981, 1, 1) ,"", new Endereco("Cascavel", "Av. Tito Muffato", "20"));
        Curso curso2 = new Curso("Contabilidade", 2500, 6, coord2);
        cadProfessor.getListaPessoas().add(coord2);
        cadCurso.getListaCursos().add(curso2);
        
        Professor coord3 = new Professor("Odontologia", "12334", 2500, "Coordenador de Curso", "Larissa", "33333333", LocalDate.of(1982, 1, 1) ,"", new Endereco("Cascavel", "Av. Tito Muffato", "30"));
        Curso curso3 = new Curso("Odontologia", 2500, 8, coord3);
        cadProfessor.getListaPessoas().add(coord3);
        cadCurso.getListaCursos().add(curso3);
        
        Aluno alu1 = new Aluno("2222", "Pedro", "44444444", LocalDate.of(1992, 1, 1), "", new Endereco("Cascavel", "Av. Tito Muffato", "40"));
        Aluno alu2 = new Aluno("2223","Ana", "5555555", LocalDate.of(1993, 1, 1),"", new Endereco("Cascavel", "Av. Tito Muffato", "50"));
        
        Aluno alu3 = new Aluno("3322","Carlos", "6666666", LocalDate.of(1994, 1, 1), "",new Endereco("Cascavel", "Av. Tito Muffato", "60") );
        Aluno alu4 = new Aluno("3323","Vanessa", "7777777", LocalDate.of(1995, 1, 1), "",new Endereco("Cascavel", "Av. Tito Muffato", "70"));
        
        Aluno alu5 = new Aluno("4422","Mario", "8888888", LocalDate.of(1996, 1, 1), "",new Endereco("Cascavel", "Av. Tito Muffato", "80"));
        Aluno alu6 = new Aluno("4423","Julia", "9999999", LocalDate.of(1997, 1, 1),"", new Endereco("Cascavel", "Av. Tito Muffato", "90"));
        
        cadAluno.getListaPessoas().add(alu1);
        cadAluno.getListaPessoas().add(alu2);
        cadAluno.getListaPessoas().add(alu3);
        cadAluno.getListaPessoas().add(alu4);
        cadAluno.getListaPessoas().add(alu5);
        cadAluno.getListaPessoas().add(alu6);
        
        Professor prof1 = new Professor("Bacharel em Ciência da Computação", "123675884", 1500, "Docente", "André", "10101010101", LocalDate.of(1990, 1, 1) ,"", new Endereco("Cascavel", "Av. Tito Muffato", "100"));
        Professor prof2 = new Professor("Bacharel em Ciências Contábeis", "19588695", 1500,"Docente", "Joares", "12211212121212", LocalDate.of(1981, 1, 1),"", new Endereco("Cascavel", "Av. Tito Muffato", "110"));
        Professor prof3 = new Professor("Odontologia", "17364375", 1500,"Docente", "Angela", "13313131313131", LocalDate.of(1982, 1, 1),"", new Endereco("Cascavel", "Av. Tito Muffato", "120"));
        
        cadProfessor.getListaPessoas().add(prof1);
        cadProfessor.getListaPessoas().add(prof2);
        cadProfessor.getListaPessoas().add(prof3);
        
        Funcionario func1 = new Funcionario("192223456", 1200, "Zelador", "Joaquim", "1155525352532", LocalDate.of(1983, 1, 1) ,"", new Endereco("Cascavel", "Av. Tito Muffato", "150"));
        cadFuncionario.getListaPessoas().add(func1);
    }
}
