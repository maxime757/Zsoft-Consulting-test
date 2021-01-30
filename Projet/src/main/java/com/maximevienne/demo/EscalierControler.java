package com.maximevienne.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EscalierControler{

    private static final String template = "%d";

    @RequestMapping("/")
	public String index(){
        return "Page d'accueil, entrez localhost:8080/escalier?marche=nombre \n , en remplaçant nombre par le nombre de marche";
    }
    /**
     * Fonction qui calcul les probabilités d'action à partir du nombre de marche
     * @param Nombre_De_Marche
     * @return
     */
    public int CalculPossibilite(int Nombre_De_Marche){
        int N_2=2;
        int N_1=3;
        int Possibilite=5;
        if(Nombre_De_Marche>=4){
            for(int i = 4;i<=Nombre_De_Marche;i++){
                Possibilite=N_2+N_1;
                N_2=N_1;
                N_1= Possibilite;
            }
            return Possibilite;
        }
        return Nombre_De_Marche;
    }
    
    /**
     * Permet d'afficher en localhost, le calcul des possibilités, avec l'affichage des paramètres de l'objet escalier
     * exemple localhost:8080/escalier?marche=5 renvoie 8 possibilités
     * @param marche est le nombre entré dans l'url à la main
     * @return
     */
    @GetMapping("/escalier")
    public Escalier escalier(@RequestParam(required = true,defaultValue = "1") Integer marche){
        int valeur = CalculPossibilite(marche);
        return new Escalier(valeur,String.format(template, marche));
    }
}
