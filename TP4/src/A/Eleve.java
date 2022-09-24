import java.util.ArrayList;
import java.io.*;

public class Eleve {
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

    public void lectureEleve(String fichier) {
        try {
            // ouverture du fichier
            FileReader file = new FileReader(fichier);
            BufferedReader in = new BufferedReader(file);
            String s = in.readLine();
            // ligne à laquelle début les notes/coeffs
            int i = 3;
            // lecture de la première ligne seulement
            String nomLect = extractNom(s);
            String prenomLect = extractPrenom(s);

            //comparer nos elements de lecture pour verifier
            comparerString(nomLect, "nom");
            comparerString(prenomLect, "prenom");

            ArrayList <Evaluation> evalsLect = new ArrayList<Evaluation>();

            // liste d'évaluations
            while (s != null) {
                for(Evaluation eval : this.evals){
                    eval.lectureEvaluation(fichier, i);
                    i++;
                    s = in.readLine();
                }
            }
            
            //calcul et attribution de la moyenne
            setMoyenne(moyenne());

            //affiche rla moyenne pour verifier
            affMoyenne();

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
            FileWriter file = new FileWriter(fichier);
            BufferedWriter buf = new BufferedWriter(file);
            PrintWriter out = new PrintWriter(buf);

            //Ecriture des informations de l'eleve
            out.println(this.nom + "\t" + this.prenom);
            out.println("Notes" + "\t" + "Coefficients");
            //Pour chaque evaluation, nous ecrivons ses caracteristiques en appelant l'autre methode
            for(Evaluation eval : this.evals){
                eval.ecritureEvaluation(fichier,out);
            }

            // fermeture du fichier ouvert en lecture
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String extractNom(String ligne) {
        boolean space = false;
        int i = 0;
        while (i < ligne.length() && !space) {
            if (Character.isWhitespace(ligne.charAt(i)))
                space = true;
            i++;
        }
        i--;
        String nom = ligne.substring(0, i);
        nom = nom.trim();
        return nom;
    }

    private String extractPrenom(String ligne) {
        boolean space = false;
        boolean digit = false;
        int i = 0;
        int start;
        // sauter le nom
        while (i < ligne.length() && !space) {
            if (Character.isWhitespace(ligne.charAt(i)))
                space = true;
            i++;
        }
        // enregistrer l'indice du début du prénom
        start = i;
        // lire jusqu'au début du prénom
        while (i < ligne.length() && !digit) {
            if (Character.isDigit(ligne.charAt(i)))
                digit = true;
            i++;
        }
        // remettre space à false
        space = false;
        // extraire le prénom
        while (i < ligne.length() && !space) {
            if (Character.isWhitespace(ligne.charAt(i)))
                space = true;
            i++;
        }
        String prenom = ligne.substring(start, i);
        prenom = prenom.trim();
        return prenom;
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

    private void affMoyenne(){
        System.out.println("La moyenne est de : " + this.moyenne);
    }
}
