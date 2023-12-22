# CashTrack 
API Rest pensada como servidor para aplicaciones de gestión de gastos personales.
La aplicación todavia se encuentra en desarrollo, aunque ya es posible acceder a los endpoints para manipular la base de datos a partir de toda la estructura interna por capas de la aplicación, aún hay funcionalidades que se desean en la aplicación y por la ventana de entrega del PI no se pudieron desarrollar, como algún método para la autenticación de usuarios y administradores, la encriptación y validación de contraseñas, métodos de administrador para la gestión de usuarios y algunos tests unitarios para probar funcionalidades de forma exhaustiva. 
Por otra lado, gran parte de los endpoints para completar el CRUD de las 4 entidades principales del proyecto ya fueron completados y probados, como también ya está totalmente definida la estrucutura de la base de datos y sus relaciones, por lo que bastarían sólo métodos concernientes a la lógica del negocio como tal.

# Consideraciones
- Existen 4 entidades principales en la aplicación: Accounts, Users, Expenses y Revenues.
- Cada cuenta tiene un saldo global, además de tener asociados uno o varios usuarios y sus gastos o ingresos, que se ven reflejados en el saldo global de la cuenta.
- Cada cuenta se protege por contraseña y es sólo administrable por el usuario definido como administrador.
- Cada usuario y sus transacciones son sólo modificables por el usuario, el cual está protegido por un pin de acceso.
- Se pueden eliminar las cuentas, esto afectará a todas las transacciones de sus usuarios puesto que se asocian al saldo global, por lo que tambien se eliminan.
- Al eliminar una cuenta, no se eliminan los usuarios pero sí se desvinculan, haciendo posible vincularlos a otras cuentas o crear la suya propia siendo administrador.
- Por otro lado, al eliminar un usuario, se eliminarán todas las transacciones asociadas a él, pero esto no afectará el saldo global de la cuenta.
- Las rutas para actualizar campos especificos de una entidad toman como cuerpo de la solicitud todos los datos que tiene la entidad, pero sólo toman en cuenta el campo especifico que se quiere actualizar, esto por el momento pues se espera en el futuro poder tomar datos como la contraseña de la cuenta para validar antes de hacer cambios a la entidad.

# Documentación de rutas

## [Crear usuario](#createUser)
## [Crear cuenta](#createAccount)
## [Crear gasto](#createExpense)
## [Crear ingreso](#createRevenue)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)
## [Sección 2](#destino)

## Crear un nuevo usuario {: #createUser}
POST /api/v1/users

### Descripción
Crea un nuevo usuario en el sistema.

### Parámetros del Cuerpo
- `username` (string): El nombre del usuario.
- `email` (string): La dirección de correo electrónico del usuario.
- `accountId` (string): La cuenta a la que pertenece al usuario (puede ser null mientras se crea y asigna la cuenta).
- `pin` (string): El pin de seguridad del usuario.

### Cuerpo de la solicitud
```json
{
    "username": "alidev",
    "email": "estiven25b777@gmail.com",
    "accountId": null,
    "pin": "12345"
}
```

## Crear una nueva cuenta <a name="createAccount"></a>
POST /api/v1/accounts

### Descripción
Crea una nueva cuenta en el sistema.

### Parámetros del Cuerpo
- `adminId` (int): El id del usuario administrador de la cuenta (no puede ser null).
- `description` (string): La descripción de la cuenta.
- `accountName` (string): El nombre para la cuenta.
- `password` (string): La contraseña para la cuenta.
- `balance` (double): El saldo inicial al crear la cuenta

### Cuerpo de la solicitud
```json
{
    "adminId": 1,
    "description": "Cuenta de gastos alidev",
    "accountName": "AlidevCash",
    "password": "12345",
    "balance": 0.0
}
```

## Crear un nuevo gasto <a name="createExpense"></a>
POST /api/v1/expenses

### Descripción
Crea un nuevo gasto en el sistema.

### Parámetros del Cuerpo
- `amount` (double): La cantidad del gasto.
- `type` (string): La categoria del gasto.
- `description` (string): La descripción del gasto.
- `userId` (int): El id del usuario que realiza el gasto en la cuenta.

