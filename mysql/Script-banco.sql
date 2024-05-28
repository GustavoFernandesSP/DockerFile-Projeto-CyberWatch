CREATE DATABASE securityWings;

	USE securityWings;

	CREATE TABLE Empresa(
		idEmpresa int primary key auto_increment,
		nome varchar(45),
		cnpj char(18) unique,
		telefone char(15)	
	);

	CREATE TABLE Endereco(
		idEndereco int primary key auto_increment,
		cidade varchar(50),
		bairro varchar(50),
		uf char(2),
		rua varchar(50),
		cep char(9),
		complemento varchar(30),
		fkEmpresa int,
		constraint fk_endereco_empresa foreign key (fkEmpresa) references Empresa(idEmpresa)
	);

	CREATE TABLE usuario(
		idUsuario int primary key auto_increment,
		nome varchar(45),
		cpf char(14)unique,
		email varchar(255) UNIQUE,
		isAdmin boolean,
		isManager boolean,
		senha varchar(255),
		fkEmpresa int,
		constraint fk_empresa_funcionario foreign key (fkEmpresa) references Empresa(idEmpresa)
	);

	CREATE TABLE ComputadorESpec(
		idComputador int primary key auto_increment,
		processadorModelo varchar(150),
		processadorNucleosFisicos int,
		processadorNucleosLógicos int,
		processadorFrequencia float,
		discoTotal int,
		ramTotal int,
		fkEmpresa int,
		fkUsuario int,
		constraint fkEmpresa foreign key (fkEmpresa) references Empresa(idEmpresa),
		constraint fkUsuarioComp foreign key(fkUsuario) references usuario(idUsuario)
	);
    
	CREATE TABLE Monitoramento(
		idMonitoramento int primary key auto_increment,
		processadorUso float,
		ramUso float,
		discoUso float,
		bytesEnviados long,
		bytesRecebidos long,
		dataCaptura varchar(100),
		fkComputador int,
		constraint fkComputadorMon foreign key (fkComputador) references ComputadorESpec(idComputador)
	);

	CREATE TABLE processosPemitidos(
	idProcesso int primary key auto_increment,
	nomeDoProcessoPermitido varchar(100),
	fkEmpresa int,
	constraint fk foreign key(fkEmpresa) references Empresa(idEmpresa)
	);

	CREATE TABLE parametrosDeAlerta(
	idAlerta int primary key auto_increment,
	ramWarning varchar(50),
    ramDanger varchar(50),
    processadorWarning varchar (50),
    processadorDanger varchar(50),
    internetWarning varchar(50),
    internetDanger varchar(50),
    fkEmpresa int,
	constraint fksEmp foreign key(fkEmpresa) references Empresa(idEmpresa)
	);
	 
	-- NOSSAS CREDÊNCIAS -- -- NOSSAS CREDÊNCIAS -- -- NOSSAS CREDÊNCIAS -- -- NOSSAS CREDÊNCIAS --

	INSERT INTO usuario (nome, cpf, email, isAdmin, isManager, senha, fkEmpresa) VALUES 
	('Eduardo Melo De Oliveira', '12345678900', 'eduardo@secWings.com', false, true, '123123', NULL),
	('Fernanda Das Flores Silvino ', '12345678910', 'fernanda@secWings.com', false, true, '123123', NULL),
	('Kauã Vidal Magalhães', '12345678920', 'kaua@secWings.com', false, true, '123123', NULL),
	('Luca Sena', '12345678930', 'luca@secWings.com', false, true, '123123', NULL),
	('Victor Nunes', '12345678940', 'victor@secWings.com', false, true, '123123', NULL),
	('Gustavo Fernandes', '12345678950', 'gustavo@secWings.com', false, true, '123123', NULL);


	-- DAQUI PRA BAIXO É TUDO MOCK PRA TESTAR EM DEV --  -- DAQUI PRA BAIXO É TUDO MOCK PRA TESTAR EM DEV --  

	INSERT INTO Empresa (nome, cnpj, telefone) VALUES 
		('Aeroportos Brasil S.A.', '12.345.678/0001-90', '(12) 3456-7890'),
		('Aviação Express Ltda.', '23.456.789/0001-91', '(23) 4567-8910'),
		('Jet Airways Inc.', '34.567.890/0001-92', '(34) 5678-9101'),
		('SkyPort Transportes Aéreos', '45.678.901/0001-93', '(45) 6789-1011'),
		('WingTech Aviação Ltda.', '56.789.012/0001-94', '(56) 7890-1122'),
		('Voo Seguro Transportadora Aérea', '67.890.123/0001-95', '(67) 8901-1233'),
		('AeroBrasil Logística Aeroportuária', '78.901.234/0001-96', '(78) 9012-3454'),
		('Aerogiro Serviços Aeronáuticos', '89.012.345/0001-97', '(89) 0123-4567'),
		('AirLink Transportes Aéreos', '90.123.456/0001-98', '(90) 1234-5678'),
		('SkyHawk Comércio de Aeronaves', '01.234.567/0001-99', '(01) 2345-6789');
	
select * from ComputadorEspec;


select * from monitoramento;

SELECT * FROM Monitoramento WHERE fkComputador = 1 ORDER BY idMonitoramento DESC LIMIT 1;