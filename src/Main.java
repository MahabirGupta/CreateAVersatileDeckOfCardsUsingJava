import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);
//        create a Card array with size 13
        Card[] cardArray = new Card[13];
        Card aceOfHearts=Card.getFaceCard(Suit.HEART,'A');
        Arrays.fill(cardArray,aceOfHearts);
//        System.out.println(Arrays.toString(cardArray));
        Card.printDeck(Arrays.asList(cardArray),"Aces of Hearts",1);
        System.out.println();

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards,aceOfHearts);//will not fill the list
        System.out.println(cards);// return empty list
        System.out.println("cards.size() = "+cards.size());
        Collections.addAll(cards,cardArray);
        Collections.addAll(cards,cardArray);
        Card.printDeck(cards,"Card Collection with Aces Added",2);

        System.out.println();

        List<Card> acesOfHearts = Collections.nCopies(13,aceOfHearts);
        Card.printDeck(acesOfHearts,"Aces of Hearts",1);
        System.out.println();
        System.out.println(acesOfHearts);
        System.out.println("cards.size() = "+acesOfHearts.size());
        System.out.println();

        Card kingOfClubs=Card.getFaceCard(Suit.CLUB,'K');
        List<Card> kingsOfClubs = Collections.nCopies(13,kingOfClubs);
        Card.printDeck(kingsOfClubs,"Kings of Clubs",1);
        System.out.println();
        Collections.copy(cards,kingsOfClubs);// it will throw an exception if the src list is empty
        Card.printDeck(cards,"Card Collection with Kings copied",2);
        System.out.println();

        cards=List.copyOf(kingsOfClubs);
        Card.printDeck(cards,"List Copy of Kings",1);
        }
    }

