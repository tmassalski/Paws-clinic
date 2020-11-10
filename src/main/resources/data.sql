INSERT INTO pet_type VALUES
(1, 'unicorn'),
(2, 'centaur'),
(3, 'dragon'),
(4, 'cerberus'),
(5, 'griffin'),
(6, 'ent'),
(7, 'medusa'),
(8, 'minotaur'),
(9, 'cyclop'),
(10, 'hydra'),
(11, 'phoenix'),
(12, 'balrog'),
(13, 'xenomorph');

INSERT INTO owner VALUES
(1, 'Bag End', 'Shire', 'Bilbo', 'Baggins', '777666777'),
(2, 'Moria', 'Khazad-dum', 'Gandalf', 'Grey', '111333444'),
(3, 'Nostromo', 'Space', 'Ellen', 'Ripley', '445544666'),
(4, 'Gryffindor', 'Hogwart', 'Harry', 'Potter', '000999000');

INSERT INTO pet VALUES
(1, '1937-1-1', 'Smaug', 1, 3),
(2, '666-6-6', 'Durin''s Bane', 2, 12),
(3, '1973-6-1', 'Queen', 3, 13),
(4, '2012-12-12', 'Fawkes', 4, 11);

INSERT INTO visit VALUES
(1, '2020-2-1', 'Fixed loose scale', 1),
(2, '2020-3-6', 'Trimmed horns', 2),
(3, '2020-4-17', 'Dental hygiene', 3),
(7, '2020-5-17', 'Dental hygiene', 3),
(4, '2020-5-20', 'Replaced burnt feather', 4),
(5, '2020-6-20', 'Replaced burnt feather', 4),
(6, '2020-7-20', 'Replaced burnt feather', 4);

INSERT INTO specialty VALUES
(1, 'surgery'),
(2, 'dentistry'),
(3, 'cardiology'),
(4, 'neurology'),
(5, 'oncology'),
(6, 'dermatology');

INSERT INTO vet VALUES
(1, 'Żanet', 'Kaleta');

INSERT INTO vet_specialties VALUES
(1,1),
(1,2),
(1,3);