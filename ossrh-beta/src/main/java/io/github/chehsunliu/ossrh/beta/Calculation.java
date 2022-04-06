package io.github.chehsunliu.ossrh.beta;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Calculation {

  private final Integer n1;
  private final Integer n2;

  public Integer answer() {
    return n1 + n2;
  }
}
