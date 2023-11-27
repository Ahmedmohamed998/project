package classes;
public class celldata {
    int studentid;
    int courseid;
    celldata nextcilldataright;
    celldata nextcilldatadown;
    public celldata(int studentid,int courseid){
        this.studentid=studentid;
        this.courseid=courseid;
    }
    public celldata getnextcilldataright() {
        return nextcilldataright;
    }
    public void setnextcilldataright(celldata nextcilldataright) {
        this.nextcilldataright = nextcilldataright;
    }
    public celldata getnextcilldatadown() {
        return nextcilldatadown;
    }
    public void setnextcilldatadown(celldata nextcilldatadown) {
        this.nextcilldatadown = nextcilldatadown;
    }
    public int getStudentid() {
        return studentid;
    }
    public int getCourseid() {
        return courseid;
    }
    
}
