package controle;

import modelo.Aluno;
import modelo.Curso;
import util.Input;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Pessoa;

import util.DialogBoxUtils;

public class CadastroAluno extends CadastroPessoa implements ICadastro{
    
    private CadastroMatriculaCurso cadMatCurso;

    public CadastroAluno() {
    }

    
    public CadastroAluno(CadastroMatriculaCurso cadCurso) {
        this.cadMatCurso = cadCurso;
    }

    public CadastroMatriculaCurso getCadMatCurso() {
        return cadMatCurso;
    }

    public void setCadMatCurso(CadastroMatriculaCurso cadMatCurso) {
        this.cadMatCurso = cadMatCurso;
    }
    
    public void menuAluno() {
        super.menuControlePessoa("Aluno");
    }

    public void setarDados(Aluno aluno) {
        super.setarDados(aluno);
        System.out.print("RA: ");
        aluno.setRa(Input.nextLine());

        int op = DialogBoxUtils.exibirCaixaConfirmacao("Matricula curso", "Deseja realizar a matrícula em um curso? ");
        if (op == 0) {
            cadMatCurso.realizarMatriculaCurso(aluno);
        }
    }
    
    @Override
    public void cadastrar() {
        try {
            Aluno al = new Aluno();
            setarDados(al);
            listaPessoas.add(al);
            DialogBoxUtils.exibirMensagem("Cadastro realizado", "O cadastro realizado com sucesso!");
        } catch (Exception e) {
            DialogBoxUtils.exibirMensagemDeErro("Falha no cadastro", "Erro! falha ao cadastrar dados!\n" + e.getMessage());
        }
    }

    @Override
   public void listar() {
        listar(listaDePessoaAlunos(), "Alunos", true);
    }
    
    protected String escolhaSituacao() {
        do {
            System.out.println("\n1 - Em andamento\n2 - Concluido\n3 - Trancada\n4 - Desistente");
            System.out.print("R: ");
            int op = Input.nextInt();
            switch (op) {
                case 1 -> {
                    return "Em andamento";
                }
                case 2 -> {
                    return "Concluido";
                }
                case 3 -> {
                    return "Trancada";
                }
                case 4 -> {
                    return "Desistente";
                }
                default -> {
                    System.out.println("\nValor inválido !!\n");
                }
            }
        } while (true);
    }

    public List<Pessoa> listaDePessoaAlunos() {
        return listaPessoas.stream().filter(e -> e.getClass() == Aluno.class).collect(Collectors.toList());
    }
    
    public List<Aluno> listaDeAlunos() {
        return listaPessoas.stream().filter(e -> e.getClass() == Aluno.class).map(a -> (Aluno) a).collect(Collectors.toList());
    }

//    public int qtdAlunosCurso(Curso curso) {
//        int contAlunos = 0;
//
//        for (Aluno al : listaDeAlunos()) {
//            if (al.getSituacao().equals("Em andamento") && curso.equals(al.getMatriculaCurso())) {
//                contAlunos++;
//            }
//        }
//        return contAlunos;
//    }
}
