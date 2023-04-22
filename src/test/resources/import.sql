INSERT INTO brands (brd_id, brd_nombre_cadena, brd_version) VALUES(1, 'ZARA', 1);

INSERT INTO productos (prd_id, prd_product_name, prd_version) VALUES (35455, 'product nombre - 35455', 1);

INSERT INTO rates (rts_id, rts_apply, rts_descripcion) VALUES (1, 5.0, 'Tarifa aplicable 5%'), (2, 2.0, 'Tarifa aplicable 2%'), (3, 8.0, 'Tarifa aplicable 8%'), (4, 10.0, 'Tarifa aplicable 10%');

INSERT INTO prices (prc_id, brd_id, start_date, end_date, rts_id, prd_id, priority, prc_price, curr) VALUES (1, 1, '2020-06-14 00:00:00.000000', '2020-12-31 23:59:59.000000', 1, 35455, 0, 35.50, 'EUR'), (2, 1, '2020-06-14 15:00:00.000000', '2020-06-14 18:30:00.000000', 2, 35455, 1, 25.45, 'EUR'), (3, 1, '2020-06-15 00:00:00.000000', '2020-06-15 11:00:00.000000', 3, 35455, 1, 30.50, 'EUR'), (4, 1, '2020-06-15 16:00:00.000000', '2020-12-31 23:59:59.000000', 4, 35455, 1, 38.95, 'EUR');