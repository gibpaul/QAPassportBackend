--
-- PostgresSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.0

-- Started on 2024-01-02 12:06:26 GMT

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 17524)
-- Name: addresses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.addresses (
    id integer NOT NULL,
    line_1 character varying,
    line_2 character varying,
    town_or_city character varying,
    country_code character varying,
    postcode character varying
);


ALTER TABLE public.addresses OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 17529)
-- Name: addresses_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.addresses_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.addresses_id_seq OWNER TO postgres;

--
-- TOC entry 3701 (class 0 OID 0)
-- Dependencies: 216
-- Name: addresses_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.addresses_id_seq OWNED BY public.addresses.id;


--
-- TOC entry 217 (class 1259 OID 17530)
-- Name: applicants; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.applicants (
    id integer NOT NULL,
    title character varying,
    type character varying,
    name_id integer,
    gender character varying,
    date_of_birth date,
    place_of_birth character varying,
    country_of_birth_code character varying,
    email character varying,
    mobile_number character varying,
    alternative_number character varying,
    sms_notification boolean,
    email_notification boolean,
    facial_image_id integer,
    current_address_id integer,
    nationality_id integer,
    previous_passports_id integer
);


ALTER TABLE public.applicants OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 17535)
-- Name: applicants_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.applicants_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.applicants_id_seq OWNER TO postgres;

--
-- TOC entry 3702 (class 0 OID 0)
-- Dependencies: 218
-- Name: applicants_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.applicants_id_seq OWNED BY public.applicants.id;


--
-- TOC entry 219 (class 1259 OID 17536)
-- Name: applications; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.applications (
    id uuid NOT NULL,
    submission_date_time timestamp with time zone,
    type character varying,
    documents_required boolean,
    source character varying,
    processing_centre character varying,
    applicant_id integer,
    product_id integer,
    applying_from_overseas boolean,
    csig_required boolean,
    payment_details_id integer,
    delivery_id integer,
    welsh_application boolean,
    document_type character varying,
    dcs_threat_level character varying,
    urgent_or_compassionate boolean,
    medium character varying,
    able_to_sign boolean,
    unable_to_sign_reason character varying
);


ALTER TABLE public.applications OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 17541)
-- Name: deliveries; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.deliveries (
    id integer NOT NULL,
    passport_delivery_address_id integer,
    documents_delivery_address_id integer,
    require_secure_document_delivery boolean
);


ALTER TABLE public.deliveries OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 17544)
-- Name: deliveries_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.deliveries_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.deliveries_id_seq OWNER TO postgres;

--
-- TOC entry 3703 (class 0 OID 0)
-- Dependencies: 221
-- Name: deliveries_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.deliveries_id_seq OWNED BY public.deliveries.id;


--
-- TOC entry 222 (class 1259 OID 17545)
-- Name: facial_images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.facial_images (
    id integer NOT NULL,
    icao_compliant boolean,
    icao_check_overridden boolean,
    yaw double precision,
    roll double precision,
    pitch double precision,
    right_eye_y integer,
    right_eye_x integer,
    left_eye_y integer,
    left_eye_x integer,
    image_type character varying,
    base_64_contents character varying,
    height integer,
    width integer,
    colour_space character varying,
    image_dpi integer,
    image_source character varying
);


ALTER TABLE public.facial_images OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 17550)
-- Name: facial_images_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.facial_images_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.facial_images_id_seq OWNER TO postgres;

--
-- TOC entry 3704 (class 0 OID 0)
-- Dependencies: 223
-- Name: facial_images_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.facial_images_id_seq OWNED BY public.facial_images.id;


--
-- TOC entry 224 (class 1259 OID 17551)
-- Name: icao_compliance_results; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.icao_compliance_results (
    compliance_id character varying NOT NULL,
    pass boolean,
    score integer,
    facial_image_id integer,
    id integer NOT NULL
);


ALTER TABLE public.icao_compliance_results OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 17556)
-- Name: icao_compliance_results_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.icao_compliance_results_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.icao_compliance_results_id_seq OWNER TO postgres;

