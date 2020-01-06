package com.javadude.articles.vaddmvc1;

/*
 * This sample code is provided "as is" and is
 * intended for demonstration purposes only.
 * 
 * Neither Scott Stanchfield nor IBM shall be
 * held liable for any damages resulting from your
 * use of this code.
 * 
 * The bean information class for com.javadude.articles.vaddmvc1.AddressDataEntryFormUI.
 * Creation date: (1/19/00 12:47:03 AM)
 * @author: Scott Stanchfield
 */
public class AddressDataEntryFormUIBeanInfo extends java.beans.SimpleBeanInfo {

	/**
	 * Find the method by comparing (name & parameter size) against the methods in the class.
	 * @return java.lang.reflect.Method
	 * @param aClass java.lang.Class
	 * @param methodName java.lang.String
	 * @param parameterCount int
	 */
	public static java.lang.reflect.Method findMethod(java.lang.Class aClass, java.lang.String methodName, int parameterCount) {
		try {
			/* Since this method attempts to find a method by getting all methods from the class,
		this method should only be called if getMethod cannot find the method. */
			java.lang.reflect.Method methods[] = aClass.getMethods();
			for (int index = 0; index < methods.length; index++){
				java.lang.reflect.Method method = methods[index];
				if ((method.getParameterTypes().length == parameterCount) && (method.getName().equals(methodName))) {
					return method;
				}
			}
		} catch (java.lang.Throwable exception) {
			return null;
		}
		return null;
	}

	/**
	 * Gets the bean class.
	 * @return java.lang.Class
	 */
	public static java.lang.Class getBeanClass() {
		return com.javadude.articles.vaddmvc1.AddressDataEntryFormUI.class;
	}

	/**
	 * Gets the bean class name.
	 * @return java.lang.String
	 */
	public static java.lang.String getBeanClassName() {
		return "com.javadude.articles.vaddmvc1.AddressDataEntryFormUI";
	}

	/**
	 * Gets the addPropertyChangeListener(java.beans.PropertyChangeListener) method descriptor.
	 * @return java.beans.MethodDescriptor
	 */
	public java.beans.MethodDescriptor addPropertyChangeListener_javabeansPropertyChangeListenerMethodDescriptor() {
		java.beans.MethodDescriptor aDescriptor = null;
		try {
			/* Create and return the addPropertyChangeListener(java.beans.PropertyChangeListener) method descriptor. */
			java.lang.reflect.Method aMethod = null;
			try {
				/* Attempt to find the method using getMethod with parameter types. */
				java.lang.Class aParameterTypes[] = {
					java.beans.PropertyChangeListener.class
				};
				aMethod = getBeanClass().getMethod("addPropertyChangeListener", aParameterTypes);
			} catch (java.lang.Throwable exception) {
				/* Since getMethod failed, call findMethod. */
				handleException(exception);
				aMethod = findMethod(getBeanClass(), "addPropertyChangeListener", 1);
			};
			try {
				/* Try creating the method descriptor with parameter descriptors. */
				java.beans.ParameterDescriptor aParameterDescriptor1 = new java.beans.ParameterDescriptor();
				aParameterDescriptor1.setName("arg1");
				aParameterDescriptor1.setDisplayName("listener");
				java.beans.ParameterDescriptor aParameterDescriptors[] = {
					aParameterDescriptor1
				};
				aDescriptor = new java.beans.MethodDescriptor(aMethod, aParameterDescriptors);
			} catch (java.lang.Throwable exception) {
				/* Try creating the method descriptor without parameter descriptors. */
				handleException(exception);
				aDescriptor = new java.beans.MethodDescriptor(aMethod);
			};
			/* aDescriptor.setDisplayName("addPropertyChangeListener(java.beans.PropertyChangeListener)"); */
			/* aDescriptor.setShortDescription("addPropertyChangeListener(java.beans.PropertyChangeListener)"); */
			/* aDescriptor.setExpert(false); */
			/* aDescriptor.setHidden(false); */
			/* aDescriptor.setValue("preferred", new java.lang.Boolean(false)); */
		} catch (java.lang.Throwable exception) {
			handleException(exception);
		};
		return aDescriptor;
	}