### Cuerpo de la solicitud
```json
{
    "amount": 20000,
    "type": "casa",
    "description": "Cuchara para huevos",
    "userId": 1
}
```

## Crear un nuevo ingreso <a name="createRevenue"></a>
POST /api/v1/revenues

### Descripción
Crea un nuevo ingreso en el sistema.

### Parámetros del Cuerpo
- `amount` (double): La cantidad del ingreso.
- `type` (string): La categoria del ingreso.
- `description` (string): La descripción del ingreso.
- `userId` (int): El id del usuario que realiza el ingreso en la cuenta.

### Cuerpo de la solicitud
```json
{
    "amount": 20000,
    "type": "casa",
    "description": "Cuchara para huevos",
    "userId": 1
}
```

## Eliminar una cuenta
DELETE /api/v1/accounts?id={id}

### Descripción
Eliminar una cuenta del sistema y sus transacciones asociadas.

### Parámetros de Ruta
- `id` (int): ID único de la cuenta.

## Eliminar un usuario
DELETE /api/v1/users?id={id}

### Descripción
Eliminar una usuario del sistema y sus transacciones asociadas.

### Parámetros de Ruta
- `id` (int): ID único del usuario.

## Eliminar un gasto reciente
DELETE /api/v1/expenses?account={accountId}&id={id}

### Descripción
Eliminar un gasto que se haya registrado recientemente para no afectar el historial del saldo.

### Parámetros de Ruta
- `id` (int): ID único del gasto.
- `account` (int): ID único de la cuenta asociada al gasto.

## Eliminar un ingreso reciente
DELETE /api/v1/revenues?account={accountId}&id={id}

### Descripción
Eliminar un ingreso que se haya registrado recientemente para no afectar el historial del saldo.

### Parámetros de Ruta
- `id` (int): ID único del ingreso.
- `account` (int): ID único de la cuenta asociada al ingreso.

## Obtener cuenta por id
GET /api/v1/accounts/id?id={id}

### Descripción
Obtener toda la información de una cuenta a partir de su ID único.

### Parámetros de Ruta
- `id` (int): ID único de la cuenta.

## Obtener cuenta por id de administrador
GET /api/v1/accounts/admin?admin={adminId}

### Descripción
Obtener toda la información de una cuenta a partir del ID único de su usuario administrador.

### Parámetros de Ruta
- `id` (int): ID único del administrador.

## Obtener usuario por id
GET /api/v1/users/id?id={id}

### Descripción
Obtener toda la información de un usuario a partir de su ID único.

### Parámetros de Ruta
- `id` (int): ID único del usuario.

## Obtener usuario por email
GET /api/v1/users/email?email={email}

### Descripción
Obtener toda la información de un usuario a partir de su email asociado.

### Parámetros de Ruta
- `email` (string): Email asociado al usuario.

## Obtener usuario por nombre de usuario
GET /api/v1/users/username?username={username}

### Descripción
Obtener toda la información de un usuario a partir de su nombre de usuario.

### Parámetros de Ruta
- `username` (string): Nombre del usuario.

## Obtener gasto por id
GET /api/v1/expenses/id?id={id}

### Descripción
Obtener toda la información de un gasto a partir de su ID único.

### Parámetros de Ruta
- `id` (int): ID único del gasto.

## Obtener gastos por id de usuario
GET /api/v1/expenses/user?user={userId}

### Descripción
Obtener toda la información de un gasto a partir del ID único del usuario que lo realizó.

### Parámetros de Ruta
- `user` (int): ID único del usuario.

## Obtener ingresos por id
GET /api/v1/revenues/id?id={id}

### Descripción
Obtener toda la información de un ingreso a partir de su ID único.

### Parámetros de Ruta
- `id` (int): ID único del ingreso.

## Obtener ingresos por id de usuario
GET /api/v1/revenues/user?user={userId}

### Descripción
Obtener toda la información de un ingreso a partir del ID único del usuario que lo realizó.

### Parámetros de Ruta
- `user` (int): ID único del usuario.

## Actualizar nombre de cuenta
UPDATE /api/v1/accounts/accountname?id={id}

