package flyweightpattern;

public class FlyweightPattern {

    public static void main(String[] args) {
        
        String name[] = {"qt", "vqt", "quangtin"};
        int id[] = {1001,1002,1003};
        int score[] = {45, 76, 87};
        
        double total = 0;
        for (int i = 0; i < score.length; i++) {
            total += score[i];
        }
        
        double averageScore = total/score.length;
        // way: 1
        //Student student = new Student(averageScore);
        // way: 2
        StudentThreaded student = StudentThreaded.getInstance();
        student.setAverageScore(averageScore);
        
        for (int i = 0; i < score.length; i++) {
            student.setName(name[i]);
            student.setId(id[i]);
            student.setScore(score[i]);
            
            System.out.println("Name: " + student.getName());
            System.out.println("Standing: " + Math.round(student.getStanding()));
            System.out.println("");
        }
    }
}