	/**
	 * Gets the firePropertyChange(java.lang.String, java.lang.Object, java.lang.Object) method descriptor.
	 * @return java.beans.MethodDescriptor
	 */
	public java.beans.MethodDescriptor firePropertyChange_javalangString_javalangObject_javalangObjectMethodDescriptor() {
		java.beans.MethodDescriptor aDescriptor = null;
		try {
			/* Create and return the firePropertyChange(java.lang.String, java.lang.Object, java.lang.Object) method descriptor. */
			java.lang.reflect.Method aMethod = null;
			try {
				/* Attempt to find the method using getMethod with parameter types. */
				java.lang.Class aParameterTypes[] = {
					java.lang.String.class,
					java.lang.Object.class,
					java.lang.Object.class
				};
				aMethod = getBeanClass().getMethod("firePropertyChange", aParameterTypes);
			} catch (java.lang.Throwable exception) {
				/* Since getMethod failed, call findMethod. */
				handleException(exception);
				aMethod = findMethod(getBeanClass(), "firePropertyChange", 3);
			};
			try {
				/* Try creating the method descriptor with parameter descriptors. */
				java.beans.ParameterDescriptor aParameterDescriptor1 = new java.beans.ParameterDescriptor();
				aParameterDescriptor1.setName("arg1");
				aParameterDescriptor1.setDisplayName("propertyName");
				java.beans.ParameterDescriptor aParameterDescriptor2 = new java.beans.ParameterDescriptor();
				aParameterDescriptor2.setName("arg2");
				aParameterDescriptor2.setDisplayName("oldValue");
				java.beans.ParameterDescriptor aParameterDescriptor3 = new java.beans.ParameterDescriptor();
				aParameterDescriptor3.setName("arg3");
				aParameterDescriptor3.setDisplayName("newValue");
				java.beans.ParameterDescriptor aParameterDescriptors[] = {
					aParameterDescriptor1,
					aParameterDescriptor2,
					aParameterDescriptor3
				};
				aDescriptor = new java.beans.MethodDescriptor(aMethod, aParameterDescriptors);
			} catch (java.lang.Throwable exception) {
				/* Try creating the method descriptor without parameter descriptors. */
				handleException(exception);
				aDescriptor = new java.beans.MethodDescriptor(aMethod);
			};
			/* aDescriptor.setDisplayName("firePropertyChange(java.lang.String, java.lang.Object, java.lang.Object)"); */
			/* aDescriptor.setShortDescription("firePropertyChange(java.lang.String, java.lang.Object, java.lang.Object)"); */
			/* aDescriptor.setExpert(false); */
			/* aDescriptor.setHidden(false); */
			/* aDescriptor.setValue("preferred", new java.lang.Boolean(false)); */
		} catch (java.lang.Throwable exception) {
			handleException(exception);
		};
		return aDescriptor;
	}

	/**
	 * Returns the BeanInfo of the superclass of this bean to inherit its features.
	 * @return java.beans.BeanInfo[]
	 */
	public java.beans.BeanInfo[] getAdditionalBeanInfo() {
		java.lang.Class superClass;
		java.beans.BeanInfo superBeanInfo = null;
	
		try {
			superClass = getBeanDescriptor().getBeanClass().getSuperclass();
		} catch (java.lang.Throwable exception) {
			return null;
		}
	
		try {
			superBeanInfo = java.beans.Introspector.getBeanInfo(superClass);
		} catch (java.beans.IntrospectionException ie) {}
	
		if (superBeanInfo != null) {
			java.beans.BeanInfo[] ret = new java.beans.BeanInfo[1];
			ret[0] = superBeanInfo;
			return ret;
		}
		return null;
	}

	public java.beans.BeanDescriptor getBeanDescriptor() {
		java.beans.BeanDescriptor aDescriptor = null;
		try {
			/* Create and return the AddressDataEntryFormUIBeanInfo bean descriptor. */
			aDescriptor = new java.beans.BeanDescriptor(com.javadude.articles.vaddmvc1.AddressDataEntryFormUI.class);
			/* aDescriptor.setExpert(false); */
			/* aDescriptor.setHidden(false); */
			/* aDescriptor.setValue("hidden-state", Boolean.FALSE); */
		} catch (Throwable exception) {
		};
		return aDescriptor;
	}

