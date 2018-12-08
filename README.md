# Algo Empire
Trabajo practico de la materia Algoritmos y programación III - Modelo de Age of Empires II -
Segundo cuatrimestre año 2018 - FIUBA.

[![Build Status](https://travis-ci.com/diaznicolasandres1/AYPIII-TP2-AlgoEmpire.svg?branch=master)](https://travis-ci.com/diaznicolasandres1/AYPIII-TP2-AlgoEmpire)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/02562e58ec574e73bee2a1ecf7b99712)](https://www.codacy.com/app/diaznicolasandres1/AYPIII-TP2-AlgoEmpire?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=diaznicolasandres1/Algo-Empire-AYP3&amp;utm_campaign=Badge_Grade)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Integrantes
- [Balladares, Alejandro](https://github.com/AlejandroBalladares)
- [Diaz, Nicolas Andres](https://github.com/diaznicolasandres1)
- [Galvan Perez, Jonathan](https://github.com/JonathanGalvanPerez)
- [Mastricchio, Facundo Rodrigo](https://github.com/FacuMastri)

---
## Pasos para trabajar

Siempre:
1. `git pull`
2.  Cambios en codigo, informe o diagramas
    1.  Informe: Modificar [informe](https://www.overleaf.com/6538475577bggwkfmmvhnz)
    1.  Codigo: Modificar src/ y test/ con IntelliJ/Eclipse/Netbeans
    1.  Diagramas: Modificar diagramas con Astah UML y subirlos como imagenes
3.  Ejecutar pruebas unitarias y de integración. Además, usar el script de Ant (`ant` en el directorio donde se tenga el proyecto) para comprobar que se pueda buildear correctamente
4. `git status`
5. `git add ARCHIVOS_MODIFICADOS`. No agregar archivos propios de los IDEs.
6. `git commit -m "Comentario del commit"`
7. `git push origin master` 
8.  Confirmar que el build paso las pruebas de [Travis](https://travis-ci.com/diaznicolasandres1/Algo-Empire-AYP3/) (se recibe un mail de no hacerlo)

## Pasos para ejecutar
1.  Abrir terminal en el directorio donde se haya clonado el proyecto
2.  `ant ejecutar.aplicacion`
