@echo off
@for /f "usebackq" %%x in (`chdir`) do set var=%%x
TIMEOUT /T 10
start mvn clean test -Dcucumber.options="%var%\src\test\resources\features --tags @firefox" & 
start mvn clean test -Dcucumber.options="%var%\src\test\resources\features --tags @chrome" & 
start mvn clean test -Dcucumber.options="%var%\src\test\resources\features --tags @ie" & 
TIMEOUT /T 5
exit
