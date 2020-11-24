create sequence seq_id_client start 1 increment 50
create sequence seq_id_competition start 1 increment 50
create sequence seq_id_equipe start 1 increment 50
create sequence seq_id_param start 1 increment 50
create sequence seq_id_qijeu start 1 increment 50
create sequence seq_id_qijeu_resultat start 1 increment 50
create sequence seq_id_question start 1 increment 50
create sequence seq_id_questionnaire start 1 increment 50
create sequence seq_id_support start 1 increment 50
create sequence seq_id_theme start 1 increment 50
create sequence seq_id_utilisateur start 1 increment 50

    create table client (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        adresse varchar(100),
        code_postal varchar(255),
        commune varchar(255),
        email1 varchar(255),
        email2 varchar(255),
        nom varchar(50) not null,
        pays varchar(255),
        telephone1 varchar(255),
        telephone2 varchar(255),
        primary key (id)
    )

    create table competition (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        date_debut timestamp,
        date_fin timestamp,
        date_maj timestamp,
        nom varchar(50) not null,
        client_id int8,
        primary key (id)
    )

    create table equipe (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        email1 varchar(255),
        email2 varchar(255),
        nom varchar(50) not null,
        telephone1 varchar(255),
        telephone2 varchar(255),
        client_id int8,
        primary key (id)
    )

    create table parametre (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        code varchar(32) not null,
        description varchar(255),
        libelle varchar(32) not null,
        type varchar(32) not null,
        primary key (id)
    )

    create table qi_jeu (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        date_qi_jeu timestamp,
        nom varchar(255),
        competition_id int8,
        questionnaire_id int8,
        primary key (id)
    )

    create table qi_jeu_resultat (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        classement int4,
        points int4,
        equipe_id int8,
        qijeu_id int8,
        primary key (id)
    )

    create table question (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        libelle varchar(255),
        metadonnees varchar(255),
        reponse varchar(255),
        version int4 not null,
        statut_id int8,
        theme_id int8,
        primary key (id)
    )

    create table question_support (
       question_id int8 not null,
        support_id int8 not null
    )

    create table questionnaire (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        description varchar(255),
        fichier oid,
        nom varchar(255) not null,
        primary key (id)
    )

    create table questionnaire_question (
       questionnaire_id int8 not null,
        question_id int8 not null
    )

    create table support (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        chemin_fichier varchar(255) not null,
        description varchar(255),
        meta_donnees varchar(255),
        primary key (id)
    )

    create table theme (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        description varchar(255),
        libelle varchar(32) not null,
        primary key (id)
    )

    create table utilisateur (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        login varchar(255) not null,
        password varchar(255) not null,
        client_id int8,
        profil_id int8,
        statut_id int8,
        primary key (id)
    )

    alter table parametre 
       add constraint code_ukey unique (code)

    alter table question_support 
       add constraint question_support_ukey unique (question_id, support_id)

    alter table questionnaire_question 
       add constraint questionnaire_question_ukey unique (questionnaire_id, question_id)

    alter table utilisateur 
       add constraint login_ukey unique (login)

    alter table competition 
       add constraint client_id_fkey 
       foreign key (client_id) 
       references client

    alter table equipe 
       add constraint client_id_fkey 
       foreign key (client_id) 
       references client

    alter table qi_jeu 
       add constraint competition_id_fkey 
       foreign key (competition_id) 
       references competition

    alter table qi_jeu 
       add constraint questionnaire_id_fkey 
       foreign key (questionnaire_id) 
       references questionnaire

    alter table qi_jeu_resultat 
       add constraint equipe_id_fkey 
       foreign key (equipe_id) 
       references equipe

    alter table qi_jeu_resultat 
       add constraint qijeu_id_fkey 
       foreign key (qijeu_id) 
       references qi_jeu

    alter table question 
       add constraint statut_id_fkey 
       foreign key (statut_id) 
       references parametre

    alter table question 
       add constraint theme_id_fkey 
       foreign key (theme_id) 
       references theme

    alter table question_support 
       add constraint support_id_fkey 
       foreign key (support_id) 
       references support

    alter table question_support 
       add constraint question_id_fkey 
       foreign key (question_id) 
       references question

    alter table questionnaire_question 
       add constraint question_id_fkey 
       foreign key (question_id) 
       references questionnaire

    alter table questionnaire_question 
       add constraint questionnaire_id_fkey 
       foreign key (questionnaire_id) 
       references question

    alter table utilisateur 
       add constraint client_id_fkey 
       foreign key (client_id) 
       references client

    alter table utilisateur 
       add constraint profil_id_fkey 
       foreign key (profil_id) 
       references parametre

    alter table utilisateur 
       add constraint statut_id_fkey 
       foreign key (statut_id) 
       references parametre
