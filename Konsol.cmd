echo off
title HaCkErTiMe
cd C:\Users\marcu\OneDrive\Gym -------\Programmering\QuickSort

:start
cls

javac QuickSort.java
set /p id=If you want to use a custom array, write it here:
java QuickSort %id%

pause
goto start