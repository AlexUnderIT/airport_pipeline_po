BEGIN;
------------------------------------------------------------------------------------------------------
---Equipment---
------------------------------------------------------------------------------------------------------
INSERT INTO equipment (id, equipment_type, model_name, state)
VALUES (1, 'BUS', 'Mercedes-Benz Sprinter II', 2);

INSERT INTO equipment (id, equipment_type, model_name, state)
VALUES (2, 'LADDER', 'MD443', 4);

INSERT INTO equipment (id, equipment_type, model_name, state)
VALUES (3, 'LOADER', 'B747', 1);

INSERT INTO equipment (id, equipment_type, model_name, state)
VALUES (4, 'LADDER', 'M74-D8', 3);

INSERT INTO equipment (id, equipment_type, model_name, state)
VALUES (5, 'LOADER', 'MD11', 5);

alter sequence equipment_id_seq restart with 6;

------------------------------------------------------------------------------------------------------
---Plane---
------------------------------------------------------------------------------------------------------
INSERT INTO plane (id, name, airline_name, plane_status, parking_name, seating_count)
VALUES (1, 'Boeing 737-800', 'Aeroflot', 'WAITING_TRIP', 'N1256', 170);

INSERT INTO plane (id, name, airline_name, plane_status, parking_name, seating_count)
VALUES (2, 'Airbus 330-300', 'Delta Air Lines', 'INNER_INSPECTION', 'P746', 440);

INSERT INTO plane (id, name, airline_name, plane_status, parking_name, seating_count)
VALUES (3, 'Airbus 320NEO', 'Ariana Afghan Airlines', 'PASSENGER_PREPARATION', 'L092', 146);

INSERT INTO plane (id, name, airline_name, plane_status, parking_name, seating_count)
VALUES (4, 'Boeing 777-300ER', 'Pobeda', 'PARKING', 'H642', 550);

INSERT INTO plane (id, name, airline_name, plane_status, parking_name, seating_count)
VALUES (5, 'Airbus A350-900', ' Kharkiv Airlines', 'TAKE_OFF', ' Y265', 314);

alter sequence plane_id_seq restart with 6;
------------------------------------------------------------------------------------------------------
---Trip---
------------------------------------------------------------------------------------------------------
INSERT INTO trip (id, trip_number, destination_city, destination_country, destination_airport, trip_status,
                  departure_time, arrival_time, airline_name, plane_id)
VALUES (1, 'NK7264', 'Moscow', 'Russia', 'VKO', 'PLANNED', '2023-08-07 17:35:00',
        '2023-08-07 19:55:00', 'Aeroflot', 1);

INSERT INTO trip (id, trip_number, destination_city, destination_country, destination_airport, trip_status,
                  departure_time, arrival_time, airline_name, plane_id)
VALUES (2, 'GTR7543', 'New York', 'USA', 'IATA', 'CANCELED',
        '2023-04-05 08:00:00', '2023-04-05 10:05:00', 'Alaska Airlines', 2);

INSERT INTO trip (id, trip_number, destination_city, destination_country, destination_airport, trip_status,
                  departure_time, arrival_time, airline_name, plane_id)
VALUES (3, 'MNH1324', 'Kandagar', 'Afghanistan', 'KDH', 'COMPLETED', '2023-12-15 09:55:00',
        '2023-12-15 12:55:00', 'Balkh Airlines', 3);

INSERT INTO trip (id, trip_number, destination_city, destination_country, destination_airport, trip_status,
                  departure_time, arrival_time, airline_name, plane_id)
VALUES (4, 'KL9768', 'Kazan', 'Russia', 'KZN', 'COMPLETED', '2023-10-09 18:10:00',
        '2023-10-09 21:30:00','Pobeda', 4);

INSERT INTO trip (id, trip_number, destination_city, destination_country, destination_airport, trip_status,
                  departure_time, arrival_time, airline_name, plane_id)
VALUES (5, 'YTT1276', 'Kiev', 'Ukraine', 'IEV', 'PLANNED', '2023-09-29 12:15:00',
        '2023-09-29 14:55:00', 'Kharkiv Airlines', 5);