	/**
	 * Return the event set descriptors for this bean.
	 * @return java.beans.EventSetDescriptor[]
	 */
	public java.beans.EventSetDescriptor[] getEventSetDescriptors() {
		try {
			java.beans.EventSetDescriptor aDescriptorList[] = {
				propertyChangeEventSetDescriptor()
			};
			return aDescriptorList;
		} catch (java.lang.Throwable exception) {
			handleException(exception);
		};
		return null;
	}

	/**
	 * Return the method descriptors for this bean.
	 * @return java.beans.MethodDescriptor[]
	 */
	public java.beans.MethodDescriptor[] getMethodDescriptors() {
		try {
			java.beans.MethodDescriptor aDescriptorList[] = {
				addPropertyChangeListener_javabeansPropertyChangeListenerMethodDescriptor()
				,firePropertyChange_javalangString_javalangObject_javalangObjectMethodDescriptor()
				,getModelMethodDescriptor()
				,main_javalangString__MethodDescriptor()
				,removePropertyChangeListener_javabeansPropertyChangeListenerMethodDescriptor()
				,setModel_comjavadudearticlesvaddmvc1AddressDataModelMethodDescriptor()
			};
			return aDescriptorList;
		} catch (java.lang.Throwable exception) {
			handleException(exception);
		};
		return null;
	}

	/**
	 * Gets the getModel() method descriptor.
	 * @return java.beans.MethodDescriptor
	 */
	public java.beans.MethodDescriptor getModelMethodDescriptor() {
		java.beans.MethodDescriptor aDescriptor = null;
		try {
			/* Create and return the getModel() method descriptor. */
			java.lang.reflect.Method aMethod = null;
			try {
				/* Attempt to find the method using getMethod with parameter types. */
				java.lang.Class aParameterTypes[] = {};
				aMethod = getBeanClass().getMethod("getModel", aParameterTypes);
			} catch (java.lang.Throwable exception) {
				/* Since getMethod failed, call findMethod. */
				handleException(exception);
				aMethod = findMethod(getBeanClass(), "getModel", 0);
			};
			try {
				/* Try creating the method descriptor with parameter descriptors. */
				java.beans.ParameterDescriptor aParameterDescriptors[] = {};
				aDescriptor = new java.beans.MethodDescriptor(aMethod, aParameterDescriptors);
			} catch (java.lang.Throwable exception) {
				/* Try creating the method descriptor without parameter descriptors. */
				handleException(exception);
				aDescriptor = new java.beans.MethodDescriptor(aMethod);
			};
			/* aDescriptor.setDisplayName("getModel()"); */
			/* aDescriptor.setShortDescription("getModel()"); */
			/* aDescriptor.setExpert(false); */
			/* aDescriptor.setHidden(false); */
			/* aDescriptor.setValue("preferred", new java.lang.Boolean(false)); */
		} catch (java.lang.Throwable exception) {
			handleException(exception);
		};
		return aDescriptor;
	}

	/**
	 * Return the property descriptors for this bean.
	 * @return java.beans.PropertyDescriptor[]
	 */
	public java.beans.PropertyDescriptor[] getPropertyDescriptors() {
		try {
			java.beans.PropertyDescriptor aDescriptorList[] = {
				modelPropertyDescriptor()
			};
			return aDescriptorList;
		} catch (java.lang.Throwable exception) {
			handleException(exception);
		};
		return null;
	}

	/**
	 * Called whenever the bean information class throws an exception.
	 * @param exception java.lang.Throwable
	 */
	private void handleException(java.lang.Throwable exception) {
	
		/* Uncomment the following lines to print uncaught exceptions to stdout */
		// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
		// exception.printStackTrace(System.out);
	}

