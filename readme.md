# Ejercicio Data handling para accenture WIP

Correr el siguiente comando en docker para dockerizar una bbdd mysql y poder correr el proyecto
> docker run --name accenture-mysql-8 -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=data-handling -e MYSQL_USER=mysql -e MYSQL_PASSWORD=1234 -p 3306:3306 -d mysql:latest

## Endpoints de autenticación:
> # Signup  
> POST http://localhost:8080/auth/singup
> ```
> {  
>     "username": string,  
>     "password": string,  
>     "role": "ADMIN" | "USER",  
>     "name": string,  
>     "lastName": string,  
>     "phoneNumber": string,  
>     "gender": string,  
>     "country": string  
> }
> ```
>
> ejemplo de retorno:
> ```
> {
>     "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzb21lVXNlcm5hbWUiLCJpYXQiOjE2OTMzNDMyOTksImV4cCI6MTY5MzM0NDczOX0.wJunPxSPFt7OpN-jjVNqm6DE1M0LmOGj0uUwjWf6EBs"
> }
> ```

> # Login
> POST http://localhost:8080/auth/login
> ```
> {  
>     "username": string,  
>     "password": string,
> }
> ```
>
> ejemplo de retorno:
> ```
> {
>     "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzb21lVXNlcm5hbWUiLCJpYXQiOjE2OTMzNDMyOTksImV4cCI6MTY5MzM0NDczOX0.wJunPxSPFt7OpN-jjVNqm6DE1M0LmOGj0uUwjWf6EBs"
> }
> ```

 Con este token podemos enviar request a cualquier endpoint asegurado colocandolo en el header Authorization + el prefijo "Bearer"
 Ejemplo:  
 "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzb21lVXNlcm5hbWUiLCJpYXQiOjE2OTMzNDMyOTksImV4cCI6MTY5MzM0NDczOX0.wJunPxSPFt7OpN-jjVNqm6DE1M0LmOGj0uUwjWf6EBs"

Métodos DAO realizados:
- [x] Lista de usuarios con un determinado rol  (GET http://localhost:8080/users?role=ADMIN)
- [ ] Cantidad de veces que fue preguntada una pregunta  
- [ ] Lista de usuarios (userName, nombre, país y rol/roles) que realizaron preguntas y NO TIENEN saldo deudor  
- [ ] Lista de usuarios ADMIN que dieron de alta preguntas y usaron el sistema para realizar al menos alguna de las mismas pregunta que crearon (nombre, apellido, telefono y pregunta).  
- [ ] Saldo deudor de un determinado usuario (nombre, apellido, importe y moneda)  
- [ ] Lista de usuarios que realizaron preguntas en un rango de fechas (userName, pregunta, fecha y hora)  
- [ ] Lista de preguntas registradas que nunca fueron preguntadas  