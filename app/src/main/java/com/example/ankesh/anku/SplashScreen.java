package com.example.ankesh.anku;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;



public class SplashScreen extends AppCompatActivity {
    private static final int REQUEST_WRITE_STORAGE_REQUEST_CODE = 1;
    private static int SPLASH_TIME = 5000;//This is 4 seconds
    private static final String TABLE_NAME = "rita";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_PARA = "para";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        requestAppPermissions();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do any action here. Now we are moving to next page
                Intent mySuperIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(mySuperIntent);
                /* This 'finish()' is for exiting the app when back button pressed
                 *  from Home page which is ActivityHome
                 */
                finish();
            }
        }, SPLASH_TIME);
    }

    private void createDB(){
        SQLiteDatabase db= openOrCreateDatabase("rita",MODE_PRIVATE,null);
        String sql= "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(\n" +
                "    " + COL_ID + " INTEGER NOT NULL CONSTRAINT ankesh_pk PRIMARY KEY AUTOINCREMENT,\n" +
                "    " + COL_NAME + " varchar(200) NOT NULL,\n" +
                "    " + COL_PARA + " varchar(30000) NOT NULL\n" +
                ");";
        db.execSQL(sql);
        String sqlI= "INSERT INTO rita (name,para) VALUES (?,?)";
        db.execSQL(sqlI,new String[] {"Introduction","Java technology is both a programming language and a platform. The Java programming language is a high-level language.\n" +
                "\n" +
                "In the Java programming language, all source code is first written in plain text files ending with the .java extension.\n" +
                "\n" +
                "Those source files are then compiled into .class files by the javac compiler.\n" +
                "\n" +
                "A .class file does not contain code that is native to your processor; it instead contains bytecodes the machine language of the Java Virtual Machine (Java VM).\n" +
                "\n" +
                "The java launcher tool then runs your application with an instance of the Java Virtual Machine."});

        db.execSQL(sqlI,new String[] {"OOP's Concept","Object means a real word entity such as pen, chair, table etc. Object-Oriented Programming is a methodology or paradigm to design a program using classes and objects. It simplifies the software development and maintenance by providing some concepts:-\n" +
                "i) Object\n" +
                "ii) Class\n" +
                "iii) Inheritance\n" +
                "iv) Interface\n" +
                "v) Polymorphism\n" +
                "vi) Abstraction\n" +
                "vii) Encapsulation\n" +
                "\n" +
                "i) Object:- An object is a software bundle of related state and behavior.\n" +
                "\n" +
                "Any entity that has state and behavior is known as an object. For example: chair, pen, table, keyboard, bike etc. It can be physical and logical.\n" +
                "\n" +
                "ii) Class:- Collection of objects is called class. It is a logical entity.\n" +
                "\n" +
                "In the real world, you'll often find many individual objects all of the same kind. There may be thousands of other bicycles in existence, all of the same make and model. Each bicycle was built from the same set of blueprints and therefore contains the same components. In object-oriented terms, we say that your bicycle is an instance of the class of objects known as bicycles. A class is the blueprint from which individual objects are created.\n" +
                "\n" +
                "iii) Inheritance:- Different kinds of objects often have a certain amount in common with each other.\n" +
                "\n" +
                "Object-oriented programming allows classes to inherit commonly used state and behavior from other classes.\n" +
                "\n" +
                "When one object acquires all the properties and behaviours of parent object i.e. known as inheritance. It provides code reusability. It is used to achieve runtime polymorphism.\n" +
                "\n" +
                "iv) Interface:- The interface is a mechanism to achieve fully abstraction in java. There can be only abstract methods in the interface. It is used to achieve fully abstraction and multiple inheritance in Java. Interface also represents IS-A relationship. It cannot be instantiated just like abstract class.\n" +
                "\n" +
                "v) Polymorphism:- When one task is performed by different ways i.e. known as polymorphism. For example: to convense the customer differently, to draw something e.g. shape or rectangle etc.\n" +
                "\n" +
                "In java, we use method overloading and method overriding to achieve polymorphism.\n" +
                "\n" +
                "vi) Abstraction:- Abstraction refers to the act of representing essential features without including background details or exceptions. Abstraction refers to the ability to make a class abstract in Object oriented programming.\n" +
                "\n" +
                "vii) Encapsulation:- The wrapping up of data and methods into a single unit (called class) is known as Encapsulation. Encapsulation is one of the four fundamental OOP concepts. The other three are inheritance, polymorphism, and abstraction"});

        db.execSQL(sqlI,new String[]{"Classes & Object","Java is a true object-oriented language and therefore the underlying structure of all java programs is classes. Anything we wise to represent in a java program must be encapsulated in a class that defines the state and behaviour of the basic program components known as objects.\n" +
                "\n" +
                "An object is anything that really exists in the world and can be distingushed from others. Every thing that we see physically will come into this definition, for example:- human being, a book, tree, a table, a pen, and so on.\n" +
                "\n" +
                "Collection of objects is called class. It is a logical entity.\n" +
                "\n" +
                "Syntax for class:-\n" +
                "[Access Specifier/Modifier-List] class < class name> [extends SuperClass] [implements Interface-List]\n" +
                "\n" +
                "Or\n" +
                "\n" +
                "< class modifiers> class < class name>< formal type parameter list> < extends clause>< implements clause> // Class header\n" +
                "{ // class body\n" +
                "   < field declarations>\n" +
                "   < method declarations>\n" +
                "   < nested class declarations>\n" +
                "   < nested interface declarations>\n" +
                "   < nested enum declarations>\n" +
                "   < constructor declarations>\n" +
                "   < initializer blocks>\n" +
                "}// End of class body\n" +
                "\n" +
                "Syntax for object:-\n" +
                "classname reference_variable = new classname([parameter-list]);"});

        db.execSQL(sqlI,new String[] {"Access Specifier","Access specifier defines the boundary and scope to access the method, variable, and class etc. Java has defines four type of access specifiers such as:-\n" +
                "1. public\n" +
                "2. private\n" +
                "3. protected\n" +
                "4. default / friendly\n" +
                "\n" +
                "These access specifiers are defines the scope for variables/methods. If you are not defining any access specifier so it will be as 'default' access specifier for variables/methods.\n" +
                "\n" +
                "1. public access specifier:- If you declare any variable/ function as public access specifier so you can used it from anywhere of the program.\n" +
                "Syntax:-\n" +
                "< Access Specifier >     data type     variable /function ;\n" +
                "Ex:-\n" +
                "public int number;\n" +
                "\n" +
                "2. private access specifier:- If you declare any variable/ function as private access specifier so you can used within the java class itself, not from outside the class, package and others.\n" +
                "Syntax:-\n" +
                "< Access Specifier >     data type     variable / function;\n" +
                "Ex:-\n" +
                "private int number=10;\n" +
                "\n" +
                "3. protected access specifier:- If you want to access the private variable of parent class within your child class so you can declare those variable as protected. If your variable/method is declared aas protected so that variables/methods can be access same Class name, Package name, and sub class.\n" +
                "Syntax:-\n" +
                "< Access Specifier >     data type     variable / function;\n" +
                "Ex:-\n" +
                "protected int number=10;\n" +
                "\n" +
                "4. default access specifier:- Actually, there is no default access modifier; the absence of a modifier is treated as default. A method or variable, declared default( that is, no access modifier specified at all ), can be accessed by any class belonging to the same package.\n" +
                "\n" +
                "Classes belonging to other packages cannot access. That is why default access modifier is known as package level access.\n" +
                "\n" +
                "A class can be either default or public.\n" +
                "\n" +
                "Note: default is keyword and is used with switch statements.\n"});

        db.execSQL(sqlI,new String[]{"Method Overloading","An overloaded method is more than one method: it is two or more separate methods using the same method name( of course, with different parameters ).\n" +
                    "\n" +
                    "Methods are defined in classes. Methods are distinguished by the compiler by their method signatures. A method signature includes method name, number of parameters and their type. But in procedural languages like in C, method overloading is not permitted.\n" +
                    "\n" +
                    "Method overloading allows to group methods of same functionality under one name. Always the name of the method should reflect its functionality( that is, what is it going to give us). In method overloading, compiler does not consider return type in differentiating the methods."});

        db.execSQL(sqlI,new String[]{"Method Overriding","If the method signatures of a method in superclass and subclass are same, we say superclass method is overridden in subclass. In method overriding the return type also must be same of that of superclass.\n" +
                "\n" +
                "The subclass method must have the same name, parameter list and return type as the superclass method. That is, by using the same method name of the superclass, the subclass gives different output.\n" +
                "\n" +
                "When you extend a class and write a method in the derived class which is exactly similiar to the one present in the base class, it is termed as overriding."});

        db.execSQL(sqlI,new String[]{"Constructor","A constructor is a special member method which will be called by the JVM implicitly(automatically) for placing user/programmer defined values instead of placing default values.\n" +
                "\n" +
                "Constructors are meant for initializing the object. Constructor is a special type of method that is used to initialize the state of an object.\n" +
                "\n" +
                "Constructor is invoked at the time of object creation. It constructs the values i.e. data for the object that is why it is known as constructor.\n" +
                "\n" +
                "Constructor is just like the instance method but it does not have any explicit return type.\n" +
                "\n" +
                "Advantages of Constructors:\n" +
                "1. A constructor eliminates placing the default values.\n" +
                "2. A constructor eliminates callling the normal method implicitly.\n" +
                "\n" +
                "RULES/CHARACTERISTICS of a Constructor:\n" +
                "1. Constructor name must be same as its class name.\n" +
                "2. Constructor should not return any value even void also.\n" +
                "3. Costructors should not be static .\n" +
                "4. Constructors should not be private.\n" +
                "5. Constructors will not be inherited at all.\n" +
                "6. Constructors are called automatically whenever an object is cereating.\n" +
                "\n" +
                "Types of Constructors:\n" +
                "There are two types of constructors:-\n" +
                "1. Default constructor (no-argument constructor)\n" +
                "2. Parameterized constructor\n" +
                "\n" +
                "1. Default constructor (no-argument constructor):- A constructor is one which will not take any parameter.\n2. Parameterized Constructor:- A constructor is one which takes some parameters."});

        db.execSQL(sqlI,new String[]{"static keyword","Static is java keyword it is utilized for static variables, static methods, static blocks, and static inner classes but not for the outer class.\n" +
                "\n" +
                "Static Variables:\n" +
                "static variable could be recognized & executed at the time of loading the byte code of respective class. The value of a variable is nnot varied for object then we should declare that variable as static.\n" +
                "\n" +
                "In java application static variables will be accessed by either by using class name directly or by using respective class object reference variable. Static method is a java method, which will be recognized at the time of loading respective class byte code & whose execution is completely depending on the movement when we access the method.\n" +
                "\n" +
                "Static method will allow directly static variables of the same name class and which will not allow non static variables directly.\n" +
                "\n" +
                "Static methods not allow to 'this' keyword, but it is possible to access static methods with 'this' keyword."});

        db.execSQL(sqlI,new String[]{"super keyword","super keyword gives explicit access to the constructors, methods and variables of its super class.\n" +
                "\n" +
                "The super keyword works with inheritance. Inheritance gives implicit access to subclass to call its superclass members. But implicit access is blocked by method overriding or by declaring the same instance variables in subclass what superclass is having.\n" +
                "\n" +
                "Here, super keyword is used. That is super keyword gives explicit access to immediate superclass parts, even if access is blocked. Usage of super with constructors - super( ) :\n" +
                "super keyword should be called in a different way with constructors, because constructors are not inherited but accessed. To access the superclass constructor from a subclass constructor we use super( ). JVM distinguishes which superclass consturctor is to be called by matching the parameters we pass with super( ). "});

        db.execSQL(sqlI,new String []{"final keyword","final is a keyword in Java which generically means, cannot be changed once created. Any final keyword when declared with variables, methods and classes specifically means:\n" +
                    "a final variable cannot be reassigned once initialized.\n" +
                    "a final method cannot be overridden.\n" +
                    "a final class cannot be subclassed.\n" +
                    "\n" +
                    "Classes are usually declared final for either performance or security reasons. final methods work like inline code of C++.\n" +
                    "\n" +
                    "final with variables:\n" +
                    "final variables work like const of C-language that can't be altered in the whole program. That is, final variables once created can't be changed and they must be used as it is by all the program.final with methods:\n" +
                    "Generally, a superclass method can be overriden by the subclass if it wants a different functionality. Or, it can use the same method if it wants the same functionality( output ).\n" +
                    "\n" +
                    "If the superclass desires that the subclass shoud not override its method by the subclass, it declares the method as final. That is mehods declared final can not be overridden( else it is a compilation error ).final with classes:\n" +
                    "If you want the class not be subclassed by any other class, declare it final. Classes declared final can not be extended. That is, any class can use the methods of a final class by creating an object of final class and call the methods with its object."});

        db.execSQL(sqlI,new String[] {"this keyword","'this' is a keyword that refers to the object of the class where it is used.\n" +
                    "\n" +
                    "In other words, 'this' refers to the object of the present class.\n" +
                    "\n" +
                    "Generally, we write instance variables, constructors and methods in a class. All these members are referenced by 'this'. When an object is created to a class, a default reference is also created internally to the object. This default reference is nothing but 'this'. So 'this' can refer to all the things of the present object."});

        db.execSQL(sqlI,new String []{"Interface","Interfaces are syntactically similar to classes, but they lack instance variables, and their methods are declared without any body.\n" +
                    "\n" +
                    "Using the keyword interface, you can fully abstract a class, interface from its implementation.\n" +
                    "\n" +
                    "That is, using interface, you can specify what a class must do, but not how it does it.\n" +
                    "\n" +
                    "Once interface is defined, any number of classes can implement it. Also, one class can implement any number of interfaces.\n" +
                    "\n" +
                    "Interfaces are designed to support dynamic method resolution at run time."});

        db.execSQL(sqlI,new String[]{"Packages","A package is a collection of classes and interfaces( generally, having a common functionality ). Packages provide access restrictions to other classes.\n" +
                    "\n" +
                    "A package groups together a set of classes and interfaces that are needed to work as a whole. The java.io package contains classes and interfaces for managing various kinds input and output operations.\n" +
                    "\n" +
                    "Package defines boundary lines to govern how classes and interfaces may interact (access) with each other.\n" +
                    "\n" +
                    "Packages also reduce the potential name clashes between classes. A single package cannot have classes with the same name more than one. But the classes with the same name can exist in different packages.\n" +
                    "\n" +
                    "That is, we can make a Button class of our own and keep in our own package. The Button in our own package does not clash with the Button of java.io package.\n" +
                    "\n" +
                    "Each class and interface belongs to some package( like a file cannot exist without a directory) . When we compile a class without mentioning the package name, it is placed in the default( unnamed ) package created by the JVM.\n" +
                    "\n" +
                    "Packages can be nested, if needed. That is we can create sub-packages to packages. For example, in java.awt.event event is the sub-package to awt package.\n" +
                    "\n" +
                    "In declaring a class, the order of statements is very important as given below, else compilation error. Always package name must be the first, if one exists."});

        db.execSQL(sqlI,new String[]{"Arrays","Array is a collection of similar type of elements that have contigious memory location.\n" +
                    "\n" +
                    "Array is an object the contains elements of similar data type. It is a data structure where we store similar elements. We can store only fixed elements in an array.\n" +
                    "\n" +
                    "Array is index based, first element of the array is stored at 0 index.Creation of arrays:\n" +
                    "\n" +
                    "Arrays are data structures that can store large amount of information of the same data type grouped together and known by a common name. Each member is called an element of the array.\n" +
                    "\n" +
                    "Arrays are capable of storing primitive data types as well as objects. The elements of the array can be accessed by its index value that starts from 0. Once array is declared, its size cannot be altered dynamically.\n" +
                    "\n" +
                    "Arrays can be :-\n" +
                    "a) declared and later assigned or\n" +
                    "b) initialized.\n" +
                    "Advantages of Array\n" +
                    "1. Code Optimization: It makes the code optimized, we can retrive or sort the data easily.\n" +
                    "2. Random access: We can get any data located at any index position.\n" +
                    "\n" +
                    "Disadvantage of Array\n" +
                    "Size Limit: We can store only fixed size of elements in the array. It doesn't grow its size at runtime. To solve this problem, collection framework is used in java.\n" +
                    "\n" +
                    "Types of Array\n" +
                    "There are two types of array.\n" +
                    "1. Single Dimensional Array\n" +
                    "2. Multidimensional Array"});

        db.execSQL(sqlI,new String[]{"Strings","A sequence of character data enclosed in double quotes is called a string. Strings of Java work differently from that of C and C + +. In C, string is an array of characters with a terminating \\ 0. But in Java, string is an object of String class.\n" +
                    "\n" +
                    "That is manipulation of strings is quite different from C and in Java, it is very easy due the rich methods of String class. For example, we can concatenate strings with + operator.\n" +
                    "\n" +
                    "Java platform provides two string classes to manipulate strings String, for constant strings and StringBuffer, for strings that can change.\n" +
                    "\n" +
                    "Strings are immutable. That is, strings once created cannot be changed at the same memory location.\n" +
                    "\n" +
                    "Whenever a new value is assigned to a string, a new memory location is created and the new value is stored in it and the old location( with old value ) is garbage collected.\n" +
                    "\n" +
                    "It is definitely a overhead to the operating system. But this is made to increase the performance and for the same reason String class is declared as final.\n" +
                    "\n" +
                    "The following the class signature of String class defined in java.lang package:\n" +
                    "\n" +
                    "public final class String extends Object implements Serializable, Comparable\n" +
                    "\n" +
                    "To overcome the OS overhead( due to immutable nature of strings), we can use StringBuffer class.\n" +
                    "\n" +
                    "Some methods of String class:\n" +
                    "\n" +
                    "1. valueOf( parameter ) :\n" +
                    "valueOf() method is static and is overloaded many times in String class. It's job is to convert any primitive data type or object, passed as parameter, into a string form.\n" +
                    "\n" +
                    "Its function similar to toString() method of Object class. But toString() method converts only objects into string form.\n" +
                    "2. length( ) :\n" +
                    "\n" +
                    "length( ) is an instance method in String class which returns an int value. It must be called with an instance of String class and returns the number of characters present in the string instance.\n" +
                    "3. equals( ) :\n" +
                    "equals( ) method is inherited from Object class and is overridden in String class. It returns a boolean value of true if the strings are same or false, if the strings are different. In the comparison, case( upper or lower) of the letters is considered.4. toLowerCase( ) and toUpperCase( ) :\n" +
                    "toLowerCase( ) is an instance method and converts all uppercase letters of the string into lowercase. toUpperCase( ) does in the reverse way."});

        db.execSQL(sqlI,new String[]{"Exceptions","try :\n" +
                    "try is a keyword in Java that defines a block of statements. First, we must identify the statements, in a program, that may raise the exception. Then place those statements in the try block.\n" +
                    "\n" +
                    "That is, the statements that are placed in the try block, may cause( throw ) the exception. If exception is not raised, the system simply ignores the try block.\n" +
                    "\n" +
                    "catch:\n" +
                    "catch is a keyword in Java and denotes a block of statements. Every try block should be followed by a catch block. The exception thrown by the try block is caught( or handled ) by the catch block.\n" +
                    "\n" +
                    "We must provide a suitable exception class that can handle( or catch) the exception thrown by the try block. That is, catch block contains the exception handler.\n" +
                    "\n" +
                    "When an exception handler present in the catch block successfully catches the exception, the program execution goes in a normal way and continues further.\n" +
                    "\n" +
                    "One program can contain any number of try - catch blocks. A try block can have any number of catch blocks.\n" +
                    "\n" +
                    "finally:\n" +
                    "finally is a keyword in Java and denotes a block of statements. The statements placed in the finally block are definitely executed whether catch block successfully catches the exception or not.\n" +
                    "\n" +
                    "Generally, we write clean up statements in this block, like closing of streams or closing of sockets etc. finally block is optional."});

        db.execSQL(sqlI,new String[]{"throw & throws keyword","throws keyword :-\n" +
                    "The main purpose of 'throws' keyword is to delegate the resposibilities of exception handling from present method to the caller method. It requires in the case of checked exception.If we are compiling the above code then we are getting the Compile time Error like:\n" +
                    "ThrowsDemo.java: unreported exception java.lang.Exception; must be caught or declared to be thrown\n" +
                    "throwsExc();throw keyword :-\n" +
                    "\n" +
                    "Sometimes we can create Exception object explicitly and we can handover that exception object to the JVM explicitly by throw keyword. The purpose of throw keyword is to handover our created exception object explicitly to the JVM. "});

        db.execSQL(sqlI,new String[]{"MultiThreading","Thread :-\n" +
                    "A thread is a single sequential( separate ) flow of control within program. Sometimes, it is called an execution context or light weight process. A thread itself is not a program.\n" +
                    "\n" +
                    "A thread can not run on it's own( as it is a part of a program ). Rather, it runs within a program. A program can be divided into a number of packets of code ---- each representing a thread having its own separate flow of control. Light weight process: A thread is considered a light weight process because it runs within the context of a program and takes advantage of the resources allocated to that program.\n" +
                    "\n" +
                    "Heavy weight process: In the heavy weight process, the control changes in between threads belonging to different processes. ( In light weight process, the control changes in between threads belonging to same(one) process ).\n" +
                    "\n" +
                    "Execution contest: A thread will have its own execution stack and program counter. The code running within the thread works only within that context.\n" +
                    "\n" +
                    "One of the strengths of Java is its support for multithreading. All the classes needed to write a multithreaded program are included in the default imported package java.lang through class Object, class Thread and interface Runnable. "});


        db.execSQL(sqlI,new String[]{"I/O Stream"," 1. Byte Streams:\n" +
                    "Generally, all the low-level streams, like keyboard input or output to a monitor or socket level data transmission goes by byte streams. In java.io package, the subclasses of Input and Output streams support these byte streams.\n" +
                    "\n" +
                    "FileInpustStream is generally used to read byte by byte from a file and FileOutputStream is used to write byte by byte to a file.\n" +
                    "\n" +
                    "2. Character Streams:\n" +
                    "jdk 1.1 version, introduces character based streams. Character-based input and output streams( subclasses of Reader and Writer classes) provide several advantages.\n" +
                    "\n" +
                    "While byte streams( subclasses of InputStream and OutputStream classes) reads 8-bit ASCII byte at a time, character-based streams reads 16-bit Unicode characters. These are introduced to support Java's internationalization.\n" +
                    "\n" +
                    "FileReader, an indirect subclass of Reader class, is a prominent class to read characters from a file.\n" +
                    "FileReader fr = new FileReader( \"Demo.txt\" ) ;\n" +
                    "fr.read( ) ;\n" +
                    "\n" +
                    "3. Filter Streams:\n" +
                    "The java.io package provides two abstract classes that define filter streams FilterInputStream and FilterOutputStream for byte streams and FilterReader and FilterWriter for character streams.\n" +
                    "\n" +
                    "A filter stream is a stream that filters data while reading and writing and adds some extra functionality which does not exist in the original source file. Example of filter streams: LineNumberInputStream, DataInputStream, and PushbackInputStream etc.\n" +
                    "\n" +
                    "The extra functionality given by the LineNumberInputStream is, it adds line numbers in the destination file that does not exist in the source file. PushbackInputStream pushes back the extra unwanted character back to the system and is generally used in compilers and parsers etc.\n" +
                    "\n" +
                    "Filter streams does not read or write to a file directly. Always input for a high-level stream is a low-level stream. And also a high level stream can be linked to another high-level stream. The following code snippet illustrates:\n" +
                    "\n" +
                    "Connecting a low-level stream to a high-level stream:\n" +
                    "// a low-level stream\n" +
                    "FileInputStream fis = new FileInputStream( \"a.java\" ) ;\n" +
                    "// a high-level stream\n" +
                    "DataInputStream dis = new DataInputStream( fis ) ;\n" +
                    "In the above code, fis, a low-level input stream is passed as parameter to a high-level stream, DataInputStream.\n" +
                    "\n" +
                    "Connecting a high-level stream to another high-level stream:\n" +
                    "// a low-level stream\n" +
                    "FileInputStream fis = new FileInputStream( \" a.java \" ) ;\n" +
                    "// a high-level stream\n" +
                    "BufferedInputStream bis = new BufferedInputStream( fis ) ;\n" +
                    "// a high-level stream\n" +
                    "DataInputStream dis = new DataInputStream( bis ) ;\n" +
                    "\n" +
                    "In the above code, bis, a high-level stream object is passed as a parameter to another high-level stream, DataInputStream.\n"});

        db.execSQL(sqlI,new String[]{"Byte Code & Unicode","Java introduces two new words to the computer world:-\n" +
                "i) Bytecode and\n" +
                "ii) Unicode.\n" +
                "\n" +
                "i) Bytecode:\n" +
                "When we compile a .java file, we get a .class file. The .class file can run on any operating system irrespective of platform on which it was compiled. For this reason, Java is called platform independent. But the .exe file of C language is not platform independent.\n" +
                "\n" +
                ".exe file contains binary code. Java's .class file contains bytecode. This bytecode makes Java cross platform. Java compiler produces bytecodes. Any JVM, can run these bytecode and produce output.\n" +
                "\n" +
                "Bytecode is a machine-independent intermediate language known to a Java interpreter. Java interpreter parses bytecode into an output. That is why Java is said, \"write once, run anywhere\".\n" +
                "\n" +
                "ii) Unicode:\n" +
                "ASCII(extended) character range is 0 to 255. We cannot add one more character, if we do want. Only English alphabets has got corresponding ASCII values. That is why we cannot write a C program in any other language than English.\n" +
                "\n" +
                "Java's motto is internationalization. That is, it supports many world languages, like Telugu, Kannada, Greek, Japanese etc. That is, there is a corresponding ASCII(Unicode) value in Java for all these international languages.\n" +
                "\n" +
                "This is possible due to the size of character of 2 bytes. That is, the character can represent values ranging from 0 to 65,535. This range is called Unicode. We can say ASCII is a subset of Unicode.\n" +
                "\n" +
                "Upto 255, Unicode represents ASCII range and afterwards it adds its own values for the alphabets of many world languages. Unicode is already includes up to 34,128 characters."});

        db.execSQL(sqlI,new String[]{"synchronized","Thread synchronization provides the tool for ensuring that different threads take proper turns when using shared resources.\n" +
                    "\n" +
                    "Thread synchronization is important in a multithreaded program to maintain the consistency and durability of data that is accessed by different threads.\n" +
                    "\n" +
                    "Multiple threads of a program run independently of one another. Each thread does not bother about the activities of other threads. When a thread works on its own and on separate data( i.e., not shard ), the data will not be in inconsistent state. The problem( due to inconsistency of data ) occurs when the same data is accessed( or shared ) by different threads.\n" +
                    "\n" +
                    "When the threads act on shared data, timing is an important issue. By the process of synchronization, we an ensure only one thread can access the source at a time and other threads should wait in a queue until the first thread comes out after finishing its execution.\n" +
                    "\n" +
                    "We use synchronized keyword to monitor the activities of different threads. We can use synchronized as an access modifier.When a thread is accessing the above update( ) method, other thread is not allowed to access it."});
             }

    private void requestAppPermissions() {
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            createDB();
        }

        if (hasReadPermissions() && hasWritePermissions()) {
            return;
        }

        try {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_STORAGE_REQUEST_CODE);
            createDB();
        } catch (Exception e) {
            e.printStackTrace();
         }
        // your request code
    }

    private boolean hasReadPermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    private boolean hasWritePermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

}
