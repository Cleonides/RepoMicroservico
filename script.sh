# parar o container atual
docker stop container-aula
# remove o container
docker rm container-aula
# remove a imagem
docker rmi aula-api
# cria a imagem com nome aula-api
docker build -t aula-api .
# roda o container ligado a imagem aula - sobe o servidor
docker run -d --name container-aula -p 8080:8080 aula-api
