package com.gacrnd.gcs.algorithm.List;

public class LruLinkedList<T> extends LinkedList<T> {
	
	int memory_size;
	static final int DEFAULT_CAP = 5;
	
	public LruLinkedList() {
		this(DEFAULT_CAP);
	}
	
	public LruLinkedList(int default_memory_size) {
		memory_size = default_memory_size;
	}

	public void lruPut(T data) {
		if (size >= memory_size) {
			removeLast();
			put(data);
		} else {
			put(data);
		}
	}

	public T lruRemove(){
		return removeLast();
	}

	public T lruGet(int index) {
		checkPositionIndex(index);
		Node node = list;
		Node pre = list;
		for(int i = 0; i < index; i++) {
			pre = node;
			node = node.next;
		}
		T resultData = node.data;
		pre.next = node.next;
		Node head = list;
		node.next = head;
		list = node;
		return resultData;
	}


	public static void main(String[] args) {
		LruLinkedList<Integer> lruLinkedList = new LruLinkedList<>(5);
		for(int i = 0; i <4; i++) {
			lruLinkedList.lruPut(i);
		}
		lruLinkedList.toString();
		System.out.println(lruLinkedList.lruGet(3));
		lruLinkedList.toString();
		lruLinkedList.lruPut(20);
		lruLinkedList.toString();
		
		lruLinkedList.lruPut(18);
		lruLinkedList.toString();

	}

}