--
-- TOC entry 3705 (class 0 OID 0)
-- Dependencies: 225
-- Name: icao_compliance_results_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.icao_compliance_results_id_seq OWNED BY public.icao_compliance_results.id;


--
-- TOC entry 226 (class 1259 OID 17557)
-- Name: names; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.names (
    id integer NOT NULL,
    surname character varying,
    forenames character varying
);


ALTER TABLE public.names OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 17562)
-- Name: names_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.names_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.names_id_seq OWNER TO postgres;

--
-- TOC entry 3706 (class 0 OID 0)
-- Dependencies: 227
-- Name: names_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.names_id_seq OWNED BY public.names.id;


--
-- TOC entry 228 (class 1259 OID 17563)
-- Name: nationalities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nationalities (
    id integer NOT NULL,
    dual_national boolean
);


ALTER TABLE public.nationalities OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 17566)
-- Name: nationalities_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nationalities_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.nationalities_id_seq OWNER TO postgres;

--
-- TOC entry 3707 (class 0 OID 0)
-- Dependencies: 229
-- Name: nationalities_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.nationalities_id_seq OWNED BY public.nationalities.id;


--
-- TOC entry 230 (class 1259 OID 17567)
-- Name: passports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.passports (
    id integer NOT NULL,
    passport_number character varying,
    expiry_year integer,
    expiry_month integer,
    expiry_day integer,
    issued_year integer,
    issued_month integer,
    issued_day integer
);


ALTER TABLE public.passports OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 17572)
-- Name: passports_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.passports_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.passports_id_seq OWNER TO postgres;

--
-- TOC entry 3708 (class 0 OID 0)
-- Dependencies: 231
-- Name: passports_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.passports_id_seq OWNED BY public.passports.id;


--
-- TOC entry 232 (class 1259 OID 17573)
-- Name: payment_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payment_details (
    id integer NOT NULL,
    payment_reference_number character varying,
    passport_cost_in_pence integer,
    amount_paid_in_pence integer,
    special_delivery_cost_in_pence integer,
    authorisation_code character varying,
    masked_card_number character varying,
    merchant_transaction_date_time timestamp with time zone,
    transaction_date_time timestamp with time zone,
    overseas_delivery_cost_in_pence integer,
    extra_large_passport_cost_in_pence integer
);


ALTER TABLE public.payment_details OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 17578)
-- Name: payment_details_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.payment_details_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.payment_details_id_seq OWNER TO postgres;

--
-- TOC entry 3709 (class 0 OID 0)
-- Dependencies: 233
-- Name: payment_details_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.payment_details_id_seq OWNED BY public.payment_details.id;


--
-- TOC entry 234 (class 1259 OID 17579)
-- Name: previous_passports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.previous_passports (
    id integer NOT NULL,
    application_passport_id integer
);


ALTER TABLE public.previous_passports OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 17582)
-- Name: previous_passports_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.previous_passports_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.previous_passports_id_seq OWNER TO postgres;

--
-- TOC entry 3710 (class 0 OID 0)
-- Dependencies: 235
-- Name: previous_passports_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.previous_passports_id_seq OWNED BY public.previous_passports.id;


--
-- TOC entry 236 (class 1259 OID 17583)
-- Name: previous_passports_passport; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.previous_passports_passport (
    previous_passports_id integer NOT NULL,
    passport_id integer NOT NULL
);


ALTER TABLE public.previous_passports_passport OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 17586)
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id integer NOT NULL,
    braille_sticker boolean,
    extra_large_passport boolean,
    service_level character varying
);


ALTER TABLE public.products OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 17591)
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.products_id_seq OWNER TO postgres;

--
-- TOC entry 3711 (class 0 OID 0)
-- Dependencies: 238
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;


--
-- TOC entry 3501 (class 2604 OID 17592)
-- Name: addresses id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.addresses ALTER COLUMN id SET DEFAULT nextval('public.addresses_id_seq'::regclass);


--
-- TOC entry 3502 (class 2604 OID 17593)
-- Name: applicants id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants ALTER COLUMN id SET DEFAULT nextval('public.applicants_id_seq'::regclass);


