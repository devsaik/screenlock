package com.paropakar;
public class Main {

    public static void main(String[] args) {
	// Class Instantiation Below
        ScreenLockingPatterns saiAndroidScreen = new ScreenLockingPatterns();
        int numberOfPatterns = saiAndroidScreen.numberOfPatterns('E',4);
        System.out.println("Number of Patterns ::"+numberOfPatterns);

    }
}
