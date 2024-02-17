-- triger para cuenta eliminadas
delimiter $$
create trigger cuenta_Eliminada
after update on cuentas
for each row
begin
    if new.estado = "eliminada" then
        -- Inserta en cuentasEliminadas
        insert into cuentaseliminadas (numerocuenta, fechaapertura, fechacierre, saldo, estado, idcliente)
        values (old.numerocuenta, old.fechaapertura, now(), old.saldo, "eliminada", old.idcliente);
    end if;
end $$
delimiter ;
