package main.java.de.zalando;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.omg.CORBA.portable.OutputStream;

public class Player {
	
	public Player player;
	
	Player pl(int Pos0){
				return player;
			
	}
	
	public String plMove (int Pos0,int WEST,
		    int NORTH,
		    int EAST,
		    int SOUTH){
		
		int PosIn = Pos0;
		int mvWest = WEST;
	    int mvNorth = NORTH;
	    int mvEast =EAST;
	    int mvSouth =SOUTH;
		String Move ="Move "+PosIn+" "+mvWest+" "+mvNorth+" "+mvEast+" "+mvSouth;
		return Move;
	    
		
	}
	
// POST Move;
// POST url;
	String Signal;
	
public String notification(int MoveResult){
	
	
	return Signal;
	
	
}
	
	
}
