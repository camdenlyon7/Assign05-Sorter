package assign05;

import java.util.ArrayList;
import java.util.Random;

public class RandomPivotChooser<E extends Comparable<? super E>> implements PivotChooser<E> {
  private Random rand;

  public RandomPivotChooser() {
    this.rand = new Random();
  }

  @Override
  public int getPivotIndex(ArrayList<E> list, int left, int right) {
    int range = (right - left) +1;
    int randomIndex = left + rand.nextInt(range);
    return randomIndex;
  }
}
