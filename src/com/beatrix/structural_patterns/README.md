# Structural Design Patterns LAB-2
> Here I used 3 design patterns - Adapter, Bridge and Proxy.  
> Below is the explanation of how and why I used these patterns.

## Table of contents

* [Explanation](#explanation)

## Explanation
This time for explanation of the lab I got graphical, I made diagrams of how  
the patterns work inside my code and how classes communicate and are bind  
to each other. First the Adapter Pattern:  
![Alt text](https://raw.githubusercontent.com/DivineBee/Design-Patterns/master/resources/adapter.jpg "Adapter")  
Here _VgaAdapter_ works as an Adapter for connecting an existing _VgaCable_ to  
the Monitor which has only Hdmi port.  
Next is the Bridge Pattern:  
![Alt text](https://raw.githubusercontent.com/DivineBee/Design-Patterns/master/resources/bridge.jpg "Bridge")   
I decided to use this pattern for variations of PC peripherals, for example I  
have a keyboard and a mouse and I want either classical one without lightning  
or one with RGB lights to be more comfortable in the dark. Bridge pattern comes  
in handy because instead of instantiating multiple classes with variations(which  
can grow exponentially for every combination). I made a "bridge" which connects  
the peripherals and their types. If the number of peripherals will grow it  
will not be a problem of productivity and resources anymore. Because with time  
more peripherals might be added - for example not only keyboard and mouse, but  
also headphones, webcam and so on. This is also acceptable for their type, for  
example the possibility to add to the peripheral some padding or customization  
like colors and stickers.  
Last of them is the Proxy pattern:  
![Alt text](https://raw.githubusercontent.com/DivineBee/Design-Patterns/master/resources/proxy.jpg "Proxy")   
Proxy controls access to the original object, this way allowing us to perform  
something either before or after the request gets through to the original object.  
The Gpu renders the same opened image every time. However, it’s very inefficient.  
to render again and again the same image on screen multiple times, the gpu  
just uses extra resources over and over, instead of caching and reusing in memory.  
The proxy class implements the same interface as the original class and delegates  
it all the work. However, it keeps track of the updated data and returns the cached  
result when the client opens the same video or image multiple times.  

### Output of the programm:
![Alt text](https://raw.githubusercontent.com/DivineBee/Design-Patterns/master/resources/output.JPG "Output")   
From the line where is written: "Your mouse is connected" the output of the  
lab 2 begins. Everything described above is in this output. Also I added a class  
responsible for colors in the output in order to be more fun and more readable :)  
