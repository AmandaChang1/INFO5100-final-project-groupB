# Dealer 

| Field Name | Type   | Description        | Example              |
| ---------- | ------ | ------------------ | -------------------- |
| name       | String | name of dealer     | "gmps-brown-wood"    |
| url        | String | web link of dealer | "www.brown-wood.net" |
| location   | String | address            | "en_US"              |



# Vehicle

| Field Name | Type   | Description                      | Example                       |
| ---------- | ------ | -------------------------------- | ----------------------------- |
| id         | String | unique id,auto generated         | "2345367743"                  |
| specialId  | String | the associated specialId         | "11"                          |
| dealerId   | String | the name of the vehicle's dealer | "gmps-brown-wood"             |
| category   | String | new or used                      | "new","used"                  |
| year       | String |                                  | "2007"                        |
| make       | String |                                  | "Chevrolet","Hyundai","Buick" |
| trim       |        |                                  |                               |













# Special  

Field Name | Type | Description|Can be NULL| Example
-----------|------|------------|-----------|-------
id         |String|unique id,auto generated|False|1, 2
dealerId|  String|got from logIn class|False|"1", "2"
startDate| String|cannot be earlier than current date|False|"20180505"|
endDate| 	 String|cannot be earlier than current date|False|"20181126"
title|		 String| Unique title for special|False|"Christmas Discount"
description|String|Description for special|True|"Discount because dealer is happy"
desclaimer|String|Desclaimer for special|True|"Under WA Law, blablabla..."
value|		 float|Discount of the special, In database, it is saved as VARCHAR|False|"0.8"
criterion|VeicleCriterion|A defined class for criterion|False


## VeicleCriterion  

Field Name | Type | Description|Can be NULL| Example
-----------|------|------------|-----------|--------
maker      |String|Name of Maker of cars|False|"Porsche"
model		 |String|Car Model	|False|"911", "Cayman"
startyear		 |String|start year of build|False|"2016"
minPrice	 |float |minimum price |False|10,000
maxPrice	 |float |maximum price|False|100,000
endyear	|String |end year of build|False|"2016"


# Specials  

Field Name | Type | Description|Can be NULL| Example
-----------|------|------------|-----------|--------
specials|ArrayList<Special>|List of Specials|True
  
  

# FilterContentModel

Field Name | Type | Description | Example
-----------|------|-------------|--------
vehicleID|ArrayList<String>|Id of the car|2844479993
brand|ArrayList<String>|brands of the car|Honda
model|ArrayList<String>|models of the car|envision
trim|ArrayList<String>|trims of the car|AWD 4dr
maxprice|double|maxprice of cars in the inventory|N/A
minprice|double|minprice of cars in the inventory|N/A
maxyear|int|maxyear of cars in the inventory|N/A
minyear|int|minyear of cars in the inventory|N/A


# FilterContent

Field Name | Type | Description | Example | DefaultValue
-----------|------|-------------|--------|---------------
dealerName|String|Name of the dealer|gmps-blue-ribbon|"dealername"
vehicleID|String|Id of the car|2844479993|"vehicleid"
condition|ArrayList<String>|conditions of the car|used or new|"condition"
brand|ArrayList<String>|brands of the car|Honda|"brand"
model|ArrayList<String>|models of the car|envision|"model"
bodyType|ArrayList<String>|types of the car|suv|"bodytype"
highPrice|double|highprice of customer's input|N/A |maxprice
lowPrice|double|lowprice of customer's input|N/A |minprice
highYear|int|highyear of customer's input|N/A|maxyear
lowYear|int|lowyear of customer's input|N/A|minyear
