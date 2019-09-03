--CUSTOMERS
insert into customer (id, active, email, first_name, last_name, telephone_number)
    values (1, TRUE, 'fasola@fasola.pl', 'Jan', 'Fasola', '0735787921');
insert into customer (id, active, email, first_name, last_name, telephone_number)
    values (2, TRUE, 'kazik@kazik.pl', 'Kazik', 'Kazikowski', '0755647890');
insert into customer (id, active, email, first_name, last_name, telephone_number)
    values (3, TRUE, 'pawel@pawel.pl', 'Pawel', 'Pawlowski', '0778999654');
insert into customer (id, active, email, first_name, last_name, telephone_number)
    values (4, TRUE, 'pawel@gawel.pl', 'Pawel', 'Gawel', '0798234532');
----------

--ADDRESSES
insert into address (id, city, street_name, zip_code) values (1, 'Gdansk', 'Gdanska 2', '12345');
insert into address (id, city, street_name, zip_code) values (2, 'Warszawa', 'Warszawska 33', '54321');
insert into address (id, city, street_name, zip_code) values (3, 'Poznan', 'Poznanska 1', '11222');
insert into address (id, city, street_name, zip_code) values (4, 'Gizycko', 'Gizycka 5', '55555');
----------

--PROJECTS
insert into project (id, active, address_id, customer_id, project_name) values (1, TRUE, 1, 1, 'Mieszkanie Gdansk');
insert into project (id, active, address_id, customer_id, project_name) values (2, TRUE, 2, 1, 'Remont Wawa');
insert into project (id, active, address_id, customer_id, project_name) values (3, TRUE, 3, 2, 'Nowa instalacja Poznan');
insert into project (id, active, address_id, customer_id, project_name) values (4, TRUE, 4, 3, 'Wakacje Gizycko');
----------

--WORKER TYPE
insert into worker_type (id, type) values ( 1, 'elektryk');
insert into worker_type (id, type) values ( 2, 'student');
insert into worker_type (id, type) values ( 3, 'pomocnik');
-------------

--UNIT OF REST
insert into unit_of_rest (id, value) VALUES (1, 0);
insert into unit_of_rest (id, value) VALUES (2, 0.5);
insert into unit_of_rest (id, value) VALUES (3, 1);

--ROLES
insert into role (id, name) values (1, 'ROLE_USER');
insert into role (id, name) values (2, 'ROLE_ADMIN');
----------

--WORKERS
insert into worker (id, active, email, first_name, last_name, telephone_number, password, type_id, username)
    values (1, TRUE, 'jaroslaw@jaroslaw.pl', 'Jaroslaw', 'Jaroslawowicz', '0987654321', '$2a$10$yxiR9RmhXVyxQ.2WITOZZOUUr7d4xOnnfXRzMFIho78aPf/GQMgpS', 1, 'jaroslaw');
insert into worker_role (worker_id, role_id) values (1, 1);

insert into worker (id, active, email, first_name, last_name, telephone_number, password, type_id, username)
    values (2, TRUE, 'antoni@antoni.pl', 'Antoni', 'Antonowicz', '1234567890', '$2a$10$5hc8Ne72dRmh4uJDBntpReNeKu.QTRmEK3Fgdynp8vGkUUNXIw3d.', 1, 'antoni');
insert into worker_role (worker_id, role_id) values (2, 1);

insert into worker (id, active, email, first_name, last_name, telephone_number, password, type_id, username)
values (3, TRUE, 'admin@admin.pl', 'Admin', 'Adminowicz', '0989765267', '$2a$04$uqHSunVw7cVxFYlRCjklgulSzLqNgTl5TR3/gB8sDST7LDr6/tPvO', 2, 'admin');
insert into worker_role (worker_id, role_id) values (3, 2);
----------

--REPORTS
insert into report (id, description, finish_work, project_id, start_work, total_hours, unit_of_rest_id, work_date, worker_id)
    values (1, 'Remont', '16:00:00', 1, '08:00:00', 7.00, 3, '2019-08-29', 1);
insert into worker_project (worker_id, project_id) values (1, 1);

insert into report (id, description, finish_work, project_id, start_work, total_hours, unit_of_rest_id, work_date, worker_id)
    values (2, 'Remont', '16:00:00', 1, '08:00:00', 7.00, 3, '2019-08-29', 2);
insert into worker_project (worker_id, project_id) values (2, 1);

insert into report (id, description, finish_work, project_id, start_work, total_hours, unit_of_rest_id, work_date, worker_id)
    values (3, 'Przygotowanie', '16:00:00', 2, '07:00:00', 8.00, 3, '2019-08-30', 1);
insert into worker_project (worker_id, project_id) values (1, 2);

insert into report (id, description, finish_work, project_id, start_work, total_hours, unit_of_rest_id, work_date, worker_id)
    values (4, 'Nowa instalacja', '16:00:00', 3, '08:00:00', 7.00, 3, '2019-08-30', 2);
insert into worker_project (worker_id, project_id) values (2, 3);

insert into report (id, description, finish_work, project_id, start_work, total_hours, unit_of_rest_id, work_date, worker_id)
    values (5, 'Praca extra', '16:00:00', 4, '08:00:00', 7.00, 3, '2019-08-31', 1);
insert into worker_project (worker_id, project_id) values (1, 4);

insert into report (id, description, finish_work, project_id, start_work, total_hours, unit_of_rest_id, work_date, worker_id)
    values (6, 'Praca extra', '16:00:00', 4, '08:00:00', 7.00, 3, '2019-08-31', 2);
insert into worker_project (worker_id, project_id) values (2, 4);

insert into report (id, description, finish_work, project_id, start_work, total_hours, unit_of_rest_id, work_date, worker_id)
    values (7, 'Sciemnianie', '16:00:00', 1, '08:00:00', 7.00, 3, '2019-09-01', 1);
-------------------