--
-- TOC entry 3503 (class 2604 OID 17594)
-- Name: deliveries id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deliveries ALTER COLUMN id SET DEFAULT nextval('public.deliveries_id_seq'::regclass);


--
-- TOC entry 3504 (class 2604 OID 17595)
-- Name: facial_images id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.facial_images ALTER COLUMN id SET DEFAULT nextval('public.facial_images_id_seq'::regclass);


--
-- TOC entry 3505 (class 2604 OID 17596)
-- Name: icao_compliance_results id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.icao_compliance_results ALTER COLUMN id SET DEFAULT nextval('public.icao_compliance_results_id_seq'::regclass);


--
-- TOC entry 3506 (class 2604 OID 17597)
-- Name: names id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.names ALTER COLUMN id SET DEFAULT nextval('public.names_id_seq'::regclass);


--
-- TOC entry 3507 (class 2604 OID 17598)
-- Name: nationalities id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nationalities ALTER COLUMN id SET DEFAULT nextval('public.nationalities_id_seq'::regclass);


--
-- TOC entry 3508 (class 2604 OID 17599)
-- Name: passports id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.passports ALTER COLUMN id SET DEFAULT nextval('public.passports_id_seq'::regclass);


--
-- TOC entry 3509 (class 2604 OID 17600)
-- Name: payment_details id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment_details ALTER COLUMN id SET DEFAULT nextval('public.payment_details_id_seq'::regclass);


--
-- TOC entry 3510 (class 2604 OID 17601)
-- Name: previous_passports id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.previous_passports ALTER COLUMN id SET DEFAULT nextval('public.previous_passports_id_seq'::regclass);


--
-- TOC entry 3511 (class 2604 OID 17602)
-- Name: products id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);


--
-- TOC entry 3513 (class 2606 OID 17604)
-- Name: addresses addresses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.addresses
    ADD CONSTRAINT addresses_pkey PRIMARY KEY (id);


--
-- TOC entry 3515 (class 2606 OID 17606)
-- Name: applicants applicants_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_pkey PRIMARY KEY (id);


--
-- TOC entry 3517 (class 2606 OID 17608)
-- Name: applications applications_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applications
    ADD CONSTRAINT applications_pkey PRIMARY KEY (id);


--
-- TOC entry 3519 (class 2606 OID 17610)
-- Name: deliveries deliveries_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deliveries
    ADD CONSTRAINT deliveries_pkey PRIMARY KEY (id);


--
-- TOC entry 3521 (class 2606 OID 17612)
-- Name: facial_images facial_images_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.facial_images
    ADD CONSTRAINT facial_images_pkey PRIMARY KEY (id);


--
-- TOC entry 3523 (class 2606 OID 17614)
-- Name: icao_compliance_results icao_compliance_results_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.icao_compliance_results
    ADD CONSTRAINT icao_compliance_results_pkey PRIMARY KEY (id);


--
-- TOC entry 3525 (class 2606 OID 17616)
-- Name: names names_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.names
    ADD CONSTRAINT names_pkey PRIMARY KEY (id);


--
-- TOC entry 3527 (class 2606 OID 17618)
-- Name: nationalities nationalities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nationalities
    ADD CONSTRAINT nationalities_pkey PRIMARY KEY (id);


--
-- TOC entry 3529 (class 2606 OID 17620)
-- Name: passports passports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.passports
    ADD CONSTRAINT passports_pkey PRIMARY KEY (id);


--
-- TOC entry 3531 (class 2606 OID 17622)
-- Name: payment_details payment_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment_details
    ADD CONSTRAINT payment_details_pkey PRIMARY KEY (id);


--
-- TOC entry 3535 (class 2606 OID 17624)
-- Name: previous_passports_passport previous_passports_passport_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.previous_passports_passport
    ADD CONSTRAINT previous_passports_passport_pkey PRIMARY KEY (previous_passports_id, passport_id);


--
-- TOC entry 3533 (class 2606 OID 17626)
-- Name: previous_passports previous_passports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.previous_passports
    ADD CONSTRAINT previous_passports_pkey PRIMARY KEY (id);


