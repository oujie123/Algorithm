package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterten;

import com.gacrnd.gcs.algorithm.base.TreeNode;

/**
 * @Author: Jack Ou
 * @CreateDate: 2021/12/23 0:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/12/23 0:15
 * @UpdateRemark: 更新说明
 */
public class Trie {

    static class TrieNode {
        TrieNode children[];
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }

            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return node.isWord;
    }

    public boolean startWith(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return true;
    }
}
