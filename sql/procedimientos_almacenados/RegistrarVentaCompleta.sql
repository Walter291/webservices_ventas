CREATE PROCEDURE RegistrarVentaCompleta
    @VendedorNombre VARCHAR(100),
    @CodigoProducto INT,
    @Monto DECIMAL(10,2)
AS
BEGIN
    SET NOCOUNT ON;
    BEGIN TRY
        BEGIN TRANSACTION;
        
        -- Insertar asignación de vendedor si no existe
        IF NOT EXISTS (
            SELECT 1 
            FROM Producto_Asignado_Vendedor 
            WHERE VendedorNombre = @VendedorNombre AND CodigoProducto = @CodigoProducto
        )
        BEGIN
            INSERT INTO Producto_Asignado_Vendedor (VendedorNombre, CodigoProducto)
            VALUES (@VendedorNombre, @CodigoProducto);
        END

        -- Actualizar o insertar monto vendido
        IF EXISTS (SELECT 1 FROM Producto_Monto_Vendido WHERE CodigoProducto = @CodigoProducto)
        BEGIN
            UPDATE Producto_Monto_Vendido
            SET MontoVendido = MontoVendido + @Monto
            WHERE CodigoProducto = @CodigoProducto;
        END
        ELSE
        BEGIN
            INSERT INTO Producto_Monto_Vendido (CodigoProducto, MontoVendido)
            VALUES (@CodigoProducto, @Monto);
        END

        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        IF @@TRANCOUNT > 0
            ROLLBACK TRANSACTION;

        -- Manejar error (puedes retornar el error o manejarlo según convenga)
        THROW;
    END CATCH
END;
GO
