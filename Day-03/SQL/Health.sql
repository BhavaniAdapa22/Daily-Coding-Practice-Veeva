CREATE TABLE drugs (
    drug_id INT PRIMARY KEY,
    drug_name VARCHAR(100) NOT NULL,
    description VARCHAR(255)
);

INSERT INTO drugs (drug_id, drug_name, description) VALUES
(101, 'Aspirin', 'Used to reduce pain and inflammation'),
(102, 'Metformin', 'Used to treat type 2 diabetes'),
(103, 'Atorvastatin', 'Used to reduce cholesterol'),
(104, 'Amoxicillin', 'Antibiotic used to treat bacterial infections'),
(105, 'Lisinopril', 'Used to treat high blood pressure');

CREATE TABLE trials (
    trial_id INT PRIMARY KEY,
    trial_name VARCHAR(150) NOT NULL,
    start_date DATE,
    end_date DATE,
    drug_id INT,
    FOREIGN KEY (drug_id) REFERENCES drugs(drug_id)
);

INSERT INTO trials (trial_id, trial_name, start_date, end_date, drug_id) VALUES
(1, 'Diabetes Treatment Trial', '2024-01-10', '2025-01-10', 102),
(2, 'Cholesterol Reduction Trial', '2024-03-15', '2025-03-15', 103),
(3, 'Blood Pressure Trial', '2024-05-01', '2025-05-01', 105),
(4, 'Antibiotic Effectiveness Trial', '2024-06-10', '2024-12-10', 104),
(5, 'Pain Relief Trial', '2024-07-01', '2025-07-01', 101);

CREATE TABLE phases (
    trial_id INT,
    phase VARCHAR(50),
    start_date DATE,
    end_date DATE,
    PRIMARY KEY (trial_id, phase),
    FOREIGN KEY (trial_id) REFERENCES trials(trial_id)
);

INSERT INTO phases (trial_id, phase, start_date, end_date) VALUES
(1, 'Phase 1', '2024-01-10', '2024-03-10'),
(1, 'Phase 2', '2024-03-15', '2024-07-15'),
(1, 'Phase 3', '2024-08-01', '2025-01-10'),

(2, 'Phase 1', '2024-03-15', '2024-05-15'),
(2, 'Phase 2', '2024-05-20', '2024-09-20'),
(2, 'Phase 3', '2024-10-01', '2025-03-15'),

(3, 'Phase 1', '2024-05-01', '2024-07-01'),
(3, 'Phase 2', '2024-07-10', '2024-10-10'),
(3, 'Phase 3', '2024-10-15', '2025-05-01'),

(4, 'Phase 1', '2024-06-10', '2024-08-10'),
(4, 'Phase 2', '2024-08-15', '2024-10-15'),
(4, 'Phase 3', '2024-10-20', '2024-12-10'),

(5, 'Phase 1', '2024-07-01', '2024-09-01'),
(5, 'Phase 2', '2024-09-10', '2024-12-10'),
(5, 'Phase 3', '2024-12-15', '2025-07-01');

-- Retrieve all the Clinical Trials, their associated drug,the phases those trials has gone through and their start and end dates.
select t.trial_id,d.drug_id,d.drug_name,p.phase,p.start_date,p.end_date from trials t inner join drugs d on t.drug_id=d.drug_id inner join phases p on t.trial_id=p.trial_id;
