import java.net.MalformedURLException;
import java.util.Random; 


public class TestFavoriteList {
    
    private static String[] randomAdjectives = {"brave", "curious", "lively", "vivid", "gentle", "radiant", "fierce", "elegant", "swift", "clever", "bold", "calm", "sturdy", "bright", "mysterious", "sharp", "smooth", "shy", "cheerful", "daring", "graceful", "nimble", "kind", "fearless", "quiet", "strong", "wise", "wild", "humble", "shiny", "playful", "warm", "cautious", "fresh", "daring", "lucky", "restless", "loyal", "gentle", "proud", "joyful", "fierce", "honest", "jolly", "crisp", "tender", "rugged", "calm", "sleek", "eager"};
    private static String[] randomNouns = {"apple", "mountain", "river", "cloud", "book", "lion", "star", "tree", "ocean", "dream", "garden", "stone", "feather", "castle", "mirror", "song", "forest", "lamp", "whale", "flower", "ship", "fire", "moon", "dragon", "wind", "bridge", "crown", "sun", "butterfly", "clock", "island", "storm", "key", "gate", "horse", "shadow", "river", "mask", "heart", "phoenix", "cloud", "desert", "pearl", "path", "tower", "flame", "shell", "gem", "wolf", "leaf"}; 
    
    public static void main(String[] args) {
        Random rand = new Random(); 
        FavoriteList favList= new FavoriteList(); 

        for (int i = 0; i <= 5; i++) {
            try {
                Favorite randomFav = new Favorite(generateUsername(), "https://www.unep.org/");
                favList.add(i, randomFav);
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }

        System.out.println(favList.toString());
        System.out.println();

        System.out.print("Index 0: ");
        System.out.println(favList.get(0));
        System.out.println();

        System.out.println("Removing index 1...");
        favList.remove(1); 
        System.out.println();
        
        System.out.println(favList.toString());
    }

    public static String generateUsername() {
        Random rand = new Random();
        return randomAdjectives[rand.nextInt(50)] + randomNouns[rand.nextInt(50)]; 
    }
}