# Template Method in Java
>Template Method is a behavioral design pattern that allows you to defines a skeleton of an algorithm in a base class and let subclasses override the steps without changing the overall algorithm’s structure.

## Usage of the pattern in Java
Usage examples: The Template Method pattern is quite common in Java frameworks. Developers often use it to provide framework users with a simple means of extending standard functionality using inheritance.

Here are some examples of Template Methods in core Java libraries:

* All non-abstract methods of java.io.InputStream, java.io.OutputStream, java.io.Reader and java.io.Writer.

* All non-abstract methods of java.util.AbstractList, java.util.AbstractSet and java.util.AbstractMap.

* javax.servlet.http.HttpServlet, all the doXXX() methods by default send a HTTP 405 “Method Not Allowed” error as a response. You’re free to override any of them.

Identification: Template Method can be recognized by behavioral methods that already have a “default” behavior defined by the base class.

## Overriding standard steps of an algorithm

In this example, the Template Method pattern defines an algorithm of working with a social network. Subclasses that match a particular social network, implement these steps according to the API provided by the social network.