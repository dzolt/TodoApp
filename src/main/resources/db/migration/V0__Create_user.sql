CREATE SEQUENCE public.todo_user_sequence
    MINVALUE 1
    MAXVALUE 9223372036854775807
    INCREMENT 1
    START 1
    CACHE 1
;

CREATE SEQUENCE public.user_role_sequence
    MINVALUE 1
    MAXVALUE 9223372036854775807
    INCREMENT 1
    START 1
    CACHE 1
;

CREATE TABLE public.user_role (
    id BIGINT   NOT NULL  PRIMARY KEY DEFAULT nextval('public.user_role_sequence'),
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE public.todo_user (
    id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('public.todo_user_sequence'),
    username    VARCHAR(255) NOT NULL UNIQUE,
    password    VARCHAR(255) NOT NULL
);

CREATE TABLE public.users_roles (
    user_id     BIGINT NOT NULL,
    role_id     BIGINT NOT NULL,

    CONSTRAINT user_id_fk   FOREIGN KEY (user_id) REFERENCES public.todo_user (id),
    CONSTRAINT role_id_fk   FOREIGN KEY (role_id) REFERENCES public.user_role (id)
);