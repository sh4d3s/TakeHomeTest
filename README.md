## Technical Problem
We have some customer records in a text file (customers.txt) -- one customer per line, JSON
lines formatted. We want to invite any customer within 100km of our Dublin office for some food
and drinks on us. Write a program that will read the full list of customers and output the names
and user ids of matching customers (within 100km), sorted by User ID (ascending).

## Installation Steps
To compile and run the project follow these simple steps.

### Prerequisites

* Java 1.8+
* Maven 3.6.0+

### Installation
1. Clone the repository
   ```sh
   git clone https://github.com/sh4d3s/TakeHomeTest.git
   cd TakeHomeTest
   ```
2. Build the project using maven
   ```sh
   mvn clean install
   ```
3. Run the project
   ```sh
   java -jar target\TakeHomeTest-1.0-jar-with-dependencies.jar customers.txt
   ```
### Examples

By default, the application shortlists customers within 100KM.
```sh
java -jar target\TakeHomeTest-1.0-jar-with-dependencies.jar customers.txt
```
Output:
```
Name                   User ID
Ian Kehoe                    4
Nora Dempsey                 5
Theresa Enright              6
Eoin Ahearn                  8
Richard Finnegan            11
Christina McArdle           12
Olive Ahearn                13
Michael Ahearn              15
Patricia Cahill             17
Eoin Gallagher              23
Rose Enright                24
Stephen McArdle             26
Oliver Ahearn               29
Nick Enright                30
Alan Behan                  31
Lisa Ahearn                 39
```
It is also possible to change the range by specifying additional distance parameter
```sh
java -jar target\TakeHomeTest-1.0-jar-with-dependencies.jar customers.txt 50
```
Output:
```
Name                   User ID
Ian Kehoe                    4
Nora Dempsey                 5
Theresa Enright              6
Richard Finnegan            11
Christina McArdle           12
Michael Ahearn              15
Alan Behan                  31
Lisa Ahearn                 39
```
