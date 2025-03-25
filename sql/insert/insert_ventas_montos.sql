-- Insertar vendedores y sus productos asignados
INSERT INTO Producto_Asignado_Vendedor (VendedorNombre, CodigoProducto)
VALUES 
    ('Juan Pérez', 101),
    ('María López', 102),
    ('Carlos Díaz', 103);

-- Insertar montos de ventas por producto
INSERT INTO Producto_Monto_Vendido (CodigoProducto, MontoVendido)
VALUES 
    (101, 5000.00),
    (102, 7500.50),
    (103, 3200.75);
