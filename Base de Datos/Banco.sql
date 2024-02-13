create database banco;
use banco;

create table clientes(
idCliente int primary key auto_increment NOT NULL,
nombreCompleto varchar(30),
fechaNacimiento date,
domicilio varchar(150),
edad int,
historial varchar(150)
);

create table cuentas(
idNumCuenta int(16) primary key,
contraseña int(12),
fechaApertura date,
saldo int,
domicilio varchar(150),
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
idNumCuenta int,
idTransaccion int,
foreign key(idNumCuenta) references cuentas(idNumCuenta),
foreign key(idTransaccion) references transacciones(idTransaccion)
);

create table transferencias(
idTransferencia int primary key auto_increment NOT NULL,
idTransaccion int,
foreign key(idTransaccion) references transacciones(idTransaccion)
);

create table retirosSinCuenta(
idRetiro int primary key auto_increment NOT NULL,
folio int (8),
contraseña int (8),
idTransaccion int,
foreign key(idTransaccion) references transacciones(idTransaccion)
);

