import java.io.*;

public class Evaluation {
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

    public void lectureEvaluation(String fichier, int nbLine) {
        try {
            // ouverture du fichier
            File file = new File(fichier);
            Reader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            // Creation de nos variables utiles
            String line;
            int lines = 0;
            // parcours de chaque ligne jusqu'à ce qu'il est tout parcouru
            while((line = br.readLine()) != null) {
                // variable d'itération
                lines++;
                // on vérifie si la ligne actuelle correspond à la ligne demandé
                if (lines == nbLine) {
                    // On essaye de set notre note et notre coeff
                    try {
                        /* - Recuperer la partie de la ligne qui correspondant a la note 
                          soit entre l'indice 0 et le premier espace 
                          Puis on le parse en nombre pour pouvoir set la note*/
                        double noteLect = Double.parseDouble(line.substring(0, line.indexOf(" ")));
                        /*- Rcuperer la seconde partie de notre fichier qui correspond au coefficient
                         soit a partir du premier espace jusqu'a la fin 
                        Puis replacer les espaces par rien afin de n'avoir qu'un nombre pour pouvoir set le coefficient
                         Puis on le parse en nombre pour pouvoir set notre coefficient*/
                        double coeffLect = Double.parseDouble(line.substring(line.indexOf(" ")).replace(" ", ""));

                        //comparer nos elements de lecture
                        comparer(noteLect, "note");
                        comparer(coeffLect, "coeff");
                    }catch (NumberFormatException e) {
                        // Si cela ne marche pas on affiche rien et on continue pour ne pas bloquer le programme
                        e.getMessage();
                        System.out.println("error");
                        continue;
                    }
                }
            }
            // fermeture du fichier ouvert en lecture
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ecritureEvaluation(String fichier,PrintWriter out) {           
        //Ecriture des informations de l'eval
        out.println(this.note + " " + "\t" + this.coeff);
    }

    private void comparer(double val,String compare){
        if(compare.equals("coeff")){
            if(this.coeff == val) System.out.println("Le coeff est egal");
            else System.out.println("Le coeff n'est pas egal : " + val );
        }
        else if(compare.equals("note")){
            if(this.note == val) System.out.println("La note est egal");
            else System.out.println("La note n'est pas egal : " + val);
        }else System.out.println("veuillez comparer a une valeur existante");
    }
}
