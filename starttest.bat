@echo off

:: Change to the repository root directory
cd /d %~dp0

:: Run Maven test
mvn test -Pweb-execution -Dbrowser=chrome -Dheadless=false
