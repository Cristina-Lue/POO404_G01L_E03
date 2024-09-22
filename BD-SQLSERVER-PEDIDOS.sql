CREATE TABLE [cliente] (
  [idcliente] integer PRIMARY KEY,
  [nombre] nvarchar(255),
  [username] nvarchar(255),
  [contraseña] nvarchar(255),
  [email] nvarchar(255),
  [direccion] nvarchar(255),
  [telefono] nvarchar(255),
  [fechaNacimiento] date
)
GO

CREATE TABLE [empleado] (
  [idEmpleado] integer PRIMARY KEY,
  [nombre] nvarchar(255),
  [username] nvarchar(255),
  [contraseña] nvarchar(255),
  [email] nvarchar(255),
  [telefono] nvarchar(255),
  [fechaNacimiento] date,
  [direccion] nvarchar(255)
)
GO

CREATE TABLE [productos] (
  [idProducto] integer PRIMARY KEY,
  [producto] nvarchar(255),
  [descripcion] text,
  [precio] decimal,
  [idCategoria] integer,
  [disponibilidad] bool
)
GO

CREATE TABLE [categoria] (
  [idCategoria] integer PRIMARY KEY,
  [categoria] nvarchar(255)
)
GO

CREATE TABLE [pedido] (
  [idPedido] integer PRIMARY KEY,
  [idcliente] integer,
  [idempleado] integer,
  [fecha] datetime,
  [idestado] nvarchar(255),
  [total] decimal
)
GO

CREATE TABLE [pedidoproducto] (
  [idPedido] integer,
  [idProducto] integer
)
GO

CREATE TABLE [estado] (
  [idestado] integer PRIMARY KEY,
  [estado] nvarchar(255)
)
GO

CREATE TABLE [pago] (
  [idpago] integer PRIMARY KEY,
  [idpedido] integer,
  [monto] decimal,
  [idfpago] integer,
  [fechaPago] datetime
)
GO

CREATE TABLE [Fpago] (
  [idFormaPago] integer PRIMARY KEY,
  [formaPago] nvarchar(255)
)
GO

ALTER TABLE [cliente] ADD FOREIGN KEY ([idcliente]) REFERENCES [pedido] ([idcliente])
GO

ALTER TABLE [empleado] ADD FOREIGN KEY ([idEmpleado]) REFERENCES [pedido] ([idempleado])
GO

ALTER TABLE [estado] ADD FOREIGN KEY ([idestado]) REFERENCES [pedido] ([idestado])
GO

ALTER TABLE [Fpago] ADD FOREIGN KEY ([idFormaPago]) REFERENCES [pago] ([idfpago])
GO

ALTER TABLE [pedido] ADD FOREIGN KEY ([idPedido]) REFERENCES [pago] ([idpedido])
GO

ALTER TABLE [categoria] ADD FOREIGN KEY ([idCategoria]) REFERENCES [productos] ([idCategoria])
GO

ALTER TABLE [pedido] ADD FOREIGN KEY ([idPedido]) REFERENCES [pedidoproducto] ([idPedido])
GO

ALTER TABLE [productos] ADD FOREIGN KEY ([idProducto]) REFERENCES [pedidoproducto] ([idProducto])
GO
