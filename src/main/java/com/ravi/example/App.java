package com.ravi.example;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App
{
	static String javaVersion;
	static String majorJavaVersion;
	
	static {
        javaVersion = System.getProperty("java.version");
        // version String should look like "1.4.2_10"
        if (javaVersion.indexOf("1.7.") != -1) {
            majorJavaVersion = "JAVA_17";
        }
        else if (javaVersion.indexOf("1.6.") != -1) {
            majorJavaVersion = "JAVA_16";
        }
        else if (javaVersion.indexOf("1.5.") != -1) {
            majorJavaVersion = "JAVA_15";
        }
        else if (javaVersion.indexOf("1.8.") != -1) {
            majorJavaVersion = "JAVA_18";
        }
        else {
            // else leave 1.4 as default (it's either 1.4 or unknown)
            majorJavaVersion = "JAVA_14";
        }
    }
	
	@Autowired
	HelloWorld helloWorld;
	
	public void getHelloWorld() {
		helloWorld.printHello();
	}
	
	public void getEmployee() {
		helloWorld.getEmployee("Ravi", 100000);
	}
	
    public static void main( String[] args )
    {
    	System.out.println(majorJavaVersion);
    	new ClassPathXmlApplicationContext("Spring-Module.xml");
    }
    
    @PostConstruct
    public void post() {
    	getHelloWorld();
    	getEmployee();
    }
}
