package players;
//Factory method for creating players - centralising logic in one place.
//What Is a Factory Method?
//Imagine you’re running a toy factory. You don’t want your workers to build toys by hand every time — instead, you give them a machine that knows how to build a toy when you press a button.
//        In programming, a Factory Method is that machine. It’s a method that creates objects for you, so you don’t have to write new BluePlayer() or new RedPlayer() everywhere in your code.
//        🔧 Why Use It?
//        - Encapsulation: You hide the details of how the object is created.
//        - Flexibility: You can change how objects are built without changing the rest of your code.
//        - Polymorphism: You can return different types of players (BluePlayer, RedPlayer) using the same method.
//Now instead of doing:
//Player p = new BluePlayer();
//You do:
//Player p = PlayerFactory.createBluePlayer();
//Later, if BluePlayer needs extra setup (e.g. loading a board, assigning a strategy), you can do it inside the factory method — and the rest of your code doesn’t need to change.


public class PlayerFactory {

    public static Player createRedPlayer(){
        return new RedPlayer();
    }
    public static Player createBluePlayer(){
        return new BluePlayer();
    }
//    public static Player createGreenPlayer(){
//        return new GreenPlayer();
//    }
//    public static Player createYellowPlayer(){
//        return new YellowPlayer();
//    }
}
