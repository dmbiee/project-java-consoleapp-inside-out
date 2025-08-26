package dev.jesus.views;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import dev.jesus.controllers.MomentController;

public class MomentExportCSVViewTest {

  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private final PrintStream standardOut = System.out;

  private MomentController originalController;

  @BeforeEach
  void setUp() throws Exception {
    System.setOut(new PrintStream(outputStreamCaptor));
    originalController = getStaticController();
  }

  @AfterEach
  void tearDown() throws Exception {
    System.setOut(standardOut);
    setStaticController(originalController);
  }

  @Test
  void testPrintCSVinfo() throws Exception {
    MomentController mockController = mock(MomentController.class);
    setStaticController(mockController);

    try (MockedStatic<HomeView> mockedHomeView = mockStatic(HomeView.class)) {

      MomentExportCSVView.printCSVinfo();

      String result = outputStreamCaptor.toString();

      assertThat(result, containsString("Exporting moments to:"));
      assertThat(result, containsString("Moment exported."));

      verify(mockController).exportMomentsToCSV(("src/main/java/dev/jesus/db/csv/moments.csv"));
      mockedHomeView.verify(HomeView::printMainMenu);
    }
  }

  private MomentController getStaticController() throws Exception {
    Field f = ShowAllMomentsView.class.getDeclaredField("CONTROLLER");
    f.setAccessible(true);
    return (MomentController) f.get(null);
  }

  public void setStaticController(MomentController originalController) throws Exception {
    Field f = MomentExportCSVView.class.getDeclaredField("CONTROLLER");
    f.setAccessible(true);
    f.set(null, originalController);
  }

}
