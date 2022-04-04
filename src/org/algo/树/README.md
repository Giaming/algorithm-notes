# 二叉树的递归遍历(必背部分)

## 前序遍历

[144.二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/submissions/)

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<>();
       preorder(root, res);
       return res;
    }
    public void preorder(TreeNode node, List<Integer> res) {
        if(node == null) return;
        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
    }
}
```

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.pop();
            if(temp.right != null) {
                cur = temp.right;
            }
        }
        return res;
    }
}
```

前序遍历是中左右，每次先处理的是中间节点，那么先将根节点放入栈中，然后将右孩子加入栈，再加入左孩子。
为什么要先加入 右孩子，再加入左孩子呢？ 因为这样出栈的时候才是中左右的顺序。

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return res;
    }
}
```

## 中序遍历

[94.二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/)

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    private void inorder(TreeNode node, List<Integer> res) {
        if(node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}
```

中序遍历是左中右，先访问的是二叉树顶部的节点，然后一层一层向下访问，直到到达树左面的最底部，
再开始处理节点（也就是在把节点的数值放进result数组中），这就造成了处理顺序和访问顺序是不一致的。
那么在使用迭代法写中序遍历，就需要借用指针的遍历来帮助访问节点，栈则用来处理节点上的元素。

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
```

## 后序遍历

[145.二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/submissions/)

```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }
    private void postorder(TreeNode node, List<Integer> res) {
        if(node == null) return;
        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);
    }
}
```

先序遍历是中左右，后续遍历是左右中，那么我们只需要调整一下先序遍历的代码顺序，就变成中右左的遍历顺序，然后在反转result数组，输出的结果顺序就是左右中了

```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
        }
        Collections.reverse(res);
        return res;
    }
}
```

## 层序遍历

[102.二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
基于队列的迭代：

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                list.add(node.val);
                if(node.left != null) {
                    que.offer(node.left);
                }
                if(node.right != null) {
                    que.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
```

递归版本：

```java
class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode node, int depth) {
        // 递归出口
        if(node == null) {
            return;
        }  
        depth++;
        if(res.size() < depth) {
            // 当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            ArrayList<Integer> item = new ArrayList<>();
            res.add(item);
        }
        res.get(depth - 1).add(node.val);
        dfs(node.left, depth);
        dfs(node.right, depth);
    }
}
```


# 相关类型的题目

### [107.二叉树的层次遍历 II](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)

层序遍历，将最终的结果reverse即可。

### [199.二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/)

层序遍历的时候，判断是否遍历到单层的最后面的元素，如果是，就放进result数组中，随后返回result就可以了。

递归版本
```java
    ArrayList<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node,int depth) {
        if (node == null) {
            return;
        }
        // 先访问当前节点，再递归访问右子树和左子树
        if (depth == result.size()) {
            // 如果当前节点所在深度还没有出现在res中，说明该深度下当前节点是第一个被访问的节点，
            // 因此将当前节点加入result中
            result.add(node.val);
        }
        depth++;
        // 先访问右边，然后再访问左边，这样得到的结果就是从右边看到的第一个节点
        dfs(node.right, depth);
        dfs(node.left, depth);
    }
```

迭代版本就是把层序遍历的代码中判断当前序号i是否等于size-1,若等于，则添加进入res中。

### [429.N叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

```java
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<Node> que = new ArrayDeque<>();
        que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                Node temp = que.poll();
                list.add(temp.val);
                List<Node> children = temp.children;
                // 因为children是一个列表，所以需要用循环遍历
                if(children != null && children.size() > 0) {
                    for(Node child : children) {
                        if(child != null) {
                            que.offer(child);
                        }
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
```

### [515.在每个树行中找最大值](https://www.programmercarl.com/0102.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E5%B1%82%E5%BA%8F%E9%81%8D%E5%8E%86.html)

