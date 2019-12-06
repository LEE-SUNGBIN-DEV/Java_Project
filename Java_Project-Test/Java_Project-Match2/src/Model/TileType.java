package Model;

public enum TileType {

	Grapes("grapes"), Lemon("lemon");

	String textureName;
	
	TileType(String textureName)
	{
		this.textureName = textureName;
	}
}
