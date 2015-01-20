package zuul.place;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.*;

public class Lieu {
    private Room northExit;
    private Room southExit;
    private Room westExit;
    private Room eastExit;
    
    
	/***
	 * 
	 * @param adresseFichier
	 *            the way to access at the file to store
	 * 
	 */

	public void store(String nomFichier) {
		Writer writer = null;
		// store
		try {
			writer = new FileWriter("Pays/" + nomFichier + ".json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Gson gson = new GsonBuilder().create();

		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    
    
	/***
	 * 
	 * @param adresseFichier
	 *            the way to access at the file to load
	 */

	public void load(String adresseFichier, String pays) {
		//Gson gson = new Gson();

		// transformer le ficher JSON en String
		File file = new File(adresseFichier);
		FileReader filereader;
		String str = "";

		try {
			// Creation de l'objet de lecture
			filereader = new FileReader(file);
			int i = 0;
			// Lecture des donnees tant qu'il y a des caracteres
			while ((i = filereader.read()) != -1)
				str += (char) i;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//JsonParser parser = new JsonParser();
		//JsonArray array = parser.parse(str).getAsJsonArray();
		/**
		this.setNorthExit(gson.fromJson(array.get(0), Room.class));
		this.setEastExit(gson.fromJson(array.get(0), Room.class));
		this.setSouthExit(gson.fromJson(array.get(0), Room.class));
		this.setWestExit(gson.fromJson(array.get(0), Room.class)); */
		//okok go

	}

	/**
	 * @return the northExit
	 */
	public Room getNorthExit() {
		return northExit;
	}

	/**
	 * @param northExit the northExit to set
	 */
	public void setNorthExit(Room northExit) {
		this.northExit = northExit;
	}

	/**
	 * @return the southExit
	 */
	public Room getSouthExit() {
		return southExit;
	}

	/**
	 * @param southExit the southExit to set
	 */
	public void setSouthExit(Room southExit) {
		this.southExit = southExit;
	}

	/**
	 * @return the westExit
	 */
	public Room getWestExit() {
		return westExit;
	}

	/**
	 * @param westExit the westExit to set
	 */
	public void setWestExit(Room westExit) {
		this.westExit = westExit;
	}

	/**
	 * @return the eastExit
	 */
	public Room getEastExit() {
		return eastExit;
	}

	/**
	 * @param eastExit the eastExit to set
	 */
	public void setEastExit(Room eastExit) {
		this.eastExit = eastExit;
	}

	
}
