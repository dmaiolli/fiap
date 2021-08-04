namespace aula_01.models
{
  // Classe abstrata -> não pode ser instanciaeda e PODE ter métodos abstratos, sem implementação
  abstract class Produto
  {
    // Propriedades
    // prop - atalho get/set de forma reduzida
    // propfull - atalho get/set de forma completa
    public string Nome { get; set; }
    public decimal Preco { get; set; }
    public int Quantidade { get; set; }

    //  Métodos
    public void Vender()
    {
      Quantidade--;
    }

    public decimal CalcularDesconto()
    {
      return Preco * 0.95m; //m define o tipo como decimal
    }

    // Sobrecarga (overload) de métodos: método com mesmo nome e parâmetros diferentes
    public decimal CalcularDesconto(decimal porcentagem)
    {
      return Preco - Preco * porcentagem / 100;
    }

    public decimal CalcularDesconto(decimal porcentagem) => Preco - Preco * porcentagem / 100;


    public virtual decimal CalcularDesconto(string cupom)
    {
      // O cupom FIAP50 da 50% de desconto
      if (cupom == "FIAP50")
      {
        return Preco * 0.5m;
      }
      return Preco;
    }



    // Método abstrato, sem implementação
    public abstract void AtualizarPrecoComJuros(decimal juros);

    // Construtor
    public Produto(string nome)
    {
      Nome = nome;
    }
  }
}