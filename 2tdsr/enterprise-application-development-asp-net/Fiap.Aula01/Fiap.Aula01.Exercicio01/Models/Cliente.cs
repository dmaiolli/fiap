namespace Fiap.Aula01.Exercicio01.Models
{
    public class Cliente
    {
        public long Id { get; set; }
        public string Nome { get; set; }
        public string Cpf { get; set; }

        public Cliente(long id, string nome)
        {
            Id = id, Nome = nome
        }
    }
}