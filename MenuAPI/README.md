# MENU API Documentation

## Detail
API | Description | Auth | HTTPS |
|---|---|---|---|
| [MenuAPI](https://github.com/NeoKokuxz/Spring_boot/tree/master/MenuAPI) | Menu API | BasicAuth | Yes |

## Auth
User: admin
Password: password

## Github Project
https://github.com/NeoKokuxz/Spring_boot/tree/master/MenuAPI

## Base URL:
http://localhost:8080

## Index
* [Usage](#Usage)

# Services

## **GET** /items
*List all items currently cataloged in the project*

### Parameters

Parameter | Type | Data Type | Description | Required
| --- | --- | --- | --- | --- |
| items | query | string | list of item| YES |
| names | query | string | name of item | No |
| types | query | string | type of item | No |
| id | query | long | id of item | No |

#### Example request
http://localhost:8080/items

## **GET** /items/names
*list of all item names currently cataloged in the project*

### Parameters
Parameter | Type | Data Type | Description | Required
| --- | --- | --- | --- | --- |
| string | query | string | string of item name | NO |
| {name} | query | string | input name to match item in order to get item detail | NO |

#### Example request
http://localhost:8080/names <br>
http://localhost:8080/names/{StringName}/

## **GET** /item/types
*list of all unique item type currently cataloged in the project*

### Parameters
Parameter | Type | Data Type | Description | Required
| --- | --- | --- | --- | --- |
| list | query | string | list of all unique item types | YES |
| {type} | query | string | input name of the item type in order to get item detail under same type | YES |

#### Example request
http://localhost:8080/types/list <br>
http://localhost:8080/types/list/{typeName}/


## **GET** /items/id
*Search item by id that currently cataloged in the project*

### Parameters
Parameter | Type | Data Type | Description | Required
| --- | --- | --- | --- | --- |
| id | query | string | id of item | YES |
| {id} | query | string | input id to search item | YES |

#### Example request
http://localhost:8080/id/{1}/
