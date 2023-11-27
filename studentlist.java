 package classes;
public class studentlist {
    student firststudent;
    public class student{
        int studentid;
        String studentname;
        student nextstudent;
        celldata firststudentcelldata;
        public student(int studentid,String studentname){
            this.studentid=studentid;
            this.studentname=studentname;
        }
        public int getStudentid() {
            return studentid;
        }
        public String getStudentname() {
            return studentname;
        }
        public celldata getfirststudentcelldata(){
            return this.firststudentcelldata;
        }
        public void setfirststudentcelldata(celldata firststudentcelldata){
             this.firststudentcelldata=firststudentcelldata;
        }
          
    }
    public student addnewstudent(int studentid,String studentname){
        student newstudent = new student(studentid,studentname);
        if (firststudent==null) {
            firststudent=newstudent;
            firststudent.nextstudent=null;
        }
        else{
         student curr = firststudent;
         while (curr.nextstudent!=null) {
            curr=curr.nextstudent;
         }
         curr.nextstudent=newstudent;

        }
        return newstudent;
    }
    public void deletstudent(int studentid,String studentname){
        if (firststudent==null) {
            System.out.println("empty syudent list");
        }else if(firststudent.nextstudent==null){
            firststudent=null;
        }
        else if(firststudent.studentid==studentid){
            firststudent=firststudent.nextstudent;
        }
        else{
            student curr = firststudent;
             for(;curr.nextstudent.studentid!=studentid && curr.nextstudent!=null;curr=curr.nextstudent);
             curr.nextstudent=curr.nextstudent.nextstudent;
         }
    }
    public void printstudentlist(){
        student curr = firststudent;
        while (curr!=null) {
            System.out.println(curr.studentname);
            curr=curr.nextstudent;
        }

    }
}
