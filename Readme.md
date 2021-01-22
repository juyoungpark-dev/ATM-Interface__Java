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


# Day4 of #100DaysOfCode
## Project: ATM Interface with Java
#### Goal: to get familiar with object-oriented programming using Java and learn new things of Java
#### Date: 1/20/2021
#### Start Time: 5pm
#### End Time: 7:30pm
#### Hours: 2.5hr

## What I have learened today
* String.format("%s : $%.02f : %s", accountID, balance, memo);
	> this is just like "printf" that is used for formatting.           
	> "%.02f" : (reminding) floating point number that has 2 digits of precision after the decimal point.          
* java.util.Date.toString() : when you print out Date type value as a String.
* Single entry & exit point rule : 
	> This is something I've been emphasized from my first C professor.          
	> I even had to resubmit an assignment because of this.   
	>                    	                
	> But, ever since completing the first semester, I have seen many people ignore this srule, and I couldn't understand why on earth I should keep this rule.          
	> So, I emailed my first professor to ask about this.    
	>                    
	> He said, this is very "touchy" subject and there are arguments for both viewpoints.            
	> The main thing is that you evaluate it every time you want to violate the principle and figure if it will present spaghetti code over the long term. If the function is very short and will never have to do anything super complicated, it might be better to violate the principle and exit early.      
	>                    
	> In my conclusion, it's always case-by-case.             
	> Also, it was a good idea to talk to my favorite old professor! :D            


# Day5 of #100DaysOFCode
## Project: ATM Interface in Java (Re-code)
#### Goal: improve skills of planning, designing, implementing..
#### Date: 1/21/2021
#### Start Time: 4:30
#### End Time: 8:30
#### Hours: 3hr

## What I have learned today
* reminded and applied software development processes while recoding the ATM interface app.
	> imagining how completed application will look like              
	> gathering requirements                         
	> designing                       
	> breaking into small chunks                        
	> immplementing!        

## What I need to improve
* spend more time to plan
