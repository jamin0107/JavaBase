package com.jamin.java.algorithm.shortestpath.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jamin.java.algorithm.shortestpath.Edge;
import com.jamin.java.algorithm.shortestpath.Graph;
import com.jamin.java.algorithm.shortestpath.Node;

public class Dijkstra {

	// 起始节点编号
	private String startNodeID = null;
	// 未被处理的节点集合
	private List<String> sourceNodeIDList = null;
	// 已被处理的节点集合
	private List<String> desNodeIDList = null;

	// '节点编号' 和 '起始节点与当前节点之间的最短路径' 的映射关系
	private Map<String, Double> nodeidShortestRouteMapping = null;
	// '节点编号' 和 '起始节点到当前节点之间的最短路径 的 上一跳节点编号' 的映射关系
	private Map<String, String> nodeidLastNodeidMapping = null;
	// '节点编号' 和 '节点对象'的 映射关系
	private Map<String, Node> idNodeMapping = null;

	public Dijkstra(Graph graph, String startNodeID) {
		this.startNodeID = startNodeID;
		// 初始化
		sourceNodeIDList = new ArrayList<String>();
		desNodeIDList = new ArrayList<String>();

		nodeidShortestRouteMapping = new HashMap<String, Double>();
		nodeidLastNodeidMapping = new HashMap<String, String>();
		idNodeMapping = new HashMap<String, Node>();

		for (Node node : graph.getNodeList()) {
			if (node.getId().equals(startNodeID)) {
				desNodeIDList.add(startNodeID);
				// 起始节点到起始节点的最短路径长度为0
				nodeidShortestRouteMapping.put(startNodeID, 0d);
			} else {
				sourceNodeIDList.add(node.getId());
				// 非起始节点到起始节点的最短路径长度为 '无穷大'
				nodeidShortestRouteMapping.put(node.getId(), Double.MAX_VALUE);
			}
			// 设置到节点最短路径的上一跳节点为'null'
			nodeidLastNodeidMapping.put(node.getId(), null);
			idNodeMapping.put(node.getId(), node);
		}

	}

	public void start() {
		Node nextNode = null;
		Node currentNode = null;
		String nextNodeID = "";
		do {
			if (nextNode == null) {
				currentNode = idNodeMapping.get(startNodeID);
			} else {
				currentNode = nextNode;
			}
			nextNodeID = getNextNode(currentNode);

			nextNode = idNodeMapping.get(nextNodeID);
			System.out.println("nextNode.id:" + nextNode.getId());

			sourceNodeIDList.remove(nextNode.getId());
			System.out.println("sourceNodeIDList:"
					+ sourceNodeIDList.toString());
		} while (sourceNodeIDList.size() > 0);
	}

	public String getNextNode(Node currentNode) {
		System.out.println("============= currentNode.id: "
				+ currentNode.getId() + " =============");
		double shortestPath = Double.MAX_VALUE;
		String nextNodeID = "";
		// 遍历从当前节点出发的邻接节点
		for (Edge nextEdge : currentNode.getOutEdges()) {
			System.out.println("nextEdge.endNodeid:" + nextEdge.getEndNodeID());
			// 判断 '经过当前节点至邻接节点的距离' < '之前记录的从源节点出发到邻接节点的距离'
			if ((nextEdge.getWeight() + nodeidShortestRouteMapping
					.get(currentNode.getId())) < nodeidShortestRouteMapping
					.get(nextEdge.getEndNodeID())) {
				// 更新路由表
				nodeidShortestRouteMapping.put(
						nextEdge.getEndNodeID(),
						nextEdge.getWeight()
								+ nodeidShortestRouteMapping.get(currentNode
										.getId()));
				nodeidLastNodeidMapping.put(nextEdge.getEndNodeID(),
						currentNode.getId());
			}
		}
		// 从未被处理过的节点集合中，取出权值最小的节点
		for (String nodeID : sourceNodeIDList) {
			if (nodeidShortestRouteMapping.get(nodeID) < shortestPath) {
				shortestPath = nodeidShortestRouteMapping.get(nodeID);
				nextNodeID = nodeID;
			}
		}
		if (sourceNodeIDList.size() == 1) // 从未被处理过的节点集合中，取出最后一个节点
			return sourceNodeIDList.get(0);
		return nextNodeID;
	}

	public Map<String, Double> getNodeidShortestRouteMapping() {
		return nodeidShortestRouteMapping;
	}

	public Map<String, String> getNodeidLastNodeidMapping() {
		return nodeidLastNodeidMapping;
	}

}
