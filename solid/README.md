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