package com.jamin.java.algorithm.shortestpath.dijkstra;

import java.util.Iterator;

import com.jamin.java.algorithm.shortestpath.Graph;

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.init();
		Dijkstra dijkstra = new Dijkstra(graph, "A");
		dijkstra.start();

		// 打印最终的路由表
		Iterator<String> it = dijkstra.getNodeidShortestRouteMapping().keySet().iterator();
		while (it.hasNext()) {
			String id = it.next();
			System.out.println("nodeId: " + id + 
					", shortest length: " + dijkstra.getNodeidShortestRouteMapping().get(id)
					+ ", last nodeId: " + dijkstra.getNodeidLastNodeidMapping().get(id));
		}
	}

}
