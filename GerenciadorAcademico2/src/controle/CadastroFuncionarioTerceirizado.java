package controle;

import java.util.List;
import java.util.stream.Collectors;
import modelo.Funcionario;
import modelo.FuncionarioTerceirizado;
import modelo.Pessoa;
import util.DialogBoxUtils;
import util.Input;


public class CadastroFuncionarioTerceirizado extends CadastroFuncionario{

    public CadastroFuncionarioTerceirizado() {
    }
    
    public void menuFuncionarioTerceirizado() {
        super.menuControlePessoa("FuncionarioTerceirizado");
    }
    
    public void setarDados(FuncionarioTerceirizado func){
        super.cadastrar();
        System.out.println("Informe a Empresa tercerizada: ");
        func.setEmpresaTercerizada(Input.nextLine());
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
        listar(listaDePessoaFuncionarios(), "Funcionários Terceirizados", true);
    }
    
    public List<Pessoa> listaDePessoaFuncionariosTercerizados(){
        return listaPessoas.stream()
                .filter(x -> x.getClass() == FuncionarioTerceirizado.class)
                .collect(Collectors.toList());
    }
    
    public List<FuncionarioTerceirizado> listaDeFuncionariosTercerizados(){
        return listaPessoas.stream()
                .filter(x -> x.getClass() == FuncionarioTerceirizado.class)
                .map(e -> (FuncionarioTerceirizado) e)
                .collect(Collectors.toList());
    }
}

