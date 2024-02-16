create database banco;
use banco;

create table clientes(
idCliente int primary key auto_increment NOT NULL,
nombre varchar(30),
apellidoPaterno varchar(30),
apellidoMaterno varchar(30),
fechaNacimiento date,
numeroCasa int,
calle varchar(40),
colonia varchar(40),
edad int,
usuario varchar(30),
contrasena  varchar(30)
);
create table usuarios(
idUsuario int primary key auto_increment NOT NULL,
contrasena  varchar(30),
usuario varchar(30),
idCliente int,
foreign key(idCliente) references clientes(idCliente)	
);

create table cuentas(
idCuenta int primary key auto_increment NOT NULL,
numeroCuenta varchar(16),
fechaApertura date,
saldo int,
estado varchar(30),
idCliente int,
foreign key(idCliente) references clientes(idCliente)	
);

create table transacciones(
idTransaccion int primary key auto_increment NOT NULL,
nombreCliente varchar(30),
monto int,
fechaHora date
);

create table cuentas_tienen_transacciones(
idTiene int primary key auto_increment NOT NULL,
idCuenta int,
idTransaccion int,
foreign key(idCuenta) references cuentas(idCuenta),
foreign key(idTransaccion) references transacciones(idTransaccion)
);

create table transferencias(
idTransferencia int primary key auto_increment NOT NULL,
idTransaccion int,
idCuentaDestino int,
idCuentaRemitente int,
foreign key(idCuentaDestino) references cuentas(idCuenta),
foreign key(idTransaccion) references transacciones(idTransaccion),
foreign key(idCuentaRemitente) references cuentas(idCuenta)
);

create table retirosSinCuentas(
idRetiro int primary key auto_increment NOT NULL,
folio int (8),
contraseña int (8),
estado varchar(30),
idTransaccion int,
foreign key(idTransaccion) references transacciones(idTransaccion)
);
create table cuentasEliminadas(
idCuenta int primary key auto_increment NOT NULL,
numeroCuenta int(16),
fechaApertura date,
fechaCierre date,
saldo int,
estado varchar(30),
idCliente int,
foreign key(idCliente) references clientes(idCliente)
);
-- triggers 
delimiter $$
create trigger retiro_sin_cuenta
after update on retirossincuentas
for each row
begin
    -- Verifica si el estado se ha actualizado a 'completado'
    if new.estado = 'completado' then
        insert into retirosSincuentas (idretiro, folio, contraseña, estado, idtransaccion)
        values (new.idretiro, new.folio, new.contraseña, new.estado, new.idtransaccion);
    end if;
end $$
delimiter ;
-- triger para cuenta eliminadas
delimiter $$
create trigger cuenta_Eliminada
after update on cuentas
for each row
begin
    if new.estado = "eliminada" then
        -- Inserta en cuentasEliminadas
        insert into cuentasEliminadas (numerocuenta, fechaapertura, fechacierre, saldo, estado, idcliente)
        values (old.numerocuenta, old.fechaapertura, now(), old.saldo, "eliminada", old.idcliente);
    end if;
end $$
delimiter ;
