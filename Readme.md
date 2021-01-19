# Day2 of #100DaysOfCode

## Project: ATM Interface with Java
#### Goal: get familiar with object-oriented programming using Java and learn new things of Java
#### Date: 1/18/2021
#### Start Time: 9:15pm
#### End Time: 10:25pm

## What I have learned today
* MD5 Hashing method in Java
> For the security purpose, we store hash instead of password itself.

Java uses **"MessageDigest"** class for the hashing functionalities.   
* import java.security.MessageDigest;
* MessageDigest md = MessageDigest.getInstance("MD5");  //instantiate the hashing algorithm
* byte[] hash = md.digest(password.getBytes());

> https://www.geeksforgeeks.org/md5-hash-in-java/
