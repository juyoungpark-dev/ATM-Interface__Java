# Day2 of #100DaysOfCode
## Project: ATM Interface with Java
#### Goal: get familiar with object-oriented programming using Java and learn new things of Java
#### Date: 1/18/2021
#### Start Time: 9:15pm
#### End Time: 10:25pm
#### Hours: 1hour

## What I have learned today
* MD5 Hashing method in Java
> For the security purpose, we store hash instead of password itself.

Java uses **"MessageDigest"** class for the hashing functionalities.   
* import java.security.MessageDigest;
* MessageDigest md = MessageDigest.getInstance("MD5");  //instantiate the hashing algorithm
* byte[] hash = md.digest(password.getBytes());
> https://www.geeksforgeeks.org/md5-hash-in-java/


# Day3 of #100DaysOfCode
## Project: ATM Interface with Java
#### Goal: get familiar with object-oriented programming using Java and learn new things of Java
#### Date: 1/19/2021
#### Start Time: 8pm
#### End Time: 9pm
#### Hours: 1hour

## What I have learned today
* When calling the default constructor within another constructor of the same class, use **this(arg, arg, ...)**     
* String.compareTo() vs String.equals() : compareTo() returns integer, equals() returns boolean which is more intuitive.
* How to generate random UUID of which date type is String:          
  > within a for loop : uuid += ((Integer)random.nextInt(10)).toString();
* How to validate a given PIN(String) with a stored hash(byte):
  > MessageDigest md = MessageDigest.getInstance("MD5");                      
  > return MessageDigest.isEqual(md.digest(pin.getBytes()), this.pinHash)  //'this' -> User object
