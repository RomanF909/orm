### Вариант №1 (проще)

1. Необходимо расставить аннотации JPA, чтобы были созданы таблицы в соответствии с описанием.
   Альпинисты (полное имя; адрес проживания)
   Горы (название; страна; высота)
   Группа для восхождения на гору (альпинисты, записавшиеся в группу; идёт набор в группу или нет; гора; дата и время
   начала и окончания похода):
   `jpa -> entity2 -> классы Alpin, Hill, Group.`
   
2. Написать следующие SQL запросы:
   1) получить название гор, на которые уже состоялись восхождения
   `SELECT tb_hill.title AS hill_title
   FROM tb_hill 
   JOIN tb_group
   WHERE finish < LocalDateTime.now();`
   2) получить название гор, на которые не было ни одного восхождения
   `SELECT tb_hill.title AS hill_title
   FROM tb_hill
   JOIN tb_group
   WHERE begin > LocalDateTime.now();`
   3) получить имена альпинистов, которые ходили в поход на гору с определенным названием
   `SELECT tb_alpin.fullname AS alpin_fullname 
   FROM tb_alpin 
   JOIN alpin_group
   ON tb_alpin.id = alpin_group.alpin_id
   JOIN tb_group
   ON tb_group.id = alpin_group.group_id
   WHERE tb_group.hill.title = 'Elbrus' AND tb_group.finish < LocalDateTime.now();`

   4) получить названия и высоту гор, восхождение на которые планируется в определенный интервал времени
   `SELECT tb_hill.title AS hill_title, tb_hill.high AS hill_high
   FROM tb_hill
   JOIN tb_group
   WHERE begin BETWEEN '2023-06-22T10:00:00.000000000' AND '2023-06-22T17:00:00.000000000;'`

   5) получить имена альпинистов, которые не записались в новые (время начала похода в будущем) группы
    `SELECT tb_alpin.name AS alpin_name 
   FROM tb_alpin
   JOIN tb_group 
   WHERE finish < LocalDateTime.now();`

