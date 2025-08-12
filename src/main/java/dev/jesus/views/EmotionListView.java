package dev.jesus.views;

public class EmotionListView extends View {

    public static int printEmotionList() {
        String emotionListText = """
                Select an emotion:
                1. Joy
                2. Sadness
                3. Anger
                4. Disgust
                5. Fear
                6. Anxiety
                7. Envy
                8. Shame
                9. Boredom
                10. Nostalgia
                -----------------
                Enter your option: """;

        System.out.print(emotionListText + " ");
        int option = SCANNER.nextInt();
        return option;
    }

}
