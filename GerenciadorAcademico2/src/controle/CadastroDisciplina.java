package controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modelo.Curso;
import modelo.Disciplina;
import util.DialogBoxUtils;
import util.Input;

/**
 *
 * @author Andre
 */
public class CadastroDisciplina implements ICadastro{
    private CadastroCurso cadCurso;

    public CadastroDisciplina(CadastroCurso cadCurso) {
        this.cadCurso = cadCurso;
    }

    public void menuControleDisciplina(){
        int op;
        do {
            op = MenuCadastro.selecionarOpcaoMenuCadastro("Disciplina");
            switch (op) {
                case 1 ->
                    cadastrar();
                case 2 ->
                    pesquisar();
                case 3 ->
                    alterar();
                case 4 ->
                    remover();
                case 5 ->
                    listar();
                case 0 ->
                    System.out.println("\nRetornando ao menu principal...");
                default ->
                    DialogBoxUtils.exibirMensagemDeErro("Opção inválida!", "Erro! Opção inválida!");
            }
        } while (op != 0);
    }
    
    @Override
    public void cadastrar() {
        try {
            Curso curso = cadCurso.pesquisa();
            if (curso == null) {
                DialogBoxUtils.exibirMensagem("Curso não encontrado", "Nenhum curso foi encontrado!");
                return;
            }
            Disciplina disciplina = new Disciplina();
            setarDados(disciplina);
            curso.adicionarDisciplina(disciplina);
            DialogBoxUtils.exibirMensagem("Cadastro realizado", "O cadastro realizado com sucesso!");
        } catch (Exception e) {
            DialogBoxUtils.exibirMensagemDeErro("Falha no cadastro", "Erro! falha ao cadastrar dados!\n" + e.getMessage());
        }
    }

    @Override
    public void alterar() {
        
        Disciplina disciplina = pesquisa();
        if (disciplina == null) {
            DialogBoxUtils.exibirMensagem("Disciplina não encontrado", "Nenhum disciplina foi encontrado!");
            return;
        }
        try {
            setarDados(disciplina);
            DialogBoxUtils.exibirMensagem("Cadastro alterado", "O cadastro alterado com sucesso!");
        } catch (Exception e) {
            DialogBoxUtils.exibirMensagemDeErro("Falha no cadastro", "Erro! falha ao alterar cadastro!\n" + e.getMessage());
        }
    }

    public void setarDados(Disciplina disciplina) {
        System.out.print("Nome do Disciplina: ");
        disciplina.setNome(Input.nextLine());
        System.out.print("Carga horária: ");
        disciplina.setCargaHoraria(Input.nextInt());
        System.out.print("Semestre: ");
        disciplina.setSemestre(Input.nextInt());
    }

    @Override
    public void pesquisar() {
        Curso curso = cadCurso.pesquisa();
        if (curso == null) {
            DialogBoxUtils.exibirMensagem("Curso não encontrado", "Nenhum curso foi encontrado!");
            return;
        }
        System.out.print("Informe o nome do disciplina: ");
        String nomeDisciplina = Input.nextLine().toLowerCase();
        
        ArrayList<Disciplina> result = buscarListaDisciplinas(curso, nomeDisciplina);
        if (result.isEmpty()) {
            System.out.println("Nenhuma disciplina foi encontrada !! ");
        } else {
            System.out.println("Disciplinas encontradas: ");
            listar(result);
        }
    }

    public ArrayList<Disciplina> buscarListaDisciplinas(Curso curso, String nomeDisciplina) {
        ArrayList<Disciplina> resultadoBusca = new ArrayList<>();
        for (Disciplina listaDisciplina : curso.getDisciplinas()) {
            if (listaDisciplina.getNome().toLowerCase().contains(nomeDisciplina)) {
                resultadoBusca.add(listaDisciplina);
            }
        }
        return resultadoBusca;
    }

    @Override
    public void remover() {
        Disciplina disciplina = pesquisa();
        if (disciplina == null) {
            DialogBoxUtils.exibirMensagem("Disciplina não encontrado", "Nenhum disciplina foi encontrado!");
        } else if (disciplina.getCurso().removerDisciplina(disciplina)) {
            DialogBoxUtils.exibirMensagem("Disciplina removido", "Disciplina removido com sucesso !");
        }
    }

    public Disciplina pesquisa() {
        Curso curso = cadCurso.pesquisa();
        if (curso == null) {
            DialogBoxUtils.exibirMensagem("Curso não encontrado", "Nenhum curso foi encontrado!");
            return null;
        }
        System.out.println("Informe o disciplina: ");
        String nomeDisciplina = Input.nextLine();
        return pesquisa(curso, nomeDisciplina);
    }

    public Disciplina pesquisa(Curso curso, String nomeDisciplina) {
        for (Disciplina listaDisciplina : curso.getDisciplinas()) {
            if (listaDisciplina.getNome().equalsIgnoreCase(nomeDisciplina)) {
                return listaDisciplina;
            }
        }
        return null;
    }

    @Override
    public void listar(){
        Collections.sort( cadCurso.getListaCursos());
        for (Curso cur : cadCurso.getListaCursos()) {
            System.out.println("\nCurso: "+cur.getNome());
            listar(cur.getDisciplinas());
        }
    }
    public void listar(List<Disciplina> listaDisciplinas) {
        System.out.println("Disciplinas: ");
        for (Disciplina listaDisciplina : listaDisciplinas) {
            listaDisciplina.exibirInformacoes();
        }
    }
}
