namespace aula_01.models
{
  class Eletronico : Produto
  {
    public string Marca { get; set; }
    public bool Garantia { get; set; }
    public double ConsumoEnergia { get; set; }

    // Construtores
    // ctor -> atalho
    // base -> chama o construtor do pai
    public Eletronico(string nome, string marca) : base(nome)
    {
      Marca = marca;
    }
    public override void AtualizarPrecoComJuros(decimal juros)
    {
      Preco += Preco * juros/100;
    }

    // Sobrescrever o método CalcularDesconto(cupom) adicionar o cupom FIAP30, com 30% de desconto
    public override decimal CalcularDesconto(string cupom)
    {
      if(cupom == "FIAP30") {
        return Preco * 0.7m;
      }
      return Preco;
    }
  }
}