	/**
	 * Gets the main(java.lang.String[]) method descriptor.
	 * @return java.beans.MethodDescriptor
	 */
	public java.beans.MethodDescriptor main_javalangString__MethodDescriptor() {
		java.beans.MethodDescriptor aDescriptor = null;
		try {
			/* Create and return the main(java.lang.String[]) method descriptor. */
			java.lang.reflect.Method aMethod = null;
			try {
				/* Attempt to find the method using getMethod with parameter types. */
				java.lang.Class aParameterTypes[] = {
					java.lang.String[].class
				};
				aMethod = getBeanClass().getMethod("main", aParameterTypes);
			} catch (java.lang.Throwable exception) {
				/* Since getMethod failed, call findMethod. */
				handleException(exception);
				aMethod = findMethod(getBeanClass(), "main", 1);
			};
			try {
				/* Try creating the method descriptor with parameter descriptors. */
				java.beans.ParameterDescriptor aParameterDescriptor1 = new java.beans.ParameterDescriptor();
				aParameterDescriptor1.setName("arg1");
				aParameterDescriptor1.setDisplayName("args");
				java.beans.ParameterDescriptor aParameterDescriptors[] = {
					aParameterDescriptor1
				};
				aDescriptor = new java.beans.MethodDescriptor(aMethod, aParameterDescriptors);
			} catch (java.lang.Throwable exception) {
				/* Try creating the method descriptor without parameter descriptors. */
				handleException(exception);
				aDescriptor = new java.beans.MethodDescriptor(aMethod);
			};
			/* aDescriptor.setDisplayName("main(java.lang.String[])"); */
			/* aDescriptor.setShortDescription("main(java.lang.String[])"); */
			/* aDescriptor.setExpert(false); */
			/* aDescriptor.setHidden(false); */
			/* aDescriptor.setValue("preferred", new java.lang.Boolean(false)); */
		} catch (java.lang.Throwable exception) {
			handleException(exception);
		};
		return aDescriptor;
	}

	/**
	 * Gets the model property descriptor.
	 * @return java.beans.PropertyDescriptor
	 */
	public java.beans.PropertyDescriptor modelPropertyDescriptor() {
		java.beans.PropertyDescriptor aDescriptor = null;
		try {
			try {
				/* Using methods via getMethod is the faster way to create the model property descriptor. */
				java.lang.reflect.Method aGetMethod = null;
				try {
					/* Attempt to find the method using getMethod with parameter types. */
					java.lang.Class aGetMethodParameterTypes[] = {};
					aGetMethod = getBeanClass().getMethod("getModel", aGetMethodParameterTypes);
				} catch (java.lang.Throwable exception) {
					/* Since getMethod failed, call findMethod. */
					handleException(exception);
					aGetMethod = findMethod(getBeanClass(), "getModel", 0);
				};
				java.lang.reflect.Method aSetMethod = null;
				try {
					/* Attempt to find the method using getMethod with parameter types. */
					java.lang.Class aSetMethodParameterTypes[] = {
						com.javadude.articles.vaddmvc1.AddressDataModel.class
					};
					aSetMethod = getBeanClass().getMethod("setModel", aSetMethodParameterTypes);
				} catch (java.lang.Throwable exception) {
					/* Since getMethod failed, call findMethod. */
					handleException(exception);
					aSetMethod = findMethod(getBeanClass(), "setModel", 1);
				};
				aDescriptor = new java.beans.PropertyDescriptor("model"
				, aGetMethod, aSetMethod);
			} catch (java.lang.Throwable exception) {
				/* Since we failed using methods, try creating a default property descriptor. */
				handleException(exception);
				aDescriptor = new java.beans.PropertyDescriptor("model"
				, getBeanClass());
			};
			aDescriptor.setBound(true);
			/* aDescriptor.setConstrained(false); */
			/* aDescriptor.setDisplayName("model"); */
			/* aDescriptor.setShortDescription("model"); */
			/* aDescriptor.setExpert(false); */
			/* aDescriptor.setHidden(false); */
			/* aDescriptor.setValue("preferred", new java.lang.Boolean(false)); */
			/* aDescriptor.setValue("ivjDesignTimeProperty", new java.lang.Boolean(true)); */
		} catch (java.lang.Throwable exception) {
			handleException(exception);
		};
		return aDescriptor;
	}

