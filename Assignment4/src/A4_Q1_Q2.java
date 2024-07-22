import java.util.Scanner;

// -------------------------------------------------------
// Assignment {4}
// Written by: {Yuqian cai}
// --------------------------------------------------------

//Test samples:
// oBjEcT-oRiEnTeD-pRoGrAmMiNg-I cOmP-248 WiNtEr-2023
// 4012573 AlphA BraVo
// 40001000,ChArLiE,DeLtA;40001000, ChArLiE,DeLtA;40002000,EcHo,FoXtRoT;40003000,GolF,HoTel;40004000,InDiA,JuLiEtT
// 20001000,KiLo,LiMa;20002000,MiKe,NovEmBeR;20003000,OsCaR,Papa;20004000,QueBec,RoMeO;20005000,SiErRa,TaNgO
// 40006600,JaNe,Doe
// 103
// 40001000;40002000;40003000;40004000

// 103
// 40001000,ChArLiE,DeLtA;40001000, ChArLiE,DeLtA;40002000,EcHo,FoXtRoT;40003000,GolF,HoTel;40004000,InDiA,JuLiEtT
// 40000000;40001000;40002000;40002500;40003000;40004000;400005000

// 104
// 20001000;20002000;20003000;20004000;20005000

// 104
// 20001000,KiLo,LiMa;20002000,MiKe,NovEmBeR;20003000,OsCaR,Papa;20004000,QueBec,RoMeO;20005000,SiErRa,TaNgO
// 20006600,JaNe,Doe
// 20000000;20001000;20002000;20002500;20003000;20004000;20005000;20004500

// 105 || 103
// 40001000;40002000;40003000;40004000

// 106
// 20001000,88;20002000,70;20003000,100;20004000,90;20005000,75

// 104
// 20001000,KiLo,LiMa;20002000,MiKe,NovEmBeR;20003000,OsCaR,Papa;20004000,QueBec,RoMeO;20005000,SiErRa,TaNgO
// 106
// 20001000,88;20002000,70;20003000,100;20003500,77;20004000,90;20005000,75;20004500,84
// 20001000,77;20002000,89;20003000,68;20004000,55;20005000,99
// 20003500,57;20005500,51;20004500,71