create sequence seq_id_client start 1 increment 50
create sequence seq_id_competition start 1 increment 50
create sequence seq_id_equipe start 1 increment 50
create sequence seq_id_param start 1 increment 50
create sequence seq_id_qijeu start 1 increment 50
create sequence seq_id_qijeu_resultat start 1 increment 50
create sequence seq_id_question start 1 increment 50
create sequence seq_id_questionnaire start 1 increment 50
create sequence seq_id_support start 1 increment 50
create sequence seq_id_theme start 1 increment 50
create sequence seq_id_utilisateur start 1 increment 50

    create table client (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        adresse varchar(100),
        code_postal varchar(255),
        commune varchar(255),
        email1 varchar(255),
        email2 varchar(255),
        nom varchar(50) not null,
        pays varchar(255),
        telephone1 varchar(255),
        telephone2 varchar(255),
        primary key (id)
    )

    create table competition (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        date_debut timestamp,
        date_fin timestamp,
        date_maj timestamp,
        nom varchar(50) not null,
        client_id int8,
        primary key (id)
    )

    create table equipe (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        email1 varchar(255),
        email2 varchar(255),
        nom varchar(50) not null,
        telephone1 varchar(255),
        telephone2 varchar(255),
        client_id int8,
        primary key (id)
    )

    create table parametre (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        code varchar(32) not null,
        description varchar(255),
        libelle varchar(32) not null,
        type varchar(32) not null,
        primary key (id)
    )

    create table qi_jeu (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        date_qi_jeu timestamp,
        nom varchar(255),
        competition_id int8,
        questionnaire_id int8,
        primary key (id)
    )

    create table qi_jeu_resultat (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        classement int4,
        points int4,
        equipe_id int8,
        qijeu_id int8,
        primary key (id)
    )

    create table question (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        libelle varchar(255),
        metadonnees varchar(255),
        reponse varchar(255),
        version int4 not null,
        statut_id int8,
        theme_id int8,
        primary key (id)
    )

    create table question_support (
       question_id int8 not null,
        support_id int8 not null
    )

    create table questionnaire (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        description varchar(255),
        fichier oid,
        nom varchar(255) not null,
        primary key (id)
    )

    create table questionnaire_question (
       questionnaire_id int8 not null,
        question_id int8 not null
    )

    create table support (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        chemin_fichier varchar(255) not null,
        description varchar(255),
        meta_donnees varchar(255),
        primary key (id)
    )

    create table theme (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        description varchar(255),
        libelle varchar(32) not null,
        primary key (id)
    )

    create table utilisateur (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        login varchar(255) not null,
        password varchar(255) not null,
        client_id int8,
        profil_id int8,
        statut_id int8,
        primary key (id)
    )

    alter table parametre 
       add constraint code_ukey unique (code)

    alter table question_support 
       add constraint question_support_ukey unique (question_id, support_id)

    alter table questionnaire_question 
       add constraint questionnaire_question_ukey unique (questionnaire_id, question_id)

    alter table utilisateur 
       add constraint login_ukey unique (login)

    alter table competition 
       add constraint client_id_fkey 
       foreign key (client_id) 
       references client

    alter table equipe 
       add constraint client_id_fkey 
       foreign key (client_id) 
       references client

    alter table qi_jeu 
       add constraint competition_id_fkey 
       foreign key (competition_id) 
       references competition

    alter table qi_jeu 
       add constraint questionnaire_id_fkey 
       foreign key (questionnaire_id) 
       references questionnaire

    alter table qi_jeu_resultat 
       add constraint equipe_id_fkey 
       foreign key (equipe_id) 
       references equipe

    alter table qi_jeu_resultat 
       add constraint qijeu_id_fkey 
       foreign key (qijeu_id) 
       references qi_jeu

    alter table question 
       add constraint statut_id_fkey 
       foreign key (statut_id) 
       references parametre

    alter table question 
       add constraint theme_id_fkey 
       foreign key (theme_id) 
       references theme

    alter table question_support 
       add constraint support_id_fkey 
       foreign key (support_id) 
       references support

    alter table question_support 
       add constraint question_id_fkey 
       foreign key (question_id) 
       references question

    alter table questionnaire_question 
       add constraint question_id_fkey 
       foreign key (question_id) 
       references questionnaire

    alter table questionnaire_question 
       add constraint questionnaire_id_fkey 
       foreign key (questionnaire_id) 
       references question

    alter table utilisateur 
       add constraint client_id_fkey 
       foreign key (client_id) 
       references client

    alter table utilisateur 
       add constraint profil_id_fkey 
       foreign key (profil_id) 
       references parametre

    alter table utilisateur 
       add constraint statut_id_fkey 
       foreign key (statut_id) 
       references parametre
