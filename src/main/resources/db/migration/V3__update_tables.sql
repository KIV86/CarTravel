ALTER TABLE cartravel.issue
    ADD COLUMN date_is_done timestamptz ;
ALTER TABLE cartravel.user_role
    DROP COLUMN role;
ALTER TABLE cartravel.issue
    DROP COLUMN description;
