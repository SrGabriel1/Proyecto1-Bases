@ -0,0 +1,126 @@
-- transacciones

-- transaccion para  realizar una transferencia
delimiter //
create procedure realizar_transferencia(in monto int,in cuenta_origen varchar(6),in cuenta_destino varchar(6),in concepto varchar(30))
begin
declare id_cuenta_origen int;
declare id_cuenta_destino int;
declare id_transaccion int;

start transaction;

-- Actualizar el saldo de la cuenta remitente
update cuentas
set saldo = saldo - monto
where numeroCuenta = cuenta_origen;

-- Actualizar el saldo de la cuenta de destino
update cuentas
set saldo = saldo + monto
where numeroCuenta = cuenta_destino;

-- Obtener los IDs de las cuentas
select idCuenta into id_cuenta_origen
from cuentas
where numeroCuenta = cuenta_origen;

select idCuenta into id_cuenta_destino
from cuentas
where numeroCuenta = cuenta_destino;

-- Insertar una nueva transacción
insert into transacciones (nombreCliente, monto, fechaHora)
values (concat("Transferencia - Concepto: ", concepto), monto, now());

-- Obtener el ID de la transacción creada
select last_insert_id() into id_transaccion;

-- Insertar en la tabla de transferencias
insert into transferencias (idTransaccion, idCuentaDestino, idCuentaRemitente, concepto)
values (id_transaccion, id_cuenta_destino, id_cuenta_origen, concepto);
commit;
end //
delimiter ;

-- transaccion para los retiros sin cuenta
delimiter //
create procedure crear_retiroSinCuenta(
in folio int (8),
in cuenta varchar(30),
in monto int,
in contraseña int (8)
)
begin
start transaction;
-- crear una transaccion
insert into transacciones (nombreCliente, monto, fechaHora)
values (concat("Retiro sin cuenta: ", folio), monto, now());

-- Obtener el id de la transacción 
set @idTransaccion = last_insert_id();

-- Insertar el retiro sin cuenta con las variables que se declaran arriba
insert into retirosSinCuentas (folio, cuenta, monto, fechaOperacion, fechaVencimiento,contraseña, estado, idTransaccion) 
values (folio, cuenta, monto, now(), date_add(now(), INTERVAL 10 MINUTE),contraseña, "Sin Cobrar", @idTransaccion);
commit;
end //
delimiter ;

-- transaccion para los retiros sin cuenta
delimiter //
create procedure realizar_retiroSinCuenta(
in folio int (8),
in contraseña int (8)
)
begin
start transaction;
update retiroSinCuentas set estado="Cobrado" where contraseña=contraseña and folio=folio;
-- Obtener el monto que contenga el folio 
set @monto = (select monto from retiroSinCuentas where contraseña=contraseña and folio=folio);

-- Obtener el ID de la cuenta que contenga el folio 
set @idCuenta = (select cuenta from retiroSinCuentas where contraseña=contraseña and folio=folio);

-- Obtener el ID del cliente que tiene la cuenta de donde se va retirar
set @idCliente = (select idCliente from cuentas where numeroCuenta = @idCuenta);

-- Actualizar el saldo del cliente restando el monto del retiro
update cuentas
set saldo = saldo - @monto
where idCliente = @idCliente;

commit;
end //
delimiter ;

-- transaccion para que se cree en automatico una cuenta para el cliente al momento de  que se cree un nuevo cliente
delimiter //
create procedure crear_cliente_con_cuenta(
in nombre varchar(30),
in apellidoPaterno varchar(30),
in apellidoMaterno varchar(30),
in fechaNacimiento date,
in numeroCasa int,
in calle varchar(40),
in colonia varchar(40),
in edad int,
in usuario varchar(30),
in contrasena  varchar(30) ,
in numeroCuenta varchar(6)
)
begin
start transaction;
-- Insertar un nuevo cliente
insert into clientes (nombre, apellidoPaterno, apellidoMaterno,fechaNacimiento, numeroCasa, calle, colonia, edad, usuario, contrasena) 
values (nombre, apellidoPaterno, apellidoMaterno,fechaNacimiento, numeroCasa, calle, colonia,edad, usuario, contrasena);

-- Obtener el ID del nuevo cliente
set @id = last_insert_id();

-- Crear automáticamente una nueva cuenta para el cliente
insert into cuentas (idCliente, numeroCuenta,fechaApertura,saldo, estado)
values (@id,numeroCuenta,now(), 0, "Activa");
commit;
end //
delimiter ;