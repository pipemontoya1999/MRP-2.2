Use MRP2;

select count(idOrdenProduccion) from OrdenProduccion;

insert into OrdenProduccion(idOrdenProduccion,Fecha,descripcion)
values(1,"2019-01-20","");



delete from OrdenProduccion where idOrdenProduccion >= 1;
ALTER TABLE ordenproduccion AUTO_INCREMENT = 1;
insert into OrdenProduccion(fecha,descripcion)
 values("1998-12-12",'no aplica');

delete from Demanda where idDemanda>0;

select idBebida,demanda, fecha from Demanda where fecha = "2019-01-20";

select idBebida,demanda, fecha from Demanda;

select idBebida,Stock from Bebida;

select distinct fecha from Demanda;

select* from ordenproduccion;

select dem.fecha as agregar,ord.fecha, count(ord.fecha) from ordenproduccion ord, demanda dem where ord.fecha <> dem.fecha group by dem.Fecha;

select count(idOrdenProduccion) from ordenproduccion;

select * from OrdenBebida;

delete from ordenbebida where idBebida>0;

select IdOrdenProduccion,fecha,descripcion from OrdenProduccion;

select* from ordenbebida;


select op.idOrdenProduccion, be.nombre, ob.cantidad, op.fecha from OrdenProduccion op, Bebida be, OrdenBebida ob 
where be.idBebida = ob.idBebida and op.idOrdenProduccion = ob.idOrdenProduccion and op.fecha='2019-01-20';


select re.idBebida, mp.idProceso, re.idInvMP, cantidad from receta re, MateriaPrima mp where re.idInvMP = mp.idInvMP and idBebida=1 and idProceso = 1 group by re.idInvMP ;