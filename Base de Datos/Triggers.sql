-- Triggers

-- triger para cuenta eliminadas
delimiter //
create trigger cuentaEliminada
after update on cuentas
for each row
begin
if new.estado = "eliminada" then
-- Inserta en cuentasEliminadas
insert into cuentaseliminadas (numerocuenta, fechaapertura, fechacierre, saldo, estado, idcliente)
values (old.numerocuenta, old.fechaapertura, now(), old.saldo, "eliminada", old.idcliente);
end if;
end //
delimiter ;

-- trigger para que no se pase el retiro del saldo que tiene en  la cuenta del cliente
delimiter //
create trigger bloquear_retiro_sin_cuenta
before insert on retirosSinCuentas
for each row
begin
declare saldo int;

-- Se obtiene  el saldo  de la cuenta de donde se quiere retirar
select saldo into saldo from cuentas where idCuenta = new.cuenta;
    
if new.monto > saldo then
set new.monto = 0;
end if;
end //
delimiter ;

-- trigger para que en una transferencia  no se pase  del saldo que tiene en  la cuenta del cliente
delimiter //
create trigger bloquear_transferencia
before insert on transferencias
for each row
begin
declare saldo int;
declare monto int;

-- Se obtiene  el saldo  de la cuenta de donde se quiere transferir
-- Se obtiene el monto que se quiere transferir desde transaccion
select monto into monto from transacciones where idTransaccion=new.idTransaccion;
if monto > 10000 then
set new.idCuentaDestino = null;
end if;
end //
delimiter ;
