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
    <h1>Список тренировок</h1>
    <#list trainings as training>
        <p>Дата - ${training.date} Средний пульс ${training.averagePulse} Общее время - ${training.time} минут <#if training.man??>Персона ${training.man.name}</#if></p>
    </#list>
</body>
</html>