package com.jamin.java.algorithm.shortestpath;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	// 图中的节点列表
	public List<Node> nodeList = null;

	public Graph() {
		nodeList = new ArrayList<Node>();
	}

	public List<Node> getNodeList() {
		return nodeList;
	}

	
	// initialize
	public void init() {
		// ************************ Node A ***********************
		Node aNode = new Node("A");
		nodeList.add(aNode);
		// A -> B
		Edge a2bEdge = new Edge();
		a2bEdge.setStartNodeID(aNode.getId());
		a2bEdge.setEndNodeID("B");
		a2bEdge.setWeight(10);
		aNode.addOutEdge(a2bEdge);
		// A -> C
		Edge a2cEdge = new Edge();
		a2cEdge.setStartNodeID(aNode.getId());
		a2cEdge.setEndNodeID("C");
		a2cEdge.setWeight(20);
		aNode.addOutEdge(a2cEdge);
		// A -> E
		Edge a2eEdge = new Edge();
		a2eEdge.setStartNodeID(aNode.getId());
		a2eEdge.setEndNodeID("E");
		a2eEdge.setWeight(30);
		aNode.addOutEdge(a2eEdge);

		// ************************ Node B ***********************
		Node bNode = new Node("B");
		nodeList.add(bNode);
		// B -> C
		Edge b2cEdge = new Edge();
		b2cEdge.setStartNodeID(bNode.getId());
		b2cEdge.setEndNodeID("C");
		b2cEdge.setWeight(5);
		bNode.addOutEdge(b2cEdge);
		// B -> E
		Edge b2eEdge = new Edge();
		b2eEdge.setStartNodeID(bNode.getId());
		b2eEdge.setEndNodeID("E");
		b2eEdge.setWeight(10);
		bNode.addOutEdge(b2eEdge);

		// ************************ Node C ***********************
		Node cNode = new Node("C");
		nodeList.add(cNode);
		// C -> D
		Edge c2dEdge = new Edge();
		c2dEdge.setStartNodeID(cNode.getId());
		c2dEdge.setEndNodeID("D");
		c2dEdge.setWeight(30);
		cNode.addOutEdge(c2dEdge);

		// ************************ Node D ***********************
		Node dNode = new Node("D");
		nodeList.add(dNode);

		// ************************ Node E ***********************
		Node eNode = new Node("E");
		nodeList.add(eNode);
		// E -> D
		Edge e2dEdge = new Edge();
		e2dEdge.setStartNodeID(eNode.getId());
		e2dEdge.setEndNodeID("D");
		e2dEdge.setWeight(20);
		eNode.addOutEdge(e2dEdge);

	}
}