### Descripción
Actualizar el nombre de una cuenta.

### Parámetros de Ruta
- `id` (int): ID único de la cuenta a actualizar.

### Parámetros del Cuerpo
- `adminId` (int): ID del usuario administrador.
- `description` (string): Descripción de la cuenta.
- `accountName` (string): Nuevo nombre asociado a la cuenta.
- `password` (string): La contraseña de la cuenta.
- `balance` (double): El saldo de la cuenta. 

### Cuerpo de la solicitud
```json
{
    "adminId": 1,
    "description": "Cuenta ejemplo",
    "accountName": "Nuevo nombre de cuenta",
    "password": "12345",
    "balance": 0.0
}
```

## Actualizar administrador de cuenta
UPDATE /api/v1/accounts/admin?id={id}

### Descripción
Actualizar el usuario administrador de una cuenta.

### Parámetros de Ruta
- `id` (int): ID único de la cuenta a actualizar.

### Parámetros del Cuerpo
- `adminId` (int): ID del nuevo usuario administrador.
- `description` (string): Descripción de la cuenta.
- `accountName` (string): Nombre asociado a la cuenta.
- `password` (string): La contraseña de la cuenta.
- `balance` (double): El saldo de la cuenta. 

### Cuerpo de la solicitud
```json
{
    "adminId": 1,
    "description": "Cuenta ejemplo",
    "accountName": "Ejemplo",
    "password": "12345",
    "balance": 0.0
}
```
## Actualizar descripción de cuenta
UPDATE /api/v1/accounts/description?id={id}

### Descripción
Actualizar la descripción de una cuenta.

### Parámetros de Ruta
- `id` (int): ID único de la cuenta a actualizar.

### Parámetros del Cuerpo
- `adminId` (int): ID del usuario administrador.
- `description` (string): Nueva descripción de la cuenta.
- `accountName` (string): Nombre asociado a la cuenta.
- `password` (string): La contraseña de la cuenta.
- `balance` (double): El saldo de la cuenta. 

### Cuerpo de la solicitud
```json
{
    "adminId": 1,
    "description": "Nueva descripción de cuenta",
    "accountName": "Ejemplo",
    "password": "12345",
    "balance": 0.0
}
```
## Actualizar contraseña
UPDATE /api/v1/accounts/password?id={id}

### Descripción
Actualizar la contraseña de una cuenta.

### Parámetros de Ruta
- `id` (int): ID único de la cuenta a actualizar.

### Parámetros del Cuerpo
- `adminId` (int): ID del usuario administrador.
- `description` (string): Descripción de la cuenta.
- `accountName` (string): Nombre asociado a la cuenta.
- `password` (string): Nueva contraseña de la cuenta.
- `balance` (double): El saldo de la cuenta. 

### Cuerpo de la solicitud
{
    "adminId": 1,
    "description": "Cuenta ejemplo",
    "accountName": "Ejemplo",
    "password": "Nueva contraseña",
    "balance": 0.0
}

## Actualizar cuenta del usuario
UPDATE /api/v1/users/account?id={id}

### Descripción
Actualizar la cuenta asociada a un usuario.

### Parámetros de Ruta
- `id` (int): ID único del usuario a actualizar.

### Parámetros del Cuerpo
- `username` (string): Nombre de usuario.
- `email` (string): Email del usuario.
- `accountId` (int): ID de la nueva cuenta asociada al usuario.
- `pin` (string): El PIN de seguridad del usuario.

### Cuerpo de la solicitud
{
    "username": "Ejemplo",
    "email": "ejemplo@gmail.com",
    "accountId": 1,
    "pin": "12345"
}

## Actualizar nombre de usuario
UPDATE /api/v1/users/username?id={id}

### Descripción
Actualizar el nombre de usuario.

### Parámetros de Ruta
- `id` (int): ID único del usuario a actualizar.

### Parámetros del Cuerpo
- `username` (string): Nuevo nombre de usuario.
- `email` (string): Email del usuario.
- `accountId` (int): ID de la cuenta asociada al usuario.
- `pin` (string): El PIN de seguridad del usuario.

