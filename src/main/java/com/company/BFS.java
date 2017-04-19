package com.company;

import java.util.*;

/**
 * Created by ozandeniz on 19/04/2017.
 */
public class BFS {
    private Node root;
    private int target;
    private List<Node> path = new ArrayList<>();

    public BFS(double value, int target) {
        this.root = new Node(value, 0);
        this.target = target;
    }

    public Node getChildNode(double value, int op) {
        Node node;

        if (op == 1) {
            node = new Node(Math.sqrt(value), op);
        } else if (op == 2) {
            node = new Node(Util.factorial(value), op);
        } else {
            node = new Node(Math.floor(value), op);
        }

        node.setPreviousValue(value);
        return node;
    }

    public void traverse() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            Node child;

            for (int i = 1; i <= 3; i++) {
                child = getChildNode(node.getValue(), i);
                child.setLevel(node.getLevel() + 1);

                if(child.getValue() != 1){
                    node.childs.put(i, child);
                    queue.add(child);
                }
            }

            if (node.getValue() == target) {
                printPath(root);
                break;
            }
        }

        for(int i=path.size() - 1;i>=0;i--){
            if(path.get(i).getOperation() == 0){
                System.out.println("root - do nothing");
            }
            else if(path.get(i).getOperation() == 1){
                System.out.println("sqrt");
            }
            else if(path.get(i).getOperation() == 2){
                System.out.println("factorial");
            }
            else if(path.get(i).getOperation() == 3){
                System.out.println("floor");
            }
        }
    }

    public Boolean printPath(Node node){
        if(node==null) return false;
        if(node.getValue() == target
                || printPath(node.childs.getOrDefault(1, null))
                || printPath(node.childs.getOrDefault(2, null))
                || printPath(node.childs.getOrDefault(3, null))){

            path.add(node);
            return true;
        }
        return false;
    }
}
