### Вариант №1 (проще)

1. Необходимо расставить аннотации JPA, чтобы были созданы таблицы в соответствии с описанием.
   Альпинисты (полное имя; адрес проживания)
   Горы (название; страна; высота)
   Группа для восхождения на гору (альпинисты, записавшиеся в группу; идёт набор в группу или нет; гора; дата и время
   начала и окончания похода):
   `jpa -> entity1 -> классы Alpins, Hills, Groups.`
   
2. Написать следующие SQL запросы:
   1) получить название гор, на которые уже состоялись восхождения
   `SELECT tb_groups.hill WHERE finish < LocalDateTime.now();`
   2) получить название гор, на которые не было ни одного восхождения
   `SELECT tb_groups.hill WHERE begin > LocalDateTime.now();`
   3) получить имена альпинистов, которые ходили в поход на гору с определенным названием
   `SELECT tb_groups.alpinist WHERE hill = 'Elbrus' AND finish < LocalDateTime.now();`
   4) получить названия и высоту гор, восхождение на которые планируется в определенный интервал времени
   `SELECT tb_hills.high AS tb_high
    FROM tb_hill
    JOIN tb_groups.hill
    ON tb_groups.hill = tb_hills.title
    WHERE tb_groups.begin BETWEEN '2023-06-22T10:00:00.000000000' AND '2023-06-22T17:00:00.000000000'`

   5) получить имена альпинистов, которые не записались в новые (время начала похода в будущем) группы
    `DELETE FROM tb_groups.alpinist WHERE begin > LocalDateTime.now();
    SELECT tb_groups.alpinist AS alpinist_notrecord_future;`

