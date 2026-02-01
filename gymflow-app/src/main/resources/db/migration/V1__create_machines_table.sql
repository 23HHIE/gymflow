CREATE TABLE machines (
    id BIGSERIAL PRIMARY KEY,
    gym_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(100),
    location VARCHAR(100),
    avg_duration_minutes INTEGER NOT NULL
);
