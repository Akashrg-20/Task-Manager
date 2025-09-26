CREATE DATABASE IF NOT EXISTS projects;

USE projects;

CREATE TABLE todo_tasks(
 id INT  AUTO_INCREMENT PRIMARY KEY,
 task VARCHAR(255),
 status VARCHAR(255)
);

SELECT * FROM todo_tasks;

DROP TABLE todo_tasks;


