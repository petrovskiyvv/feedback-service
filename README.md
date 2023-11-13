# Сервис для сбора отзывов
## Описание проекта
Сервис для сбора отзывов на организации с возможностью регистрации.


## Как запустить?
1. Склонируйте проект 
```
git clone https://github.com/petrovskiyvv/feedback-service.git
```
2. В файле ```src/main/resources/application.properties``` введите:
* ```spring.datasource.username=``` - имя пользователя вашей локальной БД
* ```spring.datasource.password=``` - пароль к БД
3. Выполните установку всех зависимостей из файла ```pom.xml```
4. Запустите приложение из файла ```FeedbackServiceApplication.java```
5. В браузере перейдите по ссылке ниже и создайте нового пользователя
```
http://localhost:8080/registration
```



-----------------

## Технологии для работы с проектом
1. Java 17
2. postgres
3. PgAdmin
