package com.paropakar;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;



class ScreenLockingPatternsTest {
    ScreenLockingPatterns saiAndroidScreen;
    char[] inputGrid;
    ScreenLockingPatternsTest(){
        setup();
    }
    public void setup(){
        saiAndroidScreen  = new ScreenLockingPatterns();
        inputGrid = new char[]{'A','B','C','D','E','F','G','H','I'};
    }

    @org.junit.jupiter.api.Test
    public void testCheckIfInputIsValid(){

        boolean inputValid = saiAndroidScreen.checkIfInputIsValid('j',inputGrid);
        assert(inputValid == false);

    }

    @Test
    void initializeJumpOvers() {
        Map<String, Character> jumpTest = new HashMap<>();
        jumpTest.put("Test",'H');
        assert((saiAndroidScreen.initializeJumpOvers(jumpTest)).size()>0);
    }

    @Test
    void initializeNeighbours() {
        Map<Character, String> neighbourTest = new HashMap<>();
        neighbourTest.put('H',"Hello");
        assert((saiAndroidScreen.initializeNeighbours(neighbourTest)).size()>0);
    }

    @Test
    void numberOfPatterns() {

       assert(saiAndroidScreen.numberOfPatterns('D',4) == 24);
       assert(saiAndroidScreen.numberOfPatterns('E',4) == 336);
    }
    @Test
    void InvalidPatterns() {

        assert(saiAndroidScreen.numberOfPatterns('Z',4) == 0);
        assert(saiAndroidScreen.numberOfPatterns('E',0) == 0);
    }

}