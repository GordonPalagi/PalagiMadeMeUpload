# Initializing a Database

### DB init Script

- When starting, make a directory in the src folder to keep it contained within the source folder, but out of the way.
- Create a new sql file called mysql-init.sql
- use this script

```sql
DROP DATABASE IF EXISTS "name-of-db";
DROP USER IF EXISTS `name-of-user-admin`@`%`;
CREATE DATABASE IF NOT EXISTS "name-of-db" CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `name-of-user-admin`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `name-of-db`.* TO `name-of-user-admin`@`%`;
```

- you can run it in MySQL workbench, and it'll run the script for you.


## Setting up MySQL Profile

- Start by creating a new properties file in /resources
- the convention is
  - application-"name of profile".sql
- then we can write

```properties
spring.datasource.username=nameOfAdminUsername
spring.datasource.password=password
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/nameOfAdminUsername?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
spring.jpa.database=mysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

```

- this will start the MySQL connection. The console should look something like this
  - HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@136bec8c
