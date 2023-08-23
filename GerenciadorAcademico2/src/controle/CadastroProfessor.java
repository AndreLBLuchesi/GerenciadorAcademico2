package controle;

import modelo.Professor;
import util.Input;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Pessoa;
import util.DialogBoxUtils;

public class CadastroProfessor extends CadastroPessoa{

    public CadastroProfessor() {
    }
    
    public void menuProfessor() {
        super.menuControlePessoa("Professor");
    }
    
    public void setarDados(Professor prof){
        super.setarDados(prof);
        System.out.print("Formação: ");
        prof.setFormacao(Input.nextLine());
    }
    
    @Override
    public void cadastrar() {
        try {
            Professor prof = new Professor();
            setarDados(prof);
            listaPessoas.add(prof);
            DialogBoxUtils.exibirMensagem("Cadastro realizado", "O cadastro realizado com sucesso!");
        } catch (Exception e) {
            DialogBoxUtils.exibirMensagemDeErro("Falha no cadastro", "Erro! falha ao cadastrar dados!\n" + e.getMessage());
        }
    }
    
    @Override
    public void listar() {
        listar(listaDePessoaProfessores(), "Professores", true);
    }
    
    public List<Pessoa> listaDePessoaProfessores() {
        return listaPessoas.stream().filter(e -> e.getClass() == Professor.class).collect(Collectors.toList());
    }
    
    public List<Professor> listaDeProfessores() {
        return listaPessoas.stream().filter(e -> e.getClass() == Professor.class).map(a -> (Professor) a).collect(Collectors.toList());
    }

}
