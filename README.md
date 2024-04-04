# AREP-Parcial02

## Enunciado

Los algoritmos de búsqueda son esenciales para desarrollo de las ciencias de la computación. En este ejercicio los estudiantes crearán una solución web que explora dos algortimos de búsqueda: la búsqueda lineal y la búsqueda binaria.

## Arquitectura

![Arquitectura](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/8f41360f-9b75-4d17-804c-43928be58cfa)

Los servicios incluyen dos funciones:
+ Uno recibe una lista de cadenas y un valor a buscar e implementa la búsqueda lineal :  linearSearch(lista, valor) retorna un json con el índice de la primera aparición del valor o con -1 si no encuentra el valor.

+ Uno recibe una lista ordenada de cadenas y un valor a buscar e implementa la búsqueda binaria de manera recursiva : binarySearch(n), retorna un json con el índice de la primera aparición del valor o con -1 si no encuentra el valor. 

## Ejemplo de llamado

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
![Test](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/07d1cf59-0456-4a12-845e-d6041b0bac51)

## Despliegue en AWS

### Se crean las máquinas virtuales en AWS

![machines](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/903f2632-0ea5-4f11-abfc-deb80ead615f)

### Se instala git en las tres máquinas
![git](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/0eae0830-7d7b-4af5-b492-dd802595d0b9)

### Creamos una carpeta para clonar el repositorio: en las tres máquinas
![gitClone](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/a789a451-bf6b-448f-9942-38c8a1d3e57e)

### Instalamos lo necesario en las tres máquinas

Se instala java con el comando:
```bash
sudo yum install java-17-amazon-corretto-devel
```
![Java](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/fd3e7cbb-7425-4986-84e9-92def8b44084)

Se instala maven con el comando:
```bash
sudo wget https://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo

sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo

sudo yum install -y apache-maven
```

![Maven](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/73a00b21-1cda-423e-ac60-070c4513aee8)

### Se compila el proyecto en las tres máquinas
```bash
mvn clean
mvn compile
mvn package
```
![MavenPackage](https://github.com/An6ie02/AREP-Parcial02/assets/100453879/c9b96941-f684-4972-a7e3-cadf7434ea4b)

### Se ejecuta el proyecto en las tres máquinas

java -cp target/microservicios-1.0-SNAPSHOT-jar-with-dependencies.jar edu.escuelaing.arep.MathServices

