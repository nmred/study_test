package test06;

public enum GenderInterface implements GenderDesc{
	MALE("男"),FEMALE("女");
	private final String name;
	private GenderInterface(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void info() {
		System.out.println("这是一个用于定义性别Field的枚举类");
	}
}
