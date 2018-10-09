UsE MRP2;

insert into Bebida(idBebida,nombre,descripcion,Stock)
values (1,"Cerveza tipo Lagger","",10), (2,"Cerveza tipo Lagger Light","",10), (3,"Cerveza tipo Lagger Cero","",10),
(4,"Cerveza tipo Lambic","",10), (5,"Cerveza tipo ALE","",10), (6,"Gaseosa tipo refajo","",10),
(7,"Gaseosa sabor limón","",10),(8,"Gaseosa sabor tamarindo","",10),(9,"Gaseosa tipo cola","",10),
(10,"Gaseosa sabor Naranja","",10);

select idBebida,nombre,Stock from Bebida where idBebida=1;

insert into Demanda (idDemanda,idBebida,demanda,fecha)
values
(1,1,150,"2019-01-20"),
(2,2,150,"2019-01-20"),
(3,3,150,"2019-01-20"),
(4,4,150,"2019-01-20"),
(5,5,150,"2019-01-20"),
(6,6,150,"2019-01-20"),
(7,7,150,"2019-01-20"),
(8,8,150,"2019-01-20"),
(9,9,150,"2019-01-20"),
(10,10,150,"2019-01-20");

insert into Demanda (idDemanda,idBebida,demanda,fecha)
values
(11,1,200,"2019-02-20"),
(12,2,250,"2019-02-20"),
(13,3,270,"2019-02-20"),
(14,4,320,"2019-02-20"),
(15,5,210,"2019-02-20"),
(16,6,180,"2019-02-20"),
(17,7,140,"2019-02-20"),
(18,8,100,"2019-02-20"),
(19,9,25,"2019-02-20"),
(20,10,50,"2019-02-20");

insert into Demanda (idDemanda,idBebida,demanda,fecha)
values
(21,1,15,"2019-03-20"),
(22,2,15,"2019-03-20"),
(23,3,15,"2019-03-20"),
(24,4,15,"2019-03-20"),
(25,5,15,"2019-03-20"),
(26,6,15,"2019-03-20"),
(27,7,15,"2019-03-20"),
(28,8,15,"2019-03-20"),
(29,9,15,"2019-03-20"),
(30,10,15,"2019-03-20");

insert into Demanda (idDemanda,idBebida,demanda,fecha)
values
(31,1,95,"2019-04-20"),
(32,2,95,"2019-04-20"),
(33,3,95,"2019-04-20"),
(34,4,95,"2019-04-20"),
(35,5,95,"2019-04-20"),
(36,6,10,"2019-04-20"),
(37,7,10,"2019-04-20"),
(38,8,10,"2019-04-20"),
(39,9,10,"2019-04-20"),
(40,10,10,"2019-04-20");

insert into Demanda (idDemanda,idBebida,demanda,fecha)
values
(41,1,10,"2019-05-20"),
(42,2,10,"2019-05-20"),
(43,3,10,"2019-05-20"),
(44,4,10,"2019-05-20"),
(45,5,10,"2019-05-20"),
(46,6,10,"2019-05-20"),
(47,7,95,"2019-05-20"),
(48,8,95,"2019-05-20"),
(49,9,95,"2019-05-20"),
(50,10,95,"2019-05-20");


insert into OrdenProduccion(fecha,descripcion)
 values("1998-12-12",'no aplica');
 
 insert into proceso (idProceso, nombre, descripcion, duracion)
values (1,"Triturado de malta","",1),(2,"Macerado","",2),(3,"Filtrado y aclarado","",2),(4,"Fermentación","",168),
(5,"Maduración","",720),(6,"Filtración","",5),(7,"Mezclado","",2),(8,"Gasificación","",1),(9,"Embotellado","",1);

select idProceso,duracion from proceso where idProceso=5;

