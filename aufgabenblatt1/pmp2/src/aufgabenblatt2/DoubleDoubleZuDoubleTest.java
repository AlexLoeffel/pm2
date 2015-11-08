package aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testklasse zum SAM DoubleDoubleZuDouble
 * 
 * @author Alexander Mendel und Karl-Fabain Witte
 *
 */
public class DoubleDoubleZuDoubleTest {
  private Double[]     x = { 1., 2., 3., 4., 5., 6., 7., 8. };
  private Double[]     y = { 1., 2., 3., 4., 5., 6., 7., 8. };

  DoubleDoubleZuDouble tester;

  @Test
  public void testWerteAusAddition() {
    tester = (x, y) -> x + y;
    for (int i = 0; i < x.length; i++) {
      assertEquals(tester.werteAus(x[i], y[i]), y[i] + x[i], 1e-4);
    }
  }

  @Test
  public void testWerteAusNullstellen() {
    // gelichung ist a = x*b +y
    // Nulstellen bei a=0 -> b= y/x
    tester = (a, b) -> b / a;
    for (int i = 0; i < x.length; i++) {
      assertEquals(tester.werteAus(x[i], y[i]), y[i] / x[i], 1e-4);
    }
  }

}
