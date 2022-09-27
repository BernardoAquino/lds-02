# lds-02
Repositório para o desenvolvimento do Laboratório 01 (Laboratório de Desenvolvimento de Software)

## Como executar o projeto

Para executar o projeto com maior facilidade seguindo os passos abaixo, é necessário possuir o [docker](https://docs.docker.com/engine/install/) instalado, assim como o [docker-compose](https://docs.docker.com/compose/install/).

Abaixo seguem instruções para executar as 2 aplicações contidas neste repositório localmente.


### Backend

Após clonar o repositório, execute a seguinte sequência de comandos:

```bash
  cd ./Implementacao/backend
```

Agora, estando no diretório do backend execute

```bash
  make up
```

Após isso você deverá ver no terminal os logs do servidor de MySQL e da aplicação Spring Boot



### Frontend

Após clonar o repositório, execute a seguinte sequência de comandos:

```bash
  cd ./Implementacao/frontend
```

Agora, estando no diretório do frontend execute

```bash
  npm i
```

Após executar o comando acima você terá as dependências do projeto instaladas, após isso basta executar:

```bash
  npm start
```

E a aplicação estará executando na porta `3000` do seu localhost