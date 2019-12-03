package com.designpatterns.structural.facade.student;

import java.util.Collection;
import java.util.Iterator;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class FacadeClient {
	  public static void main( String[] args ) {
	    Facade facade = new Facade();

	    Facade.buildCampus();
	    Facade.buildTeam( "OS1000", 1000 );
	    Facade.buildTeam( "CJ2000", 2000 );
			
	    facade.enroll( 100, "OS1000" );
	    facade.enroll( 101, "CJ2000" );
	    facade.enroll( 102, "OS1000" );
			
	    Collection<String> c = facade.display( "OS1000" );
	    Iterator<String> iter = c.iterator();
	    System.out.println( "Team Name: "
	      + ( String )iter.next() );
	    System.out.println( "Course Name: "
	      + ( String )iter.next() );
	    System.out.println( "Students List: " );
	    while ( iter.hasNext() ) {
	      System.out.println( "  + "
	        + (  String )iter.next() );
	    }
	  }
	}