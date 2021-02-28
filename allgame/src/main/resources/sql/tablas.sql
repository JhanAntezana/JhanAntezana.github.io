create table usuarios(
    id_usuario serial PRIMARY key,
    nombre varchar (20) not null,
    apellido varchar (20) not null,
    username varchar (20) not null,
    email VARCHAR (40) not null,
    password VARCHAR (30) not null
);

CREATE TABLE juegos(
    id_juego serial PRIMARY key,
    nombre TEXT not null,
    precio FLOAT not null,
    consola VARCHAR (20) not null,
    stock int not null,
    descuento float DEFAULT 0.0,
    descripcion TEXT,
    url TEXT
);

CREATE table juegos_en_carrito (
    id_usuario int not null,
    id_juego int not null,
    cant_juego int,
    FOREIGN key (id_usuario) REFERENCES usuarios (id_usuario),
    FOREIGN key (id_juego) REFERENCES juegos (id_juego)
);

create table compras(
    id_usuario int not null,
    id_juego int not null,
    cant_juego int not null,
    estado VARCHAR(30) not null,
    fecha_pedido Date,
    fecha_entrega Date,
    FOREIGN key (id_usuario) references usuarios (id_usuario),
    FOREIGN key (id_juego) references juegos (id_juego)
);