关键代码：
```java
int size = queue.size();
int maxNum = Integer.MIN_VALUE;
for (int i = 0; i < size; i++) {
    TreeNode node = queue.poll();
    maxNum = maxNum < node.val ? node.val : maxNum;
    if (node.left != null) {
        queue.offer(node.left);
    }
    if (node.right != null) {
        queue.offer(node.right);
    }
}
result.add(maxNum);
```

### [116.填充每个节点的下一个右侧节点指针](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/)

[https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-2-4/](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-2-4/)

### [117.填充每个节点的下一个右侧节点指针II](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/)

### [104.二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)

### [111.二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)

关键代码：
```java
                if (node.left == null && node.right == null) {
                    return depth;
                }
```

### [226.翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)

### [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)

```java
/**
     * 递归实现版本
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else if (left == null && right == null) {  // 这个条件必须判断，否则出现空指针异常
            return true;
        } else if (left.val != right.val) {
            return false;
        }
        boolean outSide = compare(left.left, right.right);
        boolean inSide = compare(left.right, right.left);
        return outSide && inSide;
    }

    /**
     * 基于双端队列：相当于使用两个栈
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }else if (leftNode == null || rightNode == null) {
                return false;
            }else if (leftNode.val != rightNode.val) {
                return false;
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }
```

### [222.完全二叉树的节点个数](https://leetcode-cn.com/problems/count-complete-tree-nodes/submissions/)

```java
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
```

### [110.平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/)

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    private int getHeight(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight =getHeight(root.right);
        if(rightHeight == -1) return -1;
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
```
```java
// 递归实现
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.abs(leftDepth - rightDepth) > 1 ? false : isBalanced(root.left)&isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
```

### [257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)

递归版本，回溯法：

```java
class Solution {
 public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        traversal(root, path, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> path, List<String> res) {
        path.add(root.val);
        // 叶子节点
        if (root.left == null && root.right == null) {
            // 输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size()-1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size()-1));
            res.add(sb.toString());
            return;  // 递归出口
        }
        if (root.left != null) {
            traversal(root.left, path, res);
            // 回溯
            path.remove(path.size()-1);
        }
        if (root.right != null) {
            traversal(root.right, path, res);
            path.remove(path.size()-1);
        }
    }
}
```

### [404.左叶子之和](https://leetcode-cn.com/problems/sum-of-left-leaves/submissions/)

那么判断当前节点是不是左叶子是无法判断的，必须要通过节点的父节点来判断其左孩子是不是左叶子。 
如果该节点的左节点不为空，该节点的左节点的左节点为空，该节点的左节点的右节点为空，则找到了一个左叶子

### [513.找树左下角的值](https://leetcode-cn.com/problems/find-bottom-left-tree-value/)

```java
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            if (root == null) return 0;
            int res = 0;
            Deque<TreeNode> que = new ArrayDeque<>();
            que.offer(root);
            while (!que.isEmpty()) {
                int size = que.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = que.poll();
                    // 记录第一个
                    if (i == 0) res = temp.val;
                    if (temp.left != null) que.offer(temp.left);
                    if (temp.right != null) que.offer(temp.right);
                }
            }
            return res;
        }
    }
```

### [112. 路径总和](https://leetcode-cn.com/problems/path-sum/)

- DFS（递归）
```python
class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        if not root: return False
        if not root.left and not root.right:
            return sum == root.val
        return self.hasPathSum(root.left, sum - root.val) or self.hasPathSum(root.right, sum - root.val)
