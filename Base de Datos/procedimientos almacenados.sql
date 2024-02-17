-- procedimientos almacenados

-- Procedimiento para encontrar un cliente por su id y mostrar sus datos
delimiter //
create procedure clientePorID(in id_Cliente int)
begin
    select *
    from clientes
    where idcliente = id_Cliente;
    

    select *
    from cuentas
    where idcliente = id_Cliente;
    
end //
delimiter ;