package com.jamin.java.algorithm.shortestpath.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jamin.java.algorithm.shortestpath.Edge;
import com.jamin.java.algorithm.shortestpath.Graph;
import com.jamin.java.algorithm.shortestpath.Node;

public class Dijkstra {

	// ��ʼ�ڵ���
	private String startNodeID = null;
	// δ������Ľڵ㼯��
	private List<String> sourceNodeIDList = null;
	// �ѱ�����Ľڵ㼯��
	private List<String> desNodeIDList = null;

	// '�ڵ���' �� '��ʼ�ڵ��뵱ǰ�ڵ�֮������·��' ��ӳ���ϵ
	private Map<String, Double> nodeidShortestRouteMapping = null;
	// '�ڵ���' �� '��ʼ�ڵ㵽��ǰ�ڵ�֮������·�� �� ��һ���ڵ���' ��ӳ���ϵ
	private Map<String, String> nodeidLastNodeidMapping = null;
	// '�ڵ���' �� '�ڵ����'�� ӳ���ϵ
	private Map<String, Node> idNodeMapping = null;

	public Dijkstra(Graph graph, String startNodeID) {
		this.startNodeID = startNodeID;
		// ��ʼ��
		sourceNodeIDList = new ArrayList<String>();
		desNodeIDList = new ArrayList<String>();

		nodeidShortestRouteMapping = new HashMap<String, Double>();
		nodeidLastNodeidMapping = new HashMap<String, String>();
		idNodeMapping = new HashMap<String, Node>();

		for (Node node : graph.getNodeList()) {
			if (node.getId().equals(startNodeID)) {
				desNodeIDList.add(startNodeID);
				// ��ʼ�ڵ㵽��ʼ�ڵ�����·������Ϊ0
				nodeidShortestRouteMapping.put(startNodeID, 0d);
			} else {
				sourceNodeIDList.add(node.getId());
				// ����ʼ�ڵ㵽��ʼ�ڵ�����·������Ϊ '�����'
				nodeidShortestRouteMapping.put(node.getId(), Double.MAX_VALUE);
			}
			// ���õ��ڵ����·������һ���ڵ�Ϊ'null'
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
		// �����ӵ�ǰ�ڵ�������ڽӽڵ�
		for (Edge nextEdge : currentNode.getOutEdges()) {
			System.out.println("nextEdge.endNodeid:" + nextEdge.getEndNodeID());
			// �ж� '������ǰ�ڵ����ڽӽڵ�ľ���' < '֮ǰ��¼�Ĵ�Դ�ڵ�������ڽӽڵ�ľ���'
			if ((nextEdge.getWeight() + nodeidShortestRouteMapping
					.get(currentNode.getId())) < nodeidShortestRouteMapping
					.get(nextEdge.getEndNodeID())) {
				// ����·�ɱ�
				nodeidShortestRouteMapping.put(
						nextEdge.getEndNodeID(),
						nextEdge.getWeight()
								+ nodeidShortestRouteMapping.get(currentNode
										.getId()));
				nodeidLastNodeidMapping.put(nextEdge.getEndNodeID(),
						currentNode.getId());
			}
		}
		// ��δ��������Ľڵ㼯���У�ȡ��Ȩֵ��С�Ľڵ�
		for (String nodeID : sourceNodeIDList) {
			if (nodeidShortestRouteMapping.get(nodeID) < shortestPath) {
				shortestPath = nodeidShortestRouteMapping.get(nodeID);
				nextNodeID = nodeID;
			}
		}
		if (sourceNodeIDList.size() == 1) // ��δ��������Ľڵ㼯���У�ȡ�����һ���ڵ�
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
