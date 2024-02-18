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