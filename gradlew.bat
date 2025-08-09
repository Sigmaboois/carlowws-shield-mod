@ECHO OFF
SET JAVA_HOME=%JAVA_HOME%
java -version >NUL 2>&1
IF %ERRORLEVEL% NEQ 0 (
    ECHO Java not found. Please install Java 17.
    EXIT /B 1
)
java -jar "%~dp0\gradle\wrapper\gradle-wrapper.jar" %*
