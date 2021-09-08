echo off
title HaCkErTiMe
cd C:\Users\marcu\OneDrive\Gym -------\Programmering\QuickSort

:start
cls

javac QuickSort.java
set /p id=What number to search for? 
java QuickSort %id%

pause
goto start