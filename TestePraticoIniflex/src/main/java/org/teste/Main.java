package org.teste;

import org.teste.industria.funcionarios.Funcionario;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();


        adicionar(funcionarios,"Maria",LocalDate.of(2000,10,18),BigDecimal.valueOf(2009.44),"Operador");
        adicionar(funcionarios,"João",LocalDate.of(1990,05,12),BigDecimal.valueOf(2284.38),"Operador");
        adicionar(funcionarios,"Caio",LocalDate.of(1961,05,02),BigDecimal.valueOf(9836.14),"Coordenador");
        adicionar(funcionarios,"Miguel",LocalDate.of(1988,10,14),BigDecimal.valueOf(19119.88),"Diretor");
        adicionar(funcionarios,"Alice",LocalDate.of(1995,01,05),BigDecimal.valueOf(2234.68),"Recepcionista");
        adicionar(funcionarios,"Heltor",LocalDate.of(1999,11,19),BigDecimal.valueOf(1582.72),"Operador");
        adicionar(funcionarios,"Arthur",LocalDate.of(1993,03,31),BigDecimal.valueOf(4071.84),"Contador");
        adicionar(funcionarios,"Laura",LocalDate.of(1994,07,8),BigDecimal.valueOf(3017.45),"Gerente");
        adicionar(funcionarios,"Heloísa",LocalDate.of(2003,05,24),BigDecimal.valueOf(1606.85),"Eletricista");
        adicionar(funcionarios,"Helena",LocalDate.of(1996,9,02),BigDecimal.valueOf(2799.93),"Gerente");

        Map<String,List<Funcionario>> funcionariosPorFuncao = mapearPorFuncao(funcionarios);

        removerFuncionario(funcionarios,1);
        imprimirTodos(funcionarios);

        imprimirTodosComAtualizacaoDeSalario(funcionarios);

        System.out.println(funcionariosPorFuncao);

    }

    public static void adicionar(List<Funcionario> funcionarios,String nome,LocalDate dataNascimento,BigDecimal salario,String funcao){
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setDataNascimento(dataNascimento);
        funcionario.setSalario(salario);
        funcionario.setFuncao(funcao);
        funcionarios.add(funcionario);
    }

    public static void imprimirTodos(List<Funcionario> funcionarios){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt","BR"));
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat formatterCurrency = new DecimalFormat("#,##0.00",symbols);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Nome    | Data de Nascimento     | Salário     | Função    ");
        for (Funcionario funcionario: funcionarios){
            System.out.println(funcionario.getNome()+ "        "+funcionario.getDataNascimento().format(formatter) + "            " +  formatterCurrency.format(funcionario.getSalario()) + "        " + funcionario.getFuncao());
        }
    }

    public static void imprimirTodosComAtualizacaoDeSalario(List<Funcionario> funcionarios){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt","BR"));
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat formatterCurrency = new DecimalFormat("#,##0.00",symbols);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Nome    | Data de Nascimento     | Salário     | Função    ");
        for (Funcionario funcionario: funcionarios){
            System.out.println(funcionario.getNome()+ "        "+funcionario.getDataNascimento().format(formatter) + "            " +  formatterCurrency.format(atualizarSalarios(funcionario.getSalario())) + "        " + funcionario.getFuncao());
        }
    }

    public static void removerFuncionario(List<Funcionario> funcionarios,int posicao){
        funcionarios.remove(posicao);
    }

    public static BigDecimal atualizarSalarios(BigDecimal salario){
        BigDecimal aumento = salario.multiply(new BigDecimal("0.10"));
        salario = salario.add(aumento);
        return salario;
    }

    public static Map<String,List<Funcionario>> mapearPorFuncao(List<Funcionario> listaFuncionario){
        Map<Funcionario,List<Funcionario>> funcaolistaFuncionarioMap = new HashMap<>();

        return listaFuncionario.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }
}