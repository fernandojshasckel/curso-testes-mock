# Curso teste unitário utilizando Mockito

### @Mock

    Uso a anotação quando desejo instanciar uma classe que usa conexão com banco de dados para troca 
    de informações.

    Exemplo:

        @Mock
        private LeilaoDao leilaoDao;

### Retornando determinada informação caso uma função seja chamada

    Quando quero chamar uma função e ela me da um retorna de uma lista por exemplo e eu quero fazer 
    uma validação em  cima disso, o Mockito me da a possibilidade de usar o .when passando a função 
    que eu chamo e em seguida o .thenReturn que é o retorno criado por mim para devolver quando a 
    função foi chamada.

    Exemplo:

        Mockito.when(leilaoDao.buscarLeiloesExpirados()).thenReturn(leiloes);

### Verificando se uma função foi chamada

    Quando quero fazer a verificação se uma determinada função foi chamada por exemplo uma função 
    que faz o save de dados no banco de dados o Mockito traz a possibilidade de utilizar o .verify 
    com o um parâmetro sendo a classe que a função está e em seguida passo o nome da função com o 
    seu parâmetro caso necessário.

    Exemplo:

        Mockito.verify(leilaoDao).salvar(leilao);

### Lançando exception para teste

    Quando desejo testar uma exception o Mockito me da a possibilidade de forçar uma exception posso 
    fazer isso chamando uma determinada função passando um parâmetro qualquer "Mockito.any()" e lançando 
    a exceção com .thenThrow(RuntimeException.class) que recebe por parâmetro a exceção a ser lançada.

    Exemplo: 

        Mockito.when(leilaoDao.salvar(Mockito.any())).thenThrow(RuntimeException.class);

### Capturando objetos com Mockito

    No Mockito existe um conceito chamado Captor que serve para capturar um determinado objeto. Ele serve 
    para capturar objetos criado dentro da minha função do service que está sendo testado tendo em vista que 
    eu não tenho acesso diretamente a esses objetos.
    Sendo assim sempre que desejo capturar um objeto que foi passado por um objeto de um mock pode ser utili-
    zado o Captor.

    Exemplo:

        @Captor
        private ArgumentCaptor<Pagamento> captor;

    Exemplo de captura do objeto:

        Mockito.verify(pagamentoDao).salvar(captor.capture());

        Nesse caso estou verificando se o método salvar foi chamado e em seguida faço a captura do objeto.

    Em seguida pego o objeto que foi capturada fazendo a instancia do objeto recebendo o captor.getValue()

    Exemplo:

        Pagamento pagamento = captor.getValue();