Семестр 2
=========
### Домашняя работа 8
[Stream API (1)](http://mit.spbau.ru/sewiki/images/5/5c/Java_2016_B_08.pdf) <br/>
[Stream API (2)](http://mit.spbau.ru/sewiki/images/2/25/Java_2016_B_09.pdf) <br/>
[Работа с потоками](http://mit.spbau.ru/sewiki/images/2/27/Java_2016_B_11.pdf) <br/>
[Темы для докладов](https://docs.google.com/document/d/1cSV-klGzx6loCzvZ-JHY_GCaw_nHK-vMiQN7UszIZ-Q/edit?usp=sharing)

- [8.1](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw8/task1) <br/>
Реализовать с помощью Java Stream API: <br/>
\- Методы в [FirstPartTasks](https://gist.github.com/yurii-litvinov/527f289e454c296f7505ccaf79873428#file-firstparttasks-java) и [SecondPartTasks](https://gist.github.com/yurii-litvinov/527f289e454c296f7505ccaf79873428#file-secondparttasks-java) <br/>
\- Тесты в [SecondPartTasksTest](https://gist.github.com/yurii-litvinov/527f289e454c296f7505ccaf79873428#file-secondparttaskstest-java) <br/>
Тесты в [FirstPartTasksTest](https://gist.github.com/yurii-litvinov/527f289e454c296f7505ccaf79873428#file-firstparttaskstest-java) и [SecondPartTasksTest](https://gist.github.com/yurii-litvinov/527f289e454c296f7505ccaf79873428#file-secondparttaskstest-java) должны успешно завершаться.
- [8.2](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw8/task2) <br/>
Реализовать многопоточный вариант быстрой сортировки, для решения использовать пул потоков или Fork/Join. Замерить время выполнения и сравнить с однопоточным вариантом.


### Домашняя работа 7
[Презентация про Reflection](http://mit.spbau.ru/sewiki/images/a/aa/Java_2016_B_10.pdf) <br/>
[Презентация про Java 8](http://mit.spbau.ru/sewiki/images/7/74/Java_2016_B_07.pdf)

- [7.1](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw7/task1) <br/>
По заданному классу, используя механизм рефлексии Java, вывести в консоль текстовое описание этого класса, максимально приближенное к его исходному коду.
- [7.2](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw7/task2) <br/>
Разработать приложение, позволяющие пользователю играть с самим собой в крестики-нолики. На экранной форме должно быть 9 кнопок, расположенных в три столбца и три строки. При первоначальном нажатии на любую из кнопок на ней появляется знак «Х». При дальнейшем нажатии на другую кнопку, на ней появляется знак «O». Повторное нажатие на кнопку не должно менять ее знака.


### Домашняя работа 6

- [6.1](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw6/task1) <br/>
Разработать и реализовать иерархию классов, описывающих дерево разбора арифметического выражения. Используя их, реализовать класс, вычисляющий значение выражения по дереву. Классы, представляющие операнды и операторы, должны сами уметь себя вычислять и печатать. Дерево разбора хранится в файле в виде (<операция> <операнд1> <операнд2>), где <операнд1> и <операнд2> сами могут быть деревьями, либо числами. Например, выражение (1 + 1) * 2 представляется в виде (* (+ 1 1) 2). Должны поддерживаться операции `+, -, *, /` и целые числа в качестве аргументов. Требуется построить дерево в явном виде, распечатать его (не обязательно так же, как во входном файле) и посчитать значение выражения обходом дерева. Можно считать, что входной файл корректен. Пример — по входному файлу (* (+ 1 1) 2) может печататься ( * ( + 1 1 ) 2 ) и выводиться 4.
- [6.2](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw6/task2) <br/>
Создать generic-класс, реализующий стандартный интерфейс Java Set и представляющий собой АТД "Множество". Можно использовать стандартные коллекции Java кроме тех, которые сами реализуют интерфейс Set.


### Домашняя работа 5

- [5.1](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw5/task1) <br/>
Релизовать программу-калькулятор со следующим графическим интерфейсом: <br/>
![картинка](http://i.imgur.com/y3VDvTQ.jpg)
- [5.2](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw5/task2) <br/>
При изменении значения аргумента или операции результат пересчитывается автоматически.
- [5.3](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw5/task3) <br/>
Реализовать продвинутый кнопочный калькулятор по аналогии со стандартными калькулятором Windows или KCalc. Как минимум должны присутствовать 10 кнопок цифр и 4 кнопки операции.


### Домашняя работа 4
[Конейнеры и генерики (презентация)](https://drive.google.com/open?id=1wYJTbXDkWUcUPuGUUBgm1xgR871ivSU7CedE3ShnFXg) <br/>
[Конейнеры и генерики (конспект)](https://drive.google.com/open?id=18-EAd66pJyCRTcqEIRRz9B8z2wAGsr4_-enwqFaNa2w)

- [4.1](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw4/task1) <br/>
Переделать один из реализованных в прошлой домашней работе список в виде generic'а. На основе него реализовать класс UniqueList, который не содержит повторяющихся значений. Реализовать классы исключений, которые генерируются при попытке добавления в такой список уже существующего или при попытке удаления несуществующего элемента.
- [4.2](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw4/task2) <br/>
Реализовать класс для работы с хеш-таблицей (на списках). Общение с пользователем должно происходит в интерактивном режиме: добавить значение в хеш-таблицу, удалить значение из хеш-таблицы, поиск значения в хеш-таблице, показать статистику по хеш-таблице (общее число ячеек, load factor, число конфликтов, максимальная длина списка в конфликтных ячейках и т.п.), выбрать хеш-функцию для подсчета хеша (из заранее заданных в коде). Смена хэш-функции должна происходить во время работы программы, в класс используемая хеш-функция должна передаваться из клиентского кода.


### Домашняя работа 3
[Принципы SOLID (конспект)](https://drive.google.com/open?id=15-XAjkfYFa-5QBEyBCPUlciIffk_wJg4lU5abDMBoF8) <br/>
[Принципы SOLID (презентация)](https://drive.google.com/open?id=1HOTW_yuAAEg7RFS3UESDjnKLSEbs_MmN28wPrZ5BGwo) <br/>
[Исключения (конспект)](https://drive.google.com/open?id=15kSnhQWLJxdRyD7jO1Uq9BkyiGRXblodv4N1gX8qj6E) <br/>
[Исключения (презентация)](https://drive.google.com/open?id=1x8YKxl3kHC1GWjoyidf454vTXlhqr1hWJlQ03J0dmo8)

- [3.1](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw3/task1) <br/>
Создать интерфейс сортировщика, принимающего массив элементов и выполняющего над ним сортировку. На его основе создать несколько классов, реализующих произвольные (разные) алгоритмы сортировки. К данному коду должны быть созданы автоматические тесты с помощью библиотеки JUnit.
- [3.2](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw3/task2) <br/>
Дан массив размерностью N x N, N - нечетное число. Вывести элементы массива при обходе его по спирали, начиная с центра. Для решения задачи разработать интерфейс Выводилка с методом вывести(), реализовать на его основе два класса, осуществляющих либо вывод на консоль либо в файл. Написать программу, которая по желанию пользователя выбирает реализацию Выводилки и выводит массив. К данному коду должны быть созданы автоматические тесты с помощью библиотеки JUnit.


### Домашняя работа 2
[Наследование и полиморфизм (конспект)](https://docs.google.com/document/d/1jSUq6-g5B44nDxJpzZy-YxUW-82GISOuceWuno2JPCk/edit?usp=sharing) <br/>
[Наследование и полиморфизм (презентация)](https://docs.google.com/presentation/d/1l8LsvKlJXWkMMqHcvhG7ZQiSHp47B28jtMnPkxCKx1M/edit?usp=sharing) <br/>
[Тестирование (конспект)](https://docs.google.com/document/d/1aqs0LEg9p-7U5wjO-Q82-zp25-9QISOIUeKDzOmD1Z0/edit?usp=sharing) <br/>
[Тестирование (презентация)](https://docs.google.com/presentation/d/1VUROElTM6LPSE_GxeqboNDc0Op-eemFpbKkMhvreanI/edit?usp=sharing)

- [2.1](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw2/task1) <br/>
Разработать интерфейс, представляющий структуру данных "стек". На его основе реализовать стек двумя разными способами. Реализовать стековый калькулятор для подсчета арифметических выражений.
- [2.2](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw2/task2) <br/>
Разработать интерфейс, представляющий структуру данных "связный список". Реализовать этот список двумя разными способами (односвязный/двусвязный, на массиве/на указателях и т.п.) на основе полученного интерфейса.


### Домашняя работа 1
[Конспект](https://docs.google.com/document/d/1wYVBQ4_OCKyQtkzBEa-8j3N9FJZqGnMBYMZV5T3xxN8/edit?usp=sharing) <br/>
[Стайлгайд](http://www.oracle.com/technetwork/java/javase/documentation/codeconvtoc-136057.html)

- [1.1](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw1/task1) <br/>
Создать класс, реализующий функциональность стека.
- [1.2](https://github.com/Victor-Y-Fadeev/SPbSU/tree/master/course1/sem2/hw1/task2) <br/>
Создать класс, реализующий функциональность односвязного линейного списка.
