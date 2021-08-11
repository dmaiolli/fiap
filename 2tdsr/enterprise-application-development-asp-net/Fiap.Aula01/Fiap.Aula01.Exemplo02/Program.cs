using System;
using Fiap.Aula01.Exemplo02.Models;
using Fiap.Aula01.Exemplo02.Repositories;
using Fiap.Aula01.Exemplo02.Exceptions;

namespace Fiap.Aula01.Exemplo02
{
    class Program
    {
        static void Main(string[] args)
        {
            Esporte esporte = new Esporte();

            esporte.Tipo = TipoEsporte.Individual;

            if(esporte.Tipo == TipoEsporte.Individual)
            {
                System.Console.WriteLine("O esporte é individual");
            }

            System.Console.WriteLine($"O esporte é do tipo {esporte.Tipo}");

            IEsporteRepository repository = new EsporteRepository();
            int opcao;

            do
            {
                switch (opcao)
                {
                    case 1:
                    // 1 - Cadastrar esporte
                        System.Console.WriteLine("Digite o ID");
                        int id = int.Parse(Console.ReadLine());
                        
                        System.Console.WriteLine("Digite o Nome");
                        string nome = Console.ReadLine();

                        System.Console.WriteLine("Digite a quantidade de competidores");
                        int qtd = int.Parse(Console.ReadLine());

                        System.Console.WriteLine("Digite o tipo de esporte(individual, coletivo, dupla)");                        
                        // Ler uma String e transformar em um dos valores do enum: .Parse(Enum, String, IgnoreCase)
                        TipoEsporte tipo = (TipoEsporte) Enum.Parse(typeof(TipoEsporte), Console.ReaLine(), true);
                        
                        Esporte cadastro = new Esporte()
                        {
                            Id = id, Nome = nome, QtdCompetidores = qtd, Tipo = tipo
                        };

                        repository.Cadastrar(cadastro);

                        break;
                    case 2:
                        try
                        {
                            // 2 - Recuperar os esportes e exibir os dados
                            var lista = repository.Listar();

                            foreach (var item in lista)
                            {
                                System.Console.WriteLine($"Nome: ${item.Nome}");
                                System.Console.WriteLine($"Qtd: ${item.QtdCompetidores}");
                                System.Console.WriteLine($"Esporte: ${item.Tipo}");
                                System.Console.WriteLine($"ID: ${item.Id}");
                            }
                        }
                        catch (EmptyListException e)
                        {
                            System.Console.WriteLine(e.Message);
                            throw;
                        }
                        break;
                    case 0:
                        System.Console.WriteLine("Obrigado! Finalizando o sistema");
                        break;
                    default:
                        System.Console.WriteLine("Opção inválida");
                        break;
                }
                System.Console.WriteLine("Escolha: \n1-Cadastrar \n2-Listar \n3-Sair");
                opcao = int.Parse(Console.ReadLine());

            } while(opcao != 0)

        }
    }
}
