package com.jamin.java.algorithm.shortestpath;

public class Edge {

	// �ߵ���ʼ�ڵ���
	private String startNodeID;
	// �ߵ�ĩβ�ڵ���
	private String endNodeID;
	// �ߵ�Ȩֵ
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