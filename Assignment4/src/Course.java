public class Course {
    //data declaration
    private String courseName;
    private String courseCode;
    private String classTerm;
    private Person instructor;
    private Person[] teachAsst;
    private Person[] student;

    //method declarations
    //setter method
    public void setCourseName(String inCourseName) {
        courseName = upperCamelCase(inCourseName);
    }

    public void setCourseCode(String inCourseCode) {
        courseCode = inCourseCode.toUpperCase();
    }

    public void setClassTerm(String inClassTerm) {
        classTerm = upperCamelCase(inClassTerm);
    }

    public void setInstructor(Person inInstructor) {
        instructor = inInstructor;
    }

    public void setTeachAsst(Person[] inTeachAsst) {
        teachAsst = inTeachAsst;
    }

    public void setStudent(Person[] inStudent) {
        student = inStudent;
    }

    //getter method
    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getClassTerm() {
        return classTerm;
    }

    public Person getInstructor() {
        return instructor;
    }

    public Person[] getTeachAsst() {
        return teachAsst;
    }

    public Person[] getStudent() {
        return student;
    }

    //constructor method
    public Course() {
        courseName = null;
        courseCode = null;
        classTerm = null;
        instructor = null;
        teachAsst = new Person[0];
        student = new Person[0];
    }

    public Course(String inCourseName, String inCourseCode, String inClassTerm, Person inInstructor, Person[] inTeachAsst, Person[] inStudent) {
        courseName = inCourseName;
        courseCode = inCourseCode;
        classTerm = inClassTerm;
        instructor = inInstructor;
        teachAsst = new Person[inTeachAsst.length];
        for(int i=0; i< inTeachAsst.length;i++)
        {
            teachAsst[i]=new Person(inTeachAsst[i]);
        }
        student = new Person[inStudent.length];
        for (int i=0; i< inStudent.length;i++)
        {
            student[i]=new Person(inStudent[i]);
        }
    }

    //count TA and student.
    public String toString() {
        return upperCamelCase(courseName) + " ("+courseCode.toUpperCase() +"): " +
                upperCamelCase(classTerm)+"\nInstructor: Dr."+instructor.toString()+"\nTeaching Asssistants: "
                +teachAsst.length+" TAs\nClass Size: " +student.length+ " students";
    }

    //custom method
    public void appendToPersonArr(Person[] srcArr, int mode) {
        if (mode == 103) {
            Person[] temp = new Person[teachAsst.length + srcArr.length];
            int index = 0;
            // copy existing array to temp
            for (Person person : teachAsst) {
                temp[index++] = person;
            }
            for (Person newPerson : srcArr) {
                boolean foundPerson = false; // flag to indicate if the person already exists in the array
                for (Person person : temp) {
                    if (person != null && person.equals(newPerson)) {
                        foundPerson = true;
                        break;
                    }
                }
                if (!foundPerson) {
                    temp[index++] = newPerson;  // tmp = [A, B, C, null, null] -> [A, B, C]
                    System.out.printf("Successfully Added: %s, %s (%s).%n", newPerson.getLastName(), newPerson.getFirstName(), newPerson.getEntityID());
                } else {
                    System.out.printf("Already Exists: %s, %s (%s).%n", newPerson.getLastName(), newPerson.getFirstName(), newPerson.getEntityID());
                }
            }
            // copy temp to teachAsst
            setTeachAsst(removeNullPersonArr(temp));
        }
        // mode = 104: append to student
        if (mode == 104) {
            Person[] temp = new Person[student.length + srcArr.length];
            int index = 0;
            // copy existing array to temp
            for (Person person : student) {
                temp[index++] = person;
            }
            for (Person newPerson : srcArr) {
                boolean foundPerson = false; // flag to indicate if the person already exists in the array
                for (Person person : temp) {
                    if (person != null && person.equals(newPerson)) {
                        foundPerson = true;
                        break;
                    }
                }
                if (!foundPerson) {
                    temp[index++] = newPerson;
                    System.out.printf("Successfully Added: %s, %s (%s).\n", newPerson.getLastName(), newPerson.getFirstName(), newPerson.getEntityID());
                } else {
                    System.out.printf("Already Exists: %s, %s (%s).\n", newPerson.getLastName(), newPerson.getFirstName(), newPerson.getEntityID());
                }
            }
            // copy temp to student
            setStudent(removeNullPersonArr(temp));
        }
    }


    private boolean arrayIsEmpty(Person[] personArr) {
        boolean allNull = true;
        for (Person person : personArr) {
            if (person != null) {
                allNull = false;
                break;
            }
        }
        return allNull;
    }

    private Person[] removePerson(String[] inStrArr, Person[] personArr) {
        for (String s : inStrArr) {
            if (arrayIsEmpty(personArr)) {
                System.out.println("You cannot delete any entity from an EMPTY array.");
                continue;
            }
            boolean foundPerson = false;
            for (int j = 0; j < personArr.length; j++) {
                if (personArr[j] != null && s.equals(personArr[j].getEntityID())) {
                    System.out.printf("Successfully Deleted: %s, %s (%s).\n", personArr[j].getLastName(), personArr[j].getFirstName(), personArr[j].getEntityID());
                    personArr[j] = null;
                    foundPerson = true;
                    break;
                }
            }
            if (!foundPerson) {
                System.out.printf("Entity NOT found: %s.\n", s);
            }
        }
        return removeNullPersonArr(personArr);
    }

    public void deleteFromPersonArr(String inStr, int mode) {
        //split inStr into an array of Strings
        String[] inStrArr = inStr.split(";");
        // mode 103 unenroll Teaching Assistants
        // remove value of inStrArr from teachAsst
        if (mode == 103) {
            setTeachAsst(removePerson(inStrArr, teachAsst));
        }
        // mode 104 unenroll Students
        // remove value of inStrArr from student
        if (mode == 104) {
            setStudent(removePerson(inStrArr, student));
        }
    }

    public void updatePersonScore(String inStr, int mode) {
        String[] idScore = inStr.split(";");
        if (mode == 106) {
            for (String s : idScore) {
                if (arrayIsEmpty(student)) {
                    System.out.println("You cannot add/update score using an EMPTY array.");
                    continue;
                }
                boolean foundPerson = false;
                String[] sArr = s.split(",");
                for (Person person : student) {
                    if (person != null && sArr[0].equals(person.getEntityID())) {
                        person.setScorePercent(Double.parseDouble(sArr[1]));
                        System.out.println("Successfully Added/Updated: Score for "+ person +".");
                        foundPerson = true;
                        break;
                    }
                }
                if (!foundPerson) {
                    System.out.println("Entity NOT found: " +sArr[0]+".");
                }
            }
        }
    }


    //custom method to upperCamelcase for courseName, courseTerm.
    public static String upperCamelCase(String inStr) {
        // left-trimmed and right-trimmed inStr
        // return camelCase version of inStr
        inStr = inStr.trim();
        inStr = inStr.substring(0, 1).toUpperCase() + inStr.substring(1).toLowerCase();
        return inStr;
    }
    //custom method :removes null elements from Person[] srcArr
    public Person[] removeNullPersonArr(Person[] srcArr) {
        int nullCount = 0;
        for (Person person : srcArr) {
            if (person == null) {
                nullCount++;
            }
        }
        Person[] tempArr = new Person[srcArr.length - nullCount];
        int tempArrIndex = 0;
        for (Person person : srcArr) {
            if (person != null) {
                tempArr[tempArrIndex] = person;
                tempArrIndex++;
            }
        }
        srcArr = tempArr;
        return srcArr;
    }

}
