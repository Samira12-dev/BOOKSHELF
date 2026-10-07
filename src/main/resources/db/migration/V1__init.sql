CREATE TABLE book (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      titre VARCHAR(255) NOT NULL,
                      auteur VARCHAR(255) NOT NULL,
                      isbn VARCHAR(255) NOT NULL,
                      category VARCHAR(255) NOT NULL,
                      date_ajout DATE NOT NULL,
                      status VARCHAR(50) NOT NULL
);