	/**
	 * Gets the propertyChange event set descriptor.
	 * @return java.beans.EventSetDescriptor
	 */
	public java.beans.EventSetDescriptor propertyChangeEventSetDescriptor() {
		java.beans.EventSetDescriptor aDescriptor = null;
		try {
			try {
				/* Try using method descriptors to create the propertyChange event set descriptor. */
				java.beans.MethodDescriptor eventMethodDescriptors[] = {
					propertyChangepropertyChange_javabeansPropertyChangeEventMethodEventDescriptor()			};
				java.lang.reflect.Method anAddMethod = null;
				try {
					/* Attempt to find the method using getMethod with parameter types. */
					java.lang.Class anAddMethodParameterTypes[] = {
						java.beans.PropertyChangeListener.class
					};
					anAddMethod = getBeanClass().getMethod("addPropertyChangeListener", anAddMethodParameterTypes);
				} catch (java.lang.Throwable exception) {
					/* Since getMethod failed, call findMethod. */
					handleException(exception);
					anAddMethod = findMethod(getBeanClass(), "addPropertyChangeListener", 1);
				};
				java.lang.reflect.Method aRemoveMethod = null;
				try {
					/* Attempt to find the method using getMethod with parameter types. */
					java.lang.Class aRemoveMethodParameterTypes[] = {
						java.beans.PropertyChangeListener.class
					};
					aRemoveMethod = getBeanClass().getMethod("removePropertyChangeListener", aRemoveMethodParameterTypes);
				} catch (java.lang.Throwable exception) {
					/* Since getMethod failed, call findMethod. */
					handleException(exception);
					aRemoveMethod = findMethod(getBeanClass(), "removePropertyChangeListener", 1);
				};
				aDescriptor = new java.beans.EventSetDescriptor(
							"propertyChange", 
							java.beans.PropertyChangeListener.class, 
							eventMethodDescriptors, anAddMethod, aRemoveMethod);
			} catch (java.lang.Throwable exception) {
				/* Using method descriptors failed, try using the methods names. */
				handleException(exception);
				java.lang.String eventMethodNames[] = {
					"propertyChange"			};
				aDescriptor = new java.beans.EventSetDescriptor(getBeanClass(), 
							"propertyChange", 
							java.beans.PropertyChangeListener.class, 
							eventMethodNames, 
							"addPropertyChangeListener", 
							"removePropertyChangeListener");
			};
			/* aDescriptor.setUnicast(false); */
			/* aDescriptor.setDisplayName("propertyChange"); */
			/* aDescriptor.setShortDescription("propertyChange"); */
			/* aDescriptor.setExpert(false); */
			/* aDescriptor.setHidden(false); */
			/* aDescriptor.setValue("preferred", new java.lang.Boolean(false)); */
		} catch (java.lang.Throwable exception) {
			handleException(exception);
		};
		return aDescriptor;
	}

	/**
	 * Gets the propertyChange.propertyChange(java.beans.PropertyChangeEvent) method descriptor.
	 * @return java.beans.MethodDescriptor
	 */
	public java.beans.MethodDescriptor propertyChangepropertyChange_javabeansPropertyChangeEventMethodEventDescriptor() {
		java.beans.MethodDescriptor aDescriptor = null;
		try {
			/* Create and return the propertyChange.propertyChange(java.beans.PropertyChangeEvent) method descriptor. */
			java.lang.reflect.Method aMethod = null;
			try {
				/* Attempt to find the method using getMethod with parameter types. */
				java.lang.Class aParameterTypes[] = {
					java.beans.PropertyChangeEvent.class
				};
				aMethod = (java.beans.PropertyChangeListener.class).getMethod("propertyChange", aParameterTypes);
			} catch (java.lang.Throwable exception) {
				/* Since getMethod failed, call findMethod. */
				handleException(exception);
				aMethod = findMethod((java.beans.PropertyChangeListener.class), "propertyChange", 1);
			};
			try {
				/* Try creating the method descriptor with parameter descriptors. */
				java.beans.ParameterDescriptor aParameterDescriptor1 = new java.beans.ParameterDescriptor();
				aParameterDescriptor1.setName("arg1");
				aParameterDescriptor1.setDisplayName("evt");
				java.beans.ParameterDescriptor aParameterDescriptors[] = {
					aParameterDescriptor1
				};
				aDescriptor = new java.beans.MethodDescriptor(aMethod, aParameterDescriptors);
			} catch (java.lang.Throwable exception) {
				/* Try creating the method descriptor without parameter descriptors. */
				handleException(exception);
				aDescriptor = new java.beans.MethodDescriptor(aMethod);
			};
			/* aDescriptor.setDisplayName("propertyChange"); */
			/* aDescriptor.setShortDescription("propertyChange"); */
			/* aDescriptor.setExpert(false); */
			/* aDescriptor.setHidden(false); */
			/* aDescriptor.setValue("preferred", new java.lang.Boolean(false)); */
		} catch (java.lang.Throwable exception) {
			handleException(exception);
		};
		return aDescriptor;
	}

