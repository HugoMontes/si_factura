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

INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Aceite De Girasol', 10.50, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Aceite Mezcla', 18, 50, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Agua Mineralizada', 9, 10, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Ají Morrón', 30, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Alcohol Etilico', 12.50, 50, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Algodón', 6.10, 50, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Arroz', 12.90, 50, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Arvejas', 5.90, 60, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Atun al natural', 19.90, 30, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Azucar Blanca', 6.90, 30, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Cacao En Polvo', 7.70, 30, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Café Molido', 14.80, 30, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Caldo', 7.90, 30, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Carne Picada', 26.90, 30, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Cebolla', 6.50, 30, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Cerveza', 9.90, 30, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Crema De Leche Entera', 8.90, 30, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Cuaderno Escolar 50 hojas', 14.50, 30, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Carne Picada', 26.90, 30, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Carne Picada', 26.90, 30, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Carne Picada', 26.90, 30, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Calabacin en Espirales', 17.5, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Calabaza en Espirales', 12.5, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Dulce De Leche Entero Clásico', 12.10, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Esponja Para Lavar Platos', 3.99, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Fideos Secos ', 7.40, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Galletitas De Agua', 4.89, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Galletitas Dulces', 13.40, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Gaseosa Cola', 12.50, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Gaseosa Lima Limón', 12.50, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Hamburguesas De Carne', 22, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Harina De Maiz ', 5.79, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Harina De Trigo', 7.99, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Helado', 30.37, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Huevos Blancos', 8.55, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Jabon Blanco', 10.60, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Jamon Cocido', 90, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Jugo Sin Diluir', 9.50, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Jugos En Polvo', 1.60, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Lavandina Comun', 5.17, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Leche Comun', 7.20, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Lechuga', 11, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Lentejas Secas', 11.29, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Limpiador', 6.99, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Manteca', 11.50, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Mayonesa Común', 7.30, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Mermelada De Ciruela', 14.50, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Pan Blanco', 14.50, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Papa', 5.10, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Papel Higienico', 19.99, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Pañales Descartables', 44.14, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Pollo Congelado', 17, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Queso Crema Entero', 44.14, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Sal fina', 7.99, 20, NOW(), null);
INSERT INTO productos (nombre, precio, stock, created_at, updated_at) VALUES ('Patata en Espirales', 12.5, 20, NOW(), null);
