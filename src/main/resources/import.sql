
#CLIENTES
insert into clientes (direccion, edad, genero, identificacion, nombre, telefono, contrasena, estado) values ("Otavalo sn y principal", null, null, null, "Jose Lema", "098254785", "1234", true);
insert into clientes (direccion, edad, genero, identificacion, nombre, telefono, contrasena, estado) values ("Amazonas y NNUU", null, null, null, "Marianela Montalvo", "097548965", "5678", true);
insert into clientes (direccion, edad, genero, identificacion, nombre, telefono, contrasena, estado) values ("13 junio y Equinoccial", null, null, null, "Juan Osorio", "098874587", "1245", true);

#CUENTAS
insert into cuentas (cliente_id, estado, numero_cuenta, saldo_inicial, tipo_cuenta) values (1, true, 478758, 2000, 0);

insert into cuentas (cliente_id, estado, numero_cuenta, saldo_inicial, tipo_cuenta) values (2, true, 225487, 100, 1);

insert into cuentas (cliente_id, estado, numero_cuenta, saldo_inicial, tipo_cuenta) values (3, true, 495878, 0, 0);

insert into cuentas (cliente_id, estado, numero_cuenta, saldo_inicial, tipo_cuenta) values (2, true, 496825, 540, 0);

insert into cuentas (cliente_id, estado, numero_cuenta, saldo_inicial, tipo_cuenta) values (1, true, 585545, 1000, 1);