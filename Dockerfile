FROM maven:3.8.7-eclipse-temurin-19-alpine
# imagem do maven com jdk 19

LABEL maintainer="Kabal <knotkabal@gmail.com>"
# criado do arquivo/projeto

WORKDIR /app
#cria a pasta no container

COPY . .
# copia tudo local para a imagem docker ([.]esquerda-local, [.]direita-imagem)

RUN mvn clean package -Dmaven.test.skip
#roda o maven e atualiza todos as dependências do projeto

EXPOSE 8080
#Porta para rodar a aplicação.

CMD ["java", "-jar", "../target/Person-service-0.0.1-SNAPSHOT.jar"]
# Roda o jar passando o caminho do .jar gerado pelo maven

