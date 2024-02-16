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
edad int
);
create table usuarios(
idUsuario int primary key auto_increment NOT NULL,
contrasena varchar(30),
usuario varchar(30),
idCliente int,
foreign key(idCliente) references clientes(idCliente)	
);

create table cuentas(
idCuenta int primary key auto_increment NOT NULL,
numeroCuenta int(16),
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
