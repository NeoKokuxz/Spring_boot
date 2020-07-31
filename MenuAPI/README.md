# MENU API Documentation

## Detail
API | Description | Auth | HTTPS |
|---|---|---|---|
| [MenuAPI](https://github.com/NeoKokuxz/Spring_boot/tree/master/MenuAPI) | Menu API | BasicAuth | Yes |

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
http://localhost:8080/names
http://localhost:8080/names/{name}

## **GET** /item/types
*list of all unique item type currently cataloged in the project*

### Parameters
Parameter | Type | Data Type | Description | Required
| --- | --- | --- | --- | --- |
| 

#### Example request
