public class Utility {


/**
 * Cette méthode a pour but de comparer des strings qui se trouvent dans le fichier JSON aux données des tableaux
 * ACTIVITES_PRINCIPALES_ACCEPTEES et LISTE_DES_ACTIVITEES_ACCEPTEES qui se trouvent dans la classe Verificateur de Formulaire.
 * */
    public static boolean comparerStringEtTableau(String string, String[] tableauDeString) {
        boolean estValide = false;

        for (int i = 0; i < tableauDeString.length; i++) {
            if (tableauDeString[i].equals(string)) {
                estValide = true;
            }
        }
        return estValide;
    }

 /**
  * * Cette méthode a pour but de comparer un caractère qui se trouve dans le fichier json à tous les caractères du tableau lettresPermises.
  * Elle est utilisée pour valider les numéros des permis
  */
    public static boolean comparerCharEtTableau(char character, char[] tableauDeChar) {
        boolean estValide = false;
        for (char c : tableauDeChar) {
            if (character == c) {
                estValide = true;
            }
        }
        return estValide;
    }
    /**
     * Vérifie si un caractère est un chiffre entre '0' et '9' en utlisant les unicode.
     * Elle est utilisée pour valider les numéros des permis
     * */
    public static boolean charEstUnNombre(char charPourVerification){
        return ((charPourVerification >= (char)48) && (charPourVerification <= (char)57));
    }

    public static boolean isLowerCaseLetter(char ch) {
        return ((int) ch >= 97 && (int)ch <= 122);
    }

    /**
     * Vérifie si une chaîne de caractères contient uniquement des chiffres.
     * Elle est utilisée pour valider les numéros des permis
     *  */
    public static boolean contientSeulementDesNombres(String stringEnEntree) {
        boolean estValide = true;
        for (int i = 0; i < stringEnEntree.length(); i++) {
            estValide = estValide && charEstUnNombre(stringEnEntree.charAt(i));;
        }
        return estValide;
    }

}
