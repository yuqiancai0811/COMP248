public class Person {
    //data declarations
    private String entityID;
    private String firstName;
    private String lastName;
    private double scorePercent;

    //method declarations
    //setter method(Sets the data X and makes sure it stays in a coherent state)
    public void setEntityID(String inEntityID) {
        entityID = inEntityID;
    }

    public void setFirstName(String inFirstName) {
        firstName = upperCamelCase(inFirstName);
    }

    public void setLastName(String inLastName) {
        lastName = upperCase(inLastName);
    }

    public void setScorePercent(double inScorePercent) {
        scorePercent = inScorePercent;
    }

    //getter method (return the value of data ID,firstName, lastName)
    public String getEntityID() {
        return entityID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getScorePercent() {
        return scorePercent;
    }

    //constructor method(initialize and overloaded for different amounts of parameters )
    public Person() {
        entityID=null;
        firstName=null;
        lastName=null;
        scorePercent=0.0;
    }

    public Person(String inEntityID, String inFirstName, String inLastName) {
        entityID = inEntityID;
        firstName = inFirstName;
        lastName = inLastName;
    }

    public Person(Person objPerson) {
        entityID = objPerson.entityID;
        firstName = objPerson.firstName;
        lastName = objPerson.lastName;
        scorePercent = objPerson.scorePercent;
    }

    //equal method
    public boolean equals(Person anotherPerson) {
        return (entityID.equals(anotherPerson.entityID));
    }

    //toString method
    public String toString() {
        return lastName +", "+ firstName +" "+"("+ entityID+")";
    }

    //custom method
    public static String upperCamelCase(String inStr) {
        inStr = inStr.trim();
        inStr = inStr.substring(0, 1).toUpperCase() + inStr.substring(1).toLowerCase();
        return inStr;

    }

    public static String multiUpperCamelcase(String inStr) {
        // concordia university => Concordia University
        String[] inStrArr = inStr.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inStrArr.length; i++) {
            inStrArr[i] = upperCamelCase(inStrArr[i]);
            result.append(inStrArr[i]);
        }
        //["Concordia", "University"]

        return result.toString();
    }

    public static String upperCase(String inStr) {
        inStr = inStr.trim();
        inStr = inStr.toUpperCase();
        return inStr;
    }

    public static Person[] inStrToPersonArr(String inStr) {
        String[] inStrToPersonArr = inStr.split(";");
        Person[] personArr = new Person[inStrToPersonArr.length];
        for (int i = 0; i < inStrToPersonArr.length; i++) {
            String[] temp = inStrToPersonArr[i].split(",");
            Person person = new Person(temp[0], upperCamelCase(temp[1]), upperCase(temp[2]));
            personArr[i] = person;
        }
        return personArr;
    }

}
