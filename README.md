# Servlet-XML
A simple tutorial on a servlet that returns our object as a XML file.


## We will use:

   * **Java**;
   * **JAXB**, a API for manipulating XML ;
   * **Java-CRUD** a simple CRUD project, that will be used as basis for this one. Consists of a class that handles our object, a persistence layer and a service class to manipulate that layer. Any doubt, the [Java-CRUD](https://github.com/BrenoCPimenta/Java-CRUD) ReadMe file explains all the workflow and classes involved of this project. The comments on the CRUD projetc were opmized and the *_StepByStep* was tranformed into *_CRUDtest*. 

## Step by Step:

	* First, to convert a object in xml, the JAXB needs a annotation statement "@XmlRootElement" in all classes that arre involved into to the process. So we will add it into Plant.java. It's necessary to import javax.xml.bind.annotation.XmlRootElement.

	* JAXB can't encapsulate ArrayLists, so we will create a class called PlantList.java that handles it. And in this class it will be used two more annotations, the root as we used before, but now with a paramenter name and a @XmlElment with a parameter as well. Remebering that this class must be serializable. And at last will be overrided the toString() method, so it returns a formated PlantList string. 



