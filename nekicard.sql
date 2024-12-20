-- Criação do banco de dados fora de uma transação
CREATE DATABASE nekicard
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Conecte-se ao banco de dados criado
\c nekicard;

-- Início da transação
BEGIN;

CREATE TABLE IF NOT EXISTS public.perfil
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    data_nascimento date NOT NULL,
    email character varying(150) COLLATE pg_catalog."default" NOT NULL,
    foto character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nome_completo character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nome_social character varying(100) COLLATE pg_catalog."default",
    facebook character varying(255) COLLATE pg_catalog."default",
    github character varying(255) COLLATE pg_catalog."default",
    instagram character varying(255) COLLATE pg_catalog."default",
    linkedin character varying(255) COLLATE pg_catalog."default",
    telefone character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT perfil_pkey PRIMARY KEY (id),
    CONSTRAINT uksfskobhnab413si4572hir21v UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS public.usuario
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    email character varying(150) COLLATE pg_catalog."default",
    nome character varying(100) COLLATE pg_catalog."default" NOT NULL,
    senha character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT uk5171l57faosmj8myawaucatdw UNIQUE (email)
);


-- Fim da transação
COMMIT;
