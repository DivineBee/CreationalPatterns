# Creational Design Patterns LAB-1
> Here I used 3 design patterns - Factory Method, Abstract Factory and Prototype.  
> Below is the explanation of how and why I used these patterns.

## Table of contents

* [Explanation](#explanation)
* [Code Examples](#code-examples)
* [Output Examples](#output-examples)

## Explanation
For this lab I used the PC building domain area.  
Where will be a factory named PCFactory which will be build from    
different hardware components: cpu, gpu, ram, motherboard.  

For this lab I mapped out different pc components and their variants,  
like motherboards which can be either for intel or amd cpu, depending on  
the socket, gpus can be from different manufacturer, cpus and rams.  

For the abstract factory I used - motherboards, cpu and gpu. They all have  
an interface for their specific component, then I created concrete product classes  
which differ and implement same methods as the interface(here it comes the factory method)  
Then I declared the abstract factory interface called PCFactory with a set of creation  
methods for all abstract products. Then implemented a set of concrete factory clases, one  
for each product variant - PCGamingFactory and PCOfficeFactory. Then in the PC class I coded  
the factory initialization which instantiates one of the concrete factory classes, also  
I have a Client class which is the main one where the "client" is requesting a specific pc  
based on user input (office or gaming) the corresponding pc is build using the factory classes  
and needed components. It is scanning through the code and find all the direct calls to product  
constructors and is replacing them with calls to the appropriate creation method on the factory  
objects.

For the 3rd pattern I chose Prototype, I created an abstract class for the Ram component  
with the clone() method which will be implemented by child classes. This prototype class defines  
an alternative constructor that accepts an object of the class as an argument. The clone() method  
consist only of the "new" line which uses its own class name. I applied this design pattern to  
the rams because it can be more than one ram in a pc, and in the main class a client is being asked    
if he wants one more ram. If yes he can add one more(in the background the clonning of the initial  
ram is happening) why cloning here? Because if adding another ram from different manufacturer or type  
they can happen to be incompatible that's why we need exactly the same ram as our initial one.

You can run it from the Client class, you will be asked to input the desired pc and then if you want one  
more ram(yes/no) and then the output of working pc processes you got from this build.   

## Code Examples
Prototype in action(the abstract class):
```java
public abstract class RamComponent {
    public int capacity;
    public String name;
    public int frequency;

    public RamComponent() { }

    public RamComponent(RamComponent component) {
        if (component != null) {
            this.capacity = component.capacity;
            this.name = component.name;
            this.frequency = component.frequency;
        }
    }

    public abstract RamComponent clone();
    ...
```
Lines from child class RamDDR3 with it's overriden clone() :

```java
public class RamDDR3 extends RamComponent {
    public String cellType;

    public RamDDR3() {
    }

    public RamDDR3(RamDDR3 target) {
        super(target);
        if (target != null) {
            this.cellType = target.cellType;
        }
    }

    @Override
    public RamComponent clone() {
        return new RamDDR3(this);
    }
    ...
```
## Output Examples
```
Enter PC type:
> gaming
Do you want another ram? yes/no
> yes
Added second identical ram for compatibility
Ram1 - RamDDR4 cellType='ddr4', capacity=16, name='Kingston', frequency=3100
Ram2 - RamDDR4 cellType='ddr4', capacity=16, name='Kingston', frequency=3100
Motherboard is working.
AMD AM4 socket.
Rendering from dedicated graphic card.
AMD cpu is up and running.
```