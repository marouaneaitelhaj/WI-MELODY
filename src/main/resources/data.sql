CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


DO $$
DECLARE
i INTEGER := 1;
BEGIN
    WHILE i <= 100 LOOP
        INSERT INTO public.dbuser(id, email, password, profile_picture, role, username)
        VALUES (uuid_generate_v4(), 'artist' || i || '@example.com', '$2a$10$oYXNJMAjs3Y65.F4OrfSTuqpvFaaxr4oWJ4OlOvYs/WtKmXjlgrui' || i, 'profile' || i || '.jpg', 'ARTIST', 'artist' || i);
        i := i + 1;
END LOOP;
END $$;



DO $$
DECLARE
i INTEGER := 1;
BEGIN
    WHILE i <= 100 LOOP
        INSERT INTO public.dbuser(id, email, password, profile_picture, role, username)
        VALUES (uuid_generate_v4(), 'artist' || i || '@example.com', '$2a$10$oYXNJMAjs3Y65.F4OrfSTuqpvFaaxr4oWJ4OlOvYs/WtKmXjlgrui' || i, 'https://thispersondoesnotexist.com', 'ARTIST', 'artist' || i);
        i := i + 1;
END LOOP;
END $$;