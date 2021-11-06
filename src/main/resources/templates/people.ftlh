<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>People</title>
</head>
<body>
<form action="/people" method="post">
    <label for="">
        Имя
        <input name="name" type="text">
    </label>
    <label for="">
        Возраст
        <input name="age" type="number">
    </label>
    <label for="">
        Страна рождения
        <input name="firstTrainingTime" type="text">
    </label>
    <button>Добавить</button>
</form>
    <h1>Список людей</h1>
    <#list people as man>
        <p><a href="/people/${man.id}">${man.name} ${man.age} Лет</a></p>
        <#list man.trainings as training>
            <p>Дата - ${training.date} Средний пульс ${training.averagePulse} Общее время - ${training.time} минут</p>
        </#list>
        <hr>
    </#list>
</body>
</html>