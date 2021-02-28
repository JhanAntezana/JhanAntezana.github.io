drop table usuarios;
drop table compras;
drop table juegos_en_carrito;
drop TABLE juegos;


Select *from usuarios where (username = 'mario.garcia@gmail.com' or email = 'mario.garcia@gmail.com') and password = 'Mario25';
SELECT *from juegos;
select *from usuarios;
SELECT *from juegos_en_carrito;
select *from juegos where nombre like '%Crash%';
SELECT *from compras;
SELECT id_usuario,compras.id_juego,cant_juego,estado,fecha_pedido,nombre,precio,consola,stock,descuento,descripcion,url 
from compras inner join juegos on compras.id_juego = juegos.id_juego;
UPDATE juegos set url = 'img/imgJuego/nintendoSwitch/DONKEY_KONG_COUNTRY_TROPICAL_FREEZE.jpg'
where id_juego = 9;