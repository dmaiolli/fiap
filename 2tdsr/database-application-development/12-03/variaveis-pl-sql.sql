/*CONCEITOS GERAIS QUE PODEM SER VISTOS NO ARQUIVO DE 
  APRESENTAÇÃO:
PL-SQL é uma linguagem procedural, proprietária Oracle que estende o SQL. 
em termos de construção de Programas
É compilada dentro do Banco de Dados Oracle gerando uma  economia fantástica de 
tempo de execução e do poder da utilização do Hardware do 
Database para processar as informações.
É uma linguagem completa pois além de executar comandos SQL 
dentro de seus blocos, também cria e  manipula variáveis, 
constantes, coleções, cursores, stored procedures, functions,
triggers, pacotes, estruturas IF, CASE,LOOP,FOR, WHILE, 
trata exceções, etc. 
Tem como grande vantagem, além de sua capacidade de manipulação 
de imensas quantidades de dados, o fato que esses não precisam 
transitar pela rede quando se utiliza PL-SQL
Pode ainda receber chamadas diretas de outras linguagens para 
executar procedures, etc.

/*TODO BLOCO PL-SQL inicia no minimo com BEGIN e termina com END;
Pode também possuir uma área de declaração DECLARE para declarar
váriáveis,constantes,cursores,tipos,etc. e uma área de exceção 
EXCEPTION para tratar os erros e exceções previstas no programa. 
ATENÇÃO: Declarações só podem ser feitas na área de declare, 
         NUNCA no bloco begin...end;*/


--Eliminado a tabela Cliente caso exista
DROP TABLE CLIENTE CASCADE CONSTRAINTS;


-- Criando a tabela cliente
CREATE TABLE CLIENTE(ID_CLIENTE NUMBER(5) PRIMARY KEY,
NOME_CLI VARCHAR2(20) NOT NULL);
-------------------------------------------------------------

/* Inserindo cliente com um bloco PL-SQL. Notem que estamos usando PL-SQL 
   pois temos no bloco BEGIN  e para fechar END; */

BEGIN
    /* & = Requer um input */
  INSERT INTO CLIENTE VALUES(&NUMERO_CLIENTE,'&NOME_CLIENTE');
  COMMIT;
  
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
  DBMS_OUTPUT.PUT_LINE('CLIENTE JÁ CADASTRADO');
  
END;

/* Aqui o que é novo para vocês?
1) O uso de insert dentro de um bloco PL-SQL
2) A variável de substituição & que automaticamente cria uma
   janela para receber um valor. Se a envolvermos junto com
   com o nome com aspas simples, recebe caracteres. Senão
   recebe valores. Então Atenção!
   Ah, mas você não disse que variáveis só podem ser declaradas
   na área de Declare?
   Sim, mas essa é uma variável de substituição que armazena 
   inserido na janela ao invés do valor literal.
   ATENÇÃO:Se você usar & ou && a frente de um nome o compilador
           entenderá que você quer abrir uma janela, mesmo se
           você colocar dentro de comentários. 
3) EXCEPTION
   Área de tratamento de êrros ou exceções. 
   Sempre WHEN <EXCEÇÃO> THEN 
   Há outras formas de tratar exceções que aprenderemos
   durante o curso.

4) DBMS_OUTPUT..... É uma procedure oracle utilizada para 
   diversas funções. No caso estamos utilizando 
   DBMS_OUTPUT.PUT_LINE(.....) onde PUT_LINE é a função para
   imprimir o conteúdo dentro do parênteses na tela.
 
------------------------------------------------------------------------

/* VAMOS CONSTRUIR UM EXEMPLO SIMPLES PASSO A PASSO */
/* OBJETIVO DO EXERCICIO: Selecionar um determinado cliente e apresentar
  número e nome  */

/* declarando variáveis normalmente! */
SET SERVEROUTPUT ON

DECLARE

  v_cliente number(5);  -- aqui declaramos as duas variáveis
  v_nome varchar2(15);  -- necessárias para receber os valores
                        -- selecionados 
BEGIN
   SELECT ID_CLIENTE,NOME_CLIENTE INTO V_CLIENTE,V_NOME
   FROM CLIENTE WHERE ID_CLIENTE=&DIGITE_NUMERO;

   DBMS_OUTPUT.PUT_LINE('NUMERO:'||V_CLIENTE || '   '  || 'NOME:'||V_NOME);

EXCEPTION   
  WHEN NO_DATA_FOUND THEN
  DBMS_OUTPUT.PUT_LINE('CLIENTE NÃO ENCONTRADO');

END;  

/* utilizando %type para herdar tipo e tamanho dos campos */ 
SET SERVEROUTPUT ON

DECLARE
  v_cliente cliente.id_cliente%type;
  v_nome cliente.nome_cliente%type;

BEGIN
   SELECT ID_CLIENTE,NOME_CLIENTE INTO V_CLIENTE,V_NOME
   FROM CLIENTE WHERE ID_CLIENTE=&DIGITE_NUMERO;

   DBMS_OUTPUT.PUT_LINE('NUMERO:'||V_CLIENTE || '   '  || 'NOME:'||V_NOME);