```

### [106.从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

```java
// 一定要注意
class Solution {
   Map<Integer, Integer> indexMap = new HashMap<>();
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                indexMap.put(inorder[i], i);
            }
            return createTree(postorder, 0, postorder.length-1, 0, inorder.length-1);
        }

        private TreeNode createTree(int[] postorder, int postStartIndex, int postEndIndex, int inStartIndex, int inEndIndex) {
            if (postStartIndex > postEndIndex || inStartIndex > inEndIndex) return null;
            int val = postorder[postEndIndex];
            int inIndex = indexMap.get(val);
            int leftNumber = inIndex - inStartIndex;
            TreeNode root = new TreeNode(val);
            root.left = createTree(postorder, postStartIndex, postStartIndex+leftNumber-1, inStartIndex, inIndex-1);
            root.right = createTree(postorder, postStartIndex+leftNumber, postEndIndex-1, inIndex+1, inEndIndex);
            return root;
        }
}
```
### [105.从前序与中序遍历序列构造二叉树]()

```java
class Solution {
    Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return createTree(preorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode createTree(int[] preorder, int preStartIndex, int preEndIndex, int inStartIndex, int inEndIndex) {
        // 递归出口
        if (preStartIndex > preEndIndex || inStartIndex > inEndIndex) return null;
        // 根节点值
        int val = preorder[preStartIndex];
        int inIndex = indexMap.get(val);
        int leftNumber = inIndex - inStartIndex;
        // 创建根节点
        TreeNode root = new TreeNode(val);
        root.left = createTree(preorder, preStartIndex+1, preStartIndex+leftNumber, inStartIndex, inIndex-1);
        root.right = createTree(preorder, preStartIndex+leftNumber+1, preEndIndex, inIndex+1, inEndIndex);
        return root;
    }
}
```
### [654.最大二叉树](https://leetcode-cn.com/problems/maximum-binary-tree/)

跟上面两道题的思想一致：

```java
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int low, int high) {
        if (low > high) return null;
        // 寻找最大值的下标索引
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = buildTree(nums, low, index-1);
        root.right = buildTree(nums, index+1, high);
        return root;
    }
}
```

### [617.合并二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees/)

```java
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        TreeNode root = new TreeNode(0);
        root.val = root1.val + root2.val;
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
```

### [700.二叉搜索树中的搜索](https://leetcode-cn.com/problems/search-in-a-binary-search-tree/)

```java
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) 
            return searchBST(root.left, val);
        else 
            return searchBST(root.right, val);
    }
```

### [98.验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)

```java
    // 如果该二叉树的左子树不为空，则左子树上的所有节点的值均小于它的根节点的值，若它的右子树不为空，则右子树上所有节点的值均大于它的根节点的值
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
```

```java
// 中序遍历
// 不能单纯的比较左节点小于中间节点，右节点大于中间节点就完事了。
class Solution{
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // 左
        boolean left = isValidBST(root.left);
        if (!left) return false;
        // 中
        if (max != null && root.val <= max.val) return false;
        max = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
    }
}
```

```java
    // 中序遍历递归版本
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pre != null && pop.val <= pre.val) {
                return false;
            }
            pre = pop;
            root = pop.right;
        }
        return true;
    }
