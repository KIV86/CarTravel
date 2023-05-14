INSERT INTO cartravel.user_role
VALUES (1, 'boss');
INSERT INTO cartravel.user_role
VALUES (2, 'slave');

INSERT INTO cartravel.car
VALUES (1, 'A111AA193', 'Kia', 'Rio');
INSERT INTO cartravel.car
VALUES (2, 'A222AA777', 'Lada', '2407');
INSERT INTO cartravel.car
VALUES (3, 'A333AA000', 'BMW', 'X7');

INSERT INTO cartravel.tasks
VALUES (1, 'Провести предпродажную подготовку автомоиля');
INSERT INTO cartravel.tasks
VALUES (2, 'Провести техническое обслуживаниек автомобиля');
INSERT INTO cartravel.tasks
VALUES (3, 'Сдать автомобиль клиенту');
INSERT INTO cartravel.tasks
VALUES (4, 'Принять автомобиль от клиента');

INSERT INTO cartravel.users
VALUES (1, '@Andrew', 'Андрей', 1);
INSERT INTO cartravel.users
VALUES (2, '@Dima', 'Дима', 2);

INSERT INTO cartravel.issue (id, name, executor_id, plan_date_start, plan_date_end, task_writer_id, tasks_id)
VALUES (1, 'помыть авто', 2, '2022-06-23T05:55:55'::timestamptz AT TIME ZONE 'Europe/Moscow',
        '2022-06-24T05:55:55'::timestamptz AT TIME ZONE 'Europe/Moscow', 1, 3);
INSERT INTO cartravel.issue (id, name, executor_id, plan_date_start, plan_date_end, task_writer_id, tasks_id)
VALUES (2, 'заменить авто', 2, '2022-07-01T05:55:55'::timestamptz AT TIME ZONE 'Europe/Moscow',
        '2022-07-02T05:55:55'::timestamptz AT TIME ZONE 'Europe/Moscow', 1, 4);
INSERT INTO cartravel.issue (id, name, executor_id, plan_date_start, plan_date_end, task_writer_id, tasks_id)
VALUES (3, 'ТО для авто', 2, '2022-08-01T05:55:55'::timestamptz AT TIME ZONE 'Europe/Moscow',
        '2022-08-02T05:55:55'::timestamptz AT TIME ZONE 'Europe/Moscow', 1, 2);

