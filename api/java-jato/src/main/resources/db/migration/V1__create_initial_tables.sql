CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE customer (
    id UUID PRIMARY KEY  DEFAULT uuid_generate_v4(),
    name_customer VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    email VARCHAR(255) NULL
);

CREATE TABLE car (
    id BIGSERIAL PRIMARY KEY,
    license_plate VARCHAR(10) UNIQUE NOT NULL, 
    model VARCHAR(100) NOT NULL,
    color VARCHAR(50) NOT NULL,
    customer_id UUID NOT NULL,
    
    CONSTRAINT fk_customer_car
        FOREIGN KEY (customer_id)
        REFERENCES customer (id)
);

CREATE TABLE service_type (
    id BIGSERIAL PRIMARY KEY,
    name_service VARCHAR(100) UNIQUE NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    estimated_time_minutes INTEGER NOT NULL
);

CREATE TABLE service (
    id BIGSERIAL PRIMARY KEY,

    state VARCHAR(50) NOT NULL,
    
    car_id BIGINT NOT NULL,
    service_type_id BIGINT NOT NULL,
    
    date_entry_queue TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    start_date_washing TIMESTAMP WITHOUT TIME ZONE NULL,
    service_end_date TIMESTAMP WITHOUT TIME ZONE NULL,
    total_value NUMERIC(10, 2) NOT NULL,

    -- Chaves 
    CONSTRAINT fk_car_service
        FOREIGN KEY (car_id)
        REFERENCES car (id),
        
    CONSTRAINT fk_service_type
        FOREIGN KEY (service_type_id)
        REFERENCES service_type (id)
);


CREATE INDEX idx_servico_estado ON service (state);