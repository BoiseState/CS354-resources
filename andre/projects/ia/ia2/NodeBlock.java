
public class NodeBlock extends Node {

	public NodeStmt stmt;
	public NodeBlock block;

	public NodeBlock(NodeStmt stmt, NodeBlock block) {
		this.stmt = stmt;
		this.block = block;
	}
}
