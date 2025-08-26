package dev.jesus.views;

import dev.jesus.controllers.MomentController;
import dev.jesus.dtos.MomentResponseDTO;
import dev.jesus.models.EmotionEnum;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;

class ShowAllMomentsViewTest {

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
  void testPrintAllMoments_whenNoMoments() throws Exception {
    MomentController mockController = mock(MomentController.class);
    when(mockController.GetDB()).thenReturn(Collections.emptyList());

    setStaticController(mockController);

    try (MockedStatic<HomeView> mockedHomeView = mockStatic(HomeView.class)) {
      ShowAllMomentsView.printAllMoments();

      String result = outputStreamCaptor.toString();
      assertThat(result, containsString("There aren't saved moments."));

      mockedHomeView.verify(HomeView::printMainMenu);
    }
  }

  @Test
  void testPrintAllMoments_whenHasMoments() throws Exception {
    MomentController mockController = mock(MomentController.class);
    MomentResponseDTO mockMoment = new MomentResponseDTO(
        "1",
        "Test moment",
        LocalDate.of(2025, 1, 1),
        "Some description",
        EmotionEnum.Joy,
        true);
    when(mockController.GetDB()).thenReturn(List.of(mockMoment));

    setStaticController(mockController);

    try (MockedStatic<HomeView> mockedHomeView = mockStatic(HomeView.class);
        MockedStatic<PrintMoment> mockedPrintMoment = mockStatic(PrintMoment.class)) {

      ShowAllMomentsView.printAllMoments();

      String result = outputStreamCaptor.toString();
      assertThat(result, containsString("List of lived moments:"));

      mockedPrintMoment.verify(() -> PrintMoment.printMoment(mockMoment));
      mockedHomeView.verify(HomeView::printMainMenu);
    }
  }

  private static MomentController getStaticController() throws Exception {
    Field f = ShowAllMomentsView.class.getDeclaredField("CONTROLLER");
    f.setAccessible(true);
    return (MomentController) f.get(null);
  }

  private static void setStaticController(MomentController controller) throws Exception {
    Field f = ShowAllMomentsView.class.getDeclaredField("CONTROLLER");
    f.setAccessible(true);
    f.set(null, controller);
  }
}
