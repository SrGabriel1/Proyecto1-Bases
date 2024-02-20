-- procedimientos almacenados

-- Procedimiento para encontrar un cliente por su id y mostrar sus datos
delimiter //
create procedure clientePorID(in idCliente int)
begin
-- se busca y se encuentra toda la informacion del cliente
select *from clientes where idcliente = idCliente;
end //
delimiter ;

-- Procedimiento para encontrar una cuenta por el nombre de usuario y mostrar sus datos
delimiter //
create procedure cuentaPorNumero(in numeroCuenta varchar(6))
begin
-- se busca y se encuentra toda la informacion de la cuenta del cliente
select c.*
from cuentas c 
where c.numeroCuenta = numeroCuenta;
end //
delimiter ;
-- procedimiento almacenado para registrar el historial
delimiter //
create procedure registrarHistorial(in operacion varchar(50), in idCuenta int, in monto int)
begin
    insert into historial (Operacion, idCuenta, monto) values (operacion, idCuenta, monto);
end //
delimiter ;
-- procedimiento almacenado para hacer un deposito
delimiter //
create procedure deposito( in idcuenta int, in monto int,in oncepto varchar(50)
)
begin
update cuentas set saldo = saldo + monto where idcuenta = idcuenta;
insert into historial (operacion, idcuenta, monto) values (concepto, idcuenta, monto);
end//
delimiter ;