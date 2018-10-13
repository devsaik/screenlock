package com.paropakar;

import java.util.*;

public class ScreenLockingPatterns {
    Map<String, Character> jumpOvers;
    Map<Character, String> neighbours ;
    char[] inputGrid = new char[]{'A','B','C','D','E','F','G','H','I'};
    /*
      Constructor for class
     */
    ScreenLockingPatterns(){
        // HashMap Initialization for jumpOvers
        jumpOvers = initializeJumpOvers(new HashMap());

        // HashMap Initialization for identifying neighbours
        neighbours = initializeNeighbours(new HashMap());

    }
    /*
      @description: Initializing a Map that contains Jump overs
      @Params: Map[String, Character]
      @return: Map[String, Character]
    */
    public Map<String, Character> initializeJumpOvers(Map<String, Character>jumpOvers){
        jumpOvers.put("AC", 'B');
        jumpOvers.put("AG", 'D');
        jumpOvers.put("AI", 'E');
        jumpOvers.put("BH", 'E');
        jumpOvers.put("CA", 'B');
        jumpOvers.put("CG", 'E');
        jumpOvers.put("CI", 'F');
        jumpOvers.put("DF", 'E');
        jumpOvers.put("FD", 'E');
        jumpOvers.put("GA", 'D');
        jumpOvers.put("GC", 'E');
        jumpOvers.put("GI", 'H');
        jumpOvers.put("HB", 'E');
        jumpOvers.put("IA", 'E');
        jumpOvers.put("IC", 'F');
        jumpOvers.put("IG", 'H');
        return jumpOvers;
    }
    /*
     @description: Initializing a Map that contains Neighbors of a character
     @Params: Map[Character, String]
     @return: Map[Character, String]
   */
    public Map<Character,String> initializeNeighbours(Map<Character,String>mapOfNeighbours){
        mapOfNeighbours.put('A', "BDE");
        mapOfNeighbours.put('B', "ACDEF");
        mapOfNeighbours.put('C', "BEF");
        mapOfNeighbours.put('D', "AEGH");
        mapOfNeighbours.put('E', "ABCDFGHI");
        mapOfNeighbours.put('F', "CIBEH");
        mapOfNeighbours.put('G', "DEH");
        mapOfNeighbours.put('H', "DEFGI");
        mapOfNeighbours.put('I', "EFH");
        return mapOfNeighbours;
    }

    /*
       @description: Method intended to check Validity of the starting character
                    if it is specified in the Given Input Grid
       @Params: char, Array of Chars
       @return: Boolean
     */
    public Boolean checkIfInputIsValid(char start,char[] inputGrid){
        for(char currentCharacter : inputGrid ){
            if(start == currentCharacter)
                return true;
        }
        return false;
    }

    /*
       @description: Method that returns number Of Patterns
       @Params: char, Integer Desired Length
       @return: Integer possible patterns
     */
    public int numberOfPatterns(char start, int desiredLength) {
        List<List<Character>> patternList = new ArrayList<List<Character>>();
        if(desiredLength != 0 && checkIfInputIsValid(start, inputGrid) )
        {
            List<Character>subList = new ArrayList();
            Set<Character> currentSet = new HashSet();
            subList.add(start);
            patternList.add(new ArrayList(subList));
            int currentListIterator = 0;
            while(currentListIterator < patternList.size() && patternList.get(currentListIterator).size() < desiredLength) {
                List<Character>currentList = patternList.get(currentListIterator);
                subList=new ArrayList(currentList);
                patternList.remove(currentListIterator);
                currentListIterator=currentListIterator-1;
                currentSet.addAll(subList);
                for (int i = 0; i < inputGrid.length; i++) {
                    subList=new ArrayList(currentList);
                    if (!subList.contains(inputGrid[i]) && checkIfCombinationIsValid(start, inputGrid[i], currentSet))
                    {
                        currentSet.add(inputGrid[i]);
                        subList.add(inputGrid[i]);
                        patternList.add(subList);

                    }
                }
                currentListIterator++;
            }

        }
        System.out.println("Patterns::"+patternList);
        return patternList.size();
    }
    /*
      @description: Method that checksValidityOfCombination
      @Params: Char, Char, Set. Set here is used for occurrence of Characters in the String
      @return: Boolean
    */
    private Boolean checkIfCombinationIsValid(char start, char end, Set<Character>alreadyUsed ){
        StringBuilder concatenatedCombination = new StringBuilder(start).append(end);
        char jumpedOver = jumpOvers.getOrDefault(concatenatedCombination,'z');
        if(jumpedOver != 'z' && alreadyUsed.contains(jumpedOver)){
            return true;
        }
        else if (neighbours.get(start).indexOf(end)>=0){
            return true;
        }
        return false;

    }
}