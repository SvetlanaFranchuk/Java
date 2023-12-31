# Home work 19.12.2023


***Описание задания.***

1) Разработайте программу, эмулирующую работу нескольких пользователей (потоков) с 
единым электронным документом. Все пользователи могут добавлять, редактировать и 
удалять записи (одна запись – одна строка). Каждый новый пользователь получает 
актуальную копию документа и работает с ней. После внесения изменений пользователь 
сохраняет изменения. Для оптимизации доступа к документу используйте ReentrantReadWriteLock.
2) Создайте классы Клиент, Товар, Задание. Создайте единый механизм для генерации уникальных 
идентификаторов для каждого из классов (у Клиентов свои идентификаторы, у Товаров – свои, 
у Заданий - свои). Используйте обёртку ThreadLocal для хранения счетчика уникальных идентификаторов 
в каждом потоке. Реализуйте класс UniqueIdGenerator, который предоставляет метод generateUniqueId(), 
возвращающий уникальный идентификатор.
3) В интернет-магазине есть два процесса: обработка заказов и доставка товаров. На фоне обработки 
заказов, нужно периодически планировать доставку готовых товаров. Разработайте программу, 
используя ThreadPoolExecutor и ScheduledThreadPoolExecutor, чтобы эффективно управлять обработкой 
заказов и доставкой.