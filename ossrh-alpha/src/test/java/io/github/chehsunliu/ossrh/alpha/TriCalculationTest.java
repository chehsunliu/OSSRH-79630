package io.github.chehsunliu.ossrh.alpha;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TriCalculationTest {

  @Test
  void work() {
    assertEquals(6, new TriCalculation(1, 2, 3).answer());
  }
}
