-- UTILISATEURS

INSERT INTO utilisateur (login,password,email,profil,date_creation)VALUES('admin','admin','guillaume.hamon@gmail.com','ADMIN',CURRENT_TIMESTAMP);

INSERT INTO utilisateur (login,password,email,profil,date_creation)VALUES('user','user','guillaume.hamon@gmail.com','USER',CURRENT_TIMESTAMP);


-- THEMES

INSERT INTO theme(libelle,description,date_creation,utilisateur_creation) VALUES ('Science','<h1>Science</h1><p>Presentation du th&egrave;me science</p>',CURRENT_TIMESTAMP,1);

INSERT INTO theme(libelle,description,date_creation,utilisateur_creation) VALUES ('Géographie','<h1>G&eacute;ographie</h1><p>Pr&eactute;sentation du th&egrave;me G&eacute;ographie</p>',CURRENT_TIMESTAMP,1);

-- QUESTIONS
INSERT INTO question(libelle,reponse,theme,version,date_creation,utilisateur_creation)VALUES('<p> Combien de planète y-a t\'il dans le syst&egrave;me solaire ? <ul><li>6</li><li>7</li><li>8</li><li>9</li></ul></p>','9',1,1,CURRENT_TIMESTAMP,1);

INSERT INTO question(libelle,reponse,theme,version,date_creation,utilisateur_creation)VALUES('<p> Ou se trouve la ceinture d\'asteroide ? <ul><li>Entre Venus et la Terre</li><li>Entre Mars et Jupiter</li><li>Au-del&agrave; de Pluton</li></ul></p>','Entre Mars et Jupiter',1,1,CURRENT_TIMESTAMP,1);

INSERT INTO question(libelle,reponse,theme,version,date_creation,utilisateur_creation)VALUES('<p>Quel est le plus long fleuve français ?</p>','Loire',2,1,CURRENT_TIMESTAMP,1);

INSERT INTO question(libelle,reponse,theme,version,date_creation,utilisateur_creation)VALUES('<p> Quelle est l\'altitude en mètre du mont Everest ? ? <ul><li>6 848</li><li>8 848</li><li>10 848</li></ul></p>','8 848',2,1,CURRENT_TIMESTAMP,1);

INSERT INTO question(libelle,reponse,theme,version,date_creation,utilisateur_creation)VALUES('<p> Quel est le plus grand pays du monde ? <ul><li>La Chine</li><li>La Russie</li><li>L\'Australie</li></ul></p>','La Russie',2,1,CURRENT_TIMESTAMP,1);


-- CLIENTS
INSERT INTO client (nom,adresse,code_postal,commune,date_creation,utilisateur_creation) VALUES('BAR DU MATIN','AV DES PYRENEES','64000','PAU',CURRENT_TIMESTAMP,1);

INSERT INTO client (nom,adresse,code_postal,commune,date_creation,utilisateur_creation) VALUES('LIONS\'S PUB','ROUTEf DE BAYONNE','64100','BAYONNE',CURRENT_TIMESTAMP,1);

-- CONTACTS

INSERT INTO contact(type,valeur,client,date_creation,utilisateur_creation)VALUES('DOMICILE','0559590000',1,CURRENT_TIMESTAMP,1);
INSERT INTO contact(type,valeur,client,date_creation,utilisateur_creation)VALUES('MOBILE_PRO','0663123456',1,CURRENT_TIMESTAMP,1);

INSERT INTO contact(type,valeur,client,date_creation,utilisateur_creation)VALUES('DOMICILE','0559595959',2,CURRENT_TIMESTAMP,1);
INSERT INTO contact(type,valeur,client,date_creation,utilisateur_creation)VALUES('MOBILE_PERSO','0688123456',2,CURRENT_TIMESTAMP,1);

-- QUESTIONNAIRES
INSERT INTO questionnaire(libelle,description,utilisateur_creation,date_creation) VALUES('De la Science','Retrouver le gout de la science',1,CURRENT_TIMESTAMP);
INSERT INTO questionnaire(libelle,description,utilisateur_creation,date_creation) VALUES('Geographie à gogo','Un petit tour de la planète',1,CURRENT_TIMESTAMP);
INSERT INTO questionnaire(libelle,description,utilisateur_creation,date_creation) VALUES('Un petit melange','De la géographie et un peu de science',1,CURRENT_TIMESTAMP);

-- QUESTIONNAIRES_CLIENTS
INSERT INTO client_questionnaires(client,questionnaires) VALUES(1,1);
INSERT INTO client_questionnaires(client,questionnaires) VALUES(1,1);
INSERT INTO client_questionnaires(client,questionnaires) VALUES(2,2);
INSERT INTO client_questionnaires(client,questionnaires) VALUES(2,2);

-- QUESTIONNAIRES_QUESTIONS
INSERT iNTO questionnaire_questions(questionnaire,questions)VALUES(1,1);
INSERT iNTO questionnaire_questions(questionnaire,questions)VALUES(1,2);
INSERT iNTO questionnaire_questions(questionnaire,questions)VALUES(2,3);
INSERT iNTO questionnaire_questions(questionnaire,questions)VALUES(2,4);
INSERT iNTO questionnaire_questions(questionnaire,questions)VALUES(2,5);
INSERT iNTO questionnaire_questions(questionnaire,questions)VALUES(3,1);
INSERT iNTO questionnaire_questions(questionnaire,questions)VALUES(3,3);
INSERT iNTO questionnaire_questions(questionnaire,questions)VALUES(3,5);

-- SUPPORTS
INSERT INTO support(chemin_fichier,meta_donnees,question,utilisateur_creation,date_creation) values ("D:\\UTILISATEURS\\CER3100342\\Documents\\03_PERSO\\01_QI\\Mont_Everest.jpg",'Montagne,Everest,Nepal',4,1,CURRENT_TIMESTAMP);
