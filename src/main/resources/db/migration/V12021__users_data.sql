CREATE TABLE archivist.usersData(
	id serial not null,
	userId numeric not null,
	cardnumber text,
	lastname text,
	firstname text,
	middlename text,
	codemo text,
	enp text,
	snils text,
	birthday text,
	description text,
	date_insert text,
	date_update text
);

-- Column comments

COMMENT ON COLUMN archivist.usersData.userId IS 'id пользователя';
COMMENT ON COLUMN archivist.usersData.cardnumber IS 'Номер карты';
COMMENT ON COLUMN archivist.usersData.lastname IS 'Фамилия';
COMMENT ON COLUMN archivist.usersData.firstname IS 'Имя';
COMMENT ON COLUMN archivist.usersData.middlename IS 'Отчество';
COMMENT ON COLUMN archivist.usersData.codemo IS 'Код медицинской организации';
COMMENT ON COLUMN archivist.usersData.enp IS 'Полис ОМС';
COMMENT ON COLUMN archivist.usersData.snils IS 'Снилс';
COMMENT ON COLUMN archivist.usersData.birthday IS 'Дата рождения';
COMMENT ON COLUMN archivist.usersData.description IS 'Описание файла';
COMMENT ON COLUMN archivist.usersData.date_insert IS 'Дата добавления';
COMMENT ON COLUMN archivist.usersData.date_update IS 'Дата изменения';

	