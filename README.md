# spring-oauth2-demo

Este proyecto contiene una demostración de cómo securizar dos APIs por medio del protocolo [OAuth2](https://oauth.net/2/) utilizando Spring Boot,
donde se les habilita el comportamiento de Resource Server a cada una de nuestras APIs para poder autorizar el acceso a sus entry points que las componen
delegando así el proceso de autenticación a los Authentication Servers [Okta](https://www.okta.com/) y [Keycloak](https://www.keycloak.org/).

Contiene además un cliente que cada cierto periodo de tiempo realiza peticiones a los Resource Servers por medio del OAuth2RestTemplate que gracias a la
autoconfiguración de Spring, anexa el access_token en los authorization header de cada request a las APIs protegidas y realiza de forma automática el refresh de los tokens 
cuando éstos han expirado.

## Configuración


TODO-> configuración de Okta y Keycloak\
Las configuraciones se pueden encontrar en los properties.yml de cada proyecto.


### Client


TODO -> description\
Se despliega en el puerto 8080 (default)

## Resource Servers:


### Okta

TODO -> description\
Se despliega en el puerto 8081


### Keycloak

TODO -> description\
Se despliega en el puerto 8082


## Consideraciones

Se deben ejecutar primero los resource server y posteriormente iniciar al cliente. De lo contrario el cliente regresará request timeout error en cada petición programada.