### Cuerpo de la solicitud
{
    "username": "Nuevo username",
    "email": "ejemplo@gmail.com",
    "accountId": 1,
    "pin": "12345"
}

## Actualizar email
UPDATE /api/v1/users/email?id={id}

### Descripción
Actualizar el email asociado al usuario.

### Parámetros de Ruta
- `id` (int): ID único del usuario a actualizar.

### Parámetros del Cuerpo
- `username` (string): Nombre de usuario.
- `email` (string): Nuevo email del usuario.
- `accountId` (int): ID de la cuenta asociada al usuario.
- `pin` (string): El PIN de seguridad del usuario.

### Cuerpo de la solicitud
```json
{
    "username": "Ejemplo",
    "email": "nuevoEmail@gmail.com",
    "accountId": 1,
    "pin": "12345"
}
```
## Actualizar PIN
UPDATE /api/v1/users/pin?id={id}

### Descripción
Actualizar el PIN de seguridad de un usuario.

### Parámetros de Ruta
- `id` (int): ID único del usuario a actualizar.

### Parámetros del Cuerpo
- `username` (string): Nmbre de usuario.
- `email` (string): Email del usuario.
- `accountId` (int): ID de la cuenta asociada al usuario.
- `pin` (string): Nuevo PIN de seguridad del usuario.

### Cuerpo de la solicitud
{
    "username": "Ejemplo",
    "email": "ejemplo@gmail.com",
    "accountId": 1,
    "pin": "Nuevo PIN"
}

## Actualizar descripción de gasto
UPDATE /api/v1/expenses/description?id={id}

### Descripción
Actualizar la descripción de un gasto.

### Parámetros de Ruta
- `id` (int): ID único del gasto a actualizar.

### Parámetros del Cuerpo
- `amount` (double): Cantidad asociada al gasto.
- `type` (string): Categoria del gasto.
- `description` (string): Nueva descripción del gasto.
- `userId` (int): ID único del usuario que realizó el gasto.

### Cuerpo de la solicitud
{
    "amount": 20000,
    "type": "ejemplo",
    "description": "Nueva descripción del gasto",
    "userId": 1
}

## Actualizar tipo de gasto
UPDATE /api/v1/expenses/type?id={id}

### Descripción
Actualizar la categoria de un gasto.

### Parámetros de Ruta
- `id` (int): ID único del gasto a actualizar.

### Parámetros del Cuerpo
- `amount` (double): Cantidad asociada al gasto.
- `type` (string): Nueva categoria del gasto.
- `description` (string): Descripción del gasto.
- `userId` (int): ID único del usuario que realizó el gasto.

### Cuerpo de la solicitud
{
    "amount": 20000,
    "type": "nuevo tipo de gasto",
    "description": "Gasto de ejemplo",
    "userId": 1
}

## Actualizar descripción de ingreso
UPDATE /api/v1/revenues/description?id={id}

### Descripción
Actualizar la descripción de un ingreso.

### Parámetros de Ruta
- `id` (int): ID único del ingreso a actualizar.

### Parámetros del Cuerpo
- `amount` (double): Cantidad asociada al ingreso.
- `type` (string): Categoria del ingreso.
- `description` (string): Nueva descripción del ingreso.
- `userId` (int): ID único del usuario que realizó el ingreso.

### Cuerpo de la solicitud
{
    "amount": 20000,
    "type": "ejemplo",
    "description": "Nueva descripción de ingreso",
    "userId": 1
}

## Actualizar tipo de ingreso
UPDATE /api/v1/revenues/type?id={id}

### Descripción
Actualizar la categoria de un ingreso.

### Parámetros de Ruta
- `id` (int): ID único del ingreso a actualizar.

### Parámetros del Cuerpo
- `amount` (double): Cantidad asociada al ingreso.
- `type` (string): Nueva categoria del ingreso.
- `description` (string): Descripción del ingreso.
- `userId` (int): ID único del usuario que realizó el ingreso.

### Cuerpo de la solicitud
{
    "amount": 20000,
    "type": "nuevo tipo de ingreso",
    "description": "Gasto de ejemplo",
    "userId": 1
}
  
