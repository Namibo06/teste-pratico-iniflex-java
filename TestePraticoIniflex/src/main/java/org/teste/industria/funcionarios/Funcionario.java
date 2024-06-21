package org.teste.industria.funcionarios;

import org.teste.industria.pessoas.Pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    private List<Funcionario> funcionarioList;

    public Funcionario() {

    }

    public void adicionarFuncionario(Funcionario funcionario){
        funcionarioList.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario){
        funcionarioList.remove(funcionario);
    }

    public void imprimirTodosFuncionarios(List<Funcionario> funcionarioList){
        System.out.println("Nome     | Data Nascimento    | Salário       | Função       ");
        for(Funcionario funcionario : funcionarioList){
            System.out.println(funcionario);
        }
    }


    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
