-- Insertar vendedores y sus productos asignados
INSERT INTO Producto_Asignado_Vendedor (VendedorNombre, CodigoProducto)
VALUES 
    ('Juan P�rez', 101),
    ('Mar�a L�pez', 102),
    ('Carlos D�az', 103);

-- Insertar montos de ventas por producto
INSERT INTO Producto_Monto_Vendido (CodigoProducto, MontoVendido)
VALUES 
    (101, 5000.00),
    (102, 7500.50),
    (103, 3200.75);
