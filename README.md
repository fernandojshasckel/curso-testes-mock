# Curso teste unitário utilizando Mockito

### @Mock

    Uso a anotação quando desejo instanciar uma classe que usa conexão com banco de dados para troca de informações

    Exemplo:

    @Mock
    private LeilaoDao leilaoDao;

### Retornando determinada informação caso uma função seja chamada

    Quando quero chamar uma função e ela me da um retorna de uma lista por exemplo e eu quero fazer uma validação em 
    cima disso, o Mockito me da a possibilidade de usar o .when passando a função que eu chamo e em seguida o 
    .thenReturn que é o retorno criado por mim para devolver quando a função foi chamada

    Exemplo:

    - Mockito.when(leilaoDao.buscarLeiloesExpirados()).thenReturn(leiloes);

### Verificando se uma função foi chamada

    Quando quero fazer a verificação se uma determinada função foi chamada por exemplo uma função que faz o save de dados 
    no banco de dados o Mockito traz a possibilidade de utilizar o .verify com o um parâmetro sendo a classe que a função 
    está e em seguida passo o nome da função com o seu parâmetro caso necessário.

    Exemplo:

    - Mockito.verify(leilaoDao).salvar(leilao);