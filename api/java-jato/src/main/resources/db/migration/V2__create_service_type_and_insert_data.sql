
COMMENT ON TABLE service_type IS 'Tipos de serviços oferecidos no lava-jato com preço e tempo estimado.';



INSERT INTO service_type (name_service, price, estimated_time_minutes) VALUES
('SIMPLE_WASH', 35.00, 30),
('FULL_WASH', 65.00, 60),
('PREMIUM_WASH', 99.90, 90),
('INTERNAL_DETAILING', 150.00, 120)