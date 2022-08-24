package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class N1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 속도를 좀 더 빠르게 하기 위해 Scanner 대신 BufferedReader 사용
        int size = Integer.parseInt(br.readLine()); // 처음 트리 노드 수 입력값을 받음
        Tree<String> tree = new Tree<>();
        // Tree 생성
        for (int i = 0; i < size; i++) {
            String[] inputValues = br.readLine().split(" ");
            // 노드의 수 만큼 입력이 되기 때문에 size번 만큼 반복 진행
            tree.add(inputValues[0], inputValues[1], inputValues[2]);
            /*
             Node Data , Left Data , Right Data 순으로 입력되기 때문에 띄어쓰기 공간을
             기준으로 split 한 다음에 순서대로 입력
             */
        }
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);

    }
    private static class Tree<V> {
        static class Node<V> {
            private V data;
            private Node<V> left;
            private Node<V> right;

            Node(V data) {
                this.data = data;
            }

        }
        private Node<V> root;
        /*
        root 부터 연결되는 자료구조이기 때문에 root 노드 property 생성
         */

        // 노드 추가 함수
        void add(V data , V leftData, V rightData) {
            // root 가 null 일때는 root 설정 후 return
            if (Objects.isNull(root)) {
                root = new Node(data);
                if (!leftData.equals(".")) {
                    // leftData나 rightData 가 . 값이 아닌 경우 node 생성
                    root.left = new Node(leftData);
                }
                if (!rightData.equals(".")) {
                    root.right = new Node(rightData);
                }
                return;
            }
            // root가 null이 아닐 때 -> 맞는 자리에 노드 새로 생성하기
            addNode(root, data, leftData, rightData);
        }


        private void addNode(Node<V> pointer, V data, V leftData, V rightData) {
            // 설정한 포인터 노드가 null 일 경우 return -> 탈출조건
            if (pointer == null) {
                return;
            }
            // pointer 데이터와 추가할 데이터가 맞을 경우
            // 해당 노드의 left와 right 데이터 삽입 -> . 값이 아닐 경우에만
            // left와 right 노드를 추가했으므로 탈출조건 리턴
            if (pointer.data.equals(data)) {
                if (!leftData.equals(".")) {
                    pointer.left = new Node(leftData);
                }
                if (!rightData.equals(".")) {
                    pointer.right = new Node(rightData);
                }
                return;
            }

            // 포인터로 받은 노드에 맞지 않은 노드일 경우 포인터 노드의 left와 right 를 포인터로 설정 후 재귀
            // 해당 메서드의 탈출조건
            // 1. pointer가 null일 경우 -> 그 전 pointer가 leaf였음
            // 2. pointer와 입력될 데이터가 같은 경우 -> 맞는 노드의 위치를 찾음 -> left , right 값이 있는 경우 노드 추가 없으면 리턴
            addNode(pointer.left, data, leftData, rightData);
            addNode(pointer.right, data, leftData, rightData);
        }


        void preOrder(Node<V> node){
            if (Objects.isNull(node)) {
                return;
            }
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }

        void inOrder(Node<V> node) {
            if (Objects.isNull(node)) {
                return;
            }
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }

        void postOrder(Node<V> node) {
            if (Objects.isNull(node)) {
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }

}
