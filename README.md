# AREP-Parcial 02 

## Enunciado

Los algoritmos de búsqueda son esenciales para desarrollo de las ciencias de la computación. En este ejercicio los estudiantes crearán una solución web que explora dos algortimos de búsqueda: la búsqueda lineal y la búsqueda binaria.

### Arquitectura

El sistema estará compuesto por tres servicios:
+ `HttpConection`: Este servicio actuará como un proxy que recibirá las peticiones del cliente y las redirigirá a los servicios de búsqueda de manera secuencial.
+ `MathService`: Este servicio implementará la búsqueda lineal y la búsqueda binaria.
+ `App`: Este servicio será el cliente que realizará las peticiones al proxy.

![Arquitectura](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/8f41360f-9b75-4d17-804c-43928be58cfa)

Los servicios incluyen dos funciones:
+ Uno recibe una lista de cadenas y un valor a buscar e implementa la búsqueda lineal :  linearSearch(lista, valor) retorna un json con el índice de la primera aparición del valor o con -1 si no encuentra el valor.

+ Uno recibe una lista ordenada de cadenas y un valor a buscar e implementa la búsqueda binaria de manera recursiva : binarySearch(n), retorna un json con el índice de la primera aparición del valor o con -1 si no encuentra el valor. 

### Ejemplo de llamado

Ejemplo 1 de un llamado:

https://amazonxxx.x.xxx.x.xxx:{port}/linearsearch?list=10,20,13,40,60&value=13

Salida. El formato de la salida y la respuesta debe ser un JSON con el siguiente formato

{
 "operation": "linearSearch",
 "inputlist": "10,20,13,40,60",
 "value": "13"
 "output":  "2"
}

## Funcionamiento en local

Para ejecutar el proyecto en local se debe clonar el repositorio y ejecutar los siguientes comandos en la terminal:

```bash
git clone https://github.com/An6ie02/AREP-Parcial02.git
cd AREP-Parcial02
mvn clean
mvn compile
mvn package
java -cp target/microservicios-1.0-SNAPSHOT-jar-with-dependencies.jar edu.escuelaing.arep.MathServices
java -cp target/microservicios-1.0-SNAPSHOT-jar-with-dependencies.jar edu.escuelaing.arep.App
```
Una vez hecho lo anterior se puede acceder a la aplicación en el navegador con la siguiente URL: [https://github.com/An6ie02/AREP-Parcial02.git](http://localhost:4567/)

Podrá ver la siguiente página web:

![Test](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/07d1cf59-0456-4a12-845e-d6041b0bac51)

### Test del servicio de búsqueda lineal y binaria

Se han realizado pruebas unitarias para los casos en que el valor se encuentra en la lista y en que el valor no se encuentra en la lista, esto para ambas opciones de búsqueda. Para ejecutar las pruebas se debe ejecutar el siguiente comando en la terminal:

```bash
mvn test
```

## Despliegue en AWS

### Se crean las máquinas virtuales en AWS

Una máquina para el proxy y dos máquinas para los servicios matemáticos

![machines](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/903f2632-0ea5-4f11-abfc-deb80ead615f)

### Se prepara el entorno en las tres máquinas

Se debe instalar git, maven, java 17 en las tres máquinas siguiendo los siguientes comandos:
```bash
# Actualizar el sistema
sudo yum update -y
# Instalar git
sudo yum install git -y
# Instalar java
sudo yum install java-17-amazon-corretto-devel
# Comprobar la versión de java
java --version
# Instalar maven
sudo wget https://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo

sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo

sudo yum install -y apache-maven

# Clonar el repositorio de la aplicación
git clone https://github.com/An6ie02/AREP-Parcial02.git
# Cambiar al directorio del repositorio
cd AREP-Parcial02
```

![git](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/0eae0830-7d7b-4af5-b492-dd802595d0b9)\
![Java](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/fd3e7cbb-7425-4986-84e9-92def8b44084)\
![Maven](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/73a00b21-1cda-423e-ac60-070c4513aee8)

### Se compila el proyecto en las tres máquinas
```bash
mvn clean
mvn compile
mvn package
```
![MavenPackage](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/c9b96941-f684-4972-a7e3-cadf7434ea4b)

### Se ejecuta el proyecto en las tres máquinas

En la máquina proxy se ejecuta el siguiente comando:
```bash
java -cp target/microservicios-1.0-SNAPSHOT-jar-with-dependencies.jar edu.escuelaing.arep.App
```
Y en las máquinas MathService1 y MathService2 se ejecuta el siguiente comando:
```bash
java -cp target/microservicios-1.0-SNAPSHOT-jar-with-dependencies.jar edu.escuelaing.arep.MathServices
```

### Pruebas de funcionamiento

Se prueba el servicio de Search en la máquina MathService1
![TestMath1](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/27f2eb88-3c54-48db-900b-546e2a6feb80)\
Se prueba el servicio de Search en la máquina MathService2
![Test2](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/d52f0661-1f56-4a60-b159-dbc35f0535d1)

Para verificar el funcionamiento del proxy se baja el servicio de MathService1 y se realiza una petición al proxy, se puede observar que el proxy cambia de máquina para realizar la petición.

El funcionamiento completo se puede ver en el siguiente video:

https://github.com/An6ie02/AREP-Parcial02/assets/100453879/36ce7c99-c196-4b14-81c6-7e3c26870553

## Autor

* **Angie Natalia Mojica** [Angie Natalia Mojica](https://www.linkedin.com/in/angienataliamojica/)

## Agradecimientos y Fuentes

* Al profesor [Luis Daniel Benavides Navarro](https://www.linkedin.com/in/danielbenavides/) por la guía y la enseñanza en el curso de Arquitecturas Empresariales.
* [Instalar java en EC2](https://github.com/kunchalavikram1427/YouTube_Series/blob/main/Tools/install%20java%20on%20aws%20ec2.md)
* [Instalar maven en EC2](https://docs.aws.amazon.com/es_es/neptune/latest/userguide/iam-auth-connect-prerq.html)