FROM maven:3.8.7-eclipse-temurin-19-alpine
# imagem do maven com jdk 19

LABEL maintainer="Kabal <knotkabal@gmail.com>"
# criado do arquivo/projeto

WORKDIR /app
#cria a pasta no container

COPY . .
# copia tudo local para a imagem docker ([.]esquerda-local, [.]direita-imagem)

RUN mvn package
#roda o maven e atualiza todos as dependências do projeto

EXPOSE 8080
#Porta para rodar a aplicação.

CMD ["java", "-jar", "target/event-microservice-0.0.1-SNAPSHOT.jar"]
# Roda o jar passando o caminho do .jar gerado pelo maven





##############
#FROM openjdk:17-jdk
#
#COPY target/event-microservice-0.0.1-SNAPSHOT.jar /app/app.jar
#
#CMD ["java", "-jar", "/app/app.jar"]
# Start with maven:3.8.7-eclipse-temurin-19-alpine base image