```

[701.二叉搜索树中的插入操作](https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/)
```java
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        if (val < root.val) root.left = insertIntoBST(root.left, val);
        if (val > root.val) root.right = insertIntoBST(root.right, val);
        return root;
    }
}
```

### [450.删除二叉搜索树中的节点](https://leetcode-cn.com/problems/delete-node-in-a-bst/)

这里就把平衡二叉树中删除节点遇到的情况都搞清楚。

有以下五种情况：

- 第一种情况：没找到删除的节点，遍历到空节点直接返回了
- 找到删除的节点
  - 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
  - 第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
  - 第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
  - 第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。

第五种情况有点难以理解，看下面动画：

![450.删除二叉搜索树中的节点](images/008eGmZEly1gnbj3k596mg30dq0aigyz.gif)

动画中棵二叉搜索树中，删除元素7， 那么删除节点（元素7）的左孩子就是5，删除节点（元素7）的右子树的最左面节点是元素8。

将删除节点（元素7）的左孩子放到删除节点（元素7）的右子树的最左面节点（元素8）的左孩子上，就是把5为根节点的子树移到了8的左孩子的位置。

要删除的节点（元素7）的右孩子（元素9）为新的根节点。.

这样就完成删除元素7的逻辑，最好动手画一个图，尝试删除一个节点试试。

```cpp
if (root->val == key) {
    // 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
    // 第三种情况：其左孩子为空，右孩子不为空，删除节点，右孩子补位 ，返回右孩子为根节点
    if (root->left == nullptr) return root->right;
    // 第四种情况：其右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
    else if (root->right == nullptr) return root->left;
    // 第五种情况：左右孩子节点都不为空，则将删除节点的左子树放到删除节点的右子树的最左面节点的左孩子的位置
    // 并返回删除节点右孩子为新的根节点。
    else {
        TreeNode* cur = root->right; // 找右子树最左面的节点
        while(cur->left != nullptr) {
            cur = cur->left;
        }
        cur->left = root->left; // 把要删除的节点（root）左子树放在cur的左孩子的位置
        TreeNode* tmp = root;   // 把root节点保存一下，下面来删除
        root = root->right;     // 返回旧root的右孩子作为新root
        delete tmp;             // 释放节点内存（这里不写也可以，但C++最好手动释放一下吧）
        return root;
    }
}
```



--
普通二叉树的删除方式（没有使用搜索树的特性，遍历整棵树），用交换值的操作来删除目标节点。
代码中目标节点（要删除的节点）被操作了两次：
  第一次是和目标节点的右子树最左面节点交换。
  第二次直接被NULL覆盖了。

```java
// 递归方式
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        root = delete(root, key);
        return root;
    }

    private TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = delete(root.left, key);
        } else if (root.val < key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            root.val = temp.val;
            root.right = delete(root.right, temp.val);
        }
        return root;
    }
}
```
```java
class Solution1 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (root.val > key)
            root.left = deleteNode(root.left, key);
        if (root.val < key)
            root.right = deleteNode(root.right, key);
        return root;
    }
}
```

[530.二叉搜索树的最小绝对差](https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/)
```java
    class Solution2{
        int result = Integer.MAX_VALUE;
        TreeNode pre = null;
        public int getMinimumDifference(TreeNode root) {
            traversal(root);
            return result;
        }

        private void traversal(TreeNode cur) {
            if (cur == null) return;
            traversal(cur.left);
            if (pre != null) {
                result = Math.min(result, cur.val - pre.val);
            }
            pre = cur;  // 记录前一个节点
            traversal(cur.right);
        }
    }
```

[501.二叉搜索树中的众数](https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/)
```java
  class Solution {
    int preVal = 0, curTimes = 0, maxTimes = 0;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        traversal(root);
        int size = list.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    // 二叉树的中序遍历
    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        // 判断当前值域上一个值的关系，更新curTimes和preVal
        if (preVal == root.val) {
            curTimes++;
        }else {
            preVal = root.val;
            curTimes = 1;
        }
        // 判断当前数量与最大数量的关系，更新list和maxTimes
        if (curTimes == maxTimes) {
            list.add(root.val);
        } else if (curTimes > maxTimes) {
            list.clear();  // 这里是关键
            list.add(root.val);
            maxTimes = curTimes;
        }
        traversal(root.right);
    }
  }
