# EDATECH application 
![Image alt](EDATECH_Architecture.png)

# Запуск

Для выполнения сборки и запуска приложения с помощью Gradle Wrapper'а следует воспользоваться shell скриптом gradlew 
или Windows скриптом gradlew.bat, например:
`gradlew clean build bootRun`

# Swagger

**_Swagger_** - это инструмент, которая позволяет автоматизировать процесс документации REST-сервисов.
Swagger поддерживает множество языков программирования и фреймворков.
Также Swagger предоставляет UI для удобного просмотра сгенерированной API документации.

В проекте используется Springfox - реализация спецификации Swagger 2 для Spring REST веб-сервиса.

Для просмотра API документации, следует запустить приложение и перейти по следующему URL:
http://localhost:8090/swagger-ui.html

# Load testing

Нагрузочное тестирование осуществляется с помощью проекта `Gatling`. Тестовые сценарии пишутся для `Gatling` пишутся на `Scala` 
и находятся в модуле `src/gatling`.

Для запуска нагрузочное тестирования необходимо сначала запусить приложение `gradle bootRun`,
а после тестовые сценарии `gradle gatlingRun`. Отчет можно посмотреть по пути `build/reports/gatling/...`.