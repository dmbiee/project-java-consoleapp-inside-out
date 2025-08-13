package dev.jesus.singletons;

import dev.jesus.controllers.MomentController;
import dev.jesus.models.Moment;

public class MomentControllerSingleton {

  private static final MomentController INSTANCE = new MomentController();

  private MomentControllerSingleton() {
  }

  public static MomentController getInstance() {
    return INSTANCE;
  }
}
