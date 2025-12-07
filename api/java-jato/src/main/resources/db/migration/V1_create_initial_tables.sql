CREATE TABLE cliente (
    id UUID PRIMARY KEY  uuid_generate_v4(),
    nome_completo VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(255) NULL,
    data_cadastro TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE carro (
    id BIGSERIAL PRIMARY KEY,
    placa VARCHAR(10) UNIQUE NOT NULL, 
    modelo VARCHAR(100) NOT NULL,
    cor VARCHAR(50) NOT NULL,
    cliente_id BIGINT NOT NULL,
    
    CONSTRAINT fk_carro_cliente
        FOREIGN KEY (cliente_id)
        REFERENCES cliente (id)
);

CREATE TABLE tipo_servico (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) UNIQUE NOT NULL,
    preco NUMERIC(10, 2) NOT NULL,
    tempo_estimado_minutos INTEGER NOT NULL
);

CREATE TABLE servico (
    id BIGSERIAL PRIMARY KEY,

    estado VARCHAR(50) NOT NULL,
    
    carro_id BIGINT NOT NULL,
    tipo_servico_id BIGINT NOT NULL,
    
    data_entrada_fila TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    data_inicio_lavagem TIMESTAMP WITHOUT TIME ZONE NULL,
    data_fim_servico TIMESTAMP WITHOUT TIME ZONE NULL,
    valor_total NUMERIC(10, 2) NOT NULL,

    -- Chaves Estrangeiras
    CONSTRAINT fk_servico_carro
        FOREIGN KEY (carro_id)
        REFERENCES carro (id),
        
    CONSTRAINT fk_servico_tipo
        FOREIGN KEY (tipo_servico_id)
        REFERENCES tipo_servico (id)
);


CREATE INDEX idx_servico_estado ON servico (estado);