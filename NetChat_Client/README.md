## Сетевой чат: Клиент

### Функционал
+ Установка хоста и порта для подключения из файла настроек (Settings.properties)
+ Возможность подключения к указанному серверу 
+ Возможность выбора ника для чата (Проверка на занятое имя)
+ Выход из чата осуществляется по команде в консоли “/exit”
+ Каждое сообщение участников чата записывается в файл log.txt, файл дополняется при каждом запуске
+ Сообщения отправляются на сервер
+ Код покрыт unit-тестами

### Реализация
Основные составляющие клиента:
1. Класс Client - подключается к серверу и запускает отдельные потоки для чтения и отправки сообщений
2. Класс ClientRegistration - отвечает за первичную регистрацию пользователя в чате
3. Класс MessageListener - отдельный поток, отвечающий за чтение сообщений от сервера
4. Класс MessageSender - отдельный поток, отвечающий отправку сообщений на сервер
5. Пакет Logger - отвечает за логирование и форматирование сообщений
6. Пакет Settings - содержит настройки для подключения к серверу