package com.javadude.articles.vaddmvc1;

/**
 * This sample code is provided "as is" and is
 * intended for demonstration purposes only.
 * 
 * Neither Scott Stanchfield nor IBM shall be
 * held liable for any damages resulting from your
 * use of this code.
 * 
 * Creation date: (1/15/00 8:12:05 PM)
 * @author: Scott Stanchfield
 */
import java.io.*;

public interface AddressBookModel extends Serializable{

	public void add(AddressDataModel address) ;

	public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) ;

	public AddressDataModel find(java.lang.String name) ;

	public com.javadude.articles.vaddmvc1.AddressDataModel[] getAddresses() ;

	public AddressDataModel getAddresses(int index) ;

	public void removePropertyChangeListener(java.beans.PropertyChangeListener listener) ;
}
