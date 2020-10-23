--
-- PostgreSQL database dump
--

-- Dumped from database version 13.0
-- Dumped by pg_dump version 13.0

-- Started on 2020-10-19 20:11:12

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 16395)
-- Name: team_works_schema; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA team_works_schema;


ALTER SCHEMA team_works_schema OWNER TO postgres;

--
-- TOC entry 3006 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA team_works_schema; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA team_works_schema IS 'Initial db schema ';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 16428)
-- Name: tw_accounts; Type: TABLE; Schema: team_works_schema; Owner: postgres
--

CREATE TABLE team_works_schema.tw_accounts (
    user_id integer NOT NULL,
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    creation_date timestamp without time zone NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE team_works_schema.tw_accounts OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16426)
-- Name: tw_accounts_user_id_seq; Type: SEQUENCE; Schema: team_works_schema; Owner: postgres
--

CREATE SEQUENCE team_works_schema.tw_accounts_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE team_works_schema.tw_accounts_user_id_seq OWNER TO postgres;

--
-- TOC entry 3007 (class 0 OID 0)
-- Dependencies: 202
-- Name: tw_accounts_user_id_seq; Type: SEQUENCE OWNED BY; Schema: team_works_schema; Owner: postgres
--

ALTER SEQUENCE team_works_schema.tw_accounts_user_id_seq OWNED BY team_works_schema.tw_accounts.user_id;


--
-- TOC entry 201 (class 1259 OID 16408)
-- Name: tw_roles; Type: TABLE; Schema: team_works_schema; Owner: postgres
--

CREATE TABLE team_works_schema.tw_roles (
    role_id integer NOT NULL,
    role_name character varying(255) NOT NULL
);


ALTER TABLE team_works_schema.tw_roles OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16406)
-- Name: tw_roles_role_id_seq; Type: SEQUENCE; Schema: team_works_schema; Owner: postgres
--

CREATE SEQUENCE team_works_schema.tw_roles_role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE team_works_schema.tw_roles_role_id_seq OWNER TO postgres;

--
-- TOC entry 3008 (class 0 OID 0)
-- Dependencies: 200
-- Name: tw_roles_role_id_seq; Type: SEQUENCE OWNED BY; Schema: team_works_schema; Owner: postgres
--

ALTER SEQUENCE team_works_schema.tw_roles_role_id_seq OWNED BY team_works_schema.tw_roles.role_id;


--
-- TOC entry 2857 (class 2604 OID 16431)
-- Name: tw_accounts user_id; Type: DEFAULT; Schema: team_works_schema; Owner: postgres
--

ALTER TABLE ONLY team_works_schema.tw_accounts ALTER COLUMN user_id SET DEFAULT nextval('team_works_schema.tw_accounts_user_id_seq'::regclass);


--
-- TOC entry 2856 (class 2604 OID 16411)
-- Name: tw_roles role_id; Type: DEFAULT; Schema: team_works_schema; Owner: postgres
--

ALTER TABLE ONLY team_works_schema.tw_roles ALTER COLUMN role_id SET DEFAULT nextval('team_works_schema.tw_roles_role_id_seq'::regclass);


--
-- TOC entry 3000 (class 0 OID 16428)
-- Dependencies: 203
-- Data for Name: tw_accounts; Type: TABLE DATA; Schema: team_works_schema; Owner: postgres
--

COPY team_works_schema.tw_accounts (user_id, username, password, creation_date, role_id) FROM stdin;
1	Maria	1234	2020-10-19 19:12:32.630614	3
\.


--
-- TOC entry 2998 (class 0 OID 16408)
-- Dependencies: 201
-- Data for Name: tw_roles; Type: TABLE DATA; Schema: team_works_schema; Owner: postgres
--

COPY team_works_schema.tw_roles (role_id, role_name) FROM stdin;
1	manager
3	cashier
4	waiter
\.


--
-- TOC entry 3009 (class 0 OID 0)
-- Dependencies: 202
-- Name: tw_accounts_user_id_seq; Type: SEQUENCE SET; Schema: team_works_schema; Owner: postgres
--

SELECT pg_catalog.setval('team_works_schema.tw_accounts_user_id_seq', 1, true);


--
-- TOC entry 3010 (class 0 OID 0)
-- Dependencies: 200
-- Name: tw_roles_role_id_seq; Type: SEQUENCE SET; Schema: team_works_schema; Owner: postgres
--

SELECT pg_catalog.setval('team_works_schema.tw_roles_role_id_seq', 4, true);


--
-- TOC entry 2863 (class 2606 OID 16433)
-- Name: tw_accounts tw_accounts_pkey; Type: CONSTRAINT; Schema: team_works_schema; Owner: postgres
--

ALTER TABLE ONLY team_works_schema.tw_accounts
    ADD CONSTRAINT tw_accounts_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2865 (class 2606 OID 16435)
-- Name: tw_accounts tw_accounts_username_key; Type: CONSTRAINT; Schema: team_works_schema; Owner: postgres
--

ALTER TABLE ONLY team_works_schema.tw_accounts
    ADD CONSTRAINT tw_accounts_username_key UNIQUE (username);


--
-- TOC entry 2859 (class 2606 OID 16413)
-- Name: tw_roles tw_roles_pkey; Type: CONSTRAINT; Schema: team_works_schema; Owner: postgres
--

ALTER TABLE ONLY team_works_schema.tw_roles
    ADD CONSTRAINT tw_roles_pkey PRIMARY KEY (role_id);


--
-- TOC entry 2861 (class 2606 OID 16415)
-- Name: tw_roles tw_roles_role_name_key; Type: CONSTRAINT; Schema: team_works_schema; Owner: postgres
--

ALTER TABLE ONLY team_works_schema.tw_roles
    ADD CONSTRAINT tw_roles_role_name_key UNIQUE (role_name);


--
-- TOC entry 2866 (class 2606 OID 16436)
-- Name: tw_accounts tw_accounts_role_id_fkey; Type: FK CONSTRAINT; Schema: team_works_schema; Owner: postgres
--

ALTER TABLE ONLY team_works_schema.tw_accounts
    ADD CONSTRAINT tw_accounts_role_id_fkey FOREIGN KEY (role_id) REFERENCES team_works_schema.tw_roles(role_id);


-- Completed on 2020-10-19 20:11:12

--
-- PostgreSQL database dump complete
--

