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
year		 |String|year of build|False|"2016"
minPrice	 |float |minimum price |False|10,000
maxPrice	 |float |maximum price|False|100,000


# Specials  

Field Name | Type | Description|Can be NULL| Example
-----------|------|------------|-----------|--------
specials|ArrayList<Special>|List of Specials|True
