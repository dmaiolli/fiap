
namespace Fiap.Aula01.Exemplo02.Models
{
    class Esporte
    {
        public string Nome { get; set; }
        public int Id { get; set; }
        public int QtdCompetidores { get; set; }
        public TipoEsporte Tipo { get; set; }

    }

    enum TipoEsporte
    {
        Individual, Coletivo, Dupla
    }
}
