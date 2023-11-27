package classes;


public class courselist {
    course firstcourse;
    public  class course{
        int courseid;
        String coursename;
        course nextcourse;
        celldata firstcourse;
        public course(int courseid, String coursename){
            this.courseid=courseid;
            this.coursename=coursename;
        }
        public int getCourseid() {
            return courseid;
        }
        public String getCoursename() {
            return coursename;
        }
        public celldata getFirstcourse() {
            return firstcourse;
        }
        public void setFirstcourse(celldata firstcourse) {
            this.firstcourse = firstcourse;
        }
        
    }
    public course addnewcourse(int courseid,String coursename){
        course newcourse = new course(courseid, coursename);
        if (firstcourse==null) {
            firstcourse=newcourse;
            firstcourse.nextcourse=null;
        }
        else{
            course curr = firstcourse;
            while (curr.nextcourse!=null) {
                curr=curr.nextcourse;
            }
            curr.nextcourse=newcourse;

        }
        return newcourse;
    }
     public void deletcourse(int courseid,String coursename){
        if (firstcourse==null) {
            System.out.println("empty syudent list");
        }else if(firstcourse.nextcourse==null){
            firstcourse=null;
        }
        else if(firstcourse.courseid==courseid){
            firstcourse=firstcourse.nextcourse;
        }
        else{
            course curr = firstcourse;
             for(;curr.nextcourse.courseid!=courseid && curr.nextcourse!=null;curr=curr.nextcourse);
             curr.nextcourse=curr.nextcourse.nextcourse;
         }
    }
    public void printcourselist(){
        course curr = firstcourse;
        while (curr!=null) {
            System.out.println(curr.coursename);
            curr=curr.nextcourse;
        }

    }
}
