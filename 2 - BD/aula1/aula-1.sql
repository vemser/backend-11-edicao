CREATE TABLE VEM_SER.PESSOA (
    id_pessoa NUMBER NOT NULL,
    nome VARCHAR2(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    telefone VARCHAR(14), -- +5551995249346
    idade NUMBER(3) NOT NULL,
    altura DECIMAL(2,1) NOT NULL,
    cpf CHAR(11) UNIQUE NOT NULL,
    PRIMARY KEY(id_pessoa)
);

DROP TABLE VEM_SER.PESSOA

CREATE SEQUENCE SEQ_PESSOA
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

DROP SEQUENCE VEM_SER.seq_pessoa

INSERT INTO VEM_SER.PESSOA
(ID_PESSOA, NOME, DATA_NASCIMENTO, TELEFONE, IDADE, ALTURA, SEXO, cpf)
VALUES(SEQ_PESSOA.nextval, 'Rafael Lazzari', TO_DATE('08-09-1990', 'dd-mm-yyyy'), '519958656666', 30, 1.74, '35283445068');


SELECT * FROM VEM_SER.PESSOA 