	/**
	 * Gets the removePropertyChangeListener(java.beans.PropertyChangeListener) method descriptor.
	 * @return java.beans.MethodDescriptor
	 */
	public java.beans.MethodDescriptor removePropertyChangeListener_javabeansPropertyChangeListenerMethodDescriptor() {
		java.beans.MethodDescriptor aDescriptor = null;
		try {
			/* Create and return the removePropertyChangeListener(java.beans.PropertyChangeListener) method descriptor. */
			java.lang.reflect.Method aMethod = null;
			try {
				/* Attempt to find the method using getMethod with parameter types. */
				java.lang.Class aParameterTypes[] = {
					java.beans.PropertyChangeListener.class
				};
				aMethod = getBeanClass().getMethod("removePropertyChangeListener", aParameterTypes);
			} catch (java.lang.Throwable exception) {
				/* Since getMethod failed, call findMethod. */
				handleException(exception);
				aMethod = findMethod(getBeanClass(), "removePropertyChangeListener", 1);
			};
			try {
				/* Try creating the method descriptor with parameter descriptors. */
				java.beans.ParameterDescriptor aParameterDescriptor1 = new java.beans.ParameterDescriptor();
				aParameterDescriptor1.setName("arg1");
				aParameterDescriptor1.setDisplayName("listener");
				java.beans.ParameterDescriptor aParameterDescriptors[] = {
					aParameterDescriptor1
				};
				aDescriptor = new java.beans.MethodDescriptor(aMethod, aParameterDescriptors);
			} catch (java.lang.Throwable exception) {
				/* Try creating the method descriptor without parameter descriptors. */
				handleException(exception);
				aDescriptor = new java.beans.MethodDescriptor(aMethod);
			};
			/* aDescriptor.setDisplayName("removePropertyChangeListener(java.beans.PropertyChangeListener)"); */
			/* aDescriptor.setShortDescription("removePropertyChangeListener(java.beans.PropertyChangeListener)"); */
			/* aDescriptor.setExpert(false); */
			/* aDescriptor.setHidden(false); */
			/* aDescriptor.setValue("preferred", new java.lang.Boolean(false)); */
		} catch (java.lang.Throwable exception) {
			handleException(exception);
		};
		return aDescriptor;
	}

	/**
	 * Gets the setModel(com.javadude.articles.vaddmvc1.AddressDataModel) method descriptor.
	 * @return java.beans.MethodDescriptor
	 */
	public java.beans.MethodDescriptor setModel_comjavadudearticlesvaddmvc1AddressDataModelMethodDescriptor() {
		java.beans.MethodDescriptor aDescriptor = null;
		try {
			/* Create and return the setModel(com.javadude.articles.vaddmvc1.AddressDataModel) method descriptor. */
			java.lang.reflect.Method aMethod = null;
			try {
				/* Attempt to find the method using getMethod with parameter types. */
				java.lang.Class aParameterTypes[] = {
					com.javadude.articles.vaddmvc1.AddressDataModel.class
				};
				aMethod = getBeanClass().getMethod("setModel", aParameterTypes);
			} catch (java.lang.Throwable exception) {
				/* Since getMethod failed, call findMethod. */
				handleException(exception);
				aMethod = findMethod(getBeanClass(), "setModel", 1);
			};
			try {
				/* Try creating the method descriptor with parameter descriptors. */
				java.beans.ParameterDescriptor aParameterDescriptor1 = new java.beans.ParameterDescriptor();
				aParameterDescriptor1.setName("arg1");
				aParameterDescriptor1.setDisplayName("arg1");
				java.beans.ParameterDescriptor aParameterDescriptors[] = {
					aParameterDescriptor1
				};
				aDescriptor = new java.beans.MethodDescriptor(aMethod, aParameterDescriptors);
			} catch (java.lang.Throwable exception) {
				/* Try creating the method descriptor without parameter descriptors. */
				handleException(exception);
				aDescriptor = new java.beans.MethodDescriptor(aMethod);
			};
			/* aDescriptor.setDisplayName("setModel(com.javadude.articles.vaddmvc1.AddressDataModel)"); */
			/* aDescriptor.setShortDescription("setModel(com.javadude.articles.vaddmvc1.AddressDataModel)"); */
			/* aDescriptor.setExpert(false); */
			/* aDescriptor.setHidden(false); */
			/* aDescriptor.setValue("preferred", new java.lang.Boolean(false)); */
		} catch (java.lang.Throwable exception) {
			handleException(exception);
		};
		return aDescriptor;
	}
}
