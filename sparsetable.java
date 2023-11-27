package classes; 
import classes.studentlist.student; 
import classes.courselist.course; 


public class sparsetable {
    public void addstudenttocourse(student student,course course){
        int studentid=student.getStudentid();
        int courseid=course.getCourseid();
        celldata newcelldata = new celldata(studentid,courseid);
        if (course.getFirstcourse()==null) {
            course.setFirstcourse(newcelldata);
        }
        else{
            celldata curr= course.getFirstcourse();
            while (curr.getnextcilldataright()!=null) {
                curr=curr.getnextcilldataright();
            }
            curr.setnextcilldataright(newcelldata);
        }
        if (student.getfirststudentcelldata()==null) {
            student.setfirststudentcelldata(newcelldata);
        }
        else{
            celldata curr1= student.getfirststudentcelldata();
            while (curr1.getnextcilldatadown()!=null) {
                curr1=curr1.getnextcilldatadown();
            }
            curr1.setnextcilldatadown(newcelldata);
        }

    }
     public void deletstudentfromcourse(student student,course course){
        int studentid=student.getStudentid();
        int courseid=course.getCourseid();
        celldata newcelldata = new celldata(studentid,courseid);
        if (course.getFirstcourse()==null) {
            System.out.println("empty table");
            return;
        }
        else if (course.getFirstcourse().courseid==courseid) {
            course.firstcourse=course.firstcourse.getnextcilldataright();
        }
        else{
            celldata curr= course.getFirstcourse();
            while (curr.getnextcilldataright().courseid!=newcelldata.courseid) {
                curr=curr.getnextcilldataright();
            }
            curr.setnextcilldataright(curr.getnextcilldataright().getnextcilldataright());
        }
         if (student.getfirststudentcelldata()==null) {
                   System.out.println("emty table");
                 return;
             }
             else if (student.getfirststudentcelldata().studentid==studentid) {
            student.firststudentcelldata=student.firststudentcelldata.getnextcilldatadown();
        }
         else{
            celldata curr1= student.getfirststudentcelldata();
            while (curr1.getnextcilldatadown().studentid!=newcelldata.studentid) {
              curr1=curr1.getnextcilldatadown();
             }
             curr1.setnextcilldatadown(curr1.getnextcilldatadown().getnextcilldatadown());
         }

    }
    public void displaystudentcourses(student student){
        if (student.getfirststudentcelldata()==null) {
            System.out.println("no courses for "+ student.getStudentid());
        }
        else{
            celldata curr = student.getfirststudentcelldata();
            System.out.println(student.getStudentname());
            while (curr!=null) {
                System.out.println(curr.getCourseid());
                curr=curr.nextcilldatadown;
            }
        }
    } public void displaycoursestudents(course course){
        if (course.getFirstcourse()==null) {
            System.out.println("no courses for "+ course.getCourseid());
        }
        else{
            celldata curr = course.getFirstcourse();
            System.out.println(course.getCoursename());
            while (curr!=null) {
                System.out.println(curr.getStudentid());
                curr=curr.getnextcilldataright();
            }
        }
    }
    public static void main(String[] args) {
        studentlist studentlist = new studentlist();
        courselist courselist = new courselist();
        student ahmed  = studentlist.addnewstudent(22010030, "ahmed");
        student omar  = studentlist.addnewstudent(22050, "omar");
        student mohamed  = studentlist.addnewstudent(2460, "mohamed");
        course math = courselist.addnewcourse(567, "math");
        course datastructre = courselist.addnewcourse(300, "data structre");
        sparsetable sparsetable = new sparsetable();
        sparsetable.addstudenttocourse(mohamed, datastructre);
        sparsetable.addstudenttocourse(mohamed, math);
        sparsetable.addstudenttocourse(omar, datastructre);
        sparsetable.addstudenttocourse(ahmed, datastructre);
        sparsetable.addstudenttocourse(ahmed,math);
        sparsetable.displaycoursestudents(datastructre);
        sparsetable.displaystudentcourses(ahmed);
        sparsetable.displaystudentcourses(omar);
        sparsetable.displaystudentcourses(mohamed);
        studentlist.deletstudent(22050, "mohamed");
        System.out.println("student list after delet");
        studentlist.printstudentlist();
        courselist.deletcourse(300, "datastructre");
        System.out.println("course list after delet");
        courselist.printcourselist();
        System.out.println("after delet mohamed from data structre");
        sparsetable.deletstudentfromcourse(mohamed, datastructre);
        sparsetable.displaycoursestudents(datastructre);
        sparsetable.displaystudentcourses(mohamed);
    }
}

