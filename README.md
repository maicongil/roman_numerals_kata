# Roman Numerals Kata

## About this project

This project is a Java solution for the [Roman Numerals Kata](http://codingdojo.org/kata/RomanNumerals/).
This Kata contains two main goals:
* Convert a number to a Roman numeral
* Convert a Roman number to a number

## Solution
### Converting an Arabic number to a Roman numeral
Thinking about the problem, three big questions popped into my mind?
1. How to convert to simple numerals(I,V,X,L,C,D,M)?
2. How to convert to compound numerals that are built by addition logic(II,III,VII,XVI...)?
3. How to convert to compound numerals that are built by subtraction logic(IV,IX,XL,XC,CD,CM)?

The answer to the first question is pretty straightforward, create a map containing all the simple
Roman numerals(I,V,X,L,C,D,M) and their respective Arabic numbers(1,5,10,50,100,500,1000) and problem solved :)

The second question is a lot harder than the first one. A simple mapping doesn't help here because we would end up with 3999 
entries in our map. We have to find a way to build the numeral symbol by symbol and for this we have to know when we have to append
a symbol and what symbol. After some TDD cycles, I ended up with this solution:
```
FOR each romanNumeral in romanArabicMap
   WHILE number >= romanNumeral.arabicNumber
      append the romanNumeral to result
      decrements the number with the romanNumeral.arabicNumber
   END WHILE
END FOR
```
For this logic to work, the map entries must be in descending order because we have to start
with the biggest numeral.

The final question can make you think a lot because these numerals have a different logic 
but in fact the solution is pretty simple, add more six entries(IV,IX,XL,XC,CD,CM) into map.

### Converting a Roman numeral to an Arabic number
With all the knowledge acquired from the Arabic to Roman solution, the solution here is 
basically the same. The main difference is that instead of append symbols to a string and 
decrease a number, we have to increase a number(result) while we remove all the symbols from
the given Roman numeral.

## Other considerations regarding the solution

### Validations
I add some basic input validations just to avoid unexpected behaviors.
* Validate the input number range in Arabic to Roman conversion
* Validate if the input Roman numeral is valid in Roman to Arabic validation

### Interface
Since a GUI was not required for this challenge, I created a simple CLI with the help of [Picocli](https://picocli.info/),
a tiny library to build a CLI for Java applications. I decided to not create unit tests for the 
CLI classes.

## How to run the program
### Requirements
* Java 11+
### Running the packaged program
1. Download and unzip the file 'app.zip' located in the root folder of this project
2. Run the script 'convert' located in /appassembler/bin
    * To convert a number to a Roman numeral:
      ```shell
       $ ./convert toRoman 2021
      ```
    * To convert a Roman numeral to a number:
      ```shell
       $ ./convert toArabic MMXXI
      ```
    * To display help about a command:
      ```shell
       $ ./convert help toArabic
   
       $ ./convert help toRoman
      ```
### Running from your IDE
1. Clone or download this repo
2. Import the Maven project using your favorite IDE
3. Run the "Application.main" method providing the program args for the desired operation:
   * toRoman 2021
   * toArabic MMXXI
   
## Other useful tasks
This project contains a Maven wrapper to make easier to run common tasks
without the need of installing a local Maven or importing the project to an IDE.
### Run tests
In the root folder of this project run the following command:
```shell
$ ./mvnw test
```
### Create package
In the root folder of this project run the following command:
```shell
$ ./mvnw package appassembler:assemble
```
The new package will be created in 'target/appassembler' folder.
This folder contains two folders:
   * bin: Contains the scripts(shell and bat) to run the program.
   * repo: Contains the application jar and also all dependencies jars. 
