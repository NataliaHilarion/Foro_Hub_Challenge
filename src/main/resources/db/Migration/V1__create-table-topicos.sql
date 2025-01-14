CREATE TABLE topicos (

    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre_usuario VARCHAR(100) NOT NULL,
    mensaje TEXT NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    nombre_curso VARCHAR(100) NOT NULL,
    titulo VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);
