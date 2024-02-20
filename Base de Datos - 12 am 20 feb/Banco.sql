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
numeroCuenta varchar(6),
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
concepto varchar(30),
foreign key(idCuentaDestino) references cuentas(idCuenta),
foreign key(idTransaccion) references transacciones(idTransaccion),
foreign key(idCuentaRemitente) references cuentas(idCuenta)
);

create table retirosSinCuentas(
idRetiro int primary key auto_increment NOT NULL,
folio int (8),
cuenta varchar(30),
monto int,
fechaOperacion date,
fechaVencimiento date,
contraseña int (8),
estado varchar(30),
idTransaccion int,
foreign key(idTransaccion) references transacciones(idTransaccion)
);
create table cuentasEliminadas(
idCuenta int primary key auto_increment NOT NULL,
numeroCuenta int(6),
fechaApertura date,
fechaCierre date,
saldo int,
estado varchar(30),
idCliente int,
foreign key(idCliente) references clientes(idCliente)
);
CREATE TABLE historial (
    idHistorial INT AUTO_INCREMENT PRIMARY KEY,
    Operacion VARCHAR(50),
    idCuenta INT,
    monto INT,
    fechaHora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    foreign key(idCuenta) references cuentas(idCuenta)
);

 -- insert into clientes (nombre, apellidoPaterno, apellidoMaterno,fechaNacimiento, numeroCasa, calle, colonia, edad, usuario, contrasena) 
-- values ("Pablo", "Galan", "Valenzuela","2004/08/13", 1233, "Nohemi", "Municipio",19, "Pablo123", "1233");

-- insert into clientes (nombre, apellidoPaterno, apellidoMaterno,fechaNacimiento, numeroCasa, calle, colonia, edad, usuario, contrasena) 
-- values ("Yohan", "Melendrez", "Leal","2004/12/12", 1233, "Nohemi", "Casablanca",19, "Yohan123", "3321");
