<!DOCTYPE html>
<html>
<head>
    <title>
        PROGRAMS
    </title>
</head>
<h1>
    PROGRAMS
</h1><hr>
<h4>
    Программы тренировок:
</h4>
<#list products as product>
<div>
    <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">Подробнее</a></p>
</div>
#list>
</hr>
<h3>
    Создать новый товар
</h3>
<form action="/product/create" method="post">
    Название объявления: <input type="text" name="title"/><br><br>
    Цена объявления: <input type="number" name="price"/><br><br>
    Описание объявления: <input type="text" name="description"/><br><br>
    <input type="submit" value="Добавить товар">
</form>
</body>
</html>