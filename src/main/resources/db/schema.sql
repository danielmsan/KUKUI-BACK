CREATE TABLE Producto (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    categoria VARCHAR(255),
    descripcion TEXT(1000),
    precio DOUBLE PRECISION NOT NULL,
    src_imagen VARCHAR(255),
    tamanio VARCHAR(255),
    PRIMARY KEY (id)
);
