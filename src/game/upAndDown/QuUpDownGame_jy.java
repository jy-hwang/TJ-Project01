package game.upAndDown;

import java.util.InputMismatchException;
import java.util.Scanner;
import commonUtil.CommonUtil;

/**
 *
1.컴퓨터는 1~100사이의 숫자 하나를 생성한다.
2.총 시도횟수는 7번을 부여한다.
3.사용자는 7번의 시도안에 숫자를 맞춰야 한다.
4.사용자가 숫자를 입력했을때 컴퓨터는 높은지/낮은지 알려준다.
5.7번안에 맞추면 성공, 맞추지 못하면 실패라고 출력한다.
6.성공/실패 후 계속 할지를 물어보고 1이면 게임 재시작, 0이면 프로그램을 종료한다.
7.함수를 사용하여 구현한다.
8.무한루프에 빠지게 된다면 scan.nextLine()을 활용하여 버퍼에 남아있는 Enter키를 제거해주도록 하자.

 * 
 */
public class QuUpDownGame_jy {

    static int min = 1, max = 100, count = 7;

    public static void main(String[] args) {

        QuUpDownGame_jy qUpDownGame = new QuUpDownGame_jy();
        qUpDownGame.upDownGame();

    }// end of main Method

    void recognizeNumber(int input, int answer) {
        if (input > answer) {
            System.out.println("좀 더 작은 수로 입력 해보세요..");
            QuUpDownGame_jy.max = input;
        } else if (input < answer) {
            System.out.println("좀 더 큰 수로 입력 해보세요..");
            QuUpDownGame_jy.min = input;
        } else if (input == answer) {
            // 5.남은 횟수 안에 맞히면 성공! 아니면 실패! 를 출력
            System.out.println("성공!");
            count = 0;
        } else {
            System.out.println("실패!");
            count = 0;
        }
    }

    // 7.메서드를 사용하여 구현한다.
    public void upDownGame() {
        // 2. 총 시도횟수는 7번을 부여한다.
        int input = 0, answer = 0;

        boolean isContinue = true, isGame = true;
        while (isGame) {
            // 1. 컴퓨터는 1~100 사이의 숫자하나를 생성하다.
            answer = (int) (Math.random() * 100) + 1;

            // 체크용 출력문
            // System.out.println(answer);

            Scanner scanner = new Scanner(System.in);

            while (isContinue) {
                if (count >= 1) {
                    // 3. 사용자는 남은 횟수 안에 숫자를 맞혀야한다.
                    System.out.println("남은 횟수 : " + QuUpDownGame_jy.count + "번 ");
                    System.out.printf("%d ~ %d 사이의 정수", min, max);
                    try {
                        input = CommonUtil.scanInt("");
                    } catch (InputMismatchException e) {
                        System.out.println("잘못입력했습니다.");
                        // 8.무한루프에 빠지게 된다면 scan.nextLine()을 활용하여 버퍼에 남아있는 Enter키를 제거해주도록 하자.
                        scanner.nextLine();
                        // 잘못입력했지만 그것도 횟수 에서 차감.
                        count--;
                        // 반복문의 처음으로 돌아가게 continue
                        continue;
                    }
                    // 4. 사용자가 숫자를 입력했을때 컴퓨터는 높은지 / 낮은지 알려준다.
                    recognizeNumber(input, answer);

                    QuUpDownGame_jy.count--;
                } else if (count <= 0) {
                    // 6. 성공 /실패 후 계속 할 것인지 물어보고 1이면 게임 재시작, 0이면 프로그램을 종료한다.
                    System.out.println("정답은 " + answer + "였습니다.");
                    System.out.print("다시 시작하려면 1, 종료하려면 0");
                    int tempContinue = 0;
                    try {
                        tempContinue = CommonUtil.scanInt("");
                    } catch (InputMismatchException e) {
                        System.out.println("잘못입력했습니다.");
                        scanner.nextLine();
                        continue;
                    }
                    switch (tempContinue) {
                        case 1:
                            isContinue = true;
                            isGame = true;
                            count = 7;
                            break;
                        case 0:
                            isContinue = false;
                            isGame = false;
                            System.out.println("upAndDown 게임이 종료됩니다.");
                            break;
                        default:
                            System.out.print("다시 입력하세요.>>");
                            break;
                    }
                    break;
                }
            }
        }
    }// end of upDownGame method
}// end of public class
