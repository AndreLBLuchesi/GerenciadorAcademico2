package modelo;

import java.time.LocalDate;

public class FuncionarioTerceirizado extends Funcionario{
    private String EmpresaTercerizada;

    public FuncionarioTerceirizado() {
    }

    public FuncionarioTerceirizado(String EmpresaTercerizada, String ctps, double salario, String cargo, String nome, String cpf, LocalDate dataNascimento, String email, Endereco endereco) {
        super(ctps, salario, cargo, nome, cpf, dataNascimento, email, endereco);
        this.EmpresaTercerizada = EmpresaTercerizada;
    }

    public String getEmpresaTercerizada() {
        return EmpresaTercerizada;
    }

    public void setEmpresaTercerizada(String EmpresaTercerizada) {
        this.EmpresaTercerizada = EmpresaTercerizada;
    }
    
    
}
