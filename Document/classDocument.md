

# Dealers

| Member Name | Type   |
| ----------- | ------ |
| name        | String |
| url         | String |
| location    | String |



# Vehicle

| Member Name   | Type   |
| ------------- | ------ |
| id            | String |
| dealerId      | String |
| category      | String |
| year          | String |
| make          | String |
| model         | String |
| trim          | String |
| type          | String |
| price         | String |
| images        | String |
| specialId     | String |
| discountPrice | String |



# Special

| Member Name | Type             |
| ----------- | ---------------- |
| id          | String           |
| dealerId    | String           |
| startDate   | String           |
| endDate     | String           |
| title       | String           |
| description | String           |
| disclaimer  | String           |
| value       | float            |
| criterion   | VehicleCriterion |

## VehicleCriterion

Inner class of Special

| Member Name | Type   |
| ----------- | ------ |
| maker       | String |
| model       | String |
| year        | String |
| minPrice    | float  |
| maxPrice    | float  |



# Inventory

| Member Name | Type               |
| ----------- | ------------------ |
| vehicles    | ArrayList<Vehicle> |



# Specials

| Member Name | Type               |
| ----------- | ------------------ |
| specials    | ArrayList<Special> |

