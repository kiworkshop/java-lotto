package View;

import com.sun.tools.jdeprscan.scan.Scan;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(scanner.nextLine());
        return money;
    }

}
