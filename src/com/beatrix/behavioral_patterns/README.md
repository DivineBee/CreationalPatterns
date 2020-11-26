# Behavioral Design Patterns LAB-3
> Here I used 2 design patterns - Command and Mediator.  
> Below is the explanation of how and why I used these patterns.

## Table of contents

* [Mediator](#mediator)
* [Command](#command)

## Mediator
The Mediator pattern suggests that you should cease all direct communication between the components  
which you want to make independent of each other. Instead, these components must collaborate indirectly,  
by calling a special mediator object that redirects the calls to appropriate components. As a result,  
the components depend only on a single mediator class instead of being coupled to dozens of their colleagues.  
In my realization the mediator has a role of checking the created PCs for their errors, using enums to  
denote the state of the PC: NOT_CHECKED, WORKING, MALFUNCTION, READY. And has two  
methods of checkParts() and repair().  
PC class stores a reference to the mediator object. The connection is established in the  
constructor, where a mediator object is passed as an argument.  
It's scope in my project is the control of which PCs are ready to be passed to the clients for purchase.  
The masters who made the PCs send them to testers for checking for errors rather than communicate with  
the store. The constraints on which can be sold or repaired are enforced by the tester. It is important  
to note that the store does not control the pc checking. It exists only to enforce constraints in the  
sold products.  
Output:  
![Alt text](https://raw.githubusercontent.com/DivineBee/Design-Patterns/master/resources/mediator.JPG "Mediator")
  
## Command
Next used design is Command, I used it to encapsulate a request as an object, thereby letting parametrize  
keys with different requests(macro keys or special keys on keyboard). Promote "invocation of a method on  
an object" to full object status with an object-oriented callback. Command decouples the object that invokes  
the operation from the one that knows how to perform it. To achieve this separation, I created an abstract  
base class(Command) that maps a key (an object) with an action upon it (a pointer to a member function).  
The base class(Keyboard) contains an execute() method that simply calls the action on the receiver in my  
project. All clients of Command objects treat each object as a "black box" by simply invoking the object's  
virtual execute() method whenever the client requires the object's "service"(execution of the action binded  
to the key). A Command class holds some subset of the following: objects, methods to be applied to the object,  
and the arguments to be passed when the method is applied. The Command's "execute" method then causes the  
pieces to come together. Sequences of Command objects are assembled into composite (or macro) commands.  
Example from code:  
```java
public class KeyboardLoader {
    Keyboard Keyboard;

    public KeyboardLoader(Keyboard Keyboard) {
        this.Keyboard = Keyboard;
    }

    public void load() {
        Light light = new Light();
        ...
        Keyboard.setCommandOnSpecialKey(0,new UndoCommand(Keyboard));
        Keyboard.setCommandOnSpecialKey(1,new LightON(light));
        LightOFF lightOff = new LightOFF(light);
        Keyboard.setCommandOnSpecialKey(2,lightOff);
        FanOFF fanOff = new FanOFF(fan);
        Keyboard.setCommandOnSpecialKey(3,fanOff);
        ...
    }
}
class BoostMode {
    void turnON() {
        System.out.println("Turn ON Boost");
    }

    void turnOFF() {
        System.out.println("Turn OFF Boost");
    }
}

public interface Command {
    public void execute();
    public void undo();
}

class MasterOffcommand implements Command{
    List<Command> commandMacro;
    public MasterOffcommand(Command... commands){
        commandMacro = Arrays.asList(commands);
    }

    @Override
    public void execute() {
        for(Command cmd:   commandMacro ){
            System.out.println("putting off  "+ cmd.getClass().getSimpleName() );
            cmd.execute();
        }
    }

    @Override
    public void undo() {
    }
}
```
Output  
![Alt text](https://raw.githubusercontent.com/DivineBee/Design-Patterns/master/resources/command.JPG "Command")   
