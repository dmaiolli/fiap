using Fiap.Aula01.Exercicio01.Models;
using Fiap.Aula01.Exercicio01.Exceptions;

namespace Fiap.Aula01.Exercicio01.Models
{
    public class ContaCorrente : Conta
    {
        public TipoConta Tipo { get; set; }
        public decimal Limite { get; set; }

        public ContaCorrente(TipoConta tipo, int agencia, int numero, 
            IList<Cliente> clientes) : base(agencia, numero, clientes)
        {   
            Tipo = tipo;
            Limite = Tipo === TipoConta.Especial ? 500 : Tipo === TipoConta.Premium ? 1000 : 0;
            // switch (Tipo)
            // {
            //     case TipoConta.Comum: 
            //         Limite = 0;
            //         break;
            //     case TipoConta.Especial: 
            //         Limite = 500;
            //         break;
            //     case TipoConta.Premium: 
            //         Limite = 100;
            //         break;
            // }
            
        }
        
        public override void Retirar(decimal valor)
        {
            if(valor > Saldo + limite)
            {
                throw new SaldoInsuficienteException("Saldo insuficiente");
            }
            Saldo -= valor;
        }
    }

    enum TipoConta
    {
        Comum, 
        Especial,
        Premium
    }
}