insert into MateriaPrima(idInvMP,idProceso, nombre, descripcion, stock, prefijo,costo,prefijoC)
values (1,1,"Malta Pilsen","",30.6,"kg",1500,"pesos/kg"), (2,1,"Malta Munich","",1800,"kg",1800,"pesos/kg"), (3,1,"Malta Carahell","",1200,"kg",1600,"pesos/kg");
insert into MateriaPrima(idInvMP,idProceso, nombre, descripcion, stock, prefijo,costo,prefijoC)
values(4,2,"Lupulo Saaz","",1.2,"kg",2000,"pesos/kg"), (5,4,"Levadura Mangrove","",100,"kg",1800,"pesos/kg"), (6,2,"Irish Moss","",200,"kg",2200,"pesos/kg");

insert into MateriaPrima(idInvMP,idProceso, nombre, descripcion, stock, prefijo,costo,prefijoC)
values(7,2,"Agua para macerado","",60,"Litros",450,"pesos/Lt"), (8,2,"Lupulo viejo","",50,"kg",2200,"pesos/kg"), (9,4,"Levadura de Brucelas","",90,"kg",2000,"pesos/kg");
insert into MateriaPrima(idInvMP,idProceso, nombre, descripcion, stock, prefijo,costo,prefijoC)
values(10,4,"Levadura saccharomyces cervesia","",90,"kg",1900,"pesos/kg"), (11,7,"Sodio","",1100,"kg",980,"pesos/kg"), (12,7,"Potasio","",900,"kg",5000,"pesos/kg");
insert into MateriaPrima(idInvMP,idProceso, nombre, descripcion, stock, prefijo,costo,prefijoC)
values(13,7,"Azucares","",5000,"kg",1400,"pesos/kg"), (14,2,"Agua para lavado","",60,"Litros",20,"pesos/Lt"), (15,7,"Saborizante de limon","",100,"kg",18,"pesos/kg");
insert into MateriaPrima(idInvMP,idProceso, nombre, descripcion, stock, prefijo,costo,prefijoC)
values(16,7,"Acidulante","",30,"L",1800,"pesos/l"), (17,7,"Saborizante de Cremasoda","",1000,"kg",1500,"pesos/kg"), (18,7,"Saborizante de Cola","",100,"kg",1500,"pesos/kg");
insert into MateriaPrima(idInvMP,idProceso, nombre, descripcion, stock, prefijo,costo,prefijoC)
values(19,7,"Saborizante de Naranja","",100,"kg",1500,"pesos/kg"), (20,1,"Malta de Trigo","",15,"kg",1700,"pesos/kg"), (21,7,"melaza","",2000,"kg",2200,"pesos/kg");
insert into MateriaPrima(idInvMP,idProceso, nombre, descripcion, stock, prefijo,costo,prefijoC)
values(22,7,"Azucar morena","",2000,"kg",1100,"pesos/kg"),(23,9,"Envases","",90,"und",15,"pesos/und"),(24,7,"Saborizante de Tamarindo","",100,"kg",1300,"pesos/kg");
insert into MateriaPrima(idInvMP,idProceso, nombre, descripcion, stock, prefijo,costo,prefijoC)
values(25,7,"Agua Comun","",60,"Litros",450,"pesos/Lt");



