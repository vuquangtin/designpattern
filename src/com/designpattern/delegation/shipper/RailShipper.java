package com.designpattern.delegation.shipper;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class RailShipper implements Shipper
{
	public void deliver( PackageInfor item )
	{
		System.out.println("<p>Package ("+item.getCode()+") deliver by rail.</p>");
	}	
}