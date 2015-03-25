package com.jamin.java.algorithm.shortestpath;

public class Edge {

	// 边的起始节点编号
	private String startNodeID;
	// 边的末尾节点编号
	private String endNodeID;
	// 边的权值
	private double weight;

	public String getStartNodeID() {
		return startNodeID;
	}

	public void setStartNodeID(String startNodeID) {
		this.startNodeID = startNodeID;
	}

	public String getEndNodeID() {
		return endNodeID;
	}

	public void setEndNodeID(String endNodeID) {
		this.endNodeID = endNodeID;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}