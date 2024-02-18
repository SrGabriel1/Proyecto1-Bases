-- transacciones

-- transaccion para  realizar una transferencia
delimiter //
create procedure realizar_transferencia(in monto int,in cuenta_origen int,in cuenta_destino int)
begin
    start transaction;
    insert into transferencias (idCuentaDestino, idCuentaRemitente) values (cuenta_destino, cuenta_origen);

    -- Actualizar el saldo de la cuenta de destino
update cuentas
set saldo = saldo + monto
where idCuenta = cuenta_destino;

-- Actualizar el saldo de la cuenta remitente
update cuentas
set saldo = saldo - monto
where idCuenta = cuenta_origen;

commit;
end //
delimiter ;

-- transaccion para los retiros sin cuenta
delimiter //
create procedure realizar_retiroSinCuenta(
in folio int (8),
in cuenta varchar(30),
in monto int,
in fechaOperacion date,
in fechaVencimiento date,
in contraseña int (8),
in estado varchar(30)
)
begin
start transaction;
-- crear una transaccion
insert into transacciones (nombreCliente, monto, fechaHora)
values (concat("Retiro sin cuenta con Folio: ", folio), monto, now());

-- Obtener el id de la transacción 
set @idTransaccion = last_insert_id();

-- Obtener el ID del cliente que tiene la cuenta de donde se va retirar
set @idCliente = (select idCliente from cuentas where numeroCuenta = cuenta);

-- Actualizar el saldo del cliente restando el monto del retiro
update cuentas
set saldo = saldo - monto
where idCliente = @idCliente;
-- Insertar el retiro sin cuenta con las variables que se declaran arriba
insert into retirosSinCuentas (folio, cuenta, monto, fechaOperacion, fechaVencimiento,contraseña, estado, idTransaccion) 
values (folio, cuenta, monto, fechaOperacion, fechaVencimiento,contraseña, estado, idTransaccion);
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
in contrasena  varchar(30) 
)
begin
start transaction;
-- Insertar un nuevo cliente
insert into clientes (nombre, apellidoPaterno, apellidoMaterno,fechaNacimiento, numeroCasa, calle, colonia, edad, usuario, contrasena) 
values (nombre, apellidoPaterno, apellidoMaterno,fechaNacimiento, numeroCasa, calle, colonia,edad, usuario, contrasena);

-- Obtener el ID del nuevo cliente
set @id = last_insert_id();

-- Crear automáticamente una nueva cuenta para el cliente
insert into cuentas (idCliente, saldo, estado)
values (@id, 0, "Activa");
commit;
end //
delimiter ;