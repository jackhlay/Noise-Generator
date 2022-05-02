import java.io.IOException;

public class Control {

    public static void main(String[] args) throws IOException {
        int num = 100000;
        new Main().go(num);
        new Sort_Quantify().go(num);
    }
}
