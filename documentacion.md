# Cómo utiliza la API

## Endpoint `beers`
**Listar todas las cervezas** -> `GET https://localhost:8080/beers`

**Consultar los datos de una cerveza por el id** -> `GET https://localhost:8080/beers/{{id}}`
Ejemplo:
```
GET https://localhost:8080/beers/1
```

**Registrar una cerveza nueva** -> `POST https://localhost:8080/beers`
Ejemplo:
```
{
  "brewery": {
		"id": 812,
		"name": "Magic Hat",
		"address1": "5 Bartlett Bay Road",
		"address2": "",
		"city": "South Burlington",
		"state": "Vermont",
		"code": "5403",
		"country": "United States",
		"phone": "1-802-658-2739",
		"website": "http://www.magichat.net/",
		"filepath": "",
		"descript": "Burlington microbrewers of Humble Patience, Fat Angel, #9, Blind Faith IPA, and Heart of Darkness Oatmeal Stout.",
		"addUser": 0,
		"lastMod": "2010-07-22T20:00:20"
	},
  "name": "SpringBoot",
  "catId": 11,
  "styleId": 116,
  "abv": 4.5,
  "ibu": 0.0,
  "srm": 0.0,
  "upc": 0,
  "filepath": "",
  "descript": "La mejor cerveza del mundo mundial",
  "addUser": 0,
  "lastMod": "2010-07-22T20:00:20"
}
```

**Modificar los datos de una cerveza por id** -> `PUT https://localhost:8080/beers/{{id}}`
Ejemplo:
```
PUT http://localhost:8080/beers/5915
```

```
{
	"id": 5915,
	"brewery": {
		"id": 812,
		"name": "Magic Hat",
		"address1": "5 Bartlett Bay Road",
		"address2": "",
		"city": "South Burlington",
		"state": "Vermont",
		"code": "5403",
		"country": "United States",
		"phone": "1-802-658-2739",
		"website": "http://www.magichat.net/",
		"filepath": "",
		"descript": "Burlington microbrewers of Humble Patience, Fat Angel, #9, Blind Faith IPA, and Heart of Darkness Oatmeal Stout.",
		"addUser": 0,
		"lastMod": "2010-07-22T20:00:20"
	},
	"name": "SpringBoot by java",
	"catId": 11,
	"styleId": 116,
	"abv": 4.5,
	"ibu": 0.0,
	"srm": 0.0,
	"upc": 0,
	"filepath": "",
	"descript": "La mejor cerveza del mundo mundial",
	"addUser": 0,
	"lastMod": "2010-07-22T20:00:20"
}
```

**Eliminar una cerveza por id** -> `DELETE http://localhost:8080/beers/{{id}}`
Ejemplo:
```
DELETE http://localhost:8080/beers/5915
```

## Endpoint `breweries`

**Listar todas las cervecerías** -> `GET http://localhost:8080/breweries`

**Consultar los datos de una cervecería por id** -> `GET http://localhost:8080/breweries/{{id}}`
Ejemplo:
```
GET http://localhost:8080/breweries/1
```

## Endpoint `categories`

**Listar todas las categorias** -> `GET http://localhost:8080/categories`

**Consultar los datos de una categoria por el id** -> `GET http://localhost:8080/categories/{{id}}`
Ejemplo:
```
GET http://localhost:8080/categories/1
```

#3 Endpoint `styles`

**Listar todos los estilos** -> `GET http://localhost:8080/styles`

**Consultar los datos de un estilo por el id** -> `GET http://localhost:8080/styles/{{id}}`
Ejemplo:
```
GET http://localhost:8080/styles/1
```


