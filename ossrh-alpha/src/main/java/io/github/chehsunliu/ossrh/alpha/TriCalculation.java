package io.github.chehsunliu.ossrh.alpha;

import io.github.chehsunliu.ossrh.beta.Calculation;

public class TriCalculation extends Calculation {
  private final Integer n3;

  @Override
  public Integer answer() {
    return super.answer() + this.n3;
  }

  public TriCalculation(Integer n1, Integer n2, Integer n3) {
    super(n1, n2);
    this.n3 = n3;
  }
}
