package io.github.chehsunliu.ossrh.beta;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculationTest {

  @Test
  void work() {
    assertEquals(7, new Calculation(3, 4).answer());
  }
}