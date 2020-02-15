package pruebalabcave;

import org.json.JSONObject;
import org.json.JSONException;
import java.io.IOException;
import java.util.Scanner;


public class PruebaLabCave {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException, JSONException {
		JSONObject json= consultaJson.readJsonFromUrl("https://swapi.co/api/people");
	    
		String results= json.get("results").toString();
	    String[] arrayResults = results.split("\\{");
	    
	    int opcion= 1;
	    
	    while (opcion!=0)
	    {
	    	System.out.println("\nEscoge una opción: \n");
	    	System.out.println("0: Salir");
	    	System.out.println("1: Mostrar todos los personajes");
	    	System.out.println("2: Buscar información de un personaje \n");
	    	
			opcion= Integer.parseInt(input.nextLine());
	    	
		    switch (opcion) {
				case 0:
					System.out.println("Fin del programa");
					break;
				case 1:
					System.out.println(results);
					break;
				case 2:
					buscarPersonaje(arrayResults);
					break;
				default:
					break;
			}
	    }
	}
	
	private static void buscarPersonaje(String[] arrayResults)
	{
		boolean existePersonaje= false;
		String personaje="";
		
		System.out.println("Escriba el personaje: ");
		personaje= input.nextLine();
	    
	    for(int i=0; i<arrayResults.length; i++)
	    {
	    	if(arrayResults[i].contains(personaje))
	    	{
	    		existePersonaje= true;
	    		System.out.println(arrayResults[i]);
	    	}
	    }
	    
	    if(!existePersonaje)
	    {
	    	System.out.println("El personaje no existe en la base de datos");
	    }
	}
}