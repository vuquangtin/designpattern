# Problem:

Assume we are writing a print library. We want the client code of our library to be able to do something like this:
```java
class Client {


	/** Prints all figures on each of the printers. */
	void printAllEverywhere( Figure[] figures, Printer[] printers ) {
	for ( int i = 0; i < figures.length; i++ ) {
	Figure figure = figures[ i ];
	for ( int j = 0; j < printers.length; j++ ) {
	 Printer printer = printers[ j ];


	 figure.printOn( printer ); 
	 // must work for any printer or figure !
	}
	}
	}
 }
```

Of course, when we add new printers or figures to our library, we want client code such as the above to immediately work with these new printers and figures, without a change in their code or even a recompile. How can we implement our library to allow this?

Another way to state this is that we need a CartesianProduct of drivers or methods of printer kinds and shape kinds. 

# Solution:

First, we define two interfaces for our figures and printers:

```java
 interface Figure {
	void printOn( Printer printer );
 }
 interface Printer {
	void printCircle( Circle circle );
	void printRectangle( Rectangle rectangle );
 }

Next, we write our two printers:

 class InkjetPrinter implements Printer {
	public void printCircle( Circle circle ) {
	// ... rasterizing logic for inkjet printing of circles here ...
	System.out.println( "Inkjet printer prints a cirlce." );
	}
	public void printRectangle( Rectangle rectangle ) {
	// ... rasterizing logic for inkjet printing of rectangles here ...
	System.out.println( "Inkjet printer prints a rectangle." );
	}
 }
 class PostscriptPrinter implements Printer {
	public void printCircle( Circle circle ) {
	// ... postscript preprocessing logic for circles here ...
	System.out.println( "PostScript printer prints a cirlce." );
	}
	public void printRectangle( Rectangle rectangle ) {
	// ... postscript preprocessing logic for rectangles here ...
	System.out.println( "PostScript printer prints a rectangle." );
	}
 }

```
Now, all we have to make sure is that calling the figure.printOn( printer ) method results in the correct printXyz implementation being executed, such as postscriptPrinter.printRectangle( rectangle ).

This can be achieved through a simple indirection in the implementation of printOn in the individual figure classes: 

```java
class Circle implements Figure {
	public void printOn( Printer printer ) {
	printer.printCircle( this ); // <-- the "trick" !
	}
 }
 class Rectangle implements Figure {
	public void printOn( Printer printer ) {
	printer.printRectangle( this );
	}
 }
```

That's it!

To test the above code, just add the following class: 

```java
public class Main {
	public static void main( String[] args ) {
	Figure [] figures = new Figure [] { 
	new Circle(), new Rectangle() };
	Printer [] printers = new Printer [] { 
	new PostscriptPrinter(), new InkjetPrinter() };


	new Client().printAllEverywhere( figures, printers );
	}
 }
```

## Explanation:

>What happens when figure.printOn( printer ) is called at runtime? This depends on the types of the objects referenced by the figure and printer variables at that time. Let's assume that at the moment, figure points to an instance of class Circle, and printer to an InkjetPrinter. So, the implementation of printOn( printer ) being called will be that of the circle instance, defined in the Circle class (first dispatch). This method just contains one line: printer.printCircle( this ), which delegates the work to the printer object. As this object is of the class InkjetPrinter, the printCircle( circle ) method of the InkjetPrinter class will be executed (second dispatch), which is just what we wanted. 