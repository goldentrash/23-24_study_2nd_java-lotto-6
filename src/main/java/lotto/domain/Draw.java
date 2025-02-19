package lotto.domain;

public class Draw {
  private final WinningNumbers winningNumbers;
  private final BonusNumber bonusNumber;

  public Draw(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
    validate(winningNumbers, bonusNumber);

    this.winningNumbers = winningNumbers;
    this.bonusNumber = bonusNumber;
  }

  public Prize compare(Lotto lotto) {
    int winningCount = this.winningNumbers.compare(lotto);
    boolean hitBonus = this.bonusNumber.belonged(lotto);
    return Prize.from(winningCount, hitBonus);
  }

  private void validate(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
    if (winningNumbers.overlap(bonusNumber)) {
      throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 겹치지 않아야 합니다.");
    }
  }
}
