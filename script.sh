docker-login
docker-compose down
# remove os dois containers
docker rmi -f aula-api
docker rmi -f postgres
# remove as duas images
docker build -t aula-api .
#roda a imagem da aplicação
docker-compose up -d
#roda o container da aplicação.

