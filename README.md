# Exemplo de Distributed Tracing com Spring Boot + Jaeger

Esse repositório tem como finalidade mostrar como funciona a observalidade em microserviços.
Para isto estamos utilizando um *api gateway* como ponto de entrada para as requisições.
Também foi desenvolvido um pequeno microserviço para criar e retornar clientes e outro para calcular a quantidade de pontos.


## Requerimentos

- Java 13
- Kotlin
- Gradle

## Como rodar?

1. Iniciar o container do Jaeger Tracing usando:

```bash
    docker run -d --name jaeger \
    -e COLLECTOR_ZIPKIN_HOST_PORT=:9411 \
    -p 5775:5775/udp \
    -p 6831:6831/udp \
    -p 6832:6832/udp \
    -p 5778:5778 \
    -p 16686:16686 \
    -p 14250:14250 \
    -p 14268:14268 \
    -p 14269:14269 \
    -p 9411:9411 \
    jaegertracing/all-in-one:1.32
```

2. Entrar na pasta de cada projeto e iniciá-lo com:

```bash
    ./gradlew --info bootRun
```

3. Fazer as requisições no Postman. Pode-se usar a *collection* abaixo como exemplo:
   
    [Exemplos de requests para o API Gateway](postman_collection.json)

## Como acessar o Jaeger Tracing?

Acesse o endereço http://localhost:16686/search.
