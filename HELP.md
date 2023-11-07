
Construir Proyecto
```bash 
mvn clean package
``` 
Ejecutar comando docker para crear imagen
```bash 
docker build -t ws-app-price:v1 .
``` 
Ejecutar comando para correr proyecto
```bash 
docker run -p 8081:8081 ws-app-price:v1
``` 







