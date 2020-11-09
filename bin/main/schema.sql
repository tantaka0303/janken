CREATE TABLE users (
    id IDENTITY,
    name CHAR NOT NULL
);
CREATE TABLE matches (
    id IDENTITY,
    user_1 CHAR NOT NULL,
    user_2 CHAR NOT NULL,
    user_1_hand CHAR NOT NULL,
    user_2_hand CHAR NOT NULL
);
