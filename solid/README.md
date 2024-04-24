# SOLID Principles of OOPs
- S: Single Responsibility Principle
- O: Open / Closed Principle
- L: Liskov Substitution Principle
- I: Interface Segmented Principle
- D: Dependency Inversion Principle

### Advantages
Helps us to write better code:
- Avoid duplicate code
- Easy to maintain
- Easy to understand
- Flexible Software
- Reduce Complexity

## Single Responsibility Principle
A class should have only 1 reason to change

Refer to: <a href="SingleResponsibility.java">SingleResponsibility.java</a>
- In the Invoice class I have three methods:
    - calculateTotal()
    - printInvoice()
    - saveToDB()

Is it following Single Responsibility Principle?
- now lets say, I want to add gst and discount, the calculation will be changed

what ways, can my class get changed then?
- if I change the calculation, calculateTotal() method will get changed
- printInvoice() can get changed if I change the printing logic
- saveToDB() might get changed if I want to save to file
- so there are three reasons so it doesn't follow single responsibility principle as a class should one one reason to change and single responsibility
 
How to correct it?
- Give only one responsibility to every class

Refer to <a href="SingleResponsibilityCorrection.java">SingleResponsibilityCorrection.java</a>

## Open / Closed Principle
Open for extension but closed for modification

Let's we just don't want to save to db but also save to file.

Now, InvoiceDao class which has the saveToDB method is live and tested. Now we can, add a new method saveToFile(), but is this following open / close principle? <br>
=> No, you can extend the class which is live but you shouldn't modify it.

So we create an interface which is extended by the classes DatabaseInvoiceDao and FileInvoiceDao and add their implementation on it. This way, the existing code won't be harmed.

<a href="OpenCloseCorrection.java">OpenCloseCorrection.java</a>

## Liskov Substitution Principle
If class B is a subtype of class A then we should be able to replace the object of A with B without breaking the behavior of the program

Subclass should extend the capability of parent class not narrow it down

Refer to <a href="LiskovSubstitutionPrinciple.java">LiskovSubstitutionPrinciple.java</a>

Here Motorcycle class implements Bike and extends its capability so it follows Liskov Substitution Principle where as Cycle implements Bike but limits its capability for turnOnEngine and hence it doesn't follow the liskov solid principle

## Interface Segmented Principle
Interfaces should such that client shouldn't implement unnecessary functions that they do not need.

Refer to <a href="InterfaceSegmentedPrinciple.java">InterfaceSegmentedPrinciple.java</a>

Here, since Waiter class is implementing RestaurantEmployee interface so it has to override methods that are of no use so it is not following Interface Segmented Principle


<a href="InterfaceSegmentedPrincipleCorrection.java">InterfaceSegmentedPrincipleCorrection.java</a>

here we define each interface such that all the implements should be of use whoever implements it.

## Dependency Inversion Principle
class should depend on interfaces rather than concrete classes


Refer to <a href="DependencyInversionPrinciple.java">DependencyInversionPrinciple.java</a>
- <<keyboard>>
    - WiredKeyboard
    - BluetoothKeyboard
- <<Mouse>>
    - WiredMouse
    - BluetoothMouse

Now we have a class Mac which extends the concrete class WiredKeyboard and WiredMouse, the problem is that if you want to enhance this in the future then you wouldn't be able to. So it is not following the Dependency Inversion Principle.

Correct it using the type as of interface and assign using constructor injection.

Refer to: <a href="DependencyInversionPrincipleCorrection.java">DependencyInversionPrincipleCorrection.java</a>