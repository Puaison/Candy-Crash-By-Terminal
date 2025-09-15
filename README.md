# Candy-Crash-By-Terminal

This was my first personal project, developed for the *Object-Oriented Programming* exam at Univaq.  
⚠️ The project is entirely in Italian and features only a **text-based interface** running in the terminal.

## Project Overview

The aim of this project is to provide a first practical approach to the design of an object-oriented software system, with particular attention to **extensibility** and **future maintenance**. In particular, following the MVC (Model–View–Controller) design pattern, we focused exclusively on the **Model package** and worked on modeling the domain of a game similar to Candy Crush.

Candy Crush is a tile-matching puzzle game where the player swaps adjacent candies to form a row or column of at least three candies of the same color. When a match is made, the candies disappear, new ones fall from above, and the player can earn points or trigger special effects.

The software was deliberately designed using the **object-oriented paradigm** so that new functionalities could be added without modifying the existing code base. For example, introducing a new type of element that has to fit in the "Slots" of the Grid with a new effect would simply require creating a new class that extends the existing "Slot hierarchy", ensuring minimal impact on the rest of the system.

Currently, the implementation includes two types of candies:

1) **Normal Candies** (represented by symbol 'N' in the terminal):

   -  They come in four different colors.

   - Apart from participating in combinations, they have no other effects.

2) **Special Candies**:

   - They combine with other candies of the same color.

   - When combined, they trigger specific effects:

     - **Row-destroying candy** (represented by symbol '=' in the terminal): destroys the entire row where it is located.

     - **Column-destroying candy** (represented by symbol '|' in the terminal): destroys the entire column where it is located.

## Class Diagram
<p align="center">
  <img src="Class Diagram.png" alt="Screenshot del gioco" width="1000">
</p>

## Requirements
- A Java Development Kit (JDK) installed on your computer (Java 8 or higher recommended).

## How to Run

First, clone the repository and move into the project directory:
```bash
git clone https://github.com/Puaison/Candy-Crash-Terminal.git
cd Candy-Crash-Terminal
```
Then, compile all the classes:
```bash
cd code
javac -source 1.8 -target 1.8 *.java
```
Finally, run the program:
```bash
java ProgettoOggetti2019
```
