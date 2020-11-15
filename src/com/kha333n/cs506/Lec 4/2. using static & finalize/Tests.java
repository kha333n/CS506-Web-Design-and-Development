// File Tests.java
public class Tests {

    public static void main(String args[]) {
        int numObjects;

        // printing current number of objects i.e 0
        numObjects = Students.getCountStudents();
        System.out.println("Students Objects" + numObjects);

        // Creating first student object & printing its values
        Students s1 = new Students("ali", 15);
        System.out.println("Student: " + s1.toString());

        // printing current number of objects i.e. 1
        numObjects = Students.getCountStudents();
        System.out.println("Students Objects" + numObjects);

        // Creating second student object & printing its values
        Students s2 = new Students("usman", 49);

        // implicit call to toString() method
        System.out.println("Student: " + s2);

        // printing current number of objects i.e. 2
        numObjects = Students.getCountStudents();
        System.out.println("Students Objects" + numObjects);

        // loosing object reference
        s1 = null;

        // requesting JVM to run Garbage collector but there is

        // no guarantee that it will run
        System.gc();

        // printing current number of objects i.e. unpredictable
        numObjects = Students.getCountStudents();
        System.out.println("Students Objects" + numObjects);
    } //end of main
} //end of class