package com.werun.solution.graph;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 *
 * <p>请你实现 Trie 类：
 * <ul>
 *   <li>{@code Trie()} 初始化前缀树对象。</li>
 *   <li>{@code void insert(String word)} 向前缀树中插入字符串 word 。</li>
 *   <li>{@code boolean search(String word)} 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。</li>
 *   <li>{@code boolean startsWith(String prefix)} 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。</li>
 * </ul>
 */
public class Trie {
    Trie[] children;
    boolean isEnd;
    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null) node.children[index] = new Trie();
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null) return false;
            node = node.children[index];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for(char c : prefix.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null) return false;
            node = node.children[index];
        }
        return true;
    }
}
/*
  你的Trie对象会被实例化并调用:
  Trie obj = new Trie();
  obj.insert(word);
  boolean param_2 = obj.search(word);
  boolean param_3 = obj.startsWith(prefix);
 */