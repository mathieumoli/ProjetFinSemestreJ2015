package zuul.intl;

import java.util.ListResourceBundle;

import zuul.Display;

/**
 * @author Lucas Martinez
  * @version 2014.11.30
 * 
 *          Zuul is a class that manages resources strings for the game
 *          when the user want a French game
 */
public class Zuul extends ListResourceBundle {
    static final Object[][] contents = {    	
    	
            {"lunchroom.description", "Vous êtes dans la cafétéria. Ici, vous pouvez acheter un peu de tout, du café, du Redbull ? Utilisez \"buy\" pour voir ce que vous pouvez acheter."},
            {"lectureroom.description1", "Vous êtes dans une salle de classe.\nVous pouvez assister au cours de "},
            {"lectureroom.shortdescription", "Vous êtes dans une salle de classe.\n"},
            {"lectureroom.description2", "pour cela, tapez \"attend lecture\" \n" },
            {"labroom.description1", "Vous êtes dans la salle de TP.\nVous pouvez assister au cours de "},
            {"labroom.description2", "pour cela, tapez \"attend lab\" \n" },
            {"labroom.shortdescription", "Vous êtes dans la salle de TP.\n"},
            {"alioffice.description","le bureau d'Ali Beikbaghban\n"},
            {"club.description", "Vous êtes dans le foyer"},
            {"secretarialDepartment.description","le secretariat\n"},
            
            {"corridor1.description", "Vous êtes dans le premier couloir"},
            {"corridor2.description", "Vous êtes dans le deuxième couloir"},
            {"corridor3.description", "Vous êtes dans le troisième couloir"},
            {"corridor4.description", "Vous êtes dans le quatrième couloir"},
            {"corridor5.description", "Vous êtes dans le cinquième couloir"},
            {"corridor6.description", "Vous êtes dans le sixième couloir"},
            {"corridor7.description", "Vous êtes dans le septième couloir"},
            {"corridor8.description", "Vous êtes dans le huitième couloir"},
            {"corridor9.description", "Vous êtes dans le neuvième couloir"},
            {"corridor10.description", "Vous êtes dans le dixième couloir"},
            {"corridor11.description", "Vous êtes dans le onzième couloir"},
            {"corridor12.description", "Vous êtes dans le douzième couloir"},
            {"corridor13.description", "Vous êtes dans le treizième couloir"},

            {"corridor.tablet", "Vous trouvez une tablette dans le couloir. Pour l'allumer, tapez \"turn tablet\""},
            {"corridor.notablet", "Quelle tablette ?"},
            {"corridor.cheatsheet", "Un bout de papier dépasse de l'imprimante...Pour aller voir, tapez \"check printer\""},
            {"corridor.nocheatsheet", "Quelle imprimante ?"},
            {"library.takebook","Vous prenez le livre avec vous !"},
            {"library.description", "Vous êtes dans la bibliothèque. Il semblerait que vous puissiez trouver ici un livre de POO."},
   
            {"examroom.description", "Vous êtes dans la salle d'examen. Pour répondre, veuillez taper VRAI ou FAUX."},
            {"examroom.shortdescription", "Vous êtes dans la salle d'examen."},
            {"examroom.noexam", "Il n'y a pas d'exament prévu pour le moment.Revenez plus tard ! "},
            { "examroom.canNotPass","Vous ne pouvez assister à cet examen, assistez à tous les cours et trouvez, si vous le pouvez, monsieur Stromboni" },
    
            {"corridor.dark","Ce couloir est d'une obscurité déconcertante, vous pourriez allumer la lumiere pour mieux y voir...\n Pour allumer la lumiere, tapez \"lights on\"\n"},
            {"library.closed","La porte est fermée à clé. Il est vrai que la bibliothèque est fermée 7 fois sur 10. Revenez plus tard !"},
            {"lunchroom.coffee1","J'ai ajouté une thermo de café dans mon sac !"},
            {"lunchroom.coffee2", "Merci Mocoffee !"},

            {"oop.lecture", "Il faut savoir...blabla"},
            {"oop.lecture1", "...les développeurs souhaitent une cohésion élevée et un couplage faible..."},
            {"oop.lecture2", "...les interfaces n'ont pas besoin de constructeur..."},
            {"oop.lecture3", "...une sous-classe doit obligatoirement faire appel à 'super' dans son constructeur..."},
            {"oop.lectureend", "Voilà, c'est tout pour aujourd'hui. Apprenez bien votre cours pour la prochaine fois."},

            {"c.lecture1", "... la programmation C n'est pas un langage de programmation orienté objet..."},
            {"c.lecture2", "...on declare un tableau avec des [] exemple int tab[]..."},
            {"c.lecture3", "...un pointeur se déclare comme suit : int *p..."},
            
            {"algo.lecture1", "...on utilise le pivot de Gauss pour obtenir une matrice triangulaire supérieure..."},
            {"algo.lecture2", "...Utiliser les différences divisées est la méthode la plus simple pour obtenir le polynôme le plus proche d'une fonction..."},
            {"algo.lecture3", "...si le déterminant d'une matrice est différent de 0 la matrice est inversible..."},
            
            {"C.exam.description", "Un examen de C vient de commencer, pour le passer, tapez \"start exam\""},
            {"C.exam.question1", "On peut déclarer un tableau avec des parenthèses ()..."},
            {"C.exam.question2", "Un pointeur se déclare avec une *..."},
            {"C.exam.question3", "Le C n'est pas un langage de programmation orienté objet..."},
            {"C.exam.answer1", "FAUX"},
            {"C.exam.answer2", "VRAI"},
            {"C.exam.answer3", "VRAI"},

            {"ALGO.exam.description", "Un examen d'Algo-Num vient de commencer, pour le passer, tapez \"start exam\""},
            {"ALGO.exam.question1", "Le déterminant d'une matrice doit être différent de 0 pour que la matrice soit inversible..."},
            {"ALGO.exam.question2", "Le pivot de Gauss est utilisé pour obtenir une matrice diagonale..."},
            {"ALGO.exam.question3", "La méthode des différences divisées est la méthode la plus simple pour obtenir un polynöme d'interpolation..."},
            {"ALGO.exam.answer1", "VRAI"},
            {"ALGO.exam.answer2", "FAUX"},
            {"ALGO.exam.answer3", "VRAI"},

            {"OOP.exam.description", "Vous allez passer un examen de POO, veuillez répondre par VRAI ou FAUX."},
            {"OOP.exam.question1", "Un constructeur est-il nécessaire dans une interface ?"},
            {"OOP.exam.question2", "Est-il vrai que les développeurs veulent une cohésion faible et un couplage élevé ?"},
            {"OOP.exam.question3", "Un constructeur d'une sous-classe doit-il contenir obligatoirement un appel de 'super' ?"},
            {"OOP.exam.answer1", "FAUX"},
            {"OOP.exam.answer2", "FAUX"},
            {"OOP.exam.answer3", "VRAI"},
            {"exam.rightanswer", "La réponse est : "},

            {"game.welcome", "Bienvenue dans Le Monde de Zuul!"},
            {"game.boring", "Le Monde de Zuul est un nouveau jeu d'aventure incroyablement (un peu moins) chiant.\n"
            		+ "Les règles sont simples, passe ton exam pour terminer le jeu."},
            {"game.help", "Tapez 'help' si vous avez besoin d'aide."},
            {"game.idontknow", "Je ne comprends pas..."},
            {"game.turn","Utiliser quoi ? une tablette peut être ?"},
            {"game.start", "Utilisation : start + exam"},
            {"game.attend","Assister à quoi ? lab ? cours ?"},
            {"game.help2", "Vous êtes un étudiant et vous devez passer l'examen final de POO."},
            {"game.help3", "Pour cela, vous devez suivre des cours, des TP et réussir l'examen."},
            {"game.help4", "Les commandes sont:"},
            {"game.where", "Aller où?"},
            {"game.take", "Prendre quoi ? un café ou un livre peut être ? Tapez: take coffee ou take book "},
            {"game.nodoor", "Il n'y a pas de porte !"},
            {"game.quitwhat", "Quitter quoi?"},
            {"game.exits", "Sorties:"},
            {"game.thankyou", "Merci d'avoir joué. Au revoir."},
            {"game.askname", "Quel est votre nom ?"},
            {"game.welcomename1", "Bienvenue "},
            {"game.welcomename2", " ! Mais je trouve que ce prénom ne vous va pas très bien...je vais vous appeler "},
            {"game.welcomename3", " la brutasse !"},
			{"game.read","Lire quoi ? "},
            {"game.win", "Félicitations ! Vous avez réussi à passer l'examen final de "},
            {"game.lose", "Désolé, vous n'avez pas la moyenne à l'examen final de "},
            {"game.lose2", " et vous devez le repasser..."},
            {"game.noonehere","Il n'y a personne dans cette salle."},
            {"game.peopleHereAre","Les personnes présentes dans cette salle sont : "},
            {"game.wrongDirection", "Cette direction n'existe pas."},
            
            {"student.youhave", "Vous avez "},
            {"student.answers", " réponses justes."},
            {"student.energy.part1", "L'énergie de "},
            {"student.energy.part2", " est de "},
            {"student.energy0", "Vous n'avez plus d'énergie ! Vous vous endormez sur place...Jojo la menace vous voit et décide de vous renvoyer...Faites attention la prochaine fois."},
            {"student.addLab.part1"," a suivi avec succès le lab de "},
            {"student.add.part2"," numéro "},
            {"student.addLecture.part1"," a suivi avec succès le cours de "},
            {"student.removeLecture1","Vous avez oublié le cours de "},
            {"student.removeLecture2"," numero "},
            {"student.removeLab1","Vous avez oublié le lab de "},
            {"student.removeLab2"," numéro "},
            {"student.busted","Vous avez été pris en flag ! Vous vous faites frapper et perdez des points d'énergie."},
            {"student.cloakoff","Vous enlevez la cape et devenez visible."},
            {"student.cloakon","Vous mettez la cape et devenez invisible."},
            {"student.donthavethisinbag","Je n'ai pas ca dans mon sac."},
            {"student.utilisationobject","Utilisation : use + nom de l'objet. Les objets suivant sont dans votre sac :"},
            {"student.emptybag","Le sac est vide."},
            {"student.canthavemoreobjects","Un object de ce type est déjà dans le sac, je ne peux pas en avoir plusieurs"},
            {"student.iadd","J'ajoute "},
            {"student.inmybag"," à mon sac."},
            {"student.noobjecthere","Je n'ai trouvé aucun objet ici."},
            {"student.whattosee","Que voulez vous voir ? Peut être un plan ?"},
            {"student.cantbuythis","Vous ne pouvez pas acheter cet object car  vous en avez déjà un dans votre sac."},
            {"student.personnothere","Cette personne n'est pas dans la salle."},         
            {"student.utilisationsteal","Utilisation : steal + nom d'une personne dans la salle."},
            {"student.spotted", "Vous vous êtes fait repéré ! En conséquence vous vous faites frapper et perdez de l'énergie."},
            {"student.stealSucces", "Vol réussit !"},
            
            {"wallet.contains", "Votre porte monaie contient : "},
            {"wallet.levelmaxreached","Niveau max atteint !"},
            {"wallet.notenoughmoney","Fond insuffisant !"},
            
            {"stromboni.canNotAllow", " ne peut pas vous autoriser à passer les examen, vous devez d'abord valider tous les cours."},
            {"stromboni.canAllow", " vous autorise à passer l'examen mon enfant, allez en paix, et courage."},
            
            {"room.empty", "Il n'y a personne dans cette salle"},
            {"room.cantStart", "Rendez vous en salle d'examen pour passer l'examen"},
            {"room.noSeller", "Il n'y à pas de vendeur ici. Essayer de vous rendre à la cafétéria, Oussama est toujours la si vous avez besoin de quelque chose."},
            {"room.noattend", "Rendez-vous dans une salle de cours pour suivre un cours."},
            
            
            {"lectureroom.attendlecture.part1","le cours de "},
            {"lectureroom.attendlecture.part4","Merci d'avoir écouté ce cours vous pouvez donc assister au lab !"},
            {"room.attend.part2"," numéro "},
            {"room.attend.part3"," va commencer !"},
            {"labroom.attendlab.part1","le lab de "},
            {"labroom.attendlab.part4","Merci d'avoir participé à ce lab !"},
            {"labroom.noattend1","Le professeur ne veut pas de vous car vous n'avez pas assisté au cours concernant le module de "},
            {"labroom.noattend2"," numéro "},
            {"lunchroom.babyFoot","Vous êtes dans la cafétéria. L'appel du baby est trop fort pour résister, vous allez faire une partie..."},            {"examroom.cant", "Vous ne pouvez pas passer l'examen de POO dans ces conditions..."},
            {"aliOffice.bordel", "C'est le bureau d'Ali. Wow! c'est le bordel ici ! Pour votre bien, partez !"},
            {"foyer.lookTab", "Vous regardez sur le tableau."},
            {"secretariat.aimable", "Vous êtes au secretariat. Les gens ici ne sont pas très aimables."},
            
            {"tablet.lecture","Vous constatez que l'étudiant qui a laissé la tablette a enregistré un cours dessus. Pourquoi ne pas l'apprendre ?"},
            {"tablet.zuul","Oh oui! Vous avez vu le monde de Zuul sur la tablette. Vous lancez dans une partie."},
            {"tablet.appli","Oh non! Vous avez vu \"Candy Crush - Oubliez vos cours et jouez avec moi\" sur la tablette. Vous vous lancez dans une partie..."},
        	{"tablet.on","$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$_$$$$$$$$$$$$$$$$_$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$__$$$$$$$$$$$$$$_$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$$_______________$$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$___________________$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$____$$$_________$$$____$$$$$$$$$$$$$\n$$$$$$$$$$$$$_____$$$_________$$$_____$$$$$$$$$$$$\n$$$$$$$$$$$$___________________________$$$$$$$$$$$\n$$$$$$$$$$$$___________________________$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n$$$$_____$$$____________________________$$$____$$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$______$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$$___$$$$____________________________$$$___$$$$\n$$$$$$$$$$$$____________________________$$$$$$$$$$\n$$$$$$$$$$$$____________________________$$$$$$$$$$\n$$$$$$$$$$$$___________________________$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n La tablette Android est allumée!"},

        	{"room.nothing","Désolé il n'y a pas de cours dans cette salle, Revenez plus tard"},
            {"cheatsheet.description1", "Vous venez de trouver une feuille avec quelque chose d'écrit dessus..."},
            {"cheatsheet.description2", "Réponses à l'examen de POO : "},
            {"name.CN","Vous êtes Chuck Norris vous ne perdez jamais ! Bravo vous avez donc gagné !"},
            {"alcohol.action","Oh j'ai la tête qui tourne ..."},
            {"broom.action","I believe I can fly \n"
					+ "I believe I can touch the sky \n"
					+ "I think about it every night and day \n"
					+ "Spread my wings and fly away \n "
					+ "I believe I can soar \n "
					+ "I see me running through that open door \n "
					+ "I believe I can fly \n " + "I believe I can fly "},
			{"pc.action","ça faisait longtemps que je me suis pas connecté ...\nFacebook.com \nConnexion échouée..."},
			{"phone.action","biip biip ... \nVeuillez laisser votre message apres le bip "},
			{"redbull.action","Le redbull c'est trop bon !"},		
			{"tobacco.action","Allez une petite cigarette ! (La cigarette est mauvaise pour la santé vous le savez non ?"},
			{"twix.action","TWIX ces doigts coupent faim !"},
			{"wand.action","Wingardium Leviosa \n...\nPourquoi il se passe rien... \ntant pis, j ai un exam à réussir "},
			
			{"maraudeur.password","je jure solennellement que mes intentions sont mauvaises"},
			{"maraudeur.show","--- Carte du Maraudeur ---"},
			{"maraudeur.see"," est dans "},
			{"maraudeur.you","Vous êtes dans "},
			{"maraudeur.alterpassword","i am dark vador"},
			{"maraudeur.passwordAnnonce","Donne moi le mot de passe stupide humain"},
			{"maraudeur.failpassword","Vous ne connaissez pas le mot de passe vous ne saurez jamais où sont les autres."},
			
			{"person.hello"," vous renvoie le bonjour !"},
			{"person.notUnderstood", " ne comprend pas ce que vous dites et vous dévisage"},
			
			{"mysteriousperson.indice1"," vous apprend qu'il y a une salle secrete au nord du corridor 4"},
			{"mysteriousperson.indice2"," vous apprend qu'il y a une salle secrete au sud de la lunchroom"},
			{"mysteriousperson.indice3"," vous apprend qu'il y a une salle secrete a l'ouest du corridor 7"},
			
			{"advertisement.ad1","...don du sang le mois prochain ..."},
			{"advertisement.ad2","...la BU sera exceptionellement fermée lundi, mardi, mercredi, jeudi et vendredi prochains..."},
			{"advertisement.ad3","...vendredi soir, soirée BDE à Nice..."},
			{"advertisement.ad4","...forum des métiers la semaine prochaine..."},
			
			{"foyer.noannonce","Il n'y a pas d'annonce."},
			
			{"seller.seewhatisell","Voici tout ce que je peux te vendre l'ami : "},
			{"seller.nothingmore","Malheureusement je ne peux rien te vendre.\nJ'ai été dévalisé, plus un seul article en stock ..."},
			{"seller.foryou","Et voila un "},
			{"seller.comeback"," pour toi, reviens me voir quand tu veux !"},
			{"seller.notfree","T'as cru que cétait gratuit !? T'as pas assez d'argent pour acheter ca !"},
			{"seller.idonthavethis","Désolé je n'ai pas ca en stock ..."},			
    };

    /***
     * 
     * 
	 * @return an array in which each item is a pair of objects in an Object
	 *         array. The first element of each pair is the key, which must be a
	 *         String, and the second element is the string associated with that
	 *         key.
	 */
    @Override
    public Object[][] getContents() {
        return contents;
    }
}
