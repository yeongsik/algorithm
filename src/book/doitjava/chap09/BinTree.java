package book.doitjava.chap09;

import java.util.Comparator;

public class BinTree<K,V> {

    private static class Node<K,V> {
        private K key;
        private V data;
        private Node<K,V> left;
        private Node<K,V> right;

        Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(K key, V data) {
            this.key = key;
            this.data = data;
        }

        K getKey() {
            return key;
        }
        V getValue() {
            return data;
        }

        void print(){
            System.out.println("data = " + data);
        }
    }

    private Node<K,V> root;
    private Comparator<? super K> comparator = null;

    public BinTree() {
        root = null; // 이 코드 없어도 어짜피 null 아닌가?
    }

    public BinTree(Comparator<? super K> c) {
        comparator = c;
    }

    // 두 키값을 비교 -> why?
    private int companyKey(K key1, K key2) {
        // 이런 상황에서 삼항 연산자 괜찮은건가?
        return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key2);
    }

    // 키로 검색
    public V search(K key) {
        Node<K,V> p = root; // 초기 포인터를 루트로 설정

        while (true) { // TODO: 2022-08-12 while ( true ) 말고 다른 코드로 변경할 수 없을까?  
            if (p == null) {  // 더이상 진행할 수 없으면 검색 실패 null return , p가 널인 경우 p.left 와 p.right가 널일 때 return null
                return null;
            }
            int cond = companyKey(key, p.getKey()); // key와 노드 p의 키 값을 비교
            if ( cond == 0) { // 같으면 검색 성공 > 해당 노드의 data 값 리턴 
                return p.getValue();
            } else if (cond < 0) { // key쪽(검색하려는 노드)이 작으면 왼쪽 서브트리에서 검색 ( 루트 기준 ) 
                p = p.left; // 포인터가 왼쪽 서브트리로 변경 
            } else { // key 쪽이 크면 오른쪽 서브트리로 변경 
                p = p.right; 
            }
        }
    }

    // node를 루트로 하는 서브트리에 노드(K,V)를 삽입
    private void addNode(Node<K, V> node, K key, V data) {
        int cond = companyKey(key, node.getKey());
        if (cond == 0) { // 키 값이 같으면 삽입 실패 ( 종료 ) - 키 값이 이미 이진트리에 존재
            return; // TODO: 2022-08-12 Exception 추가하기 
        } else if (cond < 0) { // key값이 삽입할 값보다 작을 경우
            if (node.left == null) { // 해당 node의 left 널일 경우 해당 부분에 추가
                node.left = new Node<K, V>(key, data);
            } else { // 널이 아닐 경우 다시 addNode 재귀 호출
                addNode(node.left,key,data);
            }
        } else { // key값이 삽입할 값보다 클 경우
            if (node.right == null) { // 해당 node의 right 널일 경우 해당 포인터 노드의 오른쪽 노드에 노드 추가 
                node.right = new Node<K, V>(key, data);
            } else { // addNode 재귀 호출 
                addNode(node.right, key, data);
            }
        }
        
        // 포인터로 되는 노드에 left나 right가 새롭게 들어가지 않은 이상 계속 재귀호출 진행
    }
    // 외부에서 사용하는 add 클래스 
    public void add(K key, V data) { 
        if (root == null) { // root가 없을 경우 root에 add
            root = new Node<K, V>(key, data);
        } else { // root가 있는 경우 private 클래스 addNode 호출 
            addNode(root,key,data);
        }
    }

    // 키값이 key인 노드를 삭제 
    public boolean remove(K key) {
        Node<K,V> p = root; // 스캔 중인 노드 - pointer 노드 설정
        Node<K,V> parent = null; // 스캔 중인 노드의 부모 노드 ( 변수 초기화 ) 
        boolean isLeftChild = true; // 왼쪽 자식노드가 있는지에 대한 boolean 변수

        while (true) {
            if (p == null) {
                return false; // 포인터 노드가 null인 경우 false
            }
            int cond = companyKey(key , p.getKey());
            // TODO: 2022-08-12 search 메서드와 비슷한 맥락 -> 중복코드처럼 느껴진다. 
            if (cond == 0) { // 포인트 키값과 삭제할 노드의 키값이 같아지면 while 문 break; 
                break;
            } else {
                parent = p;
                if (cond < 0) {
                    isLeftChild = true;
                    p = p.left;
                } else {
                    isLeftChild = false;
                    p = p.right;
                }
            }
        }
        if (p.left == null) { // 삭제할 노드의 왼쪽 자식이 없을 경우
            if (p == root) {  // 삭제할 노드가 root인 경우
                root = p.right; // root는 오른쪽 자식 노드로 설정
            } else if (isLeftChild) { // parent의 왼쪽 자식 노드가 있는 경우
                parent.left = p.right;
            } else {
                parent.right = p.right;
            }
        } else if (p.right == null) {
            if (p == root) {
                root = p.left;
            } else if (isLeftChild) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
        } else {
            parent = p;
            Node<K,V> left = p.left;
            isLeftChild = true;
            while (left.right != null) {
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            p.key = left.key;
            p.data = left.data;
            if (isLeftChild) {
                parent.left = left.left;
            } else {
                parent.right = left.left;
            }
        }
        return true;
    }

    // node를 루트로 하는 서브트리의 노드를 키값의 오름차순으로 출력
    private void printSubTree(Node node) {
        if (node != null) {
            printSubTree(node.left);
            System.out.println(node.key + " " + node.data); // node를 출력
            printSubTree(node.right);
        }
    }

    // 모든 노드를 키값의 오름차순으로 출력
    public void print() {
        printSubTree(root);
    }
}
