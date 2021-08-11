using System;
using Fiap.Aula01.Exemplo02.Models;
using System.Exception;
using Fiap.Aula01.Exemplo02.Exceptions;

namespace Fiap.Aula01.Exemplo02.Repositories
{
    class EsporteRepository : IEsporteRepository
    {
        private IList<Esporte> _lista;

        public void Cadastrar(Esporte esporte)
        {
            // Validar se o esporte não é vazio
            if(esporte == null)
            {
                throw new ArgumentNullException("O esporte não pode estar vazio")
            }
            _lista.Add(esporte);
        }

        public IList<Esporte> Listar()
        {
            // Validar se a lista está null ou vazia
            if(_lista.Count == 0)
            {
                throw new EmptyListException("Não existem esportes cadastrados")
            }
            return _lista;
        }

        public EsporteRepository()
        {
            _lista = new List<Esporte>();
        }
    }
}