package controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modelo.Pessoa;
import util.DialogBoxUtils;
import util.Input;

public abstract class CadastroPessoa implements ICadastro{

    protected ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    public ArrayList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }
    
    @Override
    public abstract void cadastrar(); 

    protected void menuControlePessoa(String entidadeModelo) {
        int op;
        do {
            op = MenuCadastro.selecionarOpcaoMenuCadastro(entidadeModelo);
            switch (op) {
                case 1 -> cadastrar();
                case 2 -> pesquisar();
                case 3 -> alterar();
                case 4 -> remover();
                case 5 -> listar();
                case 0 ->
                    System.out.println("\nRetornando ao menu principal...");
                default ->
                    DialogBoxUtils.exibirMensagemDeErro("Opção inválida!", "Erro! Opção inválida!");
            }
        } while (op != 0);
    }
    

    @Override
    public void alterar() {
        Pessoa pessoa = pesquisa();
        if (pessoa == null) {
            DialogBoxUtils.exibirMensagem("Pessoa não encontrada", "Nenhuma pessoa foi encontrada!");
            return;
        }
        try {
            setarDados(pessoa);
            DialogBoxUtils.exibirMensagem("Cadastro alterado", "O cadastro alterado com sucesso!");
        } catch (Exception e) {
            DialogBoxUtils.exibirMensagemDeErro("Falha no cadastro", "Erro! falha ao alterar cadastro!\n" + e.getMessage());
        }
    }

    protected void setarDados(Pessoa pessoa) {
        System.out.print("Nome: ");
        pessoa.setNome(Input.nextLine());
        System.out.print("CPF: ");
        pessoa.setCpf(Input.nextLine());
        System.out.print("Data de nascimento: ");
        pessoa.setDataNascimento(Input.nextLocalDate());
        CadastroEndereco.setarDadosEndereco(pessoa.getEndereco());
    }

    public Pessoa pesquisa() {
        System.out.println("Informe o Cpf: ");
        String dadoBusca = Input.nextLine();
        return pesquisa(listaPessoas, dadoBusca.toLowerCase());
    }

    public Pessoa pesquisa(ArrayList<Pessoa> listaPessoas, String dadoBusca) {
        for (Pessoa listaPessoa : listaPessoas) {
            if (listaPessoa.getNome().toLowerCase().equals(dadoBusca) || listaPessoa.getCpf().equals(dadoBusca)) {
                return listaPessoa;
            }
        }
        return null;
    }

    @Override
    public void pesquisar() {
        List<Pessoa> resultado = pesquisaContains(listaPessoas);

        if (resultado.isEmpty()) {
            DialogBoxUtils.exibirMensagem("Pessoa não encotrada", "Nenhuma pessoa foi encontrada!");
        } else {
            listar(resultado, "Pessoas", false);
        }
    }

    public List<Pessoa> pesquisaContains(List<Pessoa> pessoas) {
        System.out.println("Informe o nome ou cpf: ");
        String dadoBusca = Input.nextLine();
        return pesquisaContains(pessoas, dadoBusca.toLowerCase());
    }

    protected ArrayList<Pessoa> pesquisaContains(List<Pessoa> listaPessoas, String dadoBusca) {
        ArrayList<Pessoa> resultado = new ArrayList<>();
        for (Pessoa listaPessoa : listaPessoas) {
            if (listaPessoa.getNome().toLowerCase().contains(dadoBusca) || listaPessoa.getCpf().contains(dadoBusca)) {
                resultado.add(listaPessoa);
            }
        }
        return resultado;
    }

    @Override
    public void remover() {
        Pessoa pessoa = pesquisa();
        if (pessoa == null) {
            DialogBoxUtils.exibirMensagem("Pessoa não encontrada", "Nenhuma pessoa foi encontrada!");
        } else if (listaPessoas.remove(pessoa)) {
            DialogBoxUtils.exibirMensagem("Pessoa removida", "Pessoa removida com sucesso !");
        }
    }

    @Override
    public void listar() {
        listar(listaPessoas, "Pessoas", true);
    }

    protected void listar(List<Pessoa> listaPessoas, String entidadeModelo, boolean exibirMenuLista) {
        int resp = 1;
        if (exibirMenuLista) {
            resp = menuListar();
        }
        switch (resp) {
            case 1 ->
                ordenarLista(listaPessoas, true);
            case 2 ->
                ordenarLista(listaPessoas, false);
            default ->
                System.out.println("\nEscolha Inválida !!\n");
        }
        if (listaPessoas.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }
        System.out.println("\n--------Lista de " + entidadeModelo + "---------");
        for (Pessoa p : listaPessoas) {
            p.exibirInformacoes();
        }
        System.out.println("Total de registros: " + listaPessoas.size() + "\n");
    }

    protected int menuListar() {
        System.out.println("Informe a forma de ordenação");
        System.out.println("\n1 - Crescente \n2 - Decrescente");
        System.out.print("opção: ");
        return Input.nextInt();
    }

    protected void ordenarLista(ArrayList<Pessoa> lista, int ordem) {
        switch (ordem) {
            case 1 ->
                ordenarLista(lista, true);
            case 2 ->
                ordenarLista(lista, false);
            default ->
                System.out.println("\nEscolha Inválida !!\n");
        }
    }

    public void ordenarLista(List<Pessoa> lista, boolean ordemCrescente) {
        if (ordemCrescente) {
            Collections.sort(lista);
        } else {
            Collections.sort(lista, Collections.reverseOrder());
        }
    }

}
