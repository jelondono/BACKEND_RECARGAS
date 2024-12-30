-- Crear tabla `seller` si no existe
CREATE TABLE IF NOT EXISTS seller (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Crear tabla `operator` con la nueva columna `pathImage`
CREATE TABLE IF NOT EXISTS operator (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    image VARCHAR(500)
);

-- Crear tabla `topup` si no existe
CREATE TABLE IF NOT EXISTS topup (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    amount DECIMAL(10, 2) NOT NULL,
    quantity BIGINT NOT NULL,
    operator_id BIGINT NOT NULL,
    seller_id BIGINT NOT NULL,
    date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (operator_id) REFERENCES operator(id),
    FOREIGN KEY (seller_id) REFERENCES seller(id)
);
