package com.jamin.java.algorithm.shortestpath;

import java.util.ArrayList;
import java.util.List;

public class Node {

	// �ڵ���
	private String id;
	// �ӵ�ǰ�ڵ�����ıߵ���Ϣ�б�
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
