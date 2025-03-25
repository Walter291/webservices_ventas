CREATE PROCEDURE ObtenerReporteVentas
AS
BEGIN
    SELECT V.VendedorNombre, SUM(P.MontoVendido) AS TotalVentas
    FROM Producto_Asignado_Vendedor V
    JOIN Producto_Monto_Vendido P ON V.CodigoProducto = P.CodigoProducto
    GROUP BY V.VendedorNombre;
END;
