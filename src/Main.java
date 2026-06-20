import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

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
        System.out.println();
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);
        Collections.shuffle(deck);
        Card.printDeck(deck,"Shuffled Deck",4);
        System.out.println();
        Collections.reverse(deck);
        Card.printDeck(deck,"Reversed Deck of Cards",4);//reverse the elements of the cards
        System.out.println();
        Comparator<Card> sorthingAlogarithm=Comparator.comparing(Card::getRank).thenComparing(Card::getSuit);
        Collections.sort(deck,sorthingAlogarithm);
        Card.printDeck(deck,"Standard Deck sorted by rank and suit",13);
        System.out.println();
        Collections.reverse(deck);
        Card.printDeck(deck,"Sorted by rank and suit reversed",13);
        System.out.println();
        List<Card> kings = new ArrayList<>(deck.subList(4,8));//4 is inclusive and 8 exclusive
        Card.printDeck(kings,"Kings in deck",1);
//        System.out.println(kings);
        System.out.println();
        List<Card> tens = new ArrayList<>(deck.subList(16,20));//4 is inclusive and 8 exclusive
        Card.printDeck(tens,"Tens in deck",1);
        System.out.println();
//        Collections.shuffle(deck);
        int indexOfSublist=Collections.indexOfSubList(deck,tens);
        System.out.println("sublist index for tens = " + indexOfSublist);
        System.out.println("Contains = "+deck.containsAll(tens));
        System.out.println();
        boolean disjoint = Collections.disjoint(deck,tens);
        System.out.println("disjoint = " + disjoint);
        System.out.println();
        boolean disjoint2 = Collections.disjoint(kings,tens);
        System.out.println("disjoint2 = " + disjoint2);

//        sort back the cards
        deck.sort(sorthingAlogarithm);
        Card tenOfHearts = Card.getNumericCard(Suit.HEART,10);
        int foundIndex = Collections.binarySearch(deck,tenOfHearts,sorthingAlogarithm);//list must be sorted before applying binarySearch(
        System.out.println("foundIndex = "+foundIndex);
        System.out.println("foundIndex = "+deck.indexOf(tenOfHearts));//should print 34
        System.out.println(deck.get(foundIndex));// print the match element at that index position
        System.out.println();
        Card tenOfClubs = Card.getNumericCard(Suit.CLUB,10);
        Collections.replaceAll(deck,tenOfClubs,tenOfHearts);
        Card.printDeck(deck.subList(32,36),"Tens row",1);
        Collections.replaceAll(deck,tenOfHearts,tenOfClubs);
        Card.printDeck(deck.subList(32,36),"Tens row",1);
        if (Collections.replaceAll(deck,tenOfHearts,tenOfClubs)){
            System.out.println("Tens of Hearts replaced with Tens of Clubs");
        }else {
            System.out.println("No tens of hearts found in the list");
        }
        System.out.println("Ten of Club cards = "+Collections.frequency(deck,tenOfClubs));
        System.out.println("Best card = "+Collections.max(deck,sorthingAlogarithm));
        System.out.println("Worst card = "+Collections.min(deck,sorthingAlogarithm));
        System.out.println();
        Comparator<Card> sortBySuit = Comparator.comparing(Card::getSuit).thenComparing(Card::getRank);
        deck.sort(sortBySuit);
        Card.printDeck(deck,"Sorted by Suit and Rank",4);
        System.out.println();
        List<Card> copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied,2);
        System.out.println("Unrotated: "+deck.subList(0,13));
        System.out.println("Rotated: "+2+": "+copied);
        System.out.println();
         copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied,-2);
        System.out.println("Unrotated: "+deck.subList(0,13));
        System.out.println("Rotated: "+-2+": "+copied);
        System.out.println();
        copied = new ArrayList<>(deck.subList(0,13));
        for (int i = 0; i < copied.size()/2; i++) {
            Collections.swap(copied,i,copied.size()-1-i);
        }
        System.out.println("Manual reverse: "+copied);
        System.out.println();
        copied = new ArrayList<>(deck.subList(0,13));
        Collections.reverse(copied);
        System.out.println("Using Collections reverse: "+copied);
        }
    }

