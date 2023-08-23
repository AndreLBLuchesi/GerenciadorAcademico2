package controle;

import java.util.List;
import java.util.stream.Collectors;
import modelo.Funcionario;
import modelo.Pessoa;
import util.DialogBoxUtils;
import util.Input;

public class CadastroFuncionario extends CadastroPessoa{

    public CadastroFuncionario() {
    }
    
    public void menuFuncionario() {
        super.menuControlePessoa("Funcionario");
    }
    
    public void setarDados(Funcionario fun) {
        super.setarDados(fun);
        System.out.print("CTPS: ");
        fun.setCtps(Input.nextLine());
        System.out.print("Salário: ");
        fun.setSalario(Input.nextDouble());
    }

    @Override
    public void cadastrar() {
        try {
            Funcionario func = new Funcionario();
            setarDados(func);
            listaPessoas.add(func);
            DialogBoxUtils.exibirMensagem("Cadastro realizado", "O cadastro realizado com sucesso!");
        } catch (Exception e) {
            DialogBoxUtils.exibirMensagemDeErro("Falha no cadastro", "Erro! falha ao cadastrar dados!\n" + e.getMessage());
        }
    }
    
    @Override
    public void listar() {
        listar(listaDePessoaFuncionarios(), "Funcionários", true);
    }
    
    public List<Pessoa> listaDePessoaFuncionarios() {
        return listaPessoas.stream().filter(e -> e.getClass() == Funcionario.class).collect(Collectors.toList());
    }
    
    public List<Funcionario> listaDeFuncionarios() {
        return listaPessoas.stream().filter(e -> e.getClass() == Funcionario.class).map(a -> (Funcionario) a).collect(Collectors.toList());
    }

}
