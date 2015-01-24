package zuul.commands;

import java.util.HashMap;

public class DirectionsWord {

    private HashMap<String, Directions> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public DirectionsWord()
    {
        validCommands = new HashMap<String, Directions>();
        for(Directions command : Directions.values()) {
            if(command != Directions.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord corresponding to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public Directions getCommandWord(String commandWord)
    {
        Directions command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return Directions.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }
}
