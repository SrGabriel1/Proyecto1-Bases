-- Triggers

-- triger para cuenta eliminadas
delimiter //
create trigger cuentaEliminada
after update on cuentas
for each row
begin
if new.estado = "cancelada" then
-- Inserta en cuentasEliminadas
insert into cuentaseliminadas (numerocuenta, fechaapertura, fechacierre, saldo, estado, idcliente)
values (old.numerocuenta, old.fechaapertura, now(), old.saldo, "eliminada", old.idcliente);
  CALL registrar_historial("cuenta cancelada", old.numerocuenta, -old.saldo);
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

select monto into monto from transacciones where idTransaccion=new.idTransaccion;
if monto > 10000 then
set new.idCuentaDestino = null;
end if;
end //
delimiter ;

-- Trigger para guardar en historial las cuentas creadas
delimiter //
create trigger historial_cuenta
after insert on cuentas
for each row
begin
call registrarHistorial("Creación de cuenta", new.idCuenta, 0);
end //
delimiter ;

-- Trigger para guardar en historial las transferencias
delimiter //
create trigger historial_transferencia
after insert on transferencias
for each row 
begin
declare monto int;

select monto into monto from transacciones where idTransaccion = new.idTransaccion;
call registrarHistorial("Transferencia", new.idCuentaRemitente, monto);
call registrarHistorial("Transferencia", new.idCuentaDestino, -monto);
end //
delimiter ;
-- Trigger para guardar en historial los retiros sin cuentas
delimiter //
create trigger historial_retiroSinCuenta
after insert on retirosSinCuentas
for each row 
begin
call registrarHistorial("Retiro sin cuenta", NEW.cuenta, -NEW.monto);
end //
delimiter ;
delimiter //
-- trigger para  calcular la edad
create trigger calcular_edad
before insert on clientes
for each row
set new.edad = (year(curdate()) - year(new.fechaNacimiento)) - (right(curdate(), 5) < right(new.fechaNacimiento, 5));

//
delimiter ;