EXCEPTION   
  WHEN NO_DATA_FOUND THEN
  DBMS_OUTPUT.PUT_LINE('CLIENTE NÃO ENCONTRADO');

END;  
-------------------------------------------------------------------------
/* utilizando %rowtype para herdar tipo e tamanho dos campos */ 
SET SERVEROUTPUT ON

DECLARE

  v_cliente_todos_campos cliente%rowtype;

BEGIN
   SELECT * INTO V_CLIENTE_TODOS_CAMPOS
   FROM CLIENTE WHERE ID_CLIENTE=&DIGITE_NUMERO;

   DBMS_OUTPUT.PUT_LINE('NUMERO:'||V_CLIENTE_TODOS_CAMPOS.id_cliente 
   || '   '  || 'NOME:'||V_CLIENTE_TODOS_CAMPOS.NOME_CLIENTE);

EXCEPTION   
  WHEN NO_DATA_FOUND THEN
  DBMS_OUTPUT.PUT_LINE('CLIENTE NÃO ENCONTRADO');

END;  

-------------------------------------------------------------------------
-- EXPLICANDO CADA PARTE DO PROGRAMA. VOU USAR COM %TYPE

SET SERVEROUTPUT ON  
/* Habilita impressão na tela. Basta uma vez ao entrar 
   no Developer ou SQL Plus. 
   Ou se preferir deixar no topo do programa */

DECLARE
  /* Aqui são declaradas a variáveis, constantes, 
     cursores (veremos adiante), etc.  */
 
  /* Para cada valor que o programador deseja que seja tratado/usado
     no bloco PL-SQL precisa ser criada uma variável. Então criamos
     as duas necessárias a seguir. */
  
  v_cliente cliente.id_cliente%type;
  v_nome cliente.nome_cliente%type;
  
BEGIN


   SELECT ID_CLIENTE,NOME_CLIENTE INTO V_CLIENTE,V_NOME
   FROM CLIENTE WHERE ID_CLIENTE=&DIGITE_NUMERO;

   /* Vejam que selecionamos o id_cliente e nome de cliente esses
      foram jogados(INTO) para dentro das variáveis V_CLIENTE E V_NOME */
   /* ATENÇÃO: SELECT ..... INTO.... é utilizado quando a lógica só 
      possibilitará o retorno de uma linha. Isso ocorre quando a 
      consulta tem como condição só retornar uma igualdade com a chave
      primária.
      Quando houver possibilidade lógica de retorno acima de uma linha
      devemos usar um mecanismo chamado cursor explicito que aprenderemos
      em aulas adiante. 

   /* Observem que o comando Select..INTO.. de um bloco PL-SQL tem que
      conter a lógica para selecionar apenas uma linha. Então pensem 
      sempre em usá-lo para pesquisar uma chave primária quando essa
      existir. */

   DBMS_OUTPUT.PUT_LINE('NUMERO:'||V_CLIENTE || '   '  || 'NOME:'||V_NOME);
    
    /* Vejam que imprimimos um texto 'NUMERO:' e concatenamos (||) com a
       a variável V_CLIENTE que também será impressa. Após concatenamos (||)
       espaços em branco para que o texto 'NOME:' e variável V_NOME ficassem
       um pouco afastados. */
       
EXCEPTION   
  WHEN NO_DATA_FOUND THEN
  DBMS_OUTPUT.PUT_LINE('CLIENTE NÃO ENCONTRADO');

  /* Nesta área podemos incluir todos os tratamentos de erros e exceções.
     vejam que incluimos um tratamento de uma exceção para o caso do
     cliente pesquisado não existir. Se tivessemos outras pesquisas neste
     bloco e a mesma exceção ocorresse, o mesmo tratamento seria dado. */

END;  



/*OPCIONAL:
      DBMS_OUTPUT.PUT_LINE('NUMERO:'||V_CLIENTE);
      DBMS_OUTPUT.PUT_LINE('NOME:'||V_NOME);
      Como opção, poderiamos ter o comando DBMS.. com linhas diferentes
      dados de NÚMERO E NOME em linhas diferentes. Se quiser testar
      habilite estas linhas (tire --) e desabilite o DBMS.. que está
      logo acima dessas*/
  
------------------blocos e subblocos ----------------------
declare
  vcodigo number(9):=&digitecodigo; -- como está no bloco
begin                               -- principal é global
 declare
   vnome varchar(20):='&digitenome'; --esta é local
   begin
     insert into eng(id_eng,nome) values(vcodigo,vnome);
   end;
end;
/

/*
Variáveis definidas dentro de um bloco serão locais para 
esse bloco e globais para os sub-blocos. 
Não serão reconhecidas em outros blocos isolados. 
Veja que foi declarada e carregada a variável vcodigo 
no bloco principal e a variavel vnome no sub-bloco e as 
duas foram utilizadas na inserção. */





