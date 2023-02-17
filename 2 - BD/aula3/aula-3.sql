

CREATE TABLE CARGO
(
   CodCargo char(2)      NOT NULL,
   NomeCargo varchar(50) NULL,
   ValorCargo decimal(10,2)      NULL,
   PRIMARY KEY(CodCargo)
);



-- Criando a tabela Funcionario
CREATE TABLE FUNCIONARIO
(
   Matricula int,
   NomeFuncionario varchar(50) NOT NULL,
   CodCargo char(2) NULL,
   PRIMARY KEY(Matricula),
   FOREIGN KEY (CodCargo) REFERENCES CARGO (CodCargo)
);


INSERT INTO CARGO (CodCargo, NomeCargo, ValorCargo) VALUES ('C1','CAIXA',  800.00);
INSERT INTO CARGO (CodCargo, NomeCargo, ValorCargo) VALUES ('C2','VENDEDOR', 1200.00);
INSERT INTO CARGO (CodCargo, NomeCargo, ValorCargo) VALUES ('C3','GERENTE', 2400.00);
INSERT INTO FUNCIONARIO (Matricula, NomeFuncionario, CodCargo) VALUES (100, 'JOÃO', 'C1');
INSERT INTO FUNCIONARIO (Matricula, NomeFuncionario, CodCargo) VALUES (110, 'MARIA', 'C2');
INSERT INTO FUNCIONARIO (Matricula, NomeFuncionario, CodCargo) VALUES (120, 'CARLOS', 'C1');
INSERT INTO FUNCIONARIO (Matricula, NomeFuncionario, CodCargo) VALUES (130, 'TADEU', NULL);


-----------------------------------------

-- EXEMPLOS DE JOIN ABORDADOS NO ARTIGO

-----------------------------------------



-- Seleção Simples ( Todos os Cargos e Todos os Funcionario ) -


SELECT * 
  FROM CARGO        C --> Apelidamos a tabelas


SELECT * 
  FROM FUNCIONARIO  F --> Apelidamos



-- CROSS JOIN ( Junção Cruzada ) - Veja Figura 3

SELECT F.NomeFuncionario
      ,C.NomeCargo
FROM            CARGO         C
   CROSS JOIN   FUNCIONARIO   F
;


-- INNER JOIN ( Junção Interna ) - Veja Figura 4

SELECT F.NomeFuncionario
      ,C.NomeCargo
  FROM CARGO C
 INNER JOIN FUNCIONARIO F ON (F.CodCargo = C.CodCargo)



-- LEFT OUTER JOIN ou simplesmente LEFT JOIN ( Junção Externa
SELECT F.nomeFuncionario
     , C.nomeCargo
  FROM FUNCIONARIO F
  LEFT OUTER JOIN CARGO C ON ( C.codCargo = F.codCargo )



-- RIGHT OUTER JOIN ou simplesmente RIGHT JOIN ( Junção
SELECT F.nomeFuncionario
     , C.nomeCargo
  FROM FUNCIONARIO F
 RIGHT OUTER JOIN CARGO C ON ( F.codCargo = C.codCargo );



-- FULL OUTER JOIN ou simplesmente FULL JOIN (Junção
SELECT F.nomeFuncionario,
       C.nomeCargo
FROM
	FUNCIONARIO F
FULL OUTER JOIN CARGO C ON
	( C.codCargo
       = F.codCargo )
       