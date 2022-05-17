import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Deck cardDeck;
    ArrayList<Card> playerHand;
    ArrayList<Card> dealerHand;
    Player player;
    Integer account, bet, total;
    String play, playerAnswer;
    Card card;
    Boolean round;

    public Game() {
        scanner = new Scanner(System.in);
        cardDeck = new Deck();
        cardDeck.shuffle();

        player = new Player("You", 500);

        playerHand = new ArrayList<>();
        playerHand.add(cardDeck.draw());
        playerHand.add(cardDeck.draw());

        dealerHand = new ArrayList<>();
        dealerHand.add(cardDeck.draw());
        dealerHand.add(cardDeck.draw());

        round = true;
    }

    public Integer cardValue(ArrayList<Card> account) {
        total = 0;
        for (Card value : account) {
            total += value.cardValue();
        }
        return total;
    }

    public void dealerTurn() {
        System.out.println("Dealer has: " + dealerHand);
        System.out.println(cardValue(dealerHand));
        while (cardValue(dealerHand) < 17 && cardValue(dealerHand) < 21) {
            Card card = cardDeck.draw();
            dealerHand.add(card);
            System.out.println(dealerHand);
            System.out.println(cardValue(dealerHand));
        }

        if (cardValue(dealerHand) > 21) {
            System.out.println("Dealer has:" + dealerHand);
            System.out.println(cardValue(dealerHand));
            System.out.println("Dealer Bust! You win");
            player.add(bet);
            System.out.println(player.print());

            round = false;
            System.out.println("New game? Yes or No");
            playerAnswer = scanner.nextLine();

            if (playerAnswer.equalsIgnoreCase("Yes")) {
                round = true;

            } else if (playerAnswer.equalsIgnoreCase("No")) {
                round = false;
            }

        }
    }

    public void gameRound() {
        while (round = true) {
            System.out.println(player.print());


            System.out.println("Place your bid: ");
            bet = Integer.valueOf(scanner.nextLine());


            System.out.println("Your hand: " + playerHand);
            System.out.println(cardValue(playerHand));
            System.out.println("Dealer hand: " + dealerHand.get(0).toString());
            if (cardValue(playerHand) == 21) {
                System.out.println("21! You win!");
                round = false;
                System.out.println("New game? Yes or No");
                playerAnswer = scanner.nextLine();

                if (playerAnswer.equalsIgnoreCase("Yes")) {
                    round = true;

                } else if (playerAnswer.equalsIgnoreCase("No")) {
                    round = false;
                    break;

                }

            }

            System.out.println("Would you like to Hit or Stand?");
            play = scanner.next();

            if (play.equalsIgnoreCase("Hit")) {
                playerHand.add(cardDeck.draw());
                System.out.println("Your hand: " + playerHand);
                System.out.println(cardValue(playerHand));

                while (cardValue(playerHand) < 21) {
                    System.out.println("Would you like to Hit or Stand?");
                    play = scanner.next();
                    if (play.equalsIgnoreCase("Hit")) {
                        playerHand.add(cardDeck.draw());
                        System.out.println("Your hand: " + playerHand);
                        System.out.println(cardValue(playerHand));
                    } else {
                        break;
                    }
                }

                if (cardValue(playerHand) > 21) {
                    System.out.println("Bust! You lose your bet");
                    player.subtract(bet);
                    System.out.println(player.print());

                    round = false;
                    System.out.println("New game? Yes or No");
                    playerAnswer = scanner.nextLine();

                    if (playerAnswer.equalsIgnoreCase("yes")) {
                        round = true;

                    } else if (playerAnswer.equalsIgnoreCase("no")) {
                        round = false;
                        break;

                    }
                }
                if (cardValue(playerHand) == 21) {
                    System.out.println("21! You win");
                    player.add(bet);
                    System.out.println(player.print());

                    round = false;
                    System.out.println("New game? Yes or No");
                    playerAnswer = scanner.nextLine();

                    if (playerAnswer.equalsIgnoreCase("Yes")) {
                        round = true;

                    } else if (playerAnswer.equalsIgnoreCase("No")) {
                        round = false;
                        break;
                    }
                }

            }

            if (play.equalsIgnoreCase("Stand")) {
                dealerTurn();

                if (cardValue(playerHand) > cardValue(dealerHand) && cardValue(playerHand) < 21) {
                    System.out.println("You have a higher value! You win");
                    player.add(bet);
                    System.out.println(player.print());

                    round = false;
                    System.out.println("New game? Yes or No");
                    playerAnswer = scanner.nextLine();

                    if (playerAnswer.equalsIgnoreCase("yes")) {
                        round = true;

                    } else if (playerAnswer.equalsIgnoreCase("no")) {
                        round = false;
                        break;
                    }
                }


                if (cardValue(dealerHand) == 21) {
                    System.out.println("Dealer 21! You lose your bet sucka");
                    player.subtract(bet);
                    System.out.println(player.print());

                    round = false;
                    System.out.println("New game? Yes or No");
                    playerAnswer = scanner.nextLine();

                    if (playerAnswer.equalsIgnoreCase("Yes")) {
                        round = true;
                    } else if (playerAnswer.equalsIgnoreCase("No")) {
                        round = false;
                        break;
                    }
                }

                if (cardValue(dealerHand) > cardValue(playerHand) && cardValue(dealerHand) < 21) {
                    System.out.println("Dealer has a higher value! You lose your bet sucka");
                    player.subtract(bet);
                    System.out.println(player.print());

                    round = false;
                    System.out.println("New game? Yes or No");
                    playerAnswer = scanner.nextLine();

                    if (playerAnswer.equalsIgnoreCase("yes")) {
                        round = true;

                    } else if (playerAnswer.equalsIgnoreCase("no")) {
                        round = false;
                        break;
                    }
                }

                if (Objects.equals(cardValue(dealerHand), cardValue(playerHand))) {
                    System.out.println("It's a Tie!");
                    System.out.println(player.print());

                    round = false;
                    System.out.println("New game? Yes or No");
                    playerAnswer = scanner.nextLine();

                    if (playerAnswer.equalsIgnoreCase("yes")) {
                        round = true;
                    } else if (playerAnswer.equalsIgnoreCase("no")) {
                        round = false;
                        break;
                    }
                }
                round = false;
                playerAnswer = scanner.nextLine();

                if (playerAnswer.equalsIgnoreCase("yes")) {
                    round = true;
                } else if (playerAnswer.equalsIgnoreCase("no")) {
                    System.out.println("Thanks for playing!");
                    round = false;
                    break;
                }


            }
        }

    }
}

