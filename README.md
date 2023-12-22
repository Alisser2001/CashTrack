# CashTrack 
API Rest pensada como servidor para aplicaciones de gestión de gastos personales.

# Consideraciones
- Existen 4 entidades principales en la aplicación: Accounts, Users, Expenses y Revenues.
- Cada cuenta tiene un saldo global, además de tener asociados uno o varios usuarios y sus gastos o ingresos, que se ven reflejados en el saldo global de la cuenta.
- Cada cuenta se protege por contraseña y es sólo administrable por el usuario definido como administrador.
- Cada usuario y sus transacciones son sólo modificables por el usuario, el cual está protegido por un pin de acceso.
- Se pueden eliminar las cuentas, esto afectará a todas las transacciones de sus usuarios puesto que se asocian al saldo global, por lo que tambien se eliminan.
- Al eliminar una cuenta, no se eliminan los usuarios pero sí se desvinculan, haciendo posible vincularlos a otras cuentas o crear la suya propia siendo administrador.
- Por otro lado, al eliminar un usuario, se eliminarán todas las transacciones asociadas a él, pero esto no afectará el saldo global de la cuenta.

# Documentación de rutas

## Crear un nuevo usuario
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

## Crear una nueva cuenta
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

## Crear un nuevo gasto
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

## Crear un nuevo ingreso
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

## Obtener cuenta por id de administrador
GET /api/v1/accounts/admin?admin={adminId}

## Obtener usuario por id
GET /api/v1/users/id?id={id}

## Obtener usuario por email
GET /api/v1/users/email?email={email}

## Obtener usuario por nombre de usuario
GET /api/v1/users/username?username={username}

## Obtener gasto por id
GET /api/v1/expenses/id?id={id}

## Obtener gastos por id de usuario
GET /api/v1/expenses/user?user={userId}

## Obtener ingresos por id
GET /api/v1/revenues/id?id={id}

## Obtener ingresos por id de usuario
GET /api/v1/revenues/user?user={userId}

## Actualizar nombre de cuenta
UPDATE /api/v1/accounts/accountname?id={id}

### Body de la solicitud
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

### Body de la solicitud
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

### Body de la solicitud
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

### Body de la solicitud
{
    "adminId": 1,
    "description": "Cuenta ejemplo",
    "accountName": "Ejemplo",
    "password": "Nueva contraseña",
    "balance": 0.0
}

## Actualizar cuenta del usuario
UPDATE /api/v1/users/account?id={id}

### Body de la solicitud
{
    "username": "Ejemplo",
    "email": "ejemplo@gmail.com",
    "accountId": 1,
    "pin": "12345"
}

## Actualizar nombre de usuario
UPDATE /api/v1/users/username?id={id}

### Body de la solicitud
{
    "username": "Nuevo username",
    "email": "ejemplo@gmail.com",
    "accountId": 1,
    "pin": "12345"
}
## Actualizar email
UPDATE /api/v1/users/email?id={id}

### Body de la solicitud
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
### Body de la solicitud
{
    "username": "Ejemplo",
    "email": "ejemplo@gmail.com",
    "accountId": 1,
    "pin": "Nuevo PIN"
}
## Actualizar descripción de gasto
UPDATE /api/v1/expenses/description?id={id}
### Body de la solicitud
{
    "amount": 20000,
    "type": "ejemplo",
    "description": "Nueva descripción del gasto",
    "userId": 1
}
## Actualizar tipo de gasto
UPDATE /api/v1/expenses/type?id={id}
### Body de la solicitud
{
    "amount": 20000,
    "type": "nuevo tipo de gasto",
    "description": "Gasto de ejemplo",
    "userId": 1
}
## Actualizar descripción de ingreso
UPDATE /api/v1/revenues/description?id={id}
### Body de la solicitud
{
    "amount": 20000,
    "type": "ejemplo",
    "description": "Nueva descripción de ingreso",
    "userId": 1
}
## Actualizar tipo de ingreso
UPDATE /api/v1/revenues/type?id={id}
### Body de la solicitud
{
    "amount": 20000,
    "type": "nuevo tipo de ingreso",
    "description": "Gasto de ejemplo",
    "userId": 1
}
  
