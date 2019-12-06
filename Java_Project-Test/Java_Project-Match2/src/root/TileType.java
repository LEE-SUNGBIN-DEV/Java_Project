package root;

public enum TileType {

	Grapes("apple.png"),
	Banana("banana.png"),
	Lemon("lemon.png"),
	Orange("orange.png"),
	Pear("pear.png"),
	Strawberry("strawberry.png"),
	Cross("stick-plus.png"),
	Vertical("stick-vertical.png"),
	Horizontal("stick-horizontal.png");

	private String texturePath;
	
	private TileType(String texturePath) {
		this.texturePath = texturePath;
	}
	
	public String getPath() {
		return "img/" + texturePath;
	}
}
