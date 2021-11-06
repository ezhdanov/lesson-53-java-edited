<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Профиль пользователя</title>
</head>
<body>
<a href="/people">К списку</a>
<p>${man.name} ${man.age} Лет</p>
<#list man.trainings as training>
    <p>Дата - ${training.date} Средний пульс ${training.averagePulse} Общее время - ${training.time} минут</p>
</#list>
</body>
</html>