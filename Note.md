# ATM Interface with Java

## New things I learned
* MD5 Hashing method in Java
	- For the security purpose, we store hash instead of password itself.
	> Java uses **"MessageDigest"** class for the hashing functionalities.   
	> * import java.security.MessageDigest;
	> * MessageDigest md = MessageDigest.getInstance("MD5");  //instantiate the hashing algorithm
	> * byte[] hash = md.digest(password.getBytes());
	> * https://www.geeksforgeeks.org/md5-hash-in-java/
* When calling a default constructor within another constructor of the same class, use **this(arg, arg, ...)**     
* String.compareTo() vs String.equals() : compareTo() returns integer, equals() returns boolean which is more intuitive.
* How to generate random UUID of which date type is String:          
  > within a for loop : uuid += ((Integer)random.nextInt(10)).toString();
* How to validate a given PIN(String) with a stored hash(byte):
  > MessageDigest md = MessageDigest.getInstance("MD5");                      
  > return MessageDigest.isEqual(md.digest(pin.getBytes()), this.pinHash)  //'this' -> User object
* String.format("%s : $%.02f : %s", accountID, balance, memo);
	> this is just like "printf" that is used for formatting.           
	> "%.02f" : (reminding) floating point number that has 2 digits of precision after the decimal point.          
* java.util.Date.toString() : when you print out Date type value as a String.    
* Reminded and applied software development processes while recoding the ATM interface app.
	> imagining how completed application will look like              
	> gathering requirements                         
	> designing                       
	> breaking into small chunks                        
	> immplementing!        

## What I need to improve
* spend more time to plan
