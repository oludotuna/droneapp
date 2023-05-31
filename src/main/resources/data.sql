INSERT INTO drone (id, serialNumber, model, weightLimit, batteryCapacity, state) VALUES (1, 'MS20006790', 'Middleweight', 300.0, 70.0, 'IDLE');

INSERT INTO drone (id, serialNumber, model, weightLimit, batteryCapacity, state) VALUES (2, 'MS20006791', 'Lightweight', 200.0, 80.0, 'IDLE');

INSERT INTO drone (id, serialNumber, model, weightLimit, batteryCapacity, state) VALUES (3, 'MS20006792', 'Heavyweight', 500.0, 70.0, 'IDLE');

INSERT INTO medication (id, name, weight, code, image) VALUES (1, 'Paracetamol-250', 60.0, 'PARA_001', null);

INSERT INTO medication (id, name, weight, code, image) VALUES (2, 'Ibrupofen-50', 50.0, 'IBRU_50', null);

INSERT INTO medication (id, name, weight, code, image) VALUES (3, 'Amatem-500', 80.0, 'AMT567', null);

INSERT INTO cargo (drone_id, medication_id) VALUES (1, 1);

INSERT INTO cargo (drone_id, medication_id) VALUES (2, 2);

INSERT INTO cargo (drone_id, medication_id) VALUES (3, 3);