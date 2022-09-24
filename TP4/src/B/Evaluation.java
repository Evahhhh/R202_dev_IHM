import java.io.*;

public class Evaluation{
    private double coeff;
    private double note;

    public Evaluation(double coeff, double note) {
        this.coeff = coeff;
        this.note = note;
    }

    public double getCoeff() {
        return this.coeff;
    }

    public double getNote() {
        return this.note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public void lectureEvaluation(String fichier, DataInputStream in) throws IOException{
        try {
            double noteLect = in.readDouble();
            double coeffLect = in.readDouble();

            //comparer nos elements de lecture
            comparer(noteLect, "note");
            comparer(coeffLect, "coeff");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ecritureEvaluation(DataOutputStream out) throws IOException{           
        //Ecriture des informations de l'eval
        out.writeDouble(this.note);
        out.writeDouble(this.coeff);
    }

    private void comparer(double val,String compare){
        if(compare.equals("coeff")){
            if(this.coeff == val) System.out.println("Le coeff est egal");
            else System.out.println("Le coeff n'est pas egal : " + val );
        }
        else if(compare.equals("note")){
            if(this.note == val) System.out.println("La note est egale");
            else System.out.println("La note n'est pas egale : " + val);
        }else System.out.println("veuillez comparer a une valeur existante");
    }
}
