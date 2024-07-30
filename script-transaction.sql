--Tipo de cuenta--
INSERT INTO public.cuenta_tipo_tbl (id, nombre) VALUES(1, 'Ahorros');
INSERT INTO public.cuenta_tipo_tbl (id, nombre) VALUES(2, 'Corriente');

--Cuenta--
INSERT INTO public.cuenta_tbl (es_primera_transaccion, saldo_inicial, id, tipo_cuenta, cuenta, estado, nombre_persona)
VALUES(true, 2000.00, 1, 1, '478758', 'ACTIVO', 'Jose Lema');

INSERT INTO public.cuenta_tbl (es_primera_transaccion, saldo_inicial, id, tipo_cuenta, cuenta, estado, nombre_persona)
VALUES(true, 100.00, 2, 2, '225487', 'ACTIVO', 'Marianela Montalvo');

INSERT INTO public.cuenta_tbl (es_primera_transaccion, saldo_inicial, id, tipo_cuenta, cuenta, estado, nombre_persona)
VALUES(true, 0.00, 3, 1, '495878', 'ACTIVO', 'Juan Osorio');

INSERT INTO public.cuenta_tbl (es_primera_transaccion, saldo_inicial, id, tipo_cuenta, cuenta, estado, nombre_persona)
VALUES(true, 540.00, 4, 1, '496825', 'ACTIVO', 'Marianela Montalvo');

--Transaccion
INSERT INTO public.movimiento_tbl(saldo, valor, cuenta, fecha, id, observacion, "type")
VALUES(700.00, 600.00, 2, '2022-02-10 19:12:49.685', 1, 'Transaccion Ejecutada', 'TRANSFERENCIA');

INSERT INTO public.movimiento_tbl(saldo, valor, cuenta, fecha, id, observacion, "type")
VALUES(0.00, 540.00, 2, '2022-02-08 19:12:49.685', 2, 'Transaccion Ejecutada', 'TRANSFERENCIA');

