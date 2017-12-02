CREATE DATABASE IF NOT EXISTS si_factura;
USE si_factura;

CREATE TABLE users(
    id int auto_increment not null,
    name varchar(255),
    email varchar(255),
    password varchar(255),
    created_at datetime,
    updated_at datetime,
    CONSTRAINT pk_users PRIMARY KEY(id)
)ENGINE=InnoDb;

CREATE TABLE productos(
    id int auto_increment not null,
    nombre varchar(255),
    precio double(8,2),
    stock int,
    created_at datetime,
    updated_at datetime,
    CONSTRAINT pk_productos PRIMARY KEY(id)
)ENGINE=InnoDb;

CREATE TABLE facturas(
    id int auto_increment not null,
    nro int, 
    nit varchar(50),
    nombre varchar(100),
    fecha datetime,
    total_num double(8,2),
    total_lit varchar(100),
    user_id int not null,
    created_at datetime,
    updated_at datetime,
    CONSTRAINT pk_facturas PRIMARY KEY(id),
    CONSTRAINT fk_facturas_users FOREIGN KEY(user_id) REFERENCES users(id)
)ENGINE=InnoDb;

CREATE TABLE detalles(
    id int auto_increment not null,
    factura_id int not null,
    producto_id int not null,
    cantidad int, 
    precio double(8,2),    
    created_at datetime,
    updated_at datetime,
    CONSTRAINT pk_detalles PRIMARY KEY(id),
    CONSTRAINT fk_detalles_facturas FOREIGN KEY(factura_id) REFERENCES facturas(id),
    CONSTRAINT fk_detalles_productos FOREIGN KEY(producto_id) REFERENCES productos(id)
)ENGINE=InnoDb;