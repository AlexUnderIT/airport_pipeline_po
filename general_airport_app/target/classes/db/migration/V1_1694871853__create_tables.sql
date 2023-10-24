CREATE TABLE passenger
(
    id                        BIGSERIAL PRIMARY KEY,
    ticket_id                 BIGINT  NOT NULL,

    name                      VARCHAR NOT NULL,
    surname                   VARCHAR NOT NULL,
    birthday                  DATE    NOT NULL,
    gender                    VARCHAR NOT NULL,
    nationality_id            BIGINT  NOT NULL,
    passport_info             VARCHAR NOT NULL,
    phone_number              VARCHAR NOT NULL,
    email                     VARCHAR NOT NULL,

    has_weapon                BOOLEAN NOT NULL DEFAULT FALSE,
    has_drugs                 BOOLEAN NOT NULL DEFAULT FALSE,
    has_dangerous_electronics BOOLEAN NOT NULL DEFAULT FALSE,
    suspicion_status          VARCHAR NOT NULL DEFAULT 'NONE'
);


CREATE TABLE trip
(
    id                  BIGSERIAL PRIMARY KEY,
    trip_number         VARCHAR   NOT NULL,
    destination_city    VARCHAR   NOT NULL,
    destination_country VARCHAR   NOT NULL,
    destination_airport VARCHAR   NOT NULL,
    trip_status         VARCHAR   NOT NULL,
    departure_time      TIMESTAMP NOT NULL,
    arrival_time        TIMESTAMP NOT NULL,
    airline_name        VARCHAR   NOT NULL,
    plane_id            BIGINT    NOT NULL
);

CREATE TABLE equipment
(
    id             BIGSERIAL PRIMARY KEY,

    equipment_type VARCHAR NOT NULL,
    model_name     VARCHAR NOT NULL,
    state          INT     NOT NULL
);


CREATE TABLE equipment_to_trip
(
    id           BIGSERIAL PRIMARY KEY,
    equipment_id BIGINT NOT NULL,
    trip_id      BIGINT NOT NULL
);

ALTER TABLE equipment_to_trip
    ADD CONSTRAINT equipment_to_trip_ids_unq UNIQUE (equipment_id, trip_id);


CREATE TABLE plane
(
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR NOT NULL,
    airline_name  VARCHAR NOT NULL,
    plane_status  VARCHAR NOT NULL,
    parking_name  VARCHAR NOT NULL,
    seating_count INT     NOT NULL
);

CREATE TABLE ticket
(
    id                     BIGSERIAL PRIMARY KEY,

    trip_id                BIGINT  NOT NULL,
    passenger_id           BIGINT,

    seat_name              VARCHAR NOT NULL,
    seat_class             VARCHAR NOT NULL,
    has_baggage            BOOLEAN NOT NULL DEFAULT FALSE,
    has_gab_baggage        BOOLEAN NOT NULL DEFAULT FALSE,
    has_food               BOOLEAN NOT NULL DEFAULT FALSE,
    has_pets               BOOLEAN NOT NULL DEFAULT FALSE,
    is_handicapped         BOOLEAN NOT NULL DEFAULT FALSE,
    transfer_to_plain_type VARCHAR NOT NULL
);


CREATE TABLE nationality
(
    id          BIGSERIAL PRIMARY KEY,
    nationality VARCHAR NOT NULL UNIQUE
);