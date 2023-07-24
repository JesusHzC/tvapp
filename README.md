
# TvApp

Aplicacion android con arquitectura MVVM y CleanArcquitecture para mostrar programas de television, con sus horarios y dias de transmision, ademas de su sinopsis y repectivo cast.


## Deployment and Project Information

```git
git clone https://github.com/JesusHzC/tvapp.git

Gradle info:
Min sdk: 27
Java Version: 17
Koltin version: 1.8.20
```


## API Reference

#### Get all shows by country and date

```http
  GET /schedule?country=US&{date}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `date`      | `string` | **Required**. Fecha actual |

#### Get show by query

```http
  GET /search/shows/{q}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `q`      | `string` | **Required**. Nombre del show a buscar |

#### Get show detail by id

```http
  GET /shows/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**. Id del show |

#### Get show cast by id

```http
  GET /shows/{id}/cast
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**. Id del show |






## Screenshots

#### Movil Portait
![App Screenshot](https://drive.google.com/uc?export=view&id=1P1SPTnIPfM2EB_nKMkD3K0odDIt0FfML)

![App Screenshot](https://drive.google.com/uc?export=view&id=1fRBgke429xfGCaaDOFu7peDsUrByX6sB)

![App Screenshot](https://drive.google.com/uc?export=view&id=1I4FeQT9DKgyGpyv9NOU4SQhlAmZwmD-S)

#### Tablet Landscape

![App Screenshot](https://drive.google.com/uc?export=view&id=19uyX70WsiBr6IlvbRrwcIttKFuyhg4mv)


