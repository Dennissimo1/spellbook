create TYPE state AS ENUM('NOT_PICKED_UP', 'BUSY', 'FINISHED', 'POSTPONED');
create TYPE priority AS ENUM('HIGH', 'MEDIUM', 'LOW', 'POSTPONED');
create table SPELLBOOKAPP(
    ID int not null GENERATED ALWAYS AS IDENTITY,
    ITEM varchar(100) not null,
    STATE state NOT NULL,
    PRIORITY priority NOT NULL,
    DATE timestamp NOT NULL,
    PRIMARY KEY ( ID )
);