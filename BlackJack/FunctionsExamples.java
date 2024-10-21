public class FunctionsExamples {
    public static void printWeather() {
        System.out.println("The weather today is sunny with a high of 75°F.");
    }

    public static void printGoodMorning() {
        System.out.println("Good morning! Hope you have a wonderful day ahead.");
    }

    public static void printKnockKnockJoke() {
        System.out.println("Knock, knock.");
        System.out.println("Who's there?");
        System.out.println("Lettuce.");
        System.out.println("Lettuce who?");
        System.out.println("Lettuce in, it's cold out here!");
    }

    public static void printGoodNight() {
        System.out.println("Good night! Sleep tight and sweet dreams.");
    }

    public static void allFunctions() {
        printWeather(); printGoodMorning(); printKnockKnockJoke(); printGoodNight();
    }

    public static void parentFunction(int choice) {
            if(choice == 1){
                printWeather();
            }
            else if(choice == 2){
                printGoodMorning();
            } 
            else if(choice == 3)
            { 
                printKnockKnockJoke();
            } 
            else if(choice == 4)
            { 
                printGoodNight();
            } 
            else if(choice == 5)
            { 
                allFunctions();
            } 
            else {
                System.out.println("Wrong input. Try again.");
            }
        }
}

