package dev.jesus.views;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.jesus.dtos.MomentResponseDTO;
import dev.jesus.models.EmotionEnum;

public class PrintMomentTest {

  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private PrintStream standardOut = System.out;

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  void tearDown() {
    System.setOut(standardOut);
  }

  @Test
  void testPrintMoment() {
    MomentResponseDTO moment = new MomentResponseDTO(
        "123",
        "My Birthday",
        LocalDate.of(2025, 8, 22),
        "test",
        EmotionEnum.Joy,
        true);

    PrintMoment.printMoment(moment);

    String result = outputStreamCaptor.toString();

    assertThat(result, containsString("123. It happened in: 22/8/2025"));
    assertThat(result, containsString("Title: My Birthday"));
    assertThat(result, containsString("Description: test"));
    assertThat(result, containsString("Emotion: Joy"));
  }
}
