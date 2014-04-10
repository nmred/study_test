package test06;

public class Season {
	private final String name;
	private final String desc;
	public static final Season SPRING = new Season("春天", "趁春踏青");
	public static final Season SUMMER = new Season("夏天", "夏日炎炎");
	public static final Season FALL   = new Season("秋天", "秋高气爽");
	public static final Season WINTER = new Season("冬天", "围炉赏雪");
	public static Season getSeason(int SeasonNum) {
		switch (SeasonNum) {
			case 1:
				return SPRING;
			case 2:
				return SUMMER;
			case 3:
				return FALL;
			case 4:
				return WINTER;
			default:
				return null;
		}
		
	}
	
	private Season(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.desc;
	}
}