create sequence seq_id_client start 1 increment 50
create sequence seq_id_competition start 1 increment 50
create sequence seq_id_equipe start 1 increment 50
create sequence seq_id_param start 1 increment 50
create sequence seq_id_qijeu start 1 increment 50
create sequence seq_id_qijeu_resultat start 1 increment 50
create sequence seq_id_question start 1 increment 50
create sequence seq_id_questionnaire start 1 increment 50
create sequence seq_id_support start 1 increment 50
create sequence seq_id_theme start 1 increment 50
create sequence seq_id_utilisateur start 1 increment 50

    create table client (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        adresse varchar(100),
        code_postal varchar(255),
        commune varchar(255),
        email1 varchar(255),
        email2 varchar(255),
        nom varchar(50) not null,
        pays varchar(255),
        telephone1 varchar(255),
        telephone2 varchar(255),
        primary key (id)
    )

    create table competition (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        date_debut timestamp,
        date_fin timestamp,
        date_maj timestamp,
        nom varchar(50) not null,
        client_id int8,
        primary key (id)
    )

    create table equipe (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        email1 varchar(255),
        email2 varchar(255),
        nom varchar(50) not null,
        telephone1 varchar(255),
        telephone2 varchar(255),
        client_id int8,
        primary key (id)
    )

    create table parametre (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        code varchar(32) not null,
        description varchar(255),
        libelle varchar(32) not null,
        type varchar(32) not null,
        primary key (id)
    )

    create table qi_jeu (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        date_qi_jeu timestamp,
        nom varchar(255),
        competition_id int8,
        questionnaire_id int8,
        primary key (id)
    )

    create table qi_jeu_resultat (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        classement int4,
        points int4,
        equipe_id int8,
        qijeu_id int8,
        primary key (id)
    )

    create table question (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        libelle varchar(255),
        metadonnees varchar(255),
        reponse varchar(255),
        version int4 not null,
        statut_id int8,
        theme_id int8,
        primary key (id)
    )

    create table question_support (
       question_id int8 not null,
        support_id int8 not null
    )

    create table questionnaire (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        description varchar(255),
        fichier oid,
        nom varchar(255) not null,
        primary key (id)
    )

    create table questionnaire_question (
       questionnaire_id int8 not null,
        question_id int8 not null
    )

    create table support (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        chemin_fichier varchar(255) not null,
        description varchar(255),
        meta_donnees varchar(255),
        primary key (id)
    )

    create table theme (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        description varchar(255),
        libelle varchar(32) not null,
        primary key (id)
    )

    create table utilisateur (
       id int8 not null,
        date_creation timestamp,
        date_modification timestamp,
        login varchar(255) not null,
        password varchar(255) not null,
        client_id int8,
        profil_id int8,
        statut_id int8,
        primary key (id)
    )

    alter table parametre 
       add constraint code_ukey unique (code)

    alter table question_support 
       add constraint question_support_ukey unique (question_id, support_id)

    alter table questionnaire_question 
       add constraint questionnaire_question_ukey unique (questionnaire_id, question_id)

    alter table utilisateur 
       add constraint login_ukey unique (login)

    alter table competition 
       add constraint client_id_fkey 
       foreign key (client_id) 
       references client

    alter table equipe 
       add constraint client_id_fkey 
       foreign key (client_id) 
       references client

    alter table qi_jeu 
       add constraint competition_id_fkey 
       foreign key (competition_id) 
       references competition

    alter table qi_jeu 
       add constraint questionnaire_id_fkey 
       foreign key (questionnaire_id) 
       references questionnaire

    alter table qi_jeu_resultat 
       add constraint equipe_id_fkey 
       foreign key (equipe_id) 
       references equipe

    alter table qi_jeu_resultat 
       add constraint qijeu_id_fkey 
       foreign key (qijeu_id) 
       references qi_jeu

    alter table question 
       add constraint statut_id_fkey 
       foreign key (statut_id) 
       references parametre

    alter table question 
       add constraint theme_id_fkey 
       foreign key (theme_id) 
       references theme

    alter table question_support 
       add constraint support_id_fkey 
       foreign key (support_id) 
       references support

    alter table question_support 
       add constraint question_id_fkey 
       foreign key (question_id) 
       references question

    alter table questionnaire_question 
       add constraint question_id_fkey 
       foreign key (question_id) 
       references questionnaire

    alter table questionnaire_question 
       add constraint questionnaire_id_fkey 
       foreign key (questionnaire_id) 
       references question

    alter table utilisateur 
       add constraint client_id_fkey 
       foreign key (client_id) 
       references client

    alter table utilisateur 
       add constraint profil_id_fkey 
       foreign key (profil_id) 
       references parametre

    alter table utilisateur 
       add constraint statut_id_fkey 
       foreign key (statut_id) 
       references parametre
