import java.util.ArrayList;

public class Scenario {
    public static void main(String[] args){
        ArrayList<Evaluation> evals = new ArrayList<Evaluation>();
        Evaluation a = new Evaluation(1, 18);
        Evaluation b = new Evaluation(9, 15);
        Evaluation c = new Evaluation(4, 8);
        Evaluation d = new Evaluation(0, 20);
        evals.add(a);
        evals.add(b);
        evals.add(c);
        evals.add(d);

        Eleve e = new Eleve("Danvers", "Martin", evals);
        
        e.ecritureEleve("C:/Users/eve-a/OneDrive/Documents/IUT_Vannes/Semestre_deux/R202_dev_IHM/TP4/src/C/infos.bin");
        e.lectureEleve("C:/Users/eve-a/OneDrive/Documents/IUT_Vannes/Semestre_deux/R202_dev_IHM/TP4/src/C/infos.bin");
        e.compareMoyenne(13.214285714285714);
    }
}