```

[230. 二叉搜索树中第K小的元素](https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/)

解法1：直接用中序遍历得到遍历数组，然后对遍历数组取k-1下标的值
归根结底就是一道中序遍历的题目:
```java
public int kthSmallest(TreeNode root, int k) {
    int count = 0;
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    while(!stack.isEmpty() || cur != null) {
        if(cur != null) {
            stack.push(cur);
            cur = cur.left;
        } else {
            cur = stack.pop();
            if (++count == k) return cur.val;
            cur = cur.right;
        }
    }
    return -1;
}
```

[236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)
那么我给大家归纳如下三点：
求最小公共祖先，需要从底向上遍历，那么二叉树，只能通过后序遍历（即：回溯）实现从低向上的遍历方式。
在回溯的过程中，必然要遍历整棵二叉树，即使已经找到结果了，依然要把其他节点遍历完，因为要使用递归函数的返回值（也就是代码中的left和right）做逻辑判断。
要理解如果返回值left为空，right不为空为什么要返回right，为什么可以用返回right传给上一层结果。
可以说这里每一步，都是有难度的，都需要对二叉树，递归和回溯有一定的理解。
```java
    class Solution {
        /**
         * 情况 1，如果 p 和 q 都在以 root 为根的树中，函数返回的即使 p 和 q 的最近公共祖先节点。
         * 情况 2，那如果 p 和 q 都不在以 root 为根的树中怎么办呢？函数理所当然地返回 null 呗。
         * 情况 3，那如果 p 和 q 只有一个存在于 root 为根的树中呢？函数就会返回那个节点。
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // case 1
            if (left != null && right != null) return root;
            // case 2
            if (left == null && right == null) return null;
            // case 3
            return left == null ? right : left;
        }
    }
```

[235. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/)
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }else {
            return root;
        }
    }
}
```

[669. 修剪二叉搜索树](https://leetcode-cn.com/problems/trim-a-binary-search-tree/)
[代码随想录](https://programmercarl.com/0669.%E4%BF%AE%E5%89%AA%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91.html#%E9%80%92%E5%BD%92%E6%B3%95)
明确了递归函数的定义之后进行思考，如果一个节点的值没有落在 [lo, hi] 中，有两种情况：
1、**root.val < lo，这种情况下 root 节点本身和 root 的左子树全都是小于 lo 的，都需要被剪掉**。
2、**root.val > hi，这种情况下 root 节点本身和 root 的右子树全都是大于 hi 的，都需要被剪掉**。
```java
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) return null;
            if (root.val < low) {
                // 直接返回root.right
                // 等于删除root以及root的左子树
                return trimBST(root.right, low, high);
            }
            if (root.val > high) {
                // 直接返回root.left
                // 等于删除root以及root的右子树
                return trimBST(root.left, low, high);
            }
            // root在[low, high]范围内的节点什么都不做
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
```

[108.将有序数组转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/submissions/)
做这道题目之前大家可以了解一下这几道：
[106.从中序与后序遍历序列构造二叉树(opens new window)](https://programmercarl.com/0106.%E4%BB%8E%E4%B8%AD%E5%BA%8F%E4%B8%8E%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E5%BA%8F%E5%88%97%E6%9E%84%E9%80%A0%E4%BA%8C%E5%8F%89%E6%A0%91.html)

```java
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildTree(nums, 0, nums.length-1);
        }

        private TreeNode buildTree(int[] nums, int low, int high) {
            if (low > high) return null; // 递归出口
            int mid = (low + high) >> 1;  //  mid = low + ((high - low) >>1);
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildTree(nums, low, mid-1);
            root.right = buildTree(nums, mid+1, high);
            return root;
        }
    }
```

[538.把二叉搜索树转换为累加树](https://leetcode-cn.com/problems/convert-bst-to-greater-tree/)
[1038. 从二叉搜索树到更大和树](https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/)
两道题相同

维护一个外部累加变量 sum，在遍历 BST 的过程中增加 sum，同时把 sum 赋值给 BST 中的每一个节点，就将 BST 转化成累加树了。
但是注意顺序，正常的中序遍历顺序是先左子树后右子树，这里需要反过来，先右子树后左子树。
```java
    class Solution {
        public TreeNode convertBST(TreeNode root) {
            traversal(root);
            return root;
        }

        // 记录累加和
        int sum = 0;
        private void traversal(TreeNode root) {
            if (root == null) return;
            // 先遍历右子树
            traversal(root.right);
            sum += root.val;
            // 将BST转化成累加树
            root.val = sum;
            traversal(root.left);
        }
    }
```