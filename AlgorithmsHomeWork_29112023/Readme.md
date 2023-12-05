# Home work 29.11.2023

***Tasks***
1. Реализовать метод search() у написанной на занятии очереди CustomArrayQueue (см. код в репозитории).
public int search(int element) -  определяет, существует ли объект в очереди.
Если элемент найден, возвращает позицию элемента с вершины стека. В противном случае он возвращает -1.

2. Имеется класс RandomizedQueue (см. код в репозитории). Это тип очереди, из которой данные извлекаются в случайном порядке.
Проанализировать класс и провести оценку эффективности методов RandomizedQueue с ростом числа элементов в очереди
асимптотическим и амортизированным анализом:


#### is the randomized queue empty?
    public boolean isEmpty()


#### return the number of items on the randomized queue
    public int size()


#### add the item
    public void enqueue(Item item)


#### remove and return a random item
    public Item dequeue()


#### return a random item (but do not remove it)
    public Item sample()


#### return an independent iterator over items in random order
    public Iterator iterator()

