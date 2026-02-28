import java.util.*;
class Student implements Comparable{
    int roll;
    int marks;
    String name;
    public Student(String name,int roll, int marks){
        this.roll = roll;
        this.marks= marks;
        this.name = name;
    }
    @Override
    public int compareTo(Object other){
        Student ot = (Student) other;
        // min heap this -  other 
        //max heap other - this
        return this.marks - ot.marks;
    }
    public String toString(){
        return this.name + "-"+this.roll+"-"+this.marks;
    }
}
class studentcomparator implements Comparator<Student>{
    public int compare(Student t , Student o){
        return t.roll-o.roll;
    }
    
}
public class comparable1{
    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>(new studentcomparator());
        PriorityQueue<Student> pq = new PriorityQueue<>( (Student s1 , Student s2)->{
            return s1.roll-s2.roll;
        });
        pq.add(new Student("sai", 10, 50));
        pq.add(new Student("ki", 11, 40));
        pq.add(new Student("ui", 12, 30));
        while(pq.size()>0){
            System.out.println(pq.remove());
        }
    }
}