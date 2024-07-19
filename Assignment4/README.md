# COMP248 Java Assignment 4

This folder contains three Java programs designed for a Simple Learning Management System (Simple LMS) to manage courses and users.

## Programs

### 1. Person Class (Person.java)

**Description:**
This class defines a `Person` with attributes such as entityID, firstName, lastName, and scorePercent. It includes getter and setter methods for these attributes, constructors for creating `Person` objects, and custom methods for formatting strings and handling arrays of `Person` objects.

**Methods:**
- `setEntityID(String inEntityID)`
- `setFirstName(String inFirstName)`
- `setLastName(String inLastName)`
- `setScorePercent(double inScorePercent)`
- `getEntityID()`
- `getFirstName()`
- `getLastName()`
- `getScorePercent()`
- `upperCamelCase(String inStr)`
- `multiUpperCamelcase(String inStr)`
- `upperCase(String inStr)`
- `inStrToPersonArr(String inStr)`

### 2. Course Class (Course.java)

**Description:**
This class defines a `Course` with attributes such as courseName, courseCode, classTerm, instructor, teachAsst, and student. It includes getter and setter methods for these attributes, constructors for creating `Course` objects, and custom methods for managing arrays of `Person` objects within a course.

**Methods:**
- `setCourseName(String inCourseName)`
- `setCourseCode(String inCourseCode)`
- `setClassTerm(String inClassTerm)`
- `setInstructor(Person inInstructor)`
- `setTeachAsst(Person[] inTeachAsst)`
- `setStudent(Person[] inStudent)`
- `getCourseName()`
- `getCourseCode()`
- `getClassTerm()`
- `getInstructor()`
- `getTeachAsst()`
- `getStudent()`
- `appendToPersonArr(Person[] srcArr, int mode)`
- `deleteFromPersonArr(String inStr, int mode)`
- `updatePersonScore(String inStr, int mode)`
- `courseStats()`
- `scoreSheet()`

### 3. Driver Class (A4_Q1_Q2.java)

**Description:**
This is the driver class for the Simple LMS application. It contains the `main` method which serves as the primary entry point into the application. It defines all the menu codes/options (101 to 110) and manages the interaction with the user to perform various tasks such as defining a class, adding instructors and students, updating scores, and displaying statistics.

**Usage:**
1. Define Class/Course (Menu Code 101)
2. Add Instructor for Class/Course (Menu Code 102)
3. Add Teaching Assistants (TAs) for Class/Course (Menu Code 103)
4. Enroll Student(s) to Class/Course (Menu Code 104)
5. Unenroll Teaching Assistant(s) and/or Student(s) (Menu Code 105)
6. Enter/Update Student(s) Scores (Menu Code 106)
7. Display Students' Statistics (Menu Code 107)
8. Display Class/Course Statistics (Menu Code 108)
9. Display Scoresheet (Menu Code 109)
10. Exit (Menu Code 110)

## IDE

- **IntelliJ IDEA Version:** 2022.3.1

## How to Run

1. Open the desired program (`A4_Q1_Q2.java`, `Course.java`, or `Person.java`) in IntelliJ IDEA.
2. Run the `main` method in `A4_Q1_Q2.java`.
3. Follow the prompts to enter the required information and navigate through the menu options.
4. The program will display the output based on the selected menu options.

## Authors

- Yuqian Cai (COMP248, Winter 2023)

---

**Note:** Ensure you have Java installed on your machine and configured in your IDE to run these programs.
