# Home work 16.01.2024

***Описание задания***

- 1.1 Создайте класс Customer с полями id, name, dateOfLastNotification, phone, email, геттрами и сеттерами. 
В приложении создайте два бина типа Customer (используйте scope Prototype). Получите бины из контекста и 
установите первому параметры {1L, “Bob”, LocalDate.now(), “+19138445656”, null }, второму {2L, “Sarah”, 
2024-16-01 , “+19158455617”, ”sarah-sweet@candy.com”}.

- 1.2 Создайте класс NotificationService, который выполняет оповещение клиентов с помощью метода sendSpam
(Customer customer): если с последней отправки прошло больше 30 дней, то он отправляет спам по имеющимся 
контактам (метод делегирует эту работу классам от которых зависит - SmsNotificationService и 
EmailNotificationService). Получите NotificationService из контекста и передайте ему бины клиентов. 
SmsNotificationService и EmailNotificationService должны внедряться в NotificationService.

- 1.3 Создайте класс SmsNotificationServiceImpl, следующий интерфейсу SmsNotificationService, и класс 
EmailNotificationServiceImpl, следующий интерфейсу EmailNotificationService.