insert into receta(idBebida,idInvMP,cantidad)
values (1,1,0.084), (1,2,0.008),(1,3,0.0008),(1,4,0.002),(1,5,0.000320),(1,6,0.0001),(1,7,0.276),(1,14,0.326),(1,23,1),
       (2,1,0.084), (2,2,0.008),(2,3,0.0008),(2,4,0.002),(2,5,0.000240),(2,6,0.0001),(2,7,0.276),(2,14,0.326),(2,23,1),
       (3,1,0.084), (3,2,0.008),(3,3,0.0008),(3,4,0.002),(3,5,0.000120),(3,6,0.0001),(3,7,0.276),(3,14,0.326),(3,23,1),
       (4,1,0.084), (4,8,0.002),(4,9,0.00024),(4,6,0.0001),(4,7,0.276),(4,14,0.326),(4,23,1),
       (5,1,0.084), (5,2,0.008),(5,4,0.002),(5,10,0.000320),(5,6,0.0001),(5,7,0.276),(5,14,0.326),(5,23,1),
       (6,1,0.042), (6,2,0.004),(6,3,0.0004),(6,4,0.001),(6,5,0.000160),(6,6,0.00005),(6,7,0.238),(6,14,0.163),
	   (6,11,0.000002), (6,12,0.0000024),(6,13,0.008),(6,17,0.005),(6,16,0.005),(6,23,1),
       (7,11,0.000004), (7,12,0.000003),(7,13,0.022),(7,25,0.2),(7,15,0.005),(7,16,0.010),(7,23,1),
       (8,11,0.000004), (8,12,0.000003),(8,13,0.022),(8,25,0.2),(8,24,0.005),(8,16,0.010),(8,23,1),
       (9,11,0.000004), (9,12,0.000003),(9,13,0.022),(9,25,0.2),(9,18,0.005),(9,16,0.010),(9,23,1),
       (10,11,0.000004), (10,12,0.000003),(10,13,0.022),(10,25,0.2),(10,19,0.005),(10,16,0.010),(10,23,1);
   select be.nombre, mp.nombre, re.cantidad from receta re, materiaprima mp, bebida be
   where re.idInvMP = mp.idInvMP and re.idBebida = be.idBebida and be.nombre='Gaseosa tipo refajo';    
insert into ProcesoBebida(idProceso,idBebida)
values (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(9,1),
(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(9,2),
(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(9,3),
(1,4),(2,4),(3,4),(4,4),(5,4),(6,4),(9,4),
(1,5),(2,5),(3,5),(4,5),(5,5),(6,5),(9,5),
(1,6),(2,6),(3,6),(4,6),(5,6),(6,6),(7,6),(8,6),(9,6),
(7,7),(8,7),(9,7),
(7,8),(8,8),(9,8),
(7,9),(8,9),(9,9),
(7,10),(8,10),(9,10);

select count(idBebida), idProceso from ProcesoBebida where idBebida = 8 and idProceso=1;
insert into Mantenimiento(idProceso,idMantenimiento, nombre, descripcion, capacidad, prefijo, stock,costo,prefijoC)
values (1,1,"Molino","Maquinaria de produccion",60,"kg/H",1,18,"pesos/H"),
(2,2,"Hervidor","Maquinaria de produccion",300,"Lt",1,40,"pesos/H"),
(4,3,"Tanque de fermentación","Maquinaria de produccion",300,"Lt",1,31,"pesos/H"), 
(9,4,"Embotelladora","Maquinaria de produccion",4000,"bph",1,25,"pesos/H");

insert into Mantenimiento(idProceso,idMantenimiento, nombre, descripcion, capacidad, prefijo, stock,costo,prefijoC)
values(6,5,"Filtro de tierras","",300,"Lt/H",1,35,"pesos/H"), 
(7,6,"Mezcladora","",45,"Kg/H",1,25,"pesos/H"), 
(8,7,"Carbonatadora","",40,"Lt/H",1,30,"pesos/H"),
(3,9,"Tamizadora","",300,"Lt/H",1,35,"pesos/H"),
(5,10,"Tanque de acondicionamiento","",300,"Lt",1,31,"pesos/H");


insert into InvProdProc(idProdProc,idProceso,idBebida,nombre,cantidad)
values (1,2,1,"maltas trituradas",0.0928), (2,2,2,"maltas trituradas",0.0928),(3,2,3,"maltas trituradas",0.0928),
(4,2,4,"malta pilsen triturada",0.084),(5,2,5,"malta pilsen y munich trituradas",0.084),
(6,2,6,"maltas trituradas",0.0464),(7,4,1,"producto aclarado",0.37);

       
select idMantenimiento, capacidad, prefijo from Mantenimiento where idProceso = 6
       
