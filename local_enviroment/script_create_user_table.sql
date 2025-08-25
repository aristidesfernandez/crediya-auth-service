CREATE EXTENSION IF NOT EXISTS "pgcrypto";


CREATE TABLE usuario (
    usuario_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nombres VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    correo_electronico VARCHAR(255) NOT NULL UNIQUE,
    salario_base NUMERIC(15,2) NOT NULL
);