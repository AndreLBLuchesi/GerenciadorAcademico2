package controle;

import modelo.Curso;
import util.Input;
import java.util.ArrayList;
import util.DialogBoxUtils;

public class CadastroCurso {
    private ArrayList<Curso> listaCursos = new ArrayList<>();

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }
    
    public void menuControleCurso(){
        int op;
        do {
            op = MenuCadastro.selecionarOpcaoMenuCadastro("Cursos");
            switch (op) {
                case 1 ->
                    cadastrar();
                case 2 ->
                    buscar();
                case 3 ->
                    alterar();
                case 4 ->
                    remover();
                case 5 ->
                    listar(listaCursos);
                case 0 ->
                    System.out.println("\nRetornando ao menu principal...");
                default ->
                    DialogBoxUtils.exibirMensagemDeErro("Opção inválida!", "Erro! Opção inválida!");
            }
        } while (op != 0);
    }
    
    public void cadastrar() {
        try {
           Curso curso = new Curso();
            setarDados(curso);
            listaCursos.add(curso);
            DialogBoxUtils.exibirMensagem("Cadastro realizado", "O cadastro realizado com sucesso!");
        } catch (Exception e) {
            DialogBoxUtils.exibirMensagemDeErro("Falha no cadastro", "Erro! falha ao cadastrar dados!\n" + e.getMessage());
        }
    }

    public void alterar() {
        Curso curso = pesquisa();
        if (curso == null) {
            DialogBoxUtils.exibirMensagem("Pessoa não encotrada", "Nenhuma pessoa foi encontrada!");
            return;
        }
        try {
            setarDados(curso);
            DialogBoxUtils.exibirMensagem("Cadastro alterado", "O cadastro alterado com sucesso!");
        } catch (Exception e) {
            DialogBoxUtils.exibirMensagemDeErro("Falha no cadastro", "Erro! falha ao alterar cadastro!\n" + e.getMessage());
        }
    }
    
    public void setarDados(Curso curso){
        System.out.print("Nome do Curso: ");
        curso.setNome(Input.nextLine());
        System.out.print("Carga horária: ");
        curso.setCargaHoraria(Input.nextInt());
        System.out.print("Quantidade de Semestres: ");
        curso.setQtdSemestres(Input.nextInt());
    }
    
    public void buscar(){
        System.out.print("Informe o nome do curso: ");
        String nomeCurso = Input.nextLine();
        if(buscarListaCursos(nomeCurso.toLowerCase()).isEmpty()){
            System.out.println("Nenhum curso foi encontrado !! ");
        }else {
            System.out.println("Cursos encontrados: ");
            listar(buscarListaCursos(nomeCurso));
        }
    }
    
    public ArrayList<Curso> buscarListaCursos(String nomeCurso){
        ArrayList<Curso> resultadoBusca = new ArrayList<>();
        for (Curso listaCurso : listaCursos){
            if(listaCurso.getNome().toLowerCase().contains(nomeCurso)){
                resultadoBusca.add(listaCurso);
            }
        }
        return resultadoBusca;
    }
    
    public void remover(){
        Curso curso = pesquisa();

        if (curso == null) {
            DialogBoxUtils.exibirMensagem("Curso não encotrado", "Nenhum curso foi encontrado!");
        } else if(listaCursos.remove(curso)) {
            DialogBoxUtils.exibirMensagem("Curso removido", "Curso removido com sucesso !");
        }
    }
    
    public Curso pesquisa(){
        System.out.println("Informe o curso: ");
        String nomeCurso = Input.nextLine();
        return pesquisa(nomeCurso);
    }
    
    public Curso pesquisa(String nomeCurso){
        for (Curso listaCurso : listaCursos){
            if(listaCurso.getNome().equalsIgnoreCase(nomeCurso)){
                return listaCurso;
            }
        }
        return null;
    }
    
    public void listar(ArrayList<Curso> listaCursos){
        System.out.println("Cursos: ");
        for(Curso listaCurso: listaCursos){
            listaCurso.exibirInformacoes();
        }
    }
}
