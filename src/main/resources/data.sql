drop table IF EXISTS track;
drop table IF EXISTS waypoint;
drop table IF EXISTS track_point;


create TABLE track (
    track_id    INT             AUTO_INCREMENT  PRIMARY KEY,
    name        VARCHAR(255)    NOT NULL,
    description VARCHAR(1000)   DEFAULT NULL,
    author      VARCHAR(50)     NOT NULL,
    url         VARCHAR(255)    NOT NULL,
    url_text    VARCHAR(255)    DEFAULT NULL,
    time        TIMESTAMP       NOT NULL,
);

create table track_point (
    track_point_id  INT             AUTO_INCREMENT PRIMARY KEY,
    track_id        INT             NOT NULL,
    latitude        DECIMAL(18,15)   NOT NULL,
    longitude       DECIMAL(18,15)   NOT NULL,
    elevation       DECIMAL(18,15)   NOT NULL,
    time            TIMESTAMP       NOT NULL
);


insert into track(name, description, author, url, url_text, time)
values ('Bardenas Reales: Piskerra y el Paso de los Ciervos',
        'Este espectacular Parque Natural semidesértico de belleza salvaje fue declarado Reserva de la Biosfera por la UNESCO. Un espectáculo insólito al sureste de Navarra próximo a Tudela, que a pesar de contar con una apariencia desnuda e inhóspita, esconde grandes valores naturales. La erosión de sus suelos arcillosos, yesos y areniscas ha esculpido caprichosas formas creando un mundo de apariencia casi lunar poblado de barrancos, mesetas planas y cerros solitarios. Es por ello por lo que ha servido como fuente de inspiración a pintores y escritores, además de ser escenario de anuncios televisivos, videoclips musicales y películas. Las Bárdenas carecen de núcleos urbanos, su vegetación es muy escasa y las múltiples corrientes de agua que surcan el territorio tienen un caudal marcadamente irregular, permaneciendo secos la mayor parte del año. &#xD;&#xA;El paisaje está marcado por la erosión, la cual crea un paisaje que es uno de sus principales atractivos',
        'nvhien',
        'http://www.oruxmaps.com',
        'OruxMaps',
        parsedatetime('2017-10-22 09:41:33', 'yyyy-MM-dd HH:mm:ss')),
       ('Aeuja High Road',
        'Track for Aeuja High Road',
        'kclerey',
        'http://graphhopper.com',
        'GraphHopper GPX',
        parsedatetime('2020-06-18 15:15:45', 'yyyy-MM-dd HH:mm:ss'));

insert into track_point(track_id, latitude, longitude, elevation, time)
values (1,
        42.2208895,
        -1.4580696,
        315.86,
        parsedatetime('2017-10-22 09:41:38', 'yyyy-MM-dd HH:mm:ss')),
        (1,
        42.2208228,
        -1.458099,
        316.03888000000006,
        parsedatetime('2017-10-22 09:43:18', 'yyyy-MM-dd HH:mm:ss'));
