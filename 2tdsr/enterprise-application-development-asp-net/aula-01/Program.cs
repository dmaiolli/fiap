using System;
using aula_01.models;


namespace aula_01
{
  /*
  Atalhos: prop, cw

  Solution -> Workspace
  Project - Project
  Namespace -> Package
  using -> import
  : -> extends

  Tipos de dados(não tem primitivos, int, long, string são abreviaturas para as classes)

  Modificadores de acesso:
  public -> Todos
  private -> Somente a classe
  protected -> A classe e as classes filhas
  internal -> Mesmo projeto
  protected internal -> A classe, classes filhas e classes do mesmo projeto
  protected private -> A classe e classes filhas do mesmo projeto

  Padrões de nomenclatura:
  Métodos/Classes -> UpperCamelCase
  Atributos -> começam com _
  Propriedades -> public string Nome { get; set; }
  */
    class Program
    {
        static void Main(string[] args)
        {
          Aluno aluno = new Aluno();

          aluno.Rm = 123;
          Console.WriteLine(aluno.Rm);

          Console.WriteLine("Digite o nome do produto");
          string nome = Console.ReadLine();

          Console.WriteLine("Digite o preço");
          decimal preco = decimal.Parse(Console.ReadLine());

          Console.WriteLine("Digite q quantidade");
          int quantidade = int.Parse(Console.ReadLine());

          // produto.Nome = nome;
          // produto.Preco = preco;
          // produto.Quantidade = quantidade;

          Produto produto = new Eletronico(nome, "Hyundai"){
            Quantidade = 15,
            Preco = 16
          };

          Console.WriteLine($"Nome: { produto.Nome}, Preço: R$ { produto.Preco }, Quantidade: { produto.Quantidade }");

          // Ler o juros (10%, 5%)
          System.Console.WriteLine("Digite o juros");
          decimal juros = decimal.Parse(Console.ReadLine());
          // Atualizar o preço
          produto.AtualizarPrecoComJuros(juros);

          // Exibir o novo preço
          System.Console.WriteLine($"Novo preço: {produto.Preco}");

        }//main
    }//class
}//namespace
