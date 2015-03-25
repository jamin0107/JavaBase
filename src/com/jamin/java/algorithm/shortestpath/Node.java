package com.jamin.java.algorithm.shortestpath;

import java.util.ArrayList;
import java.util.List;

public class Node {

	// 节点编号
	private String id;
	// 从当前节点出发的边的信息列表
	private List<Edge> outEdges;

	public Node(String id) {
		this.id = id;
		outEdges = new ArrayList<Edge>();
	}

	public void addOutEdge(Edge edge) {
		if (edge != null)
			outEdges.add(edge);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Edge> getOutEdges() {
		return outEdges;
	}

	public void setOutEdges(List<Edge> outEdges) {
		this.outEdges = outEdges;
	}
}
