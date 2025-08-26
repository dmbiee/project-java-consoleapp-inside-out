package dev.jesus.views;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class HomeViewTest {

  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private PrintStream standardOut = System.out;
  private java.io.InputStream standardIn = System.in;

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  void tearDown() {
    System.setOut(standardOut);
    System.setIn(standardIn);
  }

}
