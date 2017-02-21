package realExam;

import javax.jws.soap.SOAPBinding;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class ascent {
    private static LinkedHashMap<String , Integer> nameAndScore = new LinkedHashMap<>();
    private static LinkedHashMap<String,String> saveGames = new LinkedHashMap<>();
    private static TreeMap<Integer,String >  reverse = new TreeMap<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine().trim();

        while (!"osu!".equals(line)){
            addInput(line);

            line = reader.readLine().trim();
        }
        print();
    }


    private static void print() {
        for (String key : nameAndScore.keySet()) {
            if(!reverse.containsKey(nameAndScore.get(key))){
                reverse.put(nameAndScore.get(key),key);
            }else{
                reverse.put(nameAndScore.get(key)+ nameAndScore.get(key),key);
            }

        }

        for (Integer keya : reverse.keySet()) {
            System.out.println(reverse.get(keya) + " - " + "("+keya+")");
            System.out.println(saveGames.get(reverse.get(keya)));
        }
    }

    private static void addInput(String line) {
        String[] playerAndScore = line.split("<->");
        String[] firstPlayerInfo = playerAndScore[0].split(" ");
        String[] secondPlayerInfo = playerAndScore[1].split(" ");
        String firstPlayerName = firstPlayerInfo[1];
        String firstPlayerScore = firstPlayerInfo[0];
        String secondPlayerName = secondPlayerInfo[0];
        String secondPlayerScore = secondPlayerInfo[1];

        gamePlay(firstPlayerName,firstPlayerScore,secondPlayerName,secondPlayerScore);
            }

    private static void gamePlay(String firstPlayerName, String firstPlayerScore, String secondPlayerName, String secondPlayerScore) {
       Integer firstPlayerScor = Integer.parseInt(firstPlayerScore);
       Integer secondPlayerScor = Integer.parseInt(secondPlayerScore);
       Integer winerScore = 0;
       Integer loserScore = 0;
       if(firstPlayerScor > secondPlayerScor){
           winerScore = firstPlayerScor - secondPlayerScor;
           loserScore = secondPlayerScor - firstPlayerScor;
           if(!nameAndScore.containsKey(firstPlayerName)){
               nameAndScore.put(firstPlayerName,winerScore);
           }else{
               nameAndScore.put(firstPlayerName,nameAndScore.get(firstPlayerName) + winerScore);
           }

           if(!nameAndScore.containsKey(secondPlayerName)){
               nameAndScore.put(secondPlayerName,loserScore);
           }else{
               nameAndScore.put(secondPlayerName,nameAndScore.get(secondPlayerName) + loserScore);
           }
                saveGame(firstPlayerName,winerScore,secondPlayerName,loserScore);

       }else{
           winerScore = secondPlayerScor - firstPlayerScor;
           loserScore = firstPlayerScor - secondPlayerScor ;
           if(!nameAndScore.containsKey(secondPlayerName)){
               nameAndScore.put(secondPlayerName,winerScore);
           }else{
               nameAndScore.put(secondPlayerName,nameAndScore.get(secondPlayerName) + winerScore);
           }

           if(!nameAndScore.containsKey(firstPlayerName)){
               nameAndScore.put(firstPlayerName,loserScore);
           }else{
               nameAndScore.put(firstPlayerName,nameAndScore.get(firstPlayerName) + loserScore);
           }
           saveGameTwo(secondPlayerName,winerScore,firstPlayerName,loserScore);
       }



    }

    private static void saveGameTwo(String secondPlayerName, Integer winerScore, String firstPlayerName, Integer loserScore) {
        if(!saveGames.containsKey(secondPlayerName)){
            saveGames.put(secondPlayerName,"*   " + firstPlayerName + " <-> " + winerScore );
        }else {
            saveGames.put(secondPlayerName, saveGames.get(secondPlayerName) + "\n" + "*   " + firstPlayerName + " <-> " + winerScore );
        }

        if(!saveGames.containsKey(firstPlayerName)){
            saveGames.put(firstPlayerName,"*   " + secondPlayerName + " <-> " + loserScore );
        }else {
            saveGames.put(firstPlayerName, saveGames.get(firstPlayerName) + "\n" + "*   " + secondPlayerName + " <-> " + loserScore );
        }

    }

    private static void saveGame(String firstPlayerName, Integer winerScore, String secondPlayerName, Integer loserScore) {
         if(!saveGames.containsKey(firstPlayerName)){
             saveGames.put(firstPlayerName,"*   " + secondPlayerName + " <-> " + winerScore );
         }else {
             saveGames.put(firstPlayerName, saveGames.get(firstPlayerName) + "\n" + "*   " + secondPlayerName + " <-> " + winerScore );
         }

        if(!saveGames.containsKey(secondPlayerName)){
            saveGames.put(secondPlayerName,"*   " + firstPlayerName + " <-> " + loserScore );
        }else {
            saveGames.put(secondPlayerName, saveGames.get(secondPlayerName) + "\n" + "*   " + firstPlayerName + " <-> " + loserScore );
        }

    }






}
