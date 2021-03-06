DRIVER 'org.apache.derby.jdbc.ClientDriver';
CONNECT 'jdbc:derby://localhost:1527/BookStore;create=true' USER 'guest' PASSWORD 'password';

DROP TABLE Inventory;
DROP TABLE BookAuthors;
DROP TABLE ElectronicBook;
DROP TABLE Book;
DROP TABLE Store;
DROP TABLE Person;

CREATE TABLE Person (
    Id		BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    FirstName		VARCHAR(40),
    LastName     	VARCHAR(40),
    Birthday		DATE,
    Gender     		VARCHAR(40),
    LastChange      TIMESTAMP,
    CONSTRAINT		PK_PERSON PRIMARY KEY(Id)
);

CREATE TABLE Store (
    Id		BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    NickName	VARCHAR(40),
    Street1     VARCHAR(40),
    Street2		VARCHAR(40),
    City		VARCHAR(40),
    State		VARCHAR(2),
    ZipCode     VARCHAR(10),
    Version		INTEGER,
    CONSTRAINT	PK_STORE PRIMARY KEY(Id)
);

CREATE TABLE Book (
   Id		BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   ISBN			VARCHAR(10) NOT NULL,
   Title		VARCHAR(40),
   PublishedOn	DATE,
   Price		DECIMAL(5,2),
   Version		INTEGER,
   CONSTRAINT	PK_BOOK PRIMARY KEY(Id)
);

CREATE TABLE BookAuthors (
   BOOK_ID		BIGINT NOT NULL,
   FirstName	VARCHAR(40) NOT NULL,
   LastName		VARCHAR(40) NOT NULL,
   CONSTRAINT	PK_BOOK_AUTHORS  PRIMARY KEY(BOOK_ID, FirstName, LastName),
   CONSTRAINT	FK_BOOK_AUTHORS_FOR_BOOK FOREIGN KEY(BOOK_ID) REFERENCES Book(Id)
);

CREATE TABLE ElectronicBook (
   ID		BIGINT NOT NULL,
   URL			VARCHAR(120) NOT NULL,
   FileType		VARCHAR(40) NOT NULL,
   CONSTRAINT	PK_ELECTRONIC_BOOK PRIMARY KEY(ID),
   CONSTRAINT	FK_ELECTRONIC_BOOK_AND_BOOK FOREIGN KEY(ID) REFERENCES Book(Id)
);

CREATE TABLE Inventory (
   Id	BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
   BOOK_ID		BIGINT NOT NULL,
   STORE_ID		BIGINT NOT NULL,
   Quantity		INTEGER NOT NULL,
   Version		INTEGER,
   CONSTRAINT	PK_INVENTORY        PRIMARY KEY(Id),
   CONSTRAINT	UNIQUE_BOOK_STORE   UNIQUE(BOOK_ID, STORE_ID),
   CONSTRAINT	FK_INVENTORY_FOR_BOOK FOREIGN KEY(BOOK_ID) REFERENCES Book(Id),
   CONSTRAINT	FK_INVENTORY_STORE FOREIGN KEY(STORE_ID) REFERENCES Store(Id)
);