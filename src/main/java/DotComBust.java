import java.util.ArrayList;

/**
 * @author Sergei Usov
 * @version 1.0.0
 */
public class DotComBust {
    private GameHelper gameHelper= new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuess = 0;

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Ваша цель - потопить три сайта");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");

        for (DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = gameHelper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying() {
        while (!dotComsList.isEmpty()) {
            String userGuess = gameHelper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    private void checkUserGuess(String userGuess) {
        numOfGuess++;
        String result = "Мимо";
        for (DotCom dotComToTest : dotComsList) {
            result = dotComToTest.checkYourSelf(userGuess);
            if (result.equals("Попал")) {
                break;
            }
            if (result.equals("Потопил")) {
                dotComsList.remove(dotComToTest);
                break;
            }
            System.out.println(result);
        }
    }
    private void finishGame() {
        System.out.println("Все сайты ушли ко дну!!! Ваши акции теперь ничего не стоят");
        if (numOfGuess <= 18) {
            System.out.println("Это заняло у вас всего "+numOfGuess+" попыток");
            System.out.println("Вы успели выбраться до того, как потеряли все вложения");
        }
        else {
            System.out.println("Это занаяло у вас больше времени. "+numOfGuess+" попыток");
            System.out.println("Рыбы водят хороводы вокруг Ваших инвестиций");
        }
    }

    public static void main(String[] args) {
        DotComBust game= new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
