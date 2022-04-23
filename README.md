# bs-bcp-favorite-service-payment
Api de negocio para registrar los servicios de pagos favoritos


## Create docket image "docker build"
`docker build -t bs-bcp-service-payment:0.0.1 .`

`docker image ls`

## Create contenedor "docker run"

`docker run -d --name bs-bcp-service-payment-dev -p 9090:8080 bs-bcp-service-payment:0.0.1`

## Create Tag "docker tag" para docker hub

`docker tag bs-bcp-service-payment:0.0.1 gek94/bs-bcp-service-payment:0.0.1`

## Para azure
Entrar al container registry, crear el recurso y loguearte utilizando:

`docker login registrybcp.azurecr.io`

Docker Tag

`docker tag gek94/bs-bcp-service-payment:0.0.1 registrybcp.azurecr.io/bs-bcp-service-payment:0.0.1`

`docker image ls`

`docker push registrybcp.azurecr.io/bs-bcp-service-payment:0.0.1`

## Levantando MONGODB

`docker pull mongo`

`docker run -d -p 27017:27017 --name mongodb mongo`

## Levantando keycloak

`docker run -d --name start-keycloak -p 9999:8080 -e KEYCLOAK_ADMIN=bcp -e KEYCLOAK_ADMIN_PASSWORD=Peru001% quay.io/keycloak/keycloak:17.0.0 start-dev`
