package entites;

import java.util.Random;

public class De {
    private static Random random = new Random();

    public static int lancerDe() {
        return random.nextInt(6) + 1;
    }
}

