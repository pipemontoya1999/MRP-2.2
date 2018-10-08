Create database MRP2;
USE MRP2;
create table Bebida(
idBebida int primary key not null,
nombre varchar(100),
descripcion varchar(200),
Stock float(10),
costo float(10),
prefijoC varchar(10)
)ENGINE=INNODB;


create table demanda(
    idDemanda int  not null primary key,
    demanda double ,
    fecha date,
    idBebida int ,
    foreign key (idBebida) references Bebida(idBebida) ON UPDATE CASCADE ON DELETE SET NULL

)ENGINE=INNODB;

create table Proceso(
idProceso int primary key not null,
nombre varchar(100),
descripcion varchar(200),
duracion float(10)
)ENGINE=INNODB;

create table ProcesoBebida(
idProceso int ,
idBebida int ,
foreign key (idProceso) references proceso(idProceso) ON UPDATE CASCADE ON DELETE SET NULL,
foreign key (idBebida) references bebida(idBebida) ON UPDATE CASCADE ON DELETE SET NULL
)ENGINE=INNODB;

create table OrdenProduccion(
idOrdenProduccion int primary key not null  AUTO_INCREMENT,
Fecha date,
descripcion varchar(200)
)ENGINE=INNODB;

create table OrdenBebida(
IdOrdenProduccion int,
idBebida int,
Cantidad float(20),
foreign key (idOrdenProduccion) references OrdenProduccion(idOrdenProduccion) ON UPDATE CASCADE ON DELETE SET NULL,
foreign key (idBebida) references Bebida(idBebida) ON UPDATE CASCADE ON DELETE SET NULL
)ENGINE=INNODB;



create table Mantenimiento(
idMantenimiento int primary key not null,
idProceso int,
nombre varchar(40),
descripcion varchar(100),
capacidad float(10),
prefijo varchar(10),
stock float(10),
costo float(10),
prefijoC varchar(10),
foreign key (idProceso) references proceso(idProceso) ON UPDATE CASCADE ON DELETE SET NULL
);


create table ProductoProceso(
idProductoProceso int primary key not null,
idProceso int,
nombre varchar(40),
descripcion varchar(100),
stock float(10),
prefijo varchar(10),
costo float(10),
foreign key (idProceso) references proceso(idProceso) ON UPDATE CASCADE ON DELETE SET NULL
)ENGINE=INNODB;


create table MateriaPrima(
idInvMP int PRIMARY KEY not null,
idProceso int,
nombre varchar(100),
descripcion varchar(200),
stock float(10),
prefijo varchar(10),
costo float(10),
prefijoC varchar(10),
foreign key (idProceso) references proceso(idProceso) ON UPDATE CASCADE ON DELETE SET NULL
)ENGINE=INNODB;

create table Receta(
idBebida int ,
idInvMP int  ,
cantidad float(10) null,
primary key(idBebida, idInvMP),
foreign key (idBebida) references Bebida(idBebida) ON UPDATE CASCADE,
foreign key (idInvMP) references MateriaPrima(idInvMP) ON UPDATE CASCADE
)ENGINE=INNODB;

create table RecursoHumano(
    idRecursoHumano int primary key not null,
    idProceso int,
    documento varchar(30),
    nombre varchar(70),
    especialidad varchar(50),
    cantidad int, 
    costo float(10),    
    prefijo varchar(10),
    foreign key (idProceso) references proceso(idProceso) ON UPDATE CASCADE ON DELETE SET NULL
)ENGINE=INNODB;

create table InvProdProc(
idProdProc int not null,
idProceso int,
idBebida int,
nombre varchar(50),
cantidad float(10),
foreign key (idProceso) references proceso(idProceso) ON UPDATE CASCADE ON DELETE SET NULL,
foreign key (idBebida) references bebida(idBebida) ON UPDATE CASCADE ON DELETE SET NULL
);




