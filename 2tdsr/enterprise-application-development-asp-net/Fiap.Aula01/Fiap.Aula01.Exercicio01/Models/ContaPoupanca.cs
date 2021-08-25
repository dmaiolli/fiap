using Fiap.Aula01.Exercicio01.Models;
using Fiap.Aula01.Exercicio01.Exceptions;

namespace Fiap.Aula01.Exercicio01.Models
{
    public class ContaPoupanca : Conta : IContaInvestimento
    {

        public decimal Taxa { get; set; }

        public ContaPoupanca(taxa decimal, int agencia, int numero, 
            IList<Cliente> clientes) : base(agencia, numero, clientes)
        {
            Taxa = taxa;
        }
        
        public override void Retirar(decimal valor)
        {
            if(valor + Taxa > Saldo)
            {
                throw new SaldoInsuficienteException("Saldo insuficiente");
            }
            Saldo -= valor;
        }

        public decimal CalcularRetornoInvestimento() 
        {
            return Saldo * 4 / 100;
        }
        
    }
}