alter sequence trip_id_seq restart with 6;
------------------------------------------------------------------------------------------------------
---Ticket---
------------------------------------------------------------------------------------------------------
INSERT INTO ticket (id, trip_id, passenger_id, seat_name, seat_class, has_baggage, has_gab_baggage,
                    has_food, has_pets, is_handicapped, transfer_to_plain_type)
VALUES (1, 2, 5, '2BF', 'BUSINESS', true, false, false ,false, false, 'BUSINESS_BUS');

INSERT INTO ticket (id, trip_id, passenger_id, seat_name, seat_class, has_baggage, has_gab_baggage,
                    has_food, has_pets, is_handicapped, transfer_to_plain_type)
VALUES (2, 4, 3, '5GT', 'FIRST CLASS',false, true, true, false, false, 'BUSINESS_BUS');

INSERT INTO ticket (id, trip_id, passenger_id, seat_name, seat_class, has_baggage, has_gab_baggage,
                    has_food, has_pets, is_handicapped, transfer_to_plain_type)
VALUES (3, 5, 4, '12T', 'ECONOMY',true, false, true, false, false, 'BUS');

INSERT INTO ticket (id, trip_id, passenger_id, seat_name, seat_class, has_baggage, has_gab_baggage,
                    has_food, has_pets, is_handicapped, transfer_to_plain_type)
VALUES (4, 1, 2, '16G', 'BUSINESS', false, true, false, false, false,'TELEBRIDGE' );

INSERT INTO ticket (id, trip_id, passenger_id, seat_name, seat_class, has_baggage, has_gab_baggage,
                    has_food, has_pets, is_handicapped, transfer_to_plain_type)
VALUES (5, 3, 1, '1A', 'ECONOMY', true, true, true, true, false, 'FOOT');

alter sequence ticket_id_seq restart with 6;

------------------------------------------------------------------------------------------------------
---Passenger---
------------------------------------------------------------------------------------------------------
INSERT INTO passenger (id, ticket_id, name, surname, birthday, gender, nationality_id, passport_info,
                       phone_number, email)
VALUES (1, 2, 'Alexey', 'Menshov', '2023-09-17', 'MALE', 23, '2387412536',
        '87564891204', 'menshov@mail.ru');

INSERT INTO passenger (id, ticket_id, name, surname, birthday, gender, nationality_id, passport_info,
                       phone_number, email)
VALUES (2, 4, 'Alex', 'Strigunov', '2002-07-14', 'MALE', 23, '1548975015',
        '88004444652', 'strig@mail.ru');

INSERT INTO passenger (id, ticket_id, name, surname, birthday, gender, nationality_id, passport_info,
                       phone_number, email)
VALUES (3, 5, 'Danil', 'Tihonov', '2002-12-16', 'MALE', 23, '6583196827',
        '848955241376', 'tikhon@mail.ru');

INSERT INTO passenger (id, ticket_id, name, surname, birthday, gender, nationality_id, passport_info,
                       phone_number, email)
VALUES (4, 1, 'Viktoria', 'Kirilina', '2002-03-05', 'FEMALE', 23, '7764812232',
        '89125725487', 'vikulya@mail.ru');

INSERT INTO passenger (id, ticket_id, name, surname, birthday, gender, nationality_id, passport_info,
                       phone_number, email)
VALUES (5, 3, 'Anastasia', 'Svirskaya', '2002-03-25', 'FEMALE', 23, '9886726534',
        '8897253782', 'nastezh@mail.ru');

alter sequence passenger_id_seq restart with 6;

------------------------------------------------------------------------------------------------------
---Equipment-To-Trip---
------------------------------------------------------------------------------------------------------
INSERT INTO  equipment_to_trip (id, equipment_id, trip_id)
VALUES (1, 4, 3);

INSERT INTO  equipment_to_trip (id, equipment_id, trip_id)
VALUES (2, 2, 1);

INSERT INTO  equipment_to_trip (id, equipment_id, trip_id)
VALUES (3, 5, 2);

INSERT INTO  equipment_to_trip (id, equipment_id, trip_id)
VALUES (4, 3, 5);

INSERT INTO  equipment_to_trip (id, equipment_id, trip_id)
VALUES (5, 1, 4);

alter sequence equipment_to_trip_id_seq restart with 6;
-------------------------------------------------------------------------------------------------------
COMMIT;