# Home work 21.11.2023

## ***Tasks***

1 уровень сложности: 
- 1 Создайте класс Logger – класс для логирования событий в программе (дата, время и текст сообщения). 
У каждого объекта данного класса должны быть методы debug(), info(), warning(), error(). 
Класс должен уметь выводить лог в консоль или в файл. В методе main() создайте объект класса Logger. 
Вызовите все доступные методы.
- 2 Залогируйте все доступные параметры и переменные окружения при старте программы.
- 3 Создайте файл настроек для вашей программы. В зависимости от указанных настроек программа должна 
включать заданный уровень логирования:
debug – логировать всё
info – логировать info, warning и error сообщения
warning – логировать warning и error сообщения
error  – логировать только error сообщения.
В настройках должно быть указано, куда нужно выводить логи – в консоль или в файл.