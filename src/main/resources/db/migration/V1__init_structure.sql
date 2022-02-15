CREATE SCHEMA IF NOT EXISTS carTravel ;

create table carTravel.user_role
(
    id   serial primary key,
    name varchar(255),
    role pg_roles
);

create table carTravel.users
(
    id           serial primary key,
    account      varchar(255),
    name         varchar(255) not null,
    user_role_id integer      not null,
    foreign key (user_role_id) references carTravel.user_role (id)
);

create table carTravel.tasks
(
    id   serial primary key,
    name varchar(255) not null
);

create table carTravel.issue
(
    id              serial primary key,
    date_done       time,
    description     varchar(255),
    name            varchar(255) not null,
    plan_date_end   time,
    plan_date_start time,
    task_writer_id  integer,
    executor_id     integer,
    tasks_id        integer,
    foreign key (task_writer_id) references carTravel.users (id),
    foreign key (executor_id) references carTravel.users (id),
    foreign key (tasks_id) references carTravel.tasks (id)
);

create table carTravel.car
(
    id            serial primary key,
    car_number    varchar(10) unique,
    model_name    varchar(255) not null,
    producer_name varchar(255) not null
);