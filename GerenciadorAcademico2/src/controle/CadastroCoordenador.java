package controle;

import modelo.Coordenador;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Curso;
import modelo.Pessoa;
import util.DialogBoxUtils;

public class CadastroCoordenador extends CadastroProfessor{
    
    private CadastroCurso cadCurso;

    public CadastroCoordenador(CadastroCurso cadCurso) {
        this.cadCurso = cadCurso;
    }
    
    public void menuCoordenador() {
        super.menuControlePessoa("Coordenador");
    }
    
    public void setarDados(Coordenador coord){
        super.setarDados(coord);
        Curso curso = cadCurso.pesquisa();
        if(curso == null){
            DialogBoxUtils.exibirMensagem("Curso não encontrado", "Nenhum curso foi encontrado!");
            return;
        }
        
        curso.setCoordenador(coord);
    }
    
    @Override
    public void cadastrar() {
        try {
            Coordenador coord = new Coordenador();
            setarDados(coord);
            listaPessoas.add(coord);
            DialogBoxUtils.exibirMensagem("Cadastro realizado", "O cadastro realizado com sucesso!");
        } catch (Exception e) {
            DialogBoxUtils.exibirMensagemDeErro("Falha no cadastro", "Erro! falha ao cadastrar dados!\n" + e.getMessage());
        }
    }

    @Override
   public void listar() {
        listar(listaDePessoasCoordenadores(), "Coordenadores", true);
    }
    public List<Pessoa> listaDePessoasCoordenadores() {
        return listaPessoas.stream().filter(e -> e.getClass() == Coordenador.class).map(a -> (Coordenador) a).collect(Collectors.toList());
    }
    
    public List<Coordenador> listaDeCoordenadores() {
        return listaPessoas.stream().filter(e -> e.getClass() == Coordenador.class).map(a -> (Coordenador) a).collect(Collectors.toList());
    }
    
}
