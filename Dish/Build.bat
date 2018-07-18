@echo off
color 0A

REM Importante
REM Abixo configura a variavel de ambiente para gerar o conteudo do arquivo \VRE2_Portal\version\version.htm
REM A variavel serve como referencia visual para a origem da geracao do pacote
SET MAVEN_OPTS=-Dsvnlocation=TRUNK

set MVN_EXE=C:\Desenvolvimento\apache-maven-3.5.0\bin\mvn
set JAVA_HOME=C:\Desenvolvimento\Java\jdk1.8.0_144
set curDir=%cd%

goto COMPILE

:COMPILE
cls

ECHO CLEAN UP
call %MVN_EXE% clean
call %MVN_EXE%  install
echo CONCLUIDO!!!
pause