CREATE  USER main_role WITH CREATEDB CREATEROLE PASSWORD 'matrix';

CREATE USER limited_role WITH NOCREATEDB NOCREATEROLE PASSWORD 'matrixHasYou';

GRANT All ON ALL TABLES IN SCHEMA carTravel TO main_role;
GRANT SELECT ON ALL TABLES IN SCHEMA carTravel TO limited_role;
GRANT UPDATE ON carTravel.issue TO limited_role;