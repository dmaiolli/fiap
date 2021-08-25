using Fiap.Aula01.Exercicio01.Models;

namespace Fiap.Aula01.Exercicio01.Models
{
    public abstract class Conta
    {
        public int Agencia { get; set; }
        public int Numero { get; set; }
        public decimal Saldo { get; protected set; }
        public DateTime DataAbertura { get; set; }
        public IList<Cliente> Clientes { get; set; }

        public Conta(int agencia, int numero, IList<Cliente> clientes)
        {
            Agencia = agencia, Numero = numero, Clientes = clientes
        }

        public abstract void Depositar(decimal valor);

        public void Retirar(decimal valor) 
        {
            if(valor < 0) 
            {
                throw new ArgumentException("O valor deve ser maior do que zero")
            }
            Saldo += valor;
        }
    }
}