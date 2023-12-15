--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

-- Started on 2023-12-15 13:12:39 GMT

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
-- TOC entry 217 (class 1259 OID 16420)
-- Name: addresses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.addresses (
    id uuid NOT NULL,
    line_1 character varying,
    line_2 character varying,
    town_or_city character varying,
    country_code character varying,
    postcode character varying
);


ALTER TABLE public.addresses OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16449)
-- Name: applicants; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.applicants (
    id uuid NOT NULL,
    title character varying,
    type character varying,
    name_id uuid,
    gender character varying,
    date_of_birth date,
    place_of_birth character varying,
    country_of_birth_code character varying,
    email character varying,
    mobile_number character varying,
    alternative_number character varying,
    sms_notification boolean,
    email_notification boolean,
    facial_image_id uuid,
    current_address_id uuid,
    nationality_id uuid,
    previous_passports_id uuid
);


ALTER TABLE public.applicants OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16510)
-- Name: applications; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.applications (
    id uuid NOT NULL,
    submission_date_time timestamp with time zone,
    type character varying,
    documents_required boolean,
    source character varying,
    processing_centre character varying,
    applicant_id uuid,
    product_id uuid,
    applying_from_overseas boolean,
    csig_required boolean,
    payment_details_id uuid,
    delivery_id uuid,
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
-- TOC entry 224 (class 1259 OID 16495)
-- Name: deliveries; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.deliveries (
    id uuid NOT NULL,
    passport_delivery_address_id uuid,
    documents_delivery_address_id uuid,
    require_secure_document_delivery boolean
);


ALTER TABLE public.deliveries OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16413)
-- Name: facial_images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.facial_images (
    id uuid NOT NULL,
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
-- TOC entry 226 (class 1259 OID 16537)
-- Name: icao_complaince_results; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.icao_complaince_results (
    compliance_id character varying NOT NULL,
    pass boolean,
    score integer,
    facial_image_id uuid
);


ALTER TABLE public.icao_complaince_results OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16406)
-- Name: names; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.names (
    id uuid NOT NULL,
    surname character varying,
    forenames character varying
);


ALTER TABLE public.names OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16427)
-- Name: nationalities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nationalities (
    id uuid NOT NULL,
    dual_national boolean
);


ALTER TABLE public.nationalities OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16432)
-- Name: passports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.passports (
    id uuid NOT NULL,
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
-- TOC entry 223 (class 1259 OID 16488)
-- Name: payment_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payment_details (
    id uuid NOT NULL,
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
-- TOC entry 220 (class 1259 OID 16439)
-- Name: previous_passports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.previous_passports (
    id uuid NOT NULL,
    application_passport_id uuid
);


ALTER TABLE public.previous_passports OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16481)
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id uuid NOT NULL,
    braille_sticker boolean,
    extra_large_passport boolean,
    service_level character varying
);


ALTER TABLE public.products OWNER TO postgres;

--
-- TOC entry 3491 (class 2606 OID 16426)
-- Name: addresses addresses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.addresses
    ADD CONSTRAINT addresses_pkey PRIMARY KEY (id);


--
-- TOC entry 3499 (class 2606 OID 16455)
-- Name: applicants applicants_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_pkey PRIMARY KEY (id);


--
-- TOC entry 3507 (class 2606 OID 16516)
-- Name: applications applications_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applications
    ADD CONSTRAINT applications_pkey PRIMARY KEY (id);


--
-- TOC entry 3505 (class 2606 OID 16499)
-- Name: deliveries deliveries_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deliveries
    ADD CONSTRAINT deliveries_pkey PRIMARY KEY (id);


--
-- TOC entry 3489 (class 2606 OID 16419)
-- Name: facial_images facial_images_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.facial_images
    ADD CONSTRAINT facial_images_pkey PRIMARY KEY (id);


--
-- TOC entry 3509 (class 2606 OID 16543)
-- Name: icao_complaince_results icao_complaince_results_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.icao_complaince_results
    ADD CONSTRAINT icao_complaince_results_pkey PRIMARY KEY (compliance_id);


--
-- TOC entry 3487 (class 2606 OID 16412)
-- Name: names names_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.names
    ADD CONSTRAINT names_pkey PRIMARY KEY (id);


--
-- TOC entry 3493 (class 2606 OID 16431)
-- Name: nationalities nationalities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nationalities
    ADD CONSTRAINT nationalities_pkey PRIMARY KEY (id);


--
-- TOC entry 3495 (class 2606 OID 16438)
-- Name: passports passports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.passports
    ADD CONSTRAINT passports_pkey PRIMARY KEY (id);


--
-- TOC entry 3503 (class 2606 OID 16494)
-- Name: payment_details payment_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment_details
    ADD CONSTRAINT payment_details_pkey PRIMARY KEY (id);


--
-- TOC entry 3497 (class 2606 OID 16443)
-- Name: previous_passports previous_passports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.previous_passports
    ADD CONSTRAINT previous_passports_pkey PRIMARY KEY (id);


--
-- TOC entry 3501 (class 2606 OID 16487)
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- TOC entry 3511 (class 2606 OID 16466)
-- Name: applicants applicants_current_address_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_current_address_id_fkey FOREIGN KEY (current_address_id) REFERENCES public.addresses(id);


--
-- TOC entry 3512 (class 2606 OID 16461)
-- Name: applicants applicants_facial_image_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_facial_image_id_fkey FOREIGN KEY (facial_image_id) REFERENCES public.facial_images(id);


--
-- TOC entry 3513 (class 2606 OID 16456)
-- Name: applicants applicants_name_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_name_id_fkey FOREIGN KEY (name_id) REFERENCES public.names(id);


--
-- TOC entry 3514 (class 2606 OID 16471)
-- Name: applicants applicants_nationality_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_nationality_id_fkey FOREIGN KEY (nationality_id) REFERENCES public.nationalities(id);


--
-- TOC entry 3515 (class 2606 OID 16476)
-- Name: applicants applicants_previous_passports_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applicants
    ADD CONSTRAINT applicants_previous_passports_id_fkey FOREIGN KEY (previous_passports_id) REFERENCES public.previous_passports(id);


--
-- TOC entry 3518 (class 2606 OID 16517)
-- Name: applications applications_applicant_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applications
    ADD CONSTRAINT applications_applicant_id_fkey FOREIGN KEY (applicant_id) REFERENCES public.applicants(id);


--
-- TOC entry 3519 (class 2606 OID 16532)
-- Name: applications applications_delivery_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applications
    ADD CONSTRAINT applications_delivery_id_fkey FOREIGN KEY (delivery_id) REFERENCES public.deliveries(id);


--
-- TOC entry 3520 (class 2606 OID 16527)
-- Name: applications applications_payment_details_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applications
    ADD CONSTRAINT applications_payment_details_id_fkey FOREIGN KEY (payment_details_id) REFERENCES public.payment_details(id);


--
-- TOC entry 3521 (class 2606 OID 16522)
-- Name: applications applications_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.applications
    ADD CONSTRAINT applications_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- TOC entry 3516 (class 2606 OID 16505)
-- Name: deliveries deliveries_documents_delivery_address_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deliveries
    ADD CONSTRAINT deliveries_documents_delivery_address_id_fkey FOREIGN KEY (documents_delivery_address_id) REFERENCES public.addresses(id);


--
-- TOC entry 3517 (class 2606 OID 16500)
-- Name: deliveries deliveries_passport_delivery_address_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deliveries
    ADD CONSTRAINT deliveries_passport_delivery_address_id_fkey FOREIGN KEY (passport_delivery_address_id) REFERENCES public.addresses(id);


--
-- TOC entry 3522 (class 2606 OID 16544)
-- Name: icao_complaince_results icao_complaince_results_facial_image_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.icao_complaince_results
    ADD CONSTRAINT icao_complaince_results_facial_image_id_fkey FOREIGN KEY (facial_image_id) REFERENCES public.facial_images(id);


--
-- TOC entry 3510 (class 2606 OID 16444)
-- Name: previous_passports previous_passports_application_passport_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.previous_passports
    ADD CONSTRAINT previous_passports_application_passport_id_fkey FOREIGN KEY (application_passport_id) REFERENCES public.passports(id);


-- Completed on 2023-12-15 13:12:40 GMT

--
-- PostgreSQL database dump complete
--

