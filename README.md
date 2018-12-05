# Algo Empire
Trabajo practico de la materia Algoritmos y programación III - Modelo de Age of Empires II -
Segundo cuatrimestre año 2018 - FIUBA.



[![Build Status](https://travis-ci.com/diaznicolasandres1/Algo-Empire-AYP3.svg?branch=master)](https://travis-ci.com/diaznicolasandres1/Algo-Empire-AYP3)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/02562e58ec574e73bee2a1ecf7b99712)](https://www.codacy.com/app/diaznicolasandres1/Algo-Empire-AYP3?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=diaznicolasandres1/Algo-Empire-AYP3&amp;utm_campaign=Badge_Grade)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Intregrantes
- [Balladares, Alejandro](https://github.com/AlejandroBalladares)
- [Diaz, Nicolas Andres](https://github.com/diaznicolasandres1)
- [Galvan Perez, Jonathan](https://github.com/JonathanGalvanPerez)
- [Mastricchio, Facundo Rodrigo](https://github.com/FacuMastri)

---
## Pasos para trabajar

_Opcional: pueden automatizar todos los pasos utilizando GitKraken o los plugins de integracion propio de cada IDE._

Solo la primera vez:
1. `git clone https://github.com/diaznicolasandres1/Algo-Empire-AYP3`.
1. `cd Algo-Empire-AYP3`

Siempre:
1. `git pull`
1. Cambios en codigo, informe o diagramas
    1. Informe: Modificar [informe](https://www.overleaf.com/6538475577bggwkfmmvhnz)
    1. Codigo: Modificar src/ y test/ con IntelliJ/Eclipse/Netbeans
    1. Diagramas: Modificar diagramas con Astah UML y subirlos como imagenes
1. Ejecutar pruebas unitarias y de integración. Además, usar el script de Ant (`ant` en el directorio donde se tenga el proyecto) para comprobar que se pueda buildear correctamente
1. `git status`
1. `git add ARCHIVOS_MODIFICADOS`. No agregar archivos propios de los IDEs.
1. `git commit -m "Comentario del commit"`
1. `git push origin master` 
1. Confirmar que el build paso las pruebas de [Travis](https://travis-ci.com/diaznicolasandres1/Algo-Empire-AYP3/) (se recibe un mail de no hacerlo)

## Para ejecutar juego.
Abrir terminal en Algo-Empire-AYP3

 `ant ejecutar.aplicacion`