// 103 || 104 || 107
// 40006000,ViCtOr,WhIsKeY;40007000,YaNkEe,ZuLu
// 20006000,ViCtOr,ZuLu;20007000,ChArLiE,ZuLu
public class A4_Q1_Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //data declaration
        String codeStr;
        boolean enterNumber = true;
        Course course = new Course();
        Person[] teachAsst=new Person[0];
        Person[] students=new Person[0];


        //welcome message
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+ Welcome to the Simple Learning Management System +");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        System.out.println("Code => Description");
        System.out.println("++++++++++++++++++++");
        System.out.println("101 => Define Class/Course");
        System.out.println("102 => Add Instructor for Class/Course");
        System.out.println("103 => Add Teaching Assistants (TAs) for Class/Course");
        System.out.println("104 => Enrol Student(s) to Class/Course");
        System.out.println("105 => Unenroll Teaching Assistant(s) and/or Student(s)");
        System.out.println("106 => Enter/Update Student(s) Scores");
        System.out.println("107 => Display Students' Statistics");
        System.out.println("108 => Display Class/Course Statistics");
        System.out.println("109 => Display Scoresheet");
        System.out.println("110 => Exit");
        System.out.print("\nPlease enter a Code, from the aforementioned, that corresponds to your task: ");

        while (enterNumber) {
            codeStr = input.nextLine();
            int code = Integer.parseInt(codeStr);
            if (code == 101) {
                System.out.println("\n\n...Define Class/Course...\n.........................");
                System.out.println("Enter class/course information (CourseName CourseCode Term) as a single line entry:");
                String entry = input.nextLine();
                String[] temp = entry.split(" ");
                course.setCourseName(temp[0]);
                course.setCourseCode(temp[1]);
                course.setClassTerm(temp[2]);
                System.out.print("\nSuccessful operation! Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
            } else if (code == 102) {
                System.out.println("\n\n...Add Instructor for Class/Course...\n.....................................");
                System.out.println("Enter instructor's information (EmployeeID FirstName LastName) as a single-line entry:");
                String entry2 = input.nextLine();
                String[] temp = entry2.split(" ");
                Person instructor = new Person(temp[0], temp[1], temp[2]);
                course.setInstructor(instructor);
                System.out.print("\nSuccessful operation! Kindly continue by entering a Code, from the menu above, that corresponds to your task:");
            } else if (code == 103) {
                System.out.println("\n\n...Add Teaching Assistants (TAs) for Class/Course...\n...................................................");
                System.out.println("Enter TAs information(ID1,FirstName1,LastName1;ID2,FirstName2,LastName2):");
                String entry3 = input.nextLine();
                teachAsst = Person.inStrToPersonArr(entry3);
                course.appendToPersonArr(teachAsst,code);
                System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task:");

            } else if (code == 104) {
                System.out.println("\n\n...Enrol Student(s) to the Class/Course...\n........................................");
                System.out.println("Enter Students information(ID1,FirstName1,LastName1;ID2,FirstName2,LastName2):");
                String entry4= input.nextLine();
                students=Person.inStrToPersonArr(entry4);
                course.appendToPersonArr(students,code);
                System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task:");

            } else if (code == 105) {
                System.out.println("\n\n...Unenroll Teaching Assistant(s) and/or Student(s)...\n..................................................");
                System.out.println("Enter '103' to unenroll Teaching Assistant(s) and '104' to unenroll Student(s):");
                String taOrstu= input.nextLine();
                int taOrStudent = Integer.parseInt(taOrstu);
                System.out.println("Enter information of entities (ID1;ID2):");
                if(taOrStudent==103)
                {
                    String taIdArr= input.nextLine();
                    course.deleteFromPersonArr(taIdArr,taOrStudent);
                }
                if(taOrStudent==104)
                {
                    String stuIdArr= input.nextLine();
                    course.deleteFromPersonArr(stuIdArr,taOrStudent);
                }
                System.out.print("\nKindly continue by entering a Code, from the menu above, that corresponds to your task:");
            } else if (code == 106) {
                System.out.println("\n\n...Enrol/Update Student(s) Scores...\n..................................");
                System.out.println("Enter Students' Scores (ID1,Score1;ID2,Score2):");
                String entry6=input.nextLine();
                course.updatePersonScore(entry6,code);
                System.out.print("\nKindly continue by entering a Code, from the menu above, that corresponds to your task:");

            } else if (code == 107) {
                System.out.println("\n\n...Display Students' Statistics...\n.................................");
                System.out.println(course);
                System.out.println("........................................");
                for(int i =0; i<students.length;i++)
                {
                    System.out.println(i+1+". "+students[i].toString());
                }
                System.out.println("........................................");
                System.out.print("\nKindly continue by entering a Code, from the menu above, that corresponds to your task:");

            } else if (code == 108) {
                System.out.println("\n\n.........................Class/Course Statistics............................");
                System.out.println(".............................................................................");
                System.out.printf(". Course Name           : %-45s .\n", course.getCourseName());
                System.out.printf(". Course Code           : %-45s .\n", course.getCourseCode());
                System.out.printf(". Term/Semester         : %-45s .\n", course.getClassTerm());
                System.out.printf(". Instructor Name       : Dr. %-41s .\n", course.getInstructor().getLastName() + ", " + course.getInstructor().getFirstName() + " (" + course.getInstructor().getEntityID() + ")");
                for (int i = 0; i < teachAsst.length; i++) {
                    System.out.printf(". Teaching Assistant %2d : %-45s .\n", (i + 1), teachAsst[i].getLastName() + ", " + teachAsst[i].getFirstName() + " (" + teachAsst[i].getEntityID() + ")");
                }
                System.out.printf(". Enrolled Students     : %-45d .\n", students.length);
                System.out.println(".........................................................................");
                System.out.print("\nKindly continue by entering a Code, from the menu above, that corresponds to your task:");
            } else if (code == 109) {
                System.out.println(".........................Class/Course Scoresheet.........................");
                System.out.println(". S/N. STUDENT ID  SURNAME               First Name               Score .");
                System.out.println(".........................................................................");
                for (int i = 0; i < students.length; i++) {
                    System.out.printf(". %3d. %-10s %-22s %-22s %6.2f  .\n", (i + 1), students[i].getEntityID(), students[i].getLastName(), students[i].getFirstName(), students[i].getScorePercent());
                }
                System.out.println(".........................................................................");

            } else if (code == 110) {
                enterNumber = false;
                System.out.println("Simple LMS >>> Exiting...");
                System.out.println("\nThank you for patronizing our Simple Learning Management System (Simple LMS).");
            }
        }

    }
}
