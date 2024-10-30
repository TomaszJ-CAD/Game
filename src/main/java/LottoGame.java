import java.util.Set;

public class LottoGame {

    private final UserInput userInput;
    private final RandomNumberGenerator randomNumberGenerator;
    private final Output output;

    private static final int QUANTITY_OF_NUMBERS = 6;

    public LottoGame(UserInput userInput, RandomNumberGenerator randomNumberGenerator, Output output) {
        this.userInput = userInput;
        this.randomNumberGenerator = randomNumberGenerator;
        this.output = output;
    }

    public void play() {


        output.println("Wybierz 6 liczb z puli od 1 do 99.");


        Set<Integer> userNumbers = userInput.selectNumbers(QUANTITY_OF_NUMBERS);
        output.println("Twoje liczby to: " + userNumbers);


        output.println("Teraz losujemy liczby.");
        Set<Integer> drawnNumbers = randomNumberGenerator.generateRandomNumbers(QUANTITY_OF_NUMBERS);
        output.println("Wylosowane liczby to: " + drawnNumbers);

        userNumbers.retainAll(drawnNumbers);

        output.println("Liczba trafionych liczb to: " + userNumbers.size());

        if (!userNumbers.isEmpty()) {
            output.println("Twoje trafione liczby: " + userNumbers);
        } else {
            output.println("Niestety, nie trafiłeś żadnej liczby.");
        }

    }
}
