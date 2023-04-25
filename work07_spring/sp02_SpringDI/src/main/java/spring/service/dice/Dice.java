package spring.service.dice;
/*
 * DiceA, DiceB, DiceC가 가지고 있는 핵심 기능의 Template
 */
public interface Dice {
		public int getValue();
		public void setValue(int value);
		public void selectedNumber();
}
