/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2014
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package fr.techcode.zuul.i18n;

import java.util.Map;

/**
 * French mapping implementation.
 */
class MessageFr extends Message {

    /**
     * Returns a map that contains the mapping.
     *
     * @return a map that contains the mapping.
     */
    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = super.toMap();
        map.put(COMMAND_HELP, "Afficher des informations d'aide.");
        map.put(COMMAND_INTERACT, "Interagir avec la salle courante.");
        map.put(COMMAND_INTERACT_DISCOVER, "Essaie de découvrir des objets dans la salle.");
        map.put(COMMAND_INTERACT_DISCOVER_FAIL, "La salle est trop sombre.");
        map.put(COMMAND_INTERACT_LIGHT, "Changer l'état de la lumière de la salle courante.");
        map.put(COMMAND_INTERACT_LIGHT_OFF, "Vous avez éteint la lumière.");
        map.put(COMMAND_INTERACT_LIGHT_ON, "Vous avez allumé la lumière.");
        map.put(COMMAND_INTERACT_USE, "Utiliser un objet dans la salle.");
        map.put(COMMAND_INTERACT_USE_FAIL, "Objet non trouvé.");
        map.put(COMMAND_INTERACT_VIEW, "Afficher quelques informations sur l'environnement.");
        map.put(COMMAND_LANG, "Affiche quelques informations sur le language.");
        map.put(COMMAND_LANG_AVAILABLE, "Afficher les langages supportés.");
        map.put(COMMAND_LANG_SET, "Vous autorise à changer la langue.");
        map.put(COMMAND_LEAVE, "Marcher vers la salle précédente.");
        map.put(COMMAND_MOVE, "Marcher vers une autre salle.");
        map.put(COMMAND_PLAYER, "Afficher les stats de votre personnage.");
        map.put(COMMAND_ROOM, "Display information about the current room.");
        map.put(COMMAND_UNKNOWN, "Commande inconnue ! Faites 'help' pour obtenir de l'aide.");
        map.put(COMMAND_VERSION, "Affiche la version du projet.");
        map.put(COURSE_FORGET, "Vous avez oublié une leçon");
        map.put(COURSE_GRADE, "Vous avez été gradué en @0");
        map.put(COURSE_GRADE_ERROR, "Vous n'avez pas été gradué en @0");
        map.put(COURSE_LEARN, "Vous avez appris une nouvelle leçon en @0");
        map.put(COURSE_LEARN_ERROR, "Vous n'avez pas appris une nouvelle leçon en @0");
        map.put(COURSE_LISTEN, "Vous avez écouté une nouvelle leçon en @0");
        map.put(COURSE_LISTEN_ERROR, "Vous n'avez pas écouté une nouvelle leçon en @0");
        map.put(ITEM_BABYFOOT, "Jouer une partie de babyfoot.");
        map.put(ITEM_BABYFOOT_INTERACT, "Vous avez joué au babyfoot.");
        map.put(ITEM_BOOK, "Ce livre contient toutes les leçons du cours de OOP.");
        map.put(ITEM_CHEAT, "Cette feuille contient les réponses du prochaine examen.");
        map.put(ITEM_COFFEE, "Boire un café pour regagner de l'énergie.");
        map.put(ITEM_COFFEE_INTERACT, "Vous avez bu un execellent café.");
        map.put(MESSAGE_AVAILABLE, "Disponibles:");
        map.put(MESSAGE_DIRECTION_EAST_ERROR, "Il n'y a pas de salle à l'est.");
        map.put(MESSAGE_DIRECTION_EAST_SUCCESS, "Vous êtes entré dans la salle à l'est.");
        map.put(MESSAGE_DIRECTION_NORTH_ERROR, "Il n'y a pas de salle au nord.");
        map.put(MESSAGE_DIRECTION_NORTH_SUCCESS, "Vous êtes entré dans la salle au nord.");
        map.put(MESSAGE_DIRECTION_SOUTH_ERROR, "Il n'y a pas de salle au sud.");
        map.put(MESSAGE_DIRECTION_SOUTH_SUCCESS, "Vous êtes entré dans la salle au sud.");
        map.put(MESSAGE_DIRECTION_UNKNOWN, "La direction est inconnue.");
        map.put(MESSAGE_DIRECTION_WEST_ERROR, "Il n'y a pas de salle à l'ouest.");
        map.put(MESSAGE_DIRECTION_WEST_SUCCESS, "Vous êtes entré dans la salle à l'ouest.");
        map.put(MESSAGE_DISCOVER, "Découvert:");
        map.put(MESSAGE_GAMEOVER, "Vous avez perdu !");
        map.put(MESSAGE_HELLO, "Bienvenue dans le monde de Zuul.");
        map.put(MESSAGE_HELP, "Faites 'help' pour obtenir de l'aide.");
        map.put(MESSAGE_USAGE, "Utilisation");
        map.put(PLAYER_DEATH, "@0 est mort de fatigue !");
        map.put(ROOM_CLOSE, "La salle est fermé.");
        map.put(ROOM_CORRIDOR, "Vous êtes désormais dans un couloir.");
        map.put(ROOM_LAB, "Vous êtes désormais dans une salle de TD.");
        map.put(ROOM_CLASS, "Vous êtes désormais dans une classe.");
        map.put(ROOM_LIBRARY, "Vous êtes désormais dans la bibliothèque.");
        map.put(ROOM_LUNCH, "Vous êtes désormais dans la cafeteria.");
        map.put(ROOM_DENY, "Vous ne pouvez pas quitter la salle maintenant.");
        return map;
    }

}
