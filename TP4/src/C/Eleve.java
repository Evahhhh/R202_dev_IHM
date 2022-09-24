import java.util.ArrayList;
import java.io.*;

public class Eleve implements Serializable{
    private String nom;
    private String prenom;
    private ArrayList<Evaluation> evals;
    private double moyenne;

    public Eleve(String nom, String prenom, ArrayList<Evaluation> evals) {
        this.nom = nom;
        this.prenom = prenom;
        this.evals = evals;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public double moyenne() {
        double moy;
        double sum = 0;
        double coeff = 0;
        for (Evaluation eval : this.evals) {
            sum += eval.getCoeff() * eval.getNote();
            coeff += eval.getCoeff();
        }
        moy = sum / coeff;
        return moy;
    }

    public void lectureEleve(String fichier){
        try {
            // ouverture du fichier
            ObjectInputStream in = new ObjectInputStream( new FileInputStream(fichier));
            // ligne à laquelle début les notes/coeffs
            int i = 3;
            // lecture de la première ligne seulement
            String nomLect = in.readUTF();
            String prenomLect = in.readUTF();

            //comparer nos elements de lecture pour verifier
            comparerString(nomLect, "nom");
            comparerString(prenomLect, "prenom");

            //listes d'evalations
            ArrayList <Evaluation> evalsLect = new ArrayList<Evaluation>();
            for(Evaluation eval : this.evals){
                eval.lectureEvaluation(fichier, in);
                i++;
            }

            // fermeture du fichier ouvert en lecture
            in.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ecritureEleve(String fichier) {
        try {
            // ouverture du fichier
            FileOutputStream streamFile = new FileOutputStream(fichier);
            BufferedOutputStream buffFile = new BufferedOutputStream(streamFile);
            ObjectOutputStream out = new ObjectOutputStream(buffFile);

            //Ecriture des informations de l'eleve
            out.writeUTF(this.nom);
            out.writeUTF(this.prenom);

            //Pour chaque evaluation, nous ecrivons ses caracteristiques en appelant l'autre methode
            for(Evaluation eval : this.evals){
                eval.ecritureEvaluation(out);
            }

            //calcul et attribution de la moyenne
            setMoyenne(moyenne());
            //ecrire la moyenne
            out.writeDouble(this.moyenne);
            //fermeture du fichier ouvert
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void comparerString(String val,String compare){
        if(compare.equals("nom")){
            if(this.nom.equals(val)) System.out.println("Le nom est egal");
            else System.out.println("Le nom n'est pas egal : " + val);
        }
        else if(compare.equals("prenom")){
            if(this.prenom.equals(val)) System.out.println("Le prenom est egal");
            else System.out.println("Le prenom n'est pas egal : " + val);
        }else System.out.println("veuillez comparer a une valeur existante");
    }

    public void compareMoyenne(Double val){
        if(this.moyenne == val) System.out.println("La moyenne est egale");
        else System.out.println("La moyenne n'est pas egale : " + val);
    }
}
