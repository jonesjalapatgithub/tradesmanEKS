package com.jonesjalapat.blog.tradesman.controller;

import lombok.Generated;

@Generated
public class CustomHashMap<K, V> {

  private static final int DEFAULT_CAPACITY = 10;
  private static final float DEFAULT_LOAD_FACTOR = 0.75f;
  private int capacity;
  private float loadFactor;
  private int size;
  private Node<K, V>[] table;

  public CustomHashMap() {
    this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
  }

  public CustomHashMap(int capacity, float loadFactor) {
    this.capacity = capacity;
    this.loadFactor = loadFactor;
    table = new Node[capacity];
  }

  public V get(K key) {
    int index = hashcode(key);
    Node<K, V> node = table[index];
    while (node != null) {
      if (key.equals(node.key)) {
        return node.value;
      }
      node = node.next;
    }
    return null;
  }

  public void put(K key, V value) {
    int index = hashcode(key);
    Node<K, V> node = table[index];
    while (node != null) {
      if (key.equals(node.key)) {
        node.value = value;
        return;
      }
      node = node.next;
    }
    Node<K, V> newNode = new Node<>(key, value);
    newNode.next = table[index];
    table[index] = newNode;
    size++;
    if (size > (int) (capacity * loadFactor)) {
      resize();
    }
  }

  private void resize() {
    int newCapacity = this.capacity * 2;
    Node<K, V>[] newTable = new Node[newCapacity];
    for (int i = 0; i < capacity; i++) {
      Node<K, V> node = table[i];
      while (node != null) {
        Node<K, V> next = node.next;
        int index = hashcode(node.key);
        node.next = newTable[index];
        newTable[index] = node;
        node = next;
      }
      table = newTable;
      capacity = newCapacity;
    }
  }

  public void remove(K key) {
    int index = hashcode(key);
    Node<K, V> node = table[index];
    Node<K, V> prev = null;
    while (node != null) {
      if (key.equals(node.key)) {
        if (prev == null) {
          table[index] = node.next;
        } else {
          prev.next = node.next;
        }
        size--;
        return;
      }
      prev = node;
      node = node.next;
    }
  }

  public int hashcode(K key) {
    return key.hashCode() % capacity;
  }

  private static class Node<K, V> {

    public K key;
    public V value;
    public Node<K, V> next;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    CustomHashMap customHashMap = new CustomHashMap();
    for (int i = 0; i < 12; i++) {
      customHashMap.put(i, "Jones");
    }
    System.out.println(customHashMap.get(11));
    customHashMap.put(11, "Anu");
    System.out.println(customHashMap.get(11));
  }
}