--
-- TOC entry 3537 (class 2606 OID 17628)
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- TOC entry 3538 (class 2606 OID 17629)
-- Name: applicants applicants_current_address_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_current_address_id_fkey FOREIGN KEY (current_address_id) REFERENCES public.addresses(id);


--
-- TOC entry 3539 (class 2606 OID 17634)
-- Name: applicants applicants_facial_image_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_facial_image_id_fkey FOREIGN KEY (facial_image_id) REFERENCES public.facial_images(id);


--
-- TOC entry 3540 (class 2606 OID 17639)
-- Name: applicants applicants_name_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_name_id_fkey FOREIGN KEY (name_id) REFERENCES public.names(id);


--
-- TOC entry 3541 (class 2606 OID 17644)
-- Name: applicants applicants_nationality_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_nationality_id_fkey FOREIGN KEY (nationality_id) REFERENCES public.nationalities(id);


--
-- TOC entry 3542 (class 2606 OID 17649)
-- Name: applicants applicants_previous_passports_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_previous_passports_id_fkey FOREIGN KEY (previous_passports_id) REFERENCES public.previous_passports(id);


--
-- TOC entry 3543 (class 2606 OID 17654)
-- Name: applications applications_applicant_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applications
    ADD CONSTRAINT applications_applicant_id_fkey FOREIGN KEY (applicant_id) REFERENCES public.applicants(id);


--
-- TOC entry 3544 (class 2606 OID 17659)
-- Name: applications applications_delivery_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applications
    ADD CONSTRAINT applications_delivery_id_fkey FOREIGN KEY (delivery_id) REFERENCES public.deliveries(id);


--
-- TOC entry 3545 (class 2606 OID 17664)
-- Name: applications applications_payment_details_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applications
    ADD CONSTRAINT applications_payment_details_id_fkey FOREIGN KEY (payment_details_id) REFERENCES public.payment_details(id);


--
-- TOC entry 3546 (class 2606 OID 17669)
-- Name: applications applications_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applications
    ADD CONSTRAINT applications_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- TOC entry 3547 (class 2606 OID 17674)
-- Name: deliveries deliveries_documents_delivery_address_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deliveries
    ADD CONSTRAINT deliveries_documents_delivery_address_id_fkey FOREIGN KEY (documents_delivery_address_id) REFERENCES public.addresses(id);


--
-- TOC entry 3548 (class 2606 OID 17679)
-- Name: deliveries deliveries_passport_delivery_address_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deliveries
    ADD CONSTRAINT deliveries_passport_delivery_address_id_fkey FOREIGN KEY (passport_delivery_address_id) REFERENCES public.addresses(id);


--
-- TOC entry 3549 (class 2606 OID 17684)
-- Name: icao_compliance_results icao_compliance_results_facial_image_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.icao_compliance_results
    ADD CONSTRAINT icao_compliance_results_facial_image_id_fkey FOREIGN KEY (facial_image_id) REFERENCES public.facial_images(id);


--
-- TOC entry 3550 (class 2606 OID 17689)
-- Name: previous_passports previous_passports_application_passport_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.previous_passports
    ADD CONSTRAINT previous_passports_application_passport_id_fkey FOREIGN KEY (application_passport_id) REFERENCES public.passports(id);


--
-- TOC entry 3551 (class 2606 OID 17694)
-- Name: previous_passports_passport previous_passports_passport_passport_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.previous_passports_passport
    ADD CONSTRAINT previous_passports_passport_passport_id_fkey FOREIGN KEY (passport_id) REFERENCES public.passports(id);


--
-- TOC entry 3552 (class 2606 OID 17699)
-- Name: previous_passports_passport previous_passports_passport_previous_passports_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.previous_passports_passport
    ADD CONSTRAINT previous_passports_passport_previous_passports_id_fkey FOREIGN KEY (previous_passports_id) REFERENCES public.previous_passports(id);


-- Completed on 2024-01-02 12:06:26 GMT

--
-- PostgresSQL database dump complete
--

