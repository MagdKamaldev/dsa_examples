# OOP

## 1) A class: is a group of properties and functions, which is a blueprint for objects. 
![Example](../../assets/class.png)

## 2) Object is an intance (physical represntstion) of a class 

## 3) . operator: is the way to access instance variable of the object.
#### example:
```java
System.out.println(porche.price);
//                     25k
```
```java
class Car{
    int price;
    int seats;
    Engine engine;
}

Car bugatti;
```
#### here bugatti doesn't refer to an actual object, it's just in the stack memory pointing to null.
![Example](../../assets/stack_memory.png)

#### to have it point to an object we initialize it this way:
```java 
    bugatti      =    new Car();
//compile time          runtime
//new keyword: dynamically allocates memory and returns a reference to it
```
![Example](../../assets/heap_memory.png)

## 4) A constructor: defines what happens when the object is created, it's a special function that runs when you create an object and it allocates variables.
```java
Car bugatti = new Car(mid,30k,5);
```
#### here the constructor binds these arguments with the object.

## 5) this keyword: gets replaced with the object when the constructor gets called.
#### it might also be used for calling a constructot from another one.

## 6)final keyword: guarantees immutability for the value on:
### A) primitive data types:
```java
final int increase = 2;
increase = 3; // compile time error
```
### B) objects:
```java
final Car bugatti = new Car();
bugatti.price = 40k; // no error
bugatti = otherObject; //compile time error
```
### Note: when a non primitive is final you cannot re-assign it

## 7) packages: containers for classes (folders)
### eg: com.magd -> only magd folder exists in com folder(append to name), if com had more files none of them will append to name:
#### 📁 com
#### - 📁 magd
#### - 📁 kamal 
### what if i want to create two classes with the same name in the same (package) folder ?
### I'll have to create a package for every one, so here in a class in magd folder we find:
```java
package com.magd;
```

## 8) import statement; used to access public methods and properties outside the package, if any statement inside the package import is not needed.

## 9)static: used to make a variable or method the same for all instances and not dependent on object
```java
class Human{
    int age;
    String name;
    static long population; // Here population will be the same value for all instances
    public Human(int, age,String name){
        this.age = age;
        this.name = name;
        Human.population+=1;
    }
}

Human magd = new Human(23,"Magd");
Human kamal = new Human(59,"Kamal");
System.out.println(magd.population); // 2
System.out.println(tasbeeh.population); // 2 
// if it was not static it would print 1 both times for it's not dependent on instance, so the convetion is to make it this way:
System.out.println(Human.population); // for it's the same for all instances and you can use it even without creating an object
```
### static methods cannot call not-static ones for not-static ones belong to an instance
```java
 static void fun(){
  greeting(); // Error
 }
 void greeting(){}
 // to make it work give it an object:
static void fun(){
Main obj = new Main();
obj.greeting();// No Error
}
```
### you cannot use this keyword in a static method for it refers to the object

## 10)Static Bloc: used to initialize static variables and gets executed once when the class is first loaded
```java
class StaticBlock{
    static int a =4;
    static int b;

    static{
        // this will only run once when the first object is created only , so when you create new objects it will not run again
      System.out.println("I'm in a static block");
      b = a * 5;
    }
}
```

## 11) Inner classes: classes inside other classes and dependent on them.
### inner classes only can be static outer cannot
### an object of non-static class cannot be created in a static method, for the the inner class depends on the main one.

## 12) Singleton class: a class that you can only create one object of it.
### it's constructor is private, and has one instance variable inside it, and a get instance metohd that creates the instance using the constructor only if instance variable is null, and it's returning the same